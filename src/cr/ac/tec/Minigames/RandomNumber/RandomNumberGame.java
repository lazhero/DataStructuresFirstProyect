package cr.ac.tec.Minigames.RandomNumber;


import java.util.Scanner;

public class RandomNumberGame {
    private static boolean playable = true;
    private static boolean player1Turn = true;
    private static double randomNumber;
    private static double numberPlayer1;
    public static double numberPlayer2;

    public static void main(String[] args){
        generateRand(0,5);
        inputNumber();
    }

    public static void inputNumber(){
        Scanner in = new Scanner(System.in);
        System.out.println(randomNumber);
        System.out.println("Player 1, enter your number");
        numberPlayer1 = in.nextDouble();
        System.out.println("Player 2, enter your number");
        numberPlayer2 = in.nextDouble();
        verifyIfPlayable();
    }


    public static void verifyIfPlayable(){
        if (player1Turn && playable){
            if (numberPlayer1 == randomNumber){
                playable = false;
                System.out.println("Player 1 won!\nThe random number was " + randomNumber + "!");
                return;
            }
        }
        if (!player1Turn && playable){
            if (numberPlayer2 == randomNumber){
                playable = false;
                System.out.println("Player 2 won!\nThe random number was " + randomNumber + "!");
                return;
            }
        } else {
            inputNumber();
        }
    }


    public static void generateRand(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        randomNumber=x;
    }
}