package cr.ac.tec.Events;

import cr.ac.tec.Board.Player;

import java.util.ArrayList;
import java.util.Collections;


public class ListOfEvents{
    static Integer duel = 10;
    static Integer StealCoins = 10;
    static Integer GiveAwayCoins = 8;
    static Integer Win2stars = 3;
    static Integer Win5stars= 1;
    static Integer Teleport= 10;
    static Integer StealStar = 3;
    static Integer ChangePlace= 5;
    static Integer LoseOneStar=6;





    public static void main(String[] args) {

        ArrayList<String>  mylist = new ArrayList<String>();

        for (int i=0; i<duel;i++){
            mylist.add("Duel");
        }
        for (int i=0; i<StealCoins;i++){
            mylist.add("StealCoins");
        }
        for (int i=0; i<GiveAwayCoins;i++){
            mylist.add("Duel");
        }
        for (int i=0; i<duel;i++){
            mylist.add("GiveAwayCoins");
        }
        for (int i=0; i<Win2stars;i++){
            mylist.add("Win2Stars");
        }
        for (int i=0; i<Win5stars;i++){
            mylist.add("Win5Stars");
        }
        for (int i=0; i<Teleport;i++){
            mylist.add("Teleport");
        }
        for (int i=0; i<StealStar;i++){
            mylist.add("StealStar");
        }
        for (int i=0; i<ChangePlace;i++){
            mylist.add("ChangePlace");
        }
        for (int i=0; i<LoseOneStar;i++){
            mylist.add("LoseOneStar");
        }


        System.out.println("Original List : \n" + mylist);

        Collections.shuffle(mylist);

        System.out.println("\nShuffled List : \n" + mylist);

    }
}
