/*
 This class will use a previously serialized instance of MazeSolver,
 and continue to solve the maze it has created.
*/

import java.util.*;
import java.io.*;
public class ResumeSolvingMaze 
{
	
	
	
	public static void main(String[]args)	throws Throwable	//main method throws all possible exceptions
	{
		//data
		String file;
		Scanner scan = new Scanner(System.in);
		
		//prompt for where the serialized maze is
		System.out.println("What file is your maze saved in?");
		file = scan.next();
		
		//read in the serialized maze
		ObjectInputStream oisVar = new ObjectInputStream(new FileInputStream(file));
		MazeSolver differentSolver = (MazeSolver)oisVar.readObject(); 
		System.out.println("differentSolver (with solver's data read into it) is: " +differentSolver);
		oisVar.close();
		
		//solve the maze.
		differentSolver.solve();
		
		
		
		
	}
	
	
}



	
