// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 3 : Challenge I - Input and user functions using the value coming from the String[] args.
// Day 3 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

public class Day3 
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
        int user_value = 0;
        // the size must be 1
        if(args.length == 0 || args.length > 1)
        {
            // Only expect one Integer for the program to run
            System.out.println("You must enter one parameter in the command line.");

        }
        else
        {
            user_value = Integer.parseInt(args[0]); //get the first parameter of the command line
        
            // display the value entered by the user
            System.out.printf("\nYou entered : %d.\n", user_value);

            // return the double of the parameter
            System.out.println("The double of the parameter is : " + Day3.double_parameter(user_value));
        } 

        System.out.println("End of program.");

        
    }
    
}