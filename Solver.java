import java.util.*;
public class Solver {
	//BFS queue
	private Queue<State> states;
	private State stateToSolve;
	private final String goal = "0123456789ABCDEF";
	private final String goal2 = "123456789ABCDEF0";
	private Map<String, String> previous;//to keep track of previous checked status
	private String solution;
	
	//-1,-1 for decrement of coordinates
	private final int up = -4;
	private final int down = 4;
	private final int left = -1;
	private final int right = 1;
	
	//CONSTRUCTOR
	public Solver(State s){
		solution = "";
		states = new LinkedList<State>();
		stateToSolve = duplicateState(s);
		previous = new HashMap<String, String>();
		solve();
//		copyState = duplicateState(s);
	}
	//a bfs version of solve
	public void solve(){
		State s = duplicateState(stateToSolve);
		StringState ss = new StringState(s);
		makeQ(ss.getStringState(),null,s);//add the first State to queue
//		System.out.println(ss.getStringState());
		boolean solved = false;
		//deal with a initial good board
		if(goalReached(s)){
			System.out.println("Already a good board.");
			return;
		}
		while(!states.isEmpty()){
			State state = states.remove();
			StringState sb = new StringState(state);
//			System.out.println("mlgb: " + sb.getStringState());
			if (goalReached(state)&&!solved){//first solution found
				s = state;
				solved = true;
				System.out.println("#########\n# Solved #\n#########");
				break;
			}
			explore(state);
		}
		solution = s.getSolution();
		if (solution.equals("")||solution.equals(null))
			System.out.println("no solution");
		else{
		System.out.println("BFS");
		System.out.println(solution);
		}
	}
		
	// to duplicate the State of the current layout
	private State duplicateState(State s){
		int l = s.getLength();
		int w = s.getWidth();
		Vector<Tile> tempTs = new Vector<Tile>();
		for (int i = 0; i < s.getTotalTiles(); i++){
			String name = s.getTiles().get(i).getName();
			int in = s.getTiles().get(i).getIndex();
			Tile tempT = new Tile(name, i);
			tempTs.add(tempT);
		}
		State state = new State(l,w,tempTs);
		state.setNumMoves(s.getNumMoves());
		state.setSolution(s.getSolution());
		return state;
	}
	//find the target Tile, "0" in the file
	private boolean goalReached(State s){
		StringState ss = new StringState(s);
		if (ss.getStringState().equals(goal)||ss.getStringState().equals(goal2))
			return true;
		return false;
	}
	
	//find the index of the movable piece marked 0 in the State
	private int movable(State s){
		for (int i = 0; i < s.getTotalTiles();i++){
			if (s.getTiles().get(i).getName().equals("0"))
				return i;
		}
		return -1;//error
	}
	//adds the State to states if it has never been added before
	private void makeQ(String next, String pre, State s){
		if (!previous.containsKey(next)){
			previous.put(next, pre);//make sure no duplicated State gets searched
//			System.out.println("MakeQ: "+next);
			states.add(s);
		}
	}
	
	/**
	 * helps explore moves
	 */
	public void explore(State s){
		moveLeft(s);
		moveRight(s);		
		moveUp(s);
		moveDown(s);
	}
	

	
	
	private void moveLeft(State s){
		
		if(s.getTiles().get(movable(s)).couldMoveLeft()){
			StringState ss = new StringState(s);//get the hash value for State s
//			System.out.println("LEFT:" + ss.getStringState());
			State copyS= duplicateState(s);
			int moveI = movable(s);		
			//change two tiles
			copyS.getTiles().get(moveI).setName(copyS.getTiles().get(moveI + left).getName());
			copyS.getTiles().get(moveI + left).setName("0");
			copyS.addSteps("left\n");//add to solution
			StringState tempSS = new StringState(copyS);
			makeQ(tempSS.getStringState(),ss.getStringState(),copyS);
//			System.out.println(movable(s)+": " + tempSS.getStringState());		
		}
		
	}
	private void moveRight(State s){
		if(s.getTiles().get(movable(s)).couldMoveRight()){
			StringState ss = new StringState(s);//get the hash value for State s
//			System.out.println("RIGHT:" + ss.getStringState());
			State copyS = duplicateState(s);
			int moveI = movable(copyS);		
			copyS.getTiles().get(moveI).setName(copyS.getTiles().get(moveI + right).getName());
			copyS.getTiles().get(moveI + right).setName("0");
			copyS.addSteps("right\n");
			StringState tempSS = new StringState(copyS);
			makeQ(tempSS.getStringState(),ss.getStringState(),copyS);	
//			System.out.println(movable(s)+": " + tempSS.getStringState());		
		}
	}
	
	
	private void moveUp(State s){
		
		if(s.getTiles().get(movable(s)).couldMoveUp()){
			StringState ss = new StringState(s);
//			System.out.println("UP:" + ss.getStringState());

			State copyS = duplicateState(s);
			int moveI = movable(copyS);
			copyS.getTiles().get(moveI).setName(copyS.getTiles().get(moveI + up).getName());
			copyS.getTiles().get(moveI + up).setName("0");
			copyS.addSteps("up\n");
				StringState tempSS = new StringState(copyS);
				makeQ(tempSS.getStringState(),ss.getStringState(),copyS);	
//				System.out.println(movable(copyS)+": " + tempSS.getStringState());	
//				System.out.println(movable(s)+": " + tempSS.getStringState());		

		}
	}
	
	private void moveDown(State s){
		
		if(s.getTiles().get(movable(s)).couldMoveDown()){
			StringState ss = new StringState(s);
//			System.out.println("DOWN:" + ss.getStringState());

			State copyS = duplicateState(s);
			int moveI = movable(copyS);
			copyS.getTiles().get(moveI).setName(copyS.getTiles().get(moveI + down).getName());
			copyS.getTiles().get(moveI + down).setName("0");
			copyS.addSteps("down\n");
			StringState tempSS = new StringState(copyS);
			makeQ(tempSS.getStringState(),ss.getStringState(),copyS);	
//			System.out.println(movable(s)+": " + tempSS.getStringState());		
		}
	}
}
