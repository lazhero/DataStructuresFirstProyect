package cr.ac.tec.Events.lists;

import cr.ac.tec.Events.YellowEvents.*;
import cr.ac.tec.LinkedList.List.DoubleList;


public class ListOfEvents {

    static Integer duel = 10;
    static Integer StealCoins = 10;
    static Integer GiveAwayCoins = 8;
    static Integer Win2stars = 3;
    static Integer Win5stars = 1;
    static Integer Teleport = 10;
    static Integer StealStar = 3;
    static Integer ChangePlace = 5;
    static Integer LoseOneStar = 6;
    public static ListOfEvents instance = null;
    protected static DoubleList mylist;


    private ListOfEvents() {
        mylist = new DoubleList<>();

        for (int i = 0; i < duel; i++) {
            mylist.AddTail(new Duel());
        }
        for (int i = 0; i < StealCoins; i++) {
            mylist.AddHead(new StealCoins());
        }
        for (int i = 0; i < GiveAwayCoins; i++) {
            mylist.AddHead(new GiveAwayCoins());
        }
        for (int i = 0; i < Win2stars; i++) {
            mylist.AddHead(new WinTwoStars());
        }
        for (int i = 0; i < Win5stars; i++) {
            mylist.AddHead(new WinFiveStars());
        }
        for (int i = 0; i < Teleport; i++) {
            mylist.AddHead(new Teleport());
        }
        for (int i = 0; i < StealStar; i++) {
            mylist.AddHead(new StealStar());
        }
        for (int i = 0; i < ChangePlace; i++) {
            mylist.AddHead(new ChangePlace());
        }
        for (int i = 0; i < LoseOneStar; i++) {
            mylist.AddHead(new LoseOneStar());
        }
        mylist=mylist.Shuffle();

    }

    public static ListOfEvents getInstance() {
        if (instance == null) {
            instance = new ListOfEvents();
        }
        return instance;
    }

    public DoubleList getDoubleList(){
        return mylist;
    }


}
