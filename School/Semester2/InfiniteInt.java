import java.util.*;
import java.io.*;
import java.lang.*;
public class InfiniteInt extends DLList<Integer>
{
	
	private StringTokenizer tk;
public InfiniteInt()
{
	super();
}

public InfiniteInt(String newInt)
{
	
	 tk = new StringTokenizer(newInt, ",");
	while(tk.hasMoreTokens())
	{	

		try
		{
			this.addLast(Integer.parseInt(tk.nextToken()));
		}
		catch(NumberFormatException e)
		{
			throw new IllegalArgumentException("Error, must pass in numbers");
		}
	}
}

public boolean equals(Object obj)
{
if(obj == null)			//if you put in null, the point cant be equal to null
			return false;		//so that test returns false
			
			else
        
		if(this.getClass() == obj.getClass())		//if it isn't null, you check what class each thing belongs to
		{
			return this.toString().equals(obj.toString());	
		}

       		return false;		//if not, return false because the two objects are not equal
}

public String toString()
{
	
	if(this.isEmpty())
	{
		throw new IllegalStateException("Error, cannot be empty");
	}
		DLLNode cursor = head;
		String str = "";
		
		while(cursor != null)
		{
			Integer newInt = (Integer) cursor.data;
			
			if(cursor.prev == null)				//first
			{
				if(cursor.next == null)
				str = str + cursor.data;
				else
					str = str + cursor.data + ",";
			}
			else if(cursor.next !=null)				//inbetween first and last
			{
				if(newInt %  10 == newInt)
				{
					str = str +  "00" + cursor.data + ",";
				}
				else if(newInt % 100 == newInt)
				{
					str = str + "0" + cursor.data + ",";
				}
				else
					str = str + cursor.data + ",";
				 
			}
			else   								//last
			{
				if(newInt %  10 == newInt)
				{
					str = str +  "00" + cursor.data;
				}
				else if(newInt % 100 == newInt)
				{
					str = str + "0" + cursor.data;
				}
				else
					str = str + cursor.data;
			}
				
				cursor = cursor.next;
		}
		
		return str ;
		
		//DLLNode cursor = head;
		//System.out.println(cursor.data.getClass());
		//return super.toString();
}
	
public boolean isEven()
{
	
	//String str = this.tail.data;
	if(this.isEmpty())
	{
		throw new IllegalStateException("Error, cannot be empty");	
	}
	else
		
		if(this.getLast() % 2 == 0)
			return true;
		else
	return false;
}

public boolean isDivisibleBy10()
{
	if(this.isEmpty())
	{
		throw new IllegalStateException("Error, cannot be empty");	
	}
	else
		
		if(this.getLast() % 10 == 0)
			return true;
		else
	return false;
}

public boolean isDivisibleBy1000()
{
	if(this.isEmpty())
	{
		throw new IllegalStateException("Error, cannot be empty");	
	}
	else
		
		if(this.getLast() % 1000 == 0)
			return true;
		else
	return false;
	
}

public int compareTo(InfiniteInt o)
{
	DLLNode<Integer> cursor1 = this.head;
	DLLNode<Integer> cursor2 = o.head;
	
	if(this.isEmpty())
	{
		throw new IllegalStateException("Error, cannot be empty");	
	}
	else
		if(this.size() > o.size())
		{
			return 1;
		}
		else if(this.size() < o.size())
		{
			return -1;
		}

	else
		do
		{
			
			if(cursor1.data > cursor2.data)
			{
				
				return 1;
			}
			else if(cursor1.data < cursor2.data)
			{
				
				return-1;
			}
			else
			cursor1 = cursor1.next;
			cursor2 = cursor2.next;
		}
		while(cursor1 != null && cursor2 != null);
		
		return 0;
	
}

public static InfiniteInt add(InfiniteInt arg1, InfiniteInt arg2)
{
	InfiniteInt int3 = new InfiniteInt();
	int sum = 0;
	int carry = 0;
	DLLNode<Integer> cursor1 = arg1.tail;
	DLLNode<Integer> cursor2 = arg2.tail;
	//case 1: arg1 is larger.
	while(cursor1 != null || cursor2 != null)
	{
		
			
			if(cursor1 == null)
			{
				sum = cursor2.data + carry;
				cursor2 = cursor2.prev;
				
			}
			else if(cursor2 == null)
			{
				sum = cursor1.data + carry;
				cursor1 = cursor1.prev;
				
			}
			else
			{
				sum = cursor1.data + cursor2.data + carry;
					
			cursor1 = cursor1.prev;
			cursor2 = cursor2.prev;
			}
			if(sum >= 1000)
			{
				carry = 1;
				sum = sum - 1000;
				int3.addFirst(sum);
				
			}
			
			else
			{
			carry = 0;
			int3.addFirst(sum);
			}
			
		
			
	}
		if(carry == 1)
		{
			int3.addFirst(carry);
		}
	
	
	
	return int3;
	
}
	
}




