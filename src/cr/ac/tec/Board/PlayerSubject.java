package cr.ac.tec.Board;

import cr.ac.tec.Board.Other.PlayerObserver;
import cr.ac.tec.LinkedList.List.DoubleList;

/**
 * @author Andrey Zuñiga
 *
 */
public abstract class PlayerSubject {
    int stars;//Number of start
    int coins;//Number of coins
    DoubleList<PlayerObserver> StarsObserver=new DoubleList<>();
    DoubleList<PlayerObserver> CoinsObserver=new DoubleList<>();

    /**
     * @author Andrey Zuñiga
     * @param observer
     */
    public void attachStarsObserver(PlayerObserver observer){
        StarsObserver.AddTail(observer);
    }

    /**
     * @author Andrey Zuñiga
     * @param observer
     */
    public void attachCoinObserver(PlayerObserver observer){
        CoinsObserver.AddTail(observer);
    }

    /**
     * @author Andrey Zuñiga
     * @param observer
     */
    public void detachStarsObservers(PlayerObserver observer){
        int pos=StarsObserver.FindFirstInstancePosition(observer);
        if(pos!=-1){
            StarsObserver.delete(pos);
        }
    }

    /**
     * @author Andrey Zuñiga
     * @param observer
     */
    public void detachCoinsObservers(PlayerObserver observer){
        int pos=CoinsObserver.FindFirstInstancePosition(observer);
        if(pos!=-1){
            CoinsObserver.delete(pos);
        }
    }

    /**
     * Updates the number of Coins per player
     * @author Andrey Zuñiga
     */
    public void UpdateStars(){
        for(int i=0;i<StarsObserver.getLength();i++){
            StarsObserver.get(i).Update(stars);
        }
    }

    /**
     * Updates the number of coins per player
     * @author Andrey Zuñiga
     */
    public void UpdateCoins(){
        for(int i=0; i<CoinsObserver.getLength();i++){
            CoinsObserver.get(i).Update(coins);
        }
    }

    /**
     * @author Andrey Zuñiga
     * @return
     */
    public abstract int getCoins();

    /**
     * @author Andrey Zuñiga
     * @param Coins
     */
    public abstract void setCoins(int Coins);

    /**
     * @author Andrey Zuñiga
     * @return
     */
    public abstract int getStars();

    /**
     * @author Andrey Zuñiga
     * @param stars
     */
    public abstract void setStars(int stars);

}
