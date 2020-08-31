// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 5 : Challenge III - Input and user functions using the Scanner and args util from java
// Day 5 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

import java.util.Scanner;

public class Day5 
{
    public static void main(String[] args)
    {
        int user_value = 0;
        // the size must be 1
        if(args.length == 0 || args.length > 1)
        {
            // Only expect one Integer for the program to run
            System.out.println("You should have entered one parameter in the command line.");
            // initialize your scanner
            Scanner sc =  new Scanner(System.in);
            // Request the user to enter a value;
            System.out.printf("Please enter an integer : ");
            user_value = sc.nextInt();
            sc.close();

        }
        else
        {
            user_value = Integer.parseInt(args[0]); //get the first parameter of the command line
        
        } 
        // display the value entered by the user
        System.out.printf("\nYou entered : %d.\n", user_value);

        // return the double of the parameter
        System.out.println("The double of the parameter is : " + Day3.double_parameter(user_value));

        System.out.println("End of program.");


    }
    
}