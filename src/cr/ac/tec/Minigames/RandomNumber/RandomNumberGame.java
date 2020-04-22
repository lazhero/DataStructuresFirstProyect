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


    /**
     * Restarts the mini game from square one
     */
    public static void restart(){
        playable = true;
        player1Turn = true;
        game();
    }

    /**
     * Checks if a draw happened between two players, if that's not the case it verify's if the game is still playable.
     */
    public static void checkDraw(){
        if (numberPlayer1 == numberPlayer2){
            text.setText("Both players guessed\nthe same number, try again!");
        } else {
            verifyIfPlayable();
        }
    }


    /**
     * Checks if a player guessed correctly the number, if that's not the case it restarts the game.
     */
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


    /**
     * Generates a random number.
     * @param min smallest number you wish to guess.
     * @param max highest number you wish to guess.
     */
    public static void generateRand(double min, double max){
        randomNumber= (int)(Math.random()*((max-min)+1))+min;
    }
}