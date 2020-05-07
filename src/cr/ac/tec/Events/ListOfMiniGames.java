package cr.ac.tec.Events;

import java.util.ArrayList;
import java.util.Collections;

public class ListOfMiniGames {


    public void MinigamesList(){
        ArrayList<String> milista = new ArrayList<>();
        milista.add("MemoryGame");
        milista.add("PRS");
        milista.add("TicTacToe");
        milista.add("PressFirst");
        milista.add("DiamondHunter");
        milista.add("Shoot");
        milista.add("RandomNumber");

        System.out.println(milista);
        Collections.shuffle(milista);
        System.out.println(milista);
        return;
    }
}
