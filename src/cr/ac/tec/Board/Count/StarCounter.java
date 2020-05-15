package cr.ac.tec.Board.Count;

import cr.ac.tec.Board.PlayerObserver;

public class StarCounter implements PlayerObserver {
    private Counter counter;
    public StarCounter(double width,double height, String route,String format){
        counter=new Counter(width,height,route,format);
    }
    @Override
    public void Update(int change) {
        System.out.println("Trato de setear la cuenta a "+change);
        counter.setCount(change);
    }
    public Counter getCounter(){
        return counter;
    }

}
