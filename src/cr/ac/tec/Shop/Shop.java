package cr.ac.tec.Shop;

import cr.ac.tec.Board.Player;

public class Shop  {
    private static Shop instance=null;
    private int StarsPrice;

    /**
     *
     * @param StarsPrice
     */
    private Shop(int StarsPrice){
        this.StarsPrice=StarsPrice;
    }
    public static Shop getInstace(int starsPrice){
        if(instance==null){
            instance=new Shop(starsPrice);
            return instance;
        }
        else return instance;
    }

    /**
     *
     * @param player
     * @return
     */
    public boolean BuyStars(Player player){
        if(player.getCoins()>=StarsPrice){
            player.DecreaseCoinsBy(StarsPrice);
            player.raiseStars(1);
            return true;
        }
        else{
            return false;
        }
    }
}
