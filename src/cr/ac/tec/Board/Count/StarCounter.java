package cr.ac.tec.Board.Count;

import cr.ac.tec.Board.PlayerObserver;

public class StarCounter implements PlayerObserver {
    private Counter counter;
    /**
     *
     * @param width
     * @param height
     * @param route
     * @param format
     */
    public StarCounter(double width,double height, String route,String format){
        counter=new Counter(width,height,route,format);
    }
    /**
     *
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
