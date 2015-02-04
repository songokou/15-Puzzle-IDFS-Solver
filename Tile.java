/**
 * 
 * @author zeli,zli48, 676755673
 * the basic square information
 *
 */
public class Tile {
	private String numberName;//0,1,2
	private int index;
	public Tile(String n, int i ){
		numberName = n;
		index = i;
//		moveInfo = possibleMoves();
	}
	
	
	//setters
	public void setName(String s){
		numberName = s;
	}

	public void setIndex(int i){
		index = i;
	}

	//getters
	public String getName(){
		return numberName;
	}

	public int getIndex(){
		return index;
	}

	
	public boolean couldMoveRight(){
		if ((index - 3)%4 != 0)
			return true;
		return false;
	}
	public boolean couldMoveLeft(){
		if((index%4!=0))
			return true;
		return false;
	}
	public boolean couldMoveUp(){
		if (index - 3 > 0)
			return true;
		return false;
	}
	public boolean couldMoveDown(){
		if (index - 12 < 0)
			return true;
		return false;
	}
	

	
}
