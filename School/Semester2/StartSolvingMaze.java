/*
 This class will create a new instance of MazeSolver, and solve the maze
 created by it.
*/

import java.util.*;
import java.io.*;
public class StartSolvingMaze implements java.io.Serializable
{
	
	
	
	public static void main(String[]args)
	{
		//data
		int rows;
		int collumns;
		Scanner scan = new Scanner(System.in);
		
		//inputs
		System.out.println("Enter the number of rows you want your maze to have.");
		rows = scan.nextInt();
		
		System.out.println("Enter the number of collumns you want your maze to have.");
		collumns = scan.nextInt();
		
		
		//create maze
		MazeSolver solver = new MazeSolver(rows, collumns);
		
		//solve
		solver.solve();
		
		
		
		
	}
	
	
}
