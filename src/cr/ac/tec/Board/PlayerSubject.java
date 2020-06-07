package cr.ac.tec.Board;

import cr.ac.tec.LinkedList.List.DoubleList;

public abstract class PlayerSubject {
    int stars;//Number of start
    int coins;//Number of coins
    DoubleList<PlayerObserver> StarsObserver=new DoubleList<>();
    DoubleList<PlayerObserver> CoinsObserver=new DoubleList<>();
    public void attachStarsObserver(PlayerObserver observer){
        StarsObserver.AddTail(observer);
    }
    public void attachCoinObserver(PlayerObserver observer){
        CoinsObserver.AddTail(observer);
    }
    public void detachStarsObservers(PlayerObserver observer){
        int pos=StarsObserver.FindFirstInstancePosition(observer);
        if(pos!=-1){
            StarsObserver.delete(pos);
        }
    }
    public void detachCoinsObservers(PlayerObserver observer){
        int pos=CoinsObserver.FindFirstInstancePosition(observer);
        if(pos!=-1){
            CoinsObserver.delete(pos);
        }
    }
    public void UpdateStars(){
        for(int i=0;i<StarsObserver.getLength();i++){
            StarsObserver.get(i).Update(stars);
        }
    }
    public void UpdateCoins(){
        System.out.println("Intente llamar a los observadores");
        System.out.println("El largo es "+CoinsObserver.getLength());
        for(int i=0; i<CoinsObserver.getLength();i++){

            CoinsObserver.get(i).Update(coins);
        }
    }

    public abstract int getCoins();
    public abstract void setCoins(int Coins);
    public abstract int getStars();
    public abstract void setStars(int stars);

}
