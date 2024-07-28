package GuessTheNumber;

import java.util.Random;
import java.util.Scanner;

class Player1{
    int rNumber;
    int inputNumber;
    int noOfGuesses;
    void disp(){
        
        System.out.println("--------------------For Player1--------------------");
    }
    void randomNum(){
        Random r = new Random();
        this.rNumber = r.nextInt(1,100);
    }
    void takeUserInput(){
        System.out.println("Guess a number between 1 to 100: ");
        Scanner sc = new Scanner(System.in);
        inputNumber = sc.nextInt();
    }
    boolean isCorrect(){
        noOfGuesses++;
        if(rNumber == inputNumber){
            System.out.format("Number is guessed in %d attempts.\n\n",noOfGuesses);
            return true;
        }
        else if(rNumber<inputNumber){
            System.out.println("Too high...");
        }
        else if(rNumber>inputNumber){
            System.out.println("Too low...");
        }
        return false;
    }
}

class Player2 extends Player1{
    void disp(){
        System.out.println("--------------------For Player2--------------------");
    }
}

class Player3 extends Player1{
    void disp(){
        System.out.println("--------------------For Player3--------------------");
    }
}

class Check{
    boolean b = false;
    int playerGuess;
    int compareInfo(Player1 player1){
        player1.randomNum();
        player1.disp();
        while (!b) {
            player1.takeUserInput();
            b = player1.isCorrect();
        }
        return playerGuess = player1.noOfGuesses;
    }
}

public class Game{
    public static void main(String[] args) {
        System.out.println("-------------------------GAME STARTED-------------------------");
        System.out.println();
        Player1 player1 = new Player1();
        Player2 player2 = new Player2();
        Player3 player3 = new Player3();
        Check c1 = new Check();
        int player1Guess = c1.compareInfo(player1);
        Check c2 = new Check();
        int player2Guess = c2.compareInfo(player2);
        Check c3 = new Check();
        int player3Guess = c3.compareInfo(player3);
        if(player1Guess<player2Guess && player1Guess<player3Guess){
            System.out.println("--------------------Player1 is Winner!!!--------------------");
            System.out.format("Player1 guess the number in %d attempts",player1Guess);
        }
        else if(player2Guess<player3Guess){
            System.out.println("--------------------Player2 is Winner!!!--------------------");
            System.out.format("Player2 guess the number in %d attempts",player2Guess);
        }
        else if(player1Guess>player3Guess && player2Guess>player3Guess){
            System.out.println("--------------------Player3 is Winner!!!--------------------");
            System.out.format("Player3 guess the number in %d attempts",player3Guess);
        }
        else if(player1Guess == player2Guess){
            System.out.println("Tie between player1 and player2");
        }
        else if(player1Guess == player3Guess){
            System.out.println("Tie between player1 and player3");
        }
        else if(player2Guess == player3Guess){
            System.out.println("Tie between player2 and player3");
        }
        else{
            System.out.println("Tie between all");
        }
    }
}
