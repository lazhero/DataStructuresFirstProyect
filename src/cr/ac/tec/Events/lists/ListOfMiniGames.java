package cr.ac.tec.Events.lists;

import cr.ac.tecLinkedList.List.DoubleList;

import java.util.ArrayList;
import java.util.Collections;
import cr.ac.tec.Minigames.Memory.*;
public class ListOfMiniGames {
    protected static DoubleList milista;
    public static ListOfMiniGames instance=null;


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
    public static ListOfMiniGames getInstance() {
        if (instance == null) {
            instance = new ListOfMiniGames();
        }
        return instance;
    }
    public DoubleList getDoubleList(){
        return milista;
    }
}

