// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 10 : Challenge VI - Generate Password
// Day 10 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Day10 
{
     // get the alphabet
     public static String getAlphabet()
     {
        String alphabet ="";
        // upper case
        for(char value = 'A'; value <= 'Z'; value++)
        {
            alphabet += value;
        }
        // lower case
        for(char value = 'a'; value <= 'z'; value++)
        {
            alphabet += value;
        }

        // return the alphabet
        return alphabet;
     }

     //  get list of numbers
     public static String getListOfNumbers()
     {
        String numbers = "";
        for(int start = 0; start < 10; start++)
        {
            numbers += start;
        }
        return numbers;
     }

     // get all ascii values
     public static String getASCII()
     {
         String symbols = "";
         // refer to the ASCII table
         // Char start at 32
         // starting at 33 for not considering the space
         for(int start = 33; start < 128; start++)
         {
            // get the char character
            symbols += (char) start;
         }
         return symbols;
     }

     // get all special chars
     public static String getSymbols()
     {
        
        String alphabet =  getAlphabet();
        String numbers = getListOfNumbers();
        String ascii = getASCII();
        String symbols = "";
        // filtering values for extracting symbols from the ascii array
        for(char character : ascii.toCharArray())
        {
            // check if it does not exist in the ASCII array
            if(
                alphabet.indexOf(character) == -1 
                && numbers.indexOf(character) == -1
              )
            {
                // add the character to the list of symbols
                symbols += character;
            }
        }
        return symbols;
     }

     // a function for shuffling the password at the end
     public static String shuffle(String password)
     {
        // use this list for storing all the characters in your password
        List<Character> characters = new ArrayList<>();
        // add the characters from password in the above list
        for(char val :  password.toCharArray()) 
        {
            // add the character in the lsit
            characters.add(val); 
        }
            
        // shuffle the list
        Collections.shuffle(characters); 
        // use a string building for returning the password as tring
        StringBuilder pwd = new StringBuilder(); 
        // add the chars in the String builder
        for(char val : characters)
          pwd.append(val);
        
        // get the password shuffled
        password = pwd.toString();

        return password;

     }
     public static void main(String[] args) 
     {

        System.out.println("\n");
        // System.out.println(getAlphabet());
        // System.out.println(getListOfNumbers());
        // System.out.println(getASCII());
        // System.out.println(getSymbols());
    
        Random rand =  new Random();
        Scanner sc = new Scanner(System.in);

        System.out.println("How many letters do you want ?");
        int num_letters = sc.nextInt();
        System.out.println("How many numbers do you want ?");
        int num_numbers = sc.nextInt();
        System.out.println("How many symbols do you want ?");
        int num_symbols = sc.nextInt();

        // generate the password
        String password = "";

        // get the String for the alphabet
        String alphabet = getAlphabet();
        // get random letters in your password
        while(num_letters > 0)
        {
            // get a random index based on the alphabet length
            int random_index = rand.nextInt(alphabet.length());
            // add the character to the password
            password += alphabet.charAt(random_index);

            //decrease your counter
            num_letters--;
        }

        // get the String for the numbers
        String numbers = getListOfNumbers();

        // get random numbers in your password
        while( num_numbers > 0)
        {
            // get a random index based on the alphabet length
            int random_index = rand.nextInt(numbers.length());
            // add the character to the password
            password += numbers.charAt(random_index);

            //decrease your counter
            num_numbers--;
        }

        // get the String for the numbers
        String symbols = getSymbols();

        // get random numbers in your password
        while( num_symbols > 0)
        {
            // get a random index based on the alphabet length
            int random_index = rand.nextInt(symbols.length());
            // add the character to the password
            password += symbols.charAt(random_index);
            
            //decrease your counter
            num_symbols--;
        }


        // print password
        System.out.printf("Your password is %s\n", shuffle(password));


        // close the scanner
        sc.close();
     }
}