package cr.ac.tec.Minigames.RandomNumber;


import static cr.ac.tec.Minigames.RandomNumber.Interface.*;
//import static cr.ac.tec.Minigames.RandomNumber.Main.game;

/**
 * A guessing game in which two players try to guess a random number, the first one to guess the number wins.
 *
 * @author migue
 */
public class RandomNumberGame {
    public static boolean playable = true;
    public static boolean player1Turn = true;
    public static double randomNumber;
    public static double numberPlayer1;
    public static double numberPlayer2;


    /**
     * Collects each number input by a player.
     */

    public static void game(int player1,int player2){
        if (playable){
            if (player1Turn) {
                text.setText("Player "+player1+ "enter\n your number");
                text.setTranslateX(85);
                text.setTranslateY(100);
                button.setOnMouseClicked(e -> {
                    numberPlayer1 = Double.parseDouble(getNumber());
                    player1Turn = false;
                    game(player1,player2); //We call game() again but this time player1Turn is false, this way it enters the second if.
                });
            }
            if (!player1Turn){
                text.setText("Player "+player2+",enter\n your number");
                button.setOnMouseClicked(e ->{
                    numberPlayer2 = Double.parseDouble(getNumber());
                    player1Turn = true;
                    checkDraw(player1,player2); //Once we finish the second if it checks if the game has a draw.
                });
            }
        }
    }


    /**
     * Restarts the mini game from square one
     */
    public static void restart(int player1, int player2){
        generateRand(0,5);
        System.out.println(randomNumber);
        playable = true;
        player1Turn = true;
        game(player1,player2);
    }

    /**
     * Checks if a draw happened between two players, if that's not the case it verify's if the game is still playable.
     */
    public static void checkDraw(int player1,int player2){
        if (numberPlayer1 == numberPlayer2 && numberPlayer1 == randomNumber){
            text.setText("      Both players guessed\nthe same number, try again!");
            text.setTranslateX(22);
        } else {
            verifyIfPlayable(player1,player2);
        }
    }


    /**
     * Checks if a player guessed correctly the number, if that's not the case it restarts the game.
     */
    public static void verifyIfPlayable(int player1,int player2){
        if (playable) {
            if (player1Turn) {
                if (numberPlayer1 == randomNumber) {
                    playable = false;
                    Interface.text.setTranslateX(22);
                    Interface.text.setText("            Player "+player1+ " won!\nThe random number was " + randomNumber + "!");
                    victory=player1;
                    lose=player2;

                    return;
                }
                player1Turn = false;
            }
            if (!player1Turn) {
                if (numberPlayer2 == randomNumber) {
                    playable = false;
                    Interface.text.setTranslateX(22);
                    Interface.text.setText("            Player"+player2+ "won!\nThe random number was " + randomNumber + "!");
                    victory=player2;
                    lose=player1;
                    return;
                } else{
                    player1Turn = true;
                    game(player1,player2);
                }
            }
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
