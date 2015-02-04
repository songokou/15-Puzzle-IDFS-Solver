/**
 * BFS implementation of 15 puzzle solver
 * @author zeli
 *
 */
import java.util.*;
public class State {
	private int length;//allows different puzzle settings
	private int width;
	private int numMoves;
	private Vector<Tile> infoTable;//keeps track of the Tile info
	private int totalTiles;
	private String solution;
	//constructor
	public State(int l, int w, Vector<Tile> p){
		length = l;
		width = w;
		infoTable = p;
		numMoves = 0;
		totalTiles = 16;
		solution = "";
	}
	//setters
	public void setLength(int l){
		length = l;
	}
	public void setWidth(int w){
		width = w;
	}
	public void setTiles(Vector<Tile> p){
		infoTable = p;
	}
	public void setNumMoves(int i){
		numMoves = i;
	}
	public void addSteps(String s){
		solution += s;
	}
	public void setSolution(String s){
		solution = s;
	}
	//getters
	public int getLength(){
		return length;
	}	
	public int getWidth(){
		return width;
	}	
	public Vector<Tile> getTiles(){
		return infoTable;
	}
	public int getNumMoves(){
		return numMoves;
	}
	public int getTotalTiles(){
		return totalTiles;
	}
	public String getSolution(){
		return solution;
	}
}
