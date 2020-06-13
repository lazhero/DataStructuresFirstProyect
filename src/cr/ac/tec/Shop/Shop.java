package cr.ac.tec.Shop;

import cr.ac.tec.Board.Player;

/**
 * Is the shop, where you can buy the stars
 * @author Andrey Zuñiga
 */
public class Shop  {
    private static Shop instance=null;
    private int StarsPrice;

    /**
     *The Constructor
     * @author Andrey Zuñiga
     * @param StarsPrice
     */
    public Shop(int StarsPrice){
        this.StarsPrice=StarsPrice;
    }

    /**
     *gets the instance, if it does not exist creates a
     * @author Andrey Zuñiga
     * @param starsPrice
     * @return
     */
    public static Shop getInstace(int starsPrice){
        if(instance==null){
            instance=new Shop(starsPrice);
            return instance;
        }
        else return instance;
    }

    /**
     * Method to buy the stars
     * @author Andrey Zuñiga
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
