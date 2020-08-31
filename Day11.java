// ---------------------------------------------------
// Author    :  Benjamin Kataliko Viranga
// Community :  Stunt Business
// Community website : www.stuntbusiness.com
// 
// 30 Days - Q&A Java basic
// Day 11 :  Challenge VII - Rock Paper Scissors
// Day 11 | IG : https://www.instagram.com/benjivrik/
// ----------------------------------------------------
// what would be the output of this program ?
import java.util.Random;
import java.util.Scanner;
public class Day11 
{
    /**
     *    
     *  Rock Paper Scissor 
    Play Rock Paper Scissor with your computer
    Plays
    Player 1      Player 2       Winner
     Rock         Scissor       Player 1
     Rock          Rock         Equality
     Rock          Paper        Player 2
     Paper        Scissor       Player 2
     Paper         Rock         Player 1
     Paper         Paper        Equality
     Scissor      Scissor       Equality
     Scissor       Rock         Player 2
     Scissor       Paper        Player 1
     */

     public static void main(String[] args)
     {
        // Available plays for String 
        String[] available_plays = new String[]{ "Rock", "Paper", "Scissors"};
        // variables initialization
        int computer_score = 0;
        int user_score = 0;
        int number_of_games = 0;
        // initiliaze scanner

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        String stop = "n";
        while(stop.equals("n"))
        {
            System.out.println("\n>>>>>>>>>> Starting a new game of Rock Paper Scissor <<<<<<\n");
            //  get the computer play
            int computer_play_index = rand.nextInt(available_plays.length);
            String computer_play = available_plays[computer_play_index];
            // get the user input
            System.out.println("Please choose between 'Rock', 'Paper' or 'Scissors':");
            String user_play = sc.next();

            // increase the number of game
            number_of_games++;

            // go through the user and computer_choice
            switch(computer_play)
            {
                case "Rock":  // computer played "Rock"
                    if(user_play.equals("Rock"))
                    {
                        System.out.println
                        (
                            String.format("I played %s\nAnd you played %s.", user_play, computer_play)
                        );
                        System.out.println("\n> We are equal here. Let's continue <\n");
                    }
                    if(user_play.equals("Paper"))
                    {
                        System.out.println
                        (
                            String.format("I played %s\nAnd you played %s.", user_play, computer_play)
                        );
                        System.out.println("\n> You win. <\n");

                        user_score++;
                    }
                    if(user_play.equals("Scissors"))
                    {
                        System.out.println
                        (
                            String.format("I played %s\nAnd you played %s.", user_play, computer_play)
                        );
                        System.out.println("\n> I win. <\n");

                        computer_score++;
                    }
                    break;
                case "Paper": // computer played "Paper"
                    if(user_play.equals("Rock"))
                    {
                        System.out.println
                        (
                            String.format("I played %s\nAnd you played %s.", user_play, computer_play)
                        ); 
                        System.out.println("\n> I win. <\n");

                        computer_score++;
                    }
                    if(user_play.equals("Paper"))
                    {
                        System.out.println
                        (
                            String.format("I played %s\nAnd you played %s.", user_play, computer_play)
                        );
                        System.out.println("\n> We are equal here. Let's continue <\n");
                    }
                    if(user_play.equals("Scissors"))
                    {
                        System.out.println
                        (
                            String.format("I played %s\nAnd you played %s.", user_play, computer_play)
                        );
                        System.out.println("\n> You win. <\n");

                        user_score++;
                    }
                    break;
                case "Scissors": // computer played "Scissors"
                    if(user_play.equals("Rock"))
                    {
                        System.out.println
                        (
                            String.format("I played %s\nAnd you played %s.", user_play, computer_play)
                        );
                        System.out.println("\n> You win. <\n");

                        user_score++;
                    }
                    if(user_play.equals("Paper"))
                    {
                        System.out.println
                        (
                            String.format("I played %s\nAnd you played %s.", user_play, computer_play)
                        );
                        System.out.println("\n> I win. <\n");

                        computer_score++;
                    }
                    if(user_play.equals("Scissors"))
                    { 
                        System.out.println
                        (
                            String.format("I played %s\nAnd you played %s.", user_play, computer_play)
                        );
                        System.out.println("\n> We are equal here. Let's continue <\n");
                    }
                    break;
                default:
                    System.out.println("Something went wrong with the computer choice!");
                    break;
            }

            // stats
            System.out.println("--- Current Stats ---\n");
            System.out.printf("> User score : %d.\n",user_score);
            System.out.printf("> Computer score : %d.\n",computer_score);
            System.out.printf("> Draws score : %d.\n",number_of_games - (user_score+computer_score));

            // ask the user if he wants to continue
            System.out.printf("\nDo you wanna stop ? (y/n) :");
            stop = sc.next();
            if(!stop.equals("y"))
            {
                stop = "n";
            }
            else
            {
                // stats
                System.out.println("\n--- Final Stats ---\n");
                System.out.printf("> User score : %d.\n",user_score);
                System.out.printf("> Computer score : %d.\n",computer_score);
                System.out.printf("> Draws score : %d.\n",number_of_games - (user_score+computer_score));
            }
            System.out.println("\n");
            
        }
        sc.close();
        System.out.println("End of program.");
    }
} 