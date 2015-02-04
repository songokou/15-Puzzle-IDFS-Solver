/**
 * 
 * @author zeli,zli48, 676755673
 *This class is used to convert State into String so it will be used 
 *for the hashing in Solver and DFSolver
 */

public class StringState {
	private String stringState;
	
	//constructor
	public StringState(State s){
		stringState = convertToString(s);
	}
	
	//method to convert State to String
	private String convertToString(State s){
		String finalString = s.getTiles().get(0).getName();
		int puzzleNum = s.getTotalTiles();//total possible positions
		for (int i = 1; i < puzzleNum; i++){
			finalString += s.getTiles().get(i).getName();
		}
		return finalString;
	}
	//getter
	public String getStringState(){
		return stringState;
	}
	//setter
	public void setStringState(String s){
		stringState = s;
	}
}

