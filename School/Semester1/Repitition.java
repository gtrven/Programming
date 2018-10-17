/* CSC 110 loop lab

this program will allow the user to select which loop they want to run
Class: CSC110
Programmer:Steven Crider, CSC110
date:9/28/2017

 */
import java.util.Scanner;

public class Repitition {

    public static void main(String[] args) {

        //declare variables

        int num1;
        int num2;
        int nextNum;
        int loop;

        Scanner scan = new Scanner(System.in); // add scanner

        //a do while loop

        //loop options
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        System.out.println("5");
        System.out.println("6");
        System.out.println("7");
        System.out.println("8");
        System.out.println("9");
        System.out.println("10");
        System.out.println("11");

        do {
            System.out.print("\nWhich loop would you like to perform?: ");
            loop = scan.nextInt();

//switch statement
            switch (loop) {


                case 1:                 //will print a single row of 15 asterisks
                {
                    num1 = 1;

                    while (num1 <= 15) {

                        System.out.print("*");
                        num1++;
                    }


                }


                break;

                case 2:                             //will print a single row of 15 asterisks
                    for (num1 = 1; num1 <= 15; num1++) {
                        System.out.print("*");
                    }

                    break;

                case 3:                             //will show all odd numbers from 1 to 50
                    for (int oddNum = 1; oddNum <= 50; oddNum++) {
                        if (oddNum % 2 == 0) {
                        } else {
                            System.out.println(oddNum);

                        }

                    }

                    break;

                case 4:                             //will display all integers from 1 to max
                    int max;


                    System.out.print("Enter a positive number: ");
                    max = scan.nextInt();

                    if (max > 0) {

                        for (nextNum = 1; nextNum <= max; nextNum++) {
                            System.out.print("\n" + nextNum);

                        }
                    }

                    break;

                case 5:                             //will display all integers from 1, down to min
                    int min;

                    System.out.print("Enter a negative number: ");
                    min = scan.nextInt();

                    if (min < 0) {

                        for (nextNum = 1; nextNum >= min; nextNum--) {
                            System.out.print("\n" + nextNum);
                        }

                    }

                    break;


                case 6:                          //will add all even numbers from 2 to max, and print the result

                    int total = 0;

                    System.out.print("Enter a positive number: ");
                    max = scan.nextInt();

                    for (num1 = 2; num1 <= max; num1++) {

                        if (num1 % 2 == 0) {

                            total = num1 + total;




                        }


                    }
                    System.out.print("\n" + total + "is your total");

                    break;

                case 7:                 //will print numbers from 1 to max, starting a new line every 5 numbers

                    System.out.print("Enter a positive number: ");
                    max = scan.nextInt();

                    for (nextNum = 1; nextNum <= max; nextNum++) {
                        System.out.print("  " + nextNum);

                        if (nextNum % 5 == 0)
                            System.out.print("\n");

                    }

                    break;

                case 8:             //will print a diagonal row of asterisks
                    int LINES = 7;

                    for (int row = 0; row < LINES; row++) {

                        //spaces
                        for (int spaces = 0; spaces < row; spaces++)
                            System.out.print(" ");

                        //asterisks
                        for (int star = 1; star <= 1; star++)
                            System.out.print("*");

                        System.out.println();  //move to the next line
                    }

                    break;


                case 9:         //upside down right triangle
                    for (int count1 = 10; count1 >= 1; count1--) {
                        for (int count2 = 1; count2 <= count1; count2++) {
                            System.out.print("*");
                        }
                        System.out.println();


                    }
                    System.out.print("\n");

                    break;

                case 10:        //right triangle upside down and translated

                    for( int row=0; row <= 10; row++ ) {
                        //spaces
                        for (int spaces=0; spaces <=row; spaces++)
                            System.out.print(" ");

                        //asterisks
                        for (int star=10; star >=row; star--)
                            System.out.print("*");





                        System.out.println();  //move to the next line


                    }




            }

        }while (loop < 11) ;
    }
}



