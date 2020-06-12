package cr.ac.tec.Events.lists;

import cr.ac.tec.Events.YellowEvents.*;
import cr.ac.tec.LinkedList.List.DoubleList;
import cr.ac.tec.Stack.Stack;

/**
 * This class contains the events of the yellow box
 * @author Gabriel Solano
 */

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
    protected static Stack mystack;


    /**
     * Method for generating the stack of events
     * @author Gabriel Solano
     *
     */
    private ListOfEvents() {
        mystack = new Stack<>();

        for (int i = 0; i < duel; i++) {
            mystack.push(new Duel());
        }
        for (int i = 0; i < StealCoins; i++) {
            mystack.push(new StealCoins());
        }
        for (int i = 0; i < GiveAwayCoins; i++) {
            mystack.push(new GiveAwayCoins());
        }
        for (int i = 0; i < Win2stars; i++) {
            mystack.push(new WinTwoStars());
        }
        for (int i = 0; i < Win5stars; i++) {
            mystack.push(new WinFiveStars());
        }
        for (int i = 0; i < Teleport; i++) {
            mystack.push(new Teleport());
        }
        for (int i = 0; i < StealStar; i++) {
            mystack.push(new StealStar());
        }
        for (int i = 0; i < ChangePlace; i++) {
            mystack.push(new ChangePlace());
        }
        for (int i = 0; i < LoseOneStar; i++) {
            mystack.push(new LoseOneStar());
        }
        mystack.Shuffle();

    }

    /**
     * @author Gabriel Solano
     * Gets the instance, if it does not exist creates a
     * @return
     */
    public static ListOfEvents getInstance() {
        if (instance == null) {
            instance = new ListOfEvents();
        }
        return instance;
    }

    /**
     * Get the Stack
     * @author Gabriel Solano
     * @return
     */

    public  Stack getMystack() {
        return mystack;
    }

}
