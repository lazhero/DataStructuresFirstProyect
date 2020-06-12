package cr.ac.tec.Events.lists;

import cr.ac.tec.LinkedList.List.DoubleList;

/**
 * This class contains the minigames of the duel
 * @author Gabriel Solano
 */
public class ListOfMiniGames {
    protected static DoubleList milista;
    public static ListOfMiniGames instance=null;

    /**
     * Method for generating the list of minigames
     * @author Gabriel Solano
     */
    private ListOfMiniGames(){
        milista = new DoubleList<String>();
        milista.AddTail("MemoryGame");
        milista.AddTail("PRS");
        milista.AddTail("TicTacToe");
        milista.AddTail("PressFirst");
        milista.AddTail("Shoot");
        milista.AddTail("RandomNumber");
        milista=milista.Shuffle();
    }

    /**
     * @author Gabriel Solano
     * Gets the instance, if it does not exist creates a
     * @return
     */
    public static ListOfMiniGames getInstance() {
        if (instance == null) {
            instance = new ListOfMiniGames();
        }
        return instance;
    }

    /**
     * Get the double list
     * @author Gabriel Solano
     * @return
     */
    public DoubleList getDoubleList(){
        return milista;
    }
}

