// This will implement an "Expression Tree" which stores an arithmetic expression

import java.util.*;

public class ExpTree
{
	//-------data
	private ExpNode root;
	int count = 0;
	
	//-------constructor
	public ExpTree()
	{
		root = null;
	}

	//constructor where a string is passed in.  It is parsed and stored
	public ExpTree(String expString)
	{
		//declare StringTokenizer, Stacks, and other variables used in parsing
		StringTokenizer tokenizer = new StringTokenizer (expString, "()+-*/%", true);
		String token;
		ExpNode operator, leftOperand, rightOperand;
		Stack<ExpNode> operators = new Stack<ExpNode>();
		Stack<ExpNode> operands = new Stack<ExpNode>();

		//break up expString into tokens
		while (tokenizer.hasMoreTokens())
		{
			token = tokenizer.nextToken();

			// if the current token is a left paren, ignore it
			if (token.equals ("("))
				;

			// if the current token is an operator, put it on the
			// operator stack
			else if ((token.equals ("+")) || (token.equals ("-")) ||
						(token.equals ("*")) || (token.equals ("/"))  || (token.equals ("%")))
				operators.push (new ExpNode(token));

			//if the current token is a right paren, pop the operators stack
			//to get the operator, pop the operands stack twice to get the two
			//operands (stored as expression trees).   Then make the two operands
			//children of the operator and push back on the operands tree.
			else if (token.equals (")"))
			{
				operator = operators.pop();

				rightOperand = operands.pop();
				leftOperand = operands.pop();

				operator.left = leftOperand;
				operator.right = rightOperand;

				operands.push(operator);
			}

			//otherwise, the token should be a number - put it in the operands stack
			else
				operands.push (new ExpNode(token));

		} // while (tokenizer.hasMoreTokens())

		//when finished parsing, the operands stack should contain the fully-built
		//expression tree.
		if (!operands.isEmpty())
			root = operands.pop();
	}

	//-------methods

	//isEmpty()
	public boolean isEmpty()
	{
		return (root == null);
	}

	//seeTree - returns a String that is what it looks like on its side
	public String seeTree()
	{
		return recursiveSeeTree(root, 0);
	}

	//recursive version of recurseInOrder
	private String recursiveSeeTree(ExpNode subTree, int indent)
	{
		String str = "";

		if (subTree == null)
			return str;     //return empty String
		else
		{
			//go down RHS
			str = str + recursiveSeeTree(subTree.right, indent+1);     //go down the RHS with one mre indent

			//put your own node on the str
			str = str + "\n\n";    //skip 3 lines for separation
			for (int i=0; i<indent; i++)
				str = str + "\t\t";     //2 tabs for each indent
			str = str + subTree.data;
			str = str + "\n\n";    //skip 3 lines for separation

			str = str + recursiveSeeTree(subTree.left, indent+1);     //go down the LHS with one more indent

			return str;
		}
	}

	//inorder traversal - starts the recursive calls to print inorder
	public String inOrder()
	{
		return recursiveInOrder(root);
	}

	//inorder traversal - recursive left side of tree, print node, right side of tree
	private String recursiveInOrder(ExpNode subTree)
	{
		if (subTree == null)
			return "";	 //don't try to do anything if tree is null

		//else build up a String to return.  It will involve recrsive calls
		String returnString = "";
		if (subTree.left != null)
		{
			returnString += "(" + recursiveInOrder(subTree.left);
		}
		returnString += subTree.data;
		if (subTree.right != null)
		{
			returnString += recursiveInOrder(subTree.right) + ")";
		}

		return returnString;
	}


	public int numPlus()
	{
		if(this.isEmpty())
		{
			throw new IllegalStateException("Error, cannot be empty");
		}
		else
		return recursiveNumPlus(root);

	}

	private int recursiveNumPlus(ExpNode subTree)
	{
		int count = 0;
		
			//stopping condition
			if(subTree == null)
			{
				
				return 0;
			}
			if(subTree.data.equals("+"))
			{
				count++;
			}

			
			//check left
			count = count + recursiveNumPlus(subTree.left); 
			
		
			count = count + recursiveNumPlus(subTree.right);

		
		return count;
			
	}

	public double evaluate()
	{	
		

		if(this.isEmpty())
		{
			throw new IllegalStateException("Error, cannot be empty");
		}
		else
		return recursiveEvaluate(root);

	}

	private double recursiveEvaluate(ExpNode subTree)
	{
		
		double result = 0.0;
		
		if(subTree.data.equals("+"))
		{
			return recursiveEvaluate(subTree.left) + recursiveEvaluate(subTree.right);
		}
		if(subTree.data.equals("-"))
		{
			return recursiveEvaluate(subTree.left) - recursiveEvaluate(subTree.right);
		}

		if(subTree.data.equals("*"))
		{
			return recursiveEvaluate(subTree.left) * recursiveEvaluate(subTree.right);
		}

		if(subTree.data.equals("/"))
		{
			double rightOperand = recursiveEvaluate(subTree.right);
			if(rightOperand == 0)
				throw new java.lang.ArithmeticException("Error, cannot divide by zero");
			else
			return recursiveEvaluate(subTree.left) / rightOperand;
		}

		if(subTree.data.equals("%"))
		{
			double rightOperand = recursiveEvaluate(subTree.right);
			if(rightOperand == 0)
				throw new java.lang.ArithmeticException("Error, cannot mod by zero");
			else
			return recursiveEvaluate(subTree.left) % rightOperand;
		}
		else
			return Double.parseDouble(subTree.data);
			
		


		
	}
	
}

//***************************************************************************
// ExpNode holds a "node" for an ExpTree.
class ExpNode
{
	//data (really should be private, but is public for convinience while we study this)
	protected String data;
	protected ExpNode left;
	protected  ExpNode right;

	//constructor
	public ExpNode(String el)
	{
		data = el;
		left = right = null;
	}

	//methods
	//toString() - this is how an ExpNode represents itself as a String
	public String toString()
	{
		return data;
	}

}
