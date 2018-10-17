

package quadratic;

import java.util.Scanner;	// Find scanner class in Java.util package

public class Quadratic {            //name a class

    
    public static void main(String[] args) {
        
       //declare variables
       
       double A; //user input variable #1
       double B; //user input variable #2
       double C; //user input variable #3
       double x1; //first x answer
       double x2; //second x answer
       double calculation; //used to do the calculations
       
       //create instance of scanner class
       
        Scanner user = new Scanner( System.in );	//set up scanner to read from keyboard
        
        //prompt user for inputs
        
        
                
        System.out.print("Enter A:");
	A = user.nextDouble();

	System.out.print("Enter B:");
	B = user.nextDouble();
        
        System.out.print("Enter C:");
	C = user.nextDouble();

	System.out.print("Given quadratic equation:"+A+"X^2 + "+B+"x + "+C+"=0");
        
        //adding in the part of the equation under the radical
        calculation = B * B - 4 * A * C;
        
     
        
        
        //conditional statements for the answer 
        if(calculation > 0)    {         //if statement
            
              System.out.println("\n the roots are real and unequal");  //instructions for if the condition is true
            x1 = ( - B + Math.sqrt(calculation))/(2*A); //adding in the parts outside of the radical, and dividing by 2A
            x2 = (-B - Math.sqrt(calculation))/(2*A);
            System.out.println("x ="+x1);
            System.out.println("x ="+x2);
              
        }
        else if (calculation == 0)      
        {
            System.out.println("\n the roots are real and equal");
            x1 = (-B+Math.sqrt(calculation))/(2*A); //adding in the rest of the equation
            System.out.println("x =" +x1);
        }
        
        else 
        {
            
            System.out.print("roots are imaginary");
        }
            
        
        
        
        
       
    }
    
}
