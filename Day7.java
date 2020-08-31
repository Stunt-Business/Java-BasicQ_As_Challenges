// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 7 : Challenge IV - basic calculator
// Day 7 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?

public class Day7 
{

    public static void main(String[] args)
    {

        // instantiante the object Day7_Calculator here
        Day7_Calculator calculator = new Day7_Calculator();
        
        //initialize your operands
        double a = 5;
        double b = 0;

        System.out.printf("\n> a = %.2f and b = %.2f.\n",a,b);
        System.out.printf("\n> a / b = %.2f", calculator.divide_operands(a, b));
        System.out.printf("\n> a + b = %.2f", calculator.add_operands(a, b));
        System.out.printf("\n> a - b = %.2f", calculator.subtract_operands(a, b));
        System.out.printf("\n> a * b = %.2f", calculator.multiply_operands(a, b));

        System.out.println("\n> End of program. <");

    }
    
}