package cr.ac.tec.Minigames.RandomNumber;


import static cr.ac.tec.Minigames.RandomNumber.Interface.text;
import static cr.ac.tec.Minigames.RandomNumber.Main.game;


public class RandomNumberGame {
    public static boolean playable = true;
    public static boolean player1Turn = true;
    public static double randomNumber;
    public static double numberPlayer1;
    public static double numberPlayer2;

    public static void main(String[] args){
        generateRand(0,5);
        System.out.println(randomNumber);
    }


    public static void restart(){
        playable = true;
        player1Turn = true;
        game();
    }

    public static void checkDraw(){
        if (numberPlayer1 == numberPlayer2){
            text.setText("Both players guessed\nthe same number, try again!");
        } else {
            verifyIfPlayable();
        }
    }


    public static void verifyIfPlayable(){
        if (playable) {
            if (player1Turn) {
                if (numberPlayer1 == randomNumber) {
                    playable = false;
                    Interface.text.setTranslateX(22);
                    Interface.text.setText("            Player 1 won!\nThe random number was " + randomNumber + "!");
                    return;
                }
                player1Turn = false;
            }
            if (!player1Turn) {
                if (numberPlayer2 == randomNumber) {
                    playable = false;
                    Interface.text.setTranslateX(22);
                    Interface.text.setText("            Player 2 won!\nThe random number was " + randomNumber + "!");
                    return;
                } else{
                    player1Turn = true;
                    game();
                }
            }
        } else{
            return;
        }
    }


    public static void generateRand(double min, double max){
        randomNumber= (int)(Math.random()*((max-min)+1))+min;
    }
}