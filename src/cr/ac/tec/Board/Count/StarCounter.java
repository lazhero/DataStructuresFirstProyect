package cr.ac.tec.Board.Count;

import cr.ac.tec.Board.Other.PlayerObserver;

/**
 * Start the coin counter
 * @author Miguel Mesen and Andrey Zuñiga
 *
 */

public class StarCounter implements PlayerObserver {
    private Counter counter;
    /**
     * Method that starts the coin counter
     * @param width
     * @param height
     * @param route
     * @param format
     */
    public StarCounter(double width,double height, String route,String format){
        counter=new Counter(width,height,route,format);
    }
    /**
     * Update value if someone wins or loses coins
     * @param change
     */
    @Override
    public void Update(int change) {
        counter.setCount(change);
    }
    /**
     *
     * @return
     */
    public Counter getCounter(){
        return counter;
    }

}
