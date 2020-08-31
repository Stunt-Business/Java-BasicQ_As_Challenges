// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 4 :  Challenge II - Input and user functions using the Scanner util from java
// Day 4 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

import java.util.Scanner;

public class Day4
{
    /**
     * 
     *  Request the user to enter a number.
     *  Use the integer entered by the user in the function that you are creating.
     *  This function return the double of the parameter.
     * 
     * 
     */

    /**
     * This function returns the double of your parameter
     * @param value
     * @return
     */
    public static int double_parameter(int value)
    {
        return value * 2;
    }

    /**
     * run your class here
     * @param args
     */
    public static void main(String[] args)
    {   
        // initialize your scanner
        Scanner sc =  new Scanner(System.in);
        // Request the user to enter a value;
        System.out.printf("Please enter an integer : ");
        int user_value = sc.nextInt();
        sc.close();

        // display the value entered by the user
        System.out.printf("\nYou entered : %d.\n", user_value);

        // return the double of the parameter
        System.out.println("The double of the parameter is : " + Day4.double_parameter(user_value));
        
    }
    
}