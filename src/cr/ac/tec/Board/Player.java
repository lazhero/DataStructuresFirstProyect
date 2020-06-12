package cr.ac.tec.Board;

import javafx.scene.Node;

/**
 * Player is created and its characteristics
 * @author Andrey Zuñiga
 */

public class Player extends PlayerSubject {
    int id;//player id
    Node node;//player javafx's node
    boolean lose; //Lose or win, for movement

    /**
     * Creates a player with the  id and node info,
     * @author Andrey Zuñiga
     * @param id an identification to the node
     * @param node A javafx node, that will work as the picture showing in screen
     */
    public Player(int id, Node node){
        this.id=id;
        this.node=node;
        this.stars=0;
        this.coins=0;
        this.lose=false;
    }

    /**
     * Returns the coins's amount
     * @author Andrey Zuñiga
     * @return the coins's amount
     */
    public int getCoins() {
        return coins;
    }

    /**
     * Changes the player’s current coins
     * @param Coins
     */
    public void setCoins(int Coins){
        this.coins=Coins;
        UpdateCoins();
    }

    /**
     * Raise the number of stars by an specified amount
     * @author Andrey Zuñiga
     * @param Coins The number of stars to raise
     */
    public void RaiseCoinsBy(int Coins){
        coins+=Coins;
        UpdateCoins();
    }

    /**
     * Decrease the number of stars by an specied number
     * @author Andrey Zuñiga
     * @param Coins The coins number to decrease
     */
    public void DecreaseCoinsBy(int Coins){
        coins-=Coins;
        UpdateCoins();
    }

    /**
     * Raise the coin's number
     * @author Andrey Zuñiga
     */
    public void RaiseCoinByOne(){
        coins++;
        UpdateCoins();
    }

    /**
     * Decrease the coin's number by one
     * @author Andrey Zuñiga
     */
    public void DecreaseCoinsByOne(){
        coins--;
        UpdateCoins();
    }

    /**
     * Return the player id
     * @author Andrey Zuñiga
     * @return the player id
     */
    public int getId() {
        return id;
    }

    /**
     * Check if he lost
     * @author Andrey Zuñiga
     * @return
     */
    public boolean isLose() {
        return lose;
    }

    /**
     * @author Andrey Zuñiga
     * @param lose
     */
    public void setLose(boolean lose) {
        this.lose = lose;
    }

    /**
     * Returns the player's node
     * @author Andrey Zuñiga
     * @return The player's node
     */
    public Node getNode(){
        return this.node;
    }

    /**
     * Sets the player's stars
     * @author Andrey Zuñiga
     * @param stars the number of stars
     */
    public void setStars(int stars) {
        this.stars = stars;
        UpdateStars();
    }

    /**
     * Return the number of stars
     * @author Andrey Zuñiga
     * @return star's number
     */
    public int getStars(){
        return stars;
    }

    /**
     * Raises the number of stars
     * @author Andrey Zuñiga
     * @param raising the number of stars to raise
     */
    public void raiseStars(int raising){
        stars+= raising;
        UpdateStars();
    }

    /**
     * Decrease the number of star
     * @author Andrey Zuñiga
     * @param decreasing the number of stars to decrease
     */
    public void decreaseStars(int decreasing){
        stars-=decreasing;
    }

    /**
     * Decrease the number of stars
     * @author Andrey Zuñiga
     * @param Raise The number of stars to decrease
     */
    public void RaiseStarsBy(int Raise){
        coins+=Raise;
    }

    /**
     * Decrease the number of stars
     * @author Andrey Zuñiga
     * @param Decrease The number of stars to decrease
     */
    public void DecreaseStarsBy(int Decrease){
        coins-=Decrease;
    }
}
