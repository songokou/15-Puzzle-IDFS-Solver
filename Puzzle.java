/**
 *implementation of 15 puzzle solver
 * @author zeli, zli48, 676755673
 *
 *NOTE: This program assumes the empty square at the topleft corner the goal
 *
 *	0 1 2 3
 *	4 5 6 7
 *	8 9 A B
 *	C D E F
 *
 *AS WELL AS
 *	1 2 3 4
 *	5 6 7 8
 *	9 A B C
 *	D E F 0
 */
import java.util.*;
public class Puzzle {


	public static void main(String args[]){
		String str = "1 0 2 3 4 5 6 7 8 9 A B C D E F";//one move to the left
		String str1 = "1 2 0 3 4 5 6 7 8 9 A B C D E F";
		String str2 = "4 1 2 3 0 5 6 7 8 9 A B C D E F";
		String str3 = "4 1 2 3 5 0 6 7 8 9 A B C D E F";
		String str4 = "0 1 2 3 4 5 6 7 8 9 A B C D E F";//perfect input
		String str5 = "4 1 2 0 8 5 6 3 C 9 A 7 D E F B";
		String str6 = "1 2 3 4 5 6 7 8 9 A B C D E 0 F";
		String str7 = "1 2 3 4 5 6 7 8 9 A 0 B D E F C";
		Vector<Tile> tiles = new Vector<Tile>();

		readInTile(str7, tiles);
		State s = new State(4,4,tiles);

		Solver solve = new Solver(s);
		DFSolver dfsolve = new DFSolver(s,10);
	}
	
//	public static Vector<Tile> 
	public static void readInTile(String s, Vector<Tile> tiles){
		String delims = "[ ]+";
		String[] tokens = s.split(delims);
		for (int i = 0; i < 16; i++){
			Tile t = new Tile(tokens[i],i);
			tiles.add(t);
		}
	}

}



