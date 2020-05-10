package cr.ac.tec.Events;

import cr.ac.tec.Board.Player;

public abstract  class Event {
    /**
     * Depend on each events
     * @param player
     */

    public abstract void event1(Player player);

    /**
     * Depend on each event, but events with two players
     * @param player1
     * @param player2
     */

    public abstract void event2 (Player player1, Player player2);

    /**
     * Information of the event
     * @param player
     */

    public abstract void EventData(Player player);


}
