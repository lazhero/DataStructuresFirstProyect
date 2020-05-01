package cr.ac.tec.Board;

import javafx.scene.Node;

public class Player {
    int id;//player id
    Node node;//player javafx's node
    int stars;//Number of start
    int coins;//Number of coins

    /**
     * Creates a player with the  id and node info,
     * @param id an identification to the node
     * @param node A javafx node, that will work as the picture showing in screen
     */
    public Player(int id, Node node){
        this.id=id;
        this.node=node;
        this.stars=0;
        this.coins=0;
    }

    /**
     * Returns the coins's amount
     * @return the coins's amount
     */
    public int getCoins() {
        return coins;
    }
    public void setCoins(int Coins){
        this.coins=Coins;
    }

    /**
     * Raise the number of stars by an specified amount
     * @param Coins The number of stars to raise
     */
    public void RaiseCoinsBy(int Coins){
        coins+=Coins;
    }

    /**
     * Decrease the number of stars by an specied number
     * @param Coins The coins number to decrease
     */
    public void DecreaseCoinsBy(int Coins){
        coins-=Coins;
    }

    /**
     * Raise the coin's number
     */
    public void RaiseCoinByOne(){
        coins++;
    }

    /**
     * Decrease the coin's number by one
     */
    public void DecreaseCoinsByOne(){
        coins--;
    }

    /**
     * Return the player id
     * @return the player id
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the player's node
     * @return The player's node
     */
    public Node getNode(){
        return this.node;
    }

    /**
     * Sets the player's stars
     * @param stars the number of stars
     */
    public void setStars(int stars) {
        this.stars = stars;
    }

    /**
     * Return the number of stars
     * @return star's number
     */
    public int getStars(){
        return stars;
    }

    /**
     * Raises the number of stars
     * @param raising the number of stars to raise
     */
    public void raiseStars(int raising){
        stars+= raising;
    }

    /**
     * Decrease the number of star
     * @param decreasing the number of stars to decrease
     */
    public void decreaseStars(int decreasing){
        stars-=decreasing;
    }

    /**
     * Decrease the number of stars
     * @param Raise The number of stars to decrease
     */
    public void RaiseStarsBy(int Raise){
        coins+=Raise;
    }

    /**
     * Decrease the number of stars
     * @param Decrease The number of stars to decrease
     */
    public void DecreaseStarsBy(int Decrease){
        coins-=Decrease;
    }
}
