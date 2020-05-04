package cr.ac.tec.Events;

import cr.ac.tec.Board.Player;

public abstract  class Event {
    /**
     * Depend on each events
     * @param player
     */

    public abstract void event(Player player);


}
