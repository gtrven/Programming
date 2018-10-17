/*
This class will perform the basic functions of a call stack, such as:
	1. push something onto the stack
	2. pop(remove) something from the stack
	3. peek at the most recently added thing in the stack
	4. check if the stack is empty
	5. check the size of the stack

Written by:
	Steven Crider
	CSC 205


*/
import java.util.*;
import java.io.*;

public class Stack<E> implements Serializable		//use <E> to allow for generic data type
{
	//data 
	private ArrayList<E> theAL;

	
	//default constructor
	public Stack()
	{
		this.theAL = new ArrayList<E>();
	}

	//methods

	public void push(E elt)		//add a new thing to the stack
	{
		this.theAL.add(0, elt);		//add value to the 0 position

	}

	public E pop()			//remove something from the stack (Last in, first out)
	{
		E value;		//store new variable using E (generic datatype) 
		if(this.theAL.isEmpty())
			throw new EmptyStackException();
		else
			value = this.theAL.get(0);	//set generic placeholder variable to the value of position 0 in the array
			this.theAL.remove(0);		//removed whats in the 0 position
			return value;			//return the placeholder variable (what you just removed from the arrayList)
			
	
	}

	public E peek()		//look at whatever is on top of the stack (last in)
	{
		if(this.theAL.isEmpty())
			throw new EmptyStackException();		//error handling
		else
			return this.theAL.get(0);		//returns whats in the 0 position
	}

	public boolean isEmpty()	//check if the stack(arrayList) is empty
	{
		return this.theAL.isEmpty();		//ArrayList method being called
	}
		
	public int size()		//return the size of the stack
	{
		return this.theAL.size();		//ArrayList method being called
	}
}
