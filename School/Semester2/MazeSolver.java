/*
 This class will use an instance of Maze, and MazeDisplay to create a maze, and then solve it. 
 MazeSolver also uses a Stack, and an ArrayList containing instances of the Point class to store moves that were made
 while solving the maze. This also gives it the ability to backtrack if you hit a dead end.
 */

import java.util.*;
import java.io.*;
public class MazeSolver implements java.io.Serializable
{
	//data
	private Stack myStack;
	private Maze aMaze;
	private ArrayList<Point> theAL;
	
	
	//constructor
	
	public MazeSolver(int numrows, int numcollums)
	{
		this.aMaze = new Maze(numrows, numcollums);
		
		this.aMaze.buildMaze(0);
		this.aMaze.setSolveAnimationDelay(5);
		
		myStack = new Stack();
		this.theAL = new ArrayList<Point>();
		
	}
	
	//solve method 		throws Throwable to allow for Serialization
	public void solve() throws Throwable
	{
		boolean finished;		//used to determine when the maze is either solved, or the user saved, or they quit
		String choice;
		Scanner myScanner = new Scanner(System.in);
		MazeDisplay aMazeDisplay = new MazeDisplay(aMaze);
		theAL.add(new Point(aMaze.getCurrentRow(), aMaze.getCurrentCol()));
		
		System.out.println("Enter Q to quit, S to save to a file, or just ENTER to move");
		
		do    				//all solving happens in a do-while loop that continues until the boolean "finished" returns true
		{
			finished = false;
			choice = myScanner.nextLine();
			
		
			if(choice.equals("S") || choice.equals("s"))		//options if you want to save, this uses serialization
			{
				System.out.println("What file would you like to save to?");
				String file = myScanner.next();
			
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));		//create new ObjectOutputStream
				oos.writeObject(this);		//write the object to your specified file
			
				oos.close();		//close the connection to this file
				finished = true;		//change boolean to true so the loop ends
			}
			
			else if(!choice.equals("Q") && !choice.equals("q"))		//if the user does not save, and does not quit, it must find the next position in the maze
			{
				if(aMaze.isOpen(Maze.Direction.UP) && !theAL.contains(new Point(aMaze.getCurrentRow() - 1, aMaze.getCurrentCol())))		//if position above is open
				{
					aMaze.move(Maze.Direction.UP);		//move up
					myStack.push(Maze.Direction.UP);		//record your move on your call stack
					theAL.add(new Point(aMaze.getCurrentRow(), aMaze.getCurrentCol()));		//add your position to the ArrayList
				}
				
				else if(aMaze.isOpen(Maze.Direction.DOWN) && !theAL.contains(new Point(aMaze.getCurrentRow() + 1, aMaze.getCurrentCol()))) //if position below is open
				{
					aMaze.move(Maze.Direction.DOWN);		//move down
					myStack.push(Maze.Direction.DOWN);	//record your move on your call stack
					theAL.add(new Point(aMaze.getCurrentRow(), aMaze.getCurrentCol()));	//add your position to the ArrayList
				}
				
				else if(aMaze.isOpen(Maze.Direction.LEFT) && !theAL.contains(new Point(aMaze.getCurrentRow(), aMaze.getCurrentCol() - 1)))	//if position to the left is open
				{	
					aMaze.move(Maze.Direction.LEFT);		//move left
					myStack.push(Maze.Direction.LEFT);	//record your move on your call stack
					theAL.add(new Point(aMaze.getCurrentRow(), aMaze.getCurrentCol()));	//add your position to the ArrayList
				}
				
				else if(aMaze.isOpen(Maze.Direction.RIGHT) && !theAL.contains(new Point(aMaze.getCurrentRow(), aMaze.getCurrentCol() + 1)))	//if position to the right is open
				{
					aMaze.move(Maze.Direction.RIGHT);		//move right
					myStack.push(Maze.Direction.RIGHT);	//record your move on your call stack
					theAL.add(new Point(aMaze.getCurrentRow(), aMaze.getCurrentCol()));	//add your position to the ArrayList
				}
				
				else 			//dead end: start backtracking
				{
					if(myStack.peek() == Maze.Direction.UP)		//if you just moved up
					{
						myStack.pop();	//pop the stack to undo the record of this move
						aMaze.move(Maze.Direction.DOWN);	//move the opposite direction to undo the move
					}
					
					else if(myStack.peek() == Maze.Direction.DOWN)	//if you just moved down
					{
						myStack.pop();	//pop the stack to undo the record of this move
						aMaze.move(Maze.Direction.UP);		//move the opposite direction to undo the move
					}
					
					else if(myStack.peek() == Maze.Direction.RIGHT)	//if you just moved to the right
					{
						myStack.pop();	//pop the stack to undo the record of this move
						aMaze.move(Maze.Direction.LEFT);		//move the opposite direction to undo the move
					}
					
					else if(myStack.peek() == Maze.Direction.LEFT)	//if you just moved to the left
					{
						myStack.pop();		//pop the stack to undo the record of this move
						aMaze.move(Maze.Direction.RIGHT);		//move the opposite direction to undo the move
					}
				}
			}
			
			else
			{
				finished = true;		//if you quit, change the boolean to true to end the loop
				System.out.println("Program ended without solving.");
			}
			
			if(aMaze.goalReached())		//if you finish the maze, change the boolean to true to end the loop
			{
				finished = true;
				System.out.println("Maze is solved.");
			}
		
		}while(!finished);
		
		
	}
	
}
