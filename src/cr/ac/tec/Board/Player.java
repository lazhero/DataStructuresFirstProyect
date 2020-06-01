package cr.ac.tec.Board;

import javafx.scene.Node;

public class Player extends PlayerSubject {
    int id;//player id
    Node node;//player javafx's node
    boolean lose; //Lose or win, for movement


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
        this.lose=false;
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
        System.out.println("Intente subir monedas");
        UpdateCoins();
    }

    /**
     * Raise the number of stars by an specified amount
     * @param Coins The number of stars to raise
     */
    public void RaiseCoinsBy(int Coins){
        coins+=Coins;
        UpdateCoins();
    }

    /**
     * Decrease the number of stars by an specied number
     * @param Coins The coins number to decrease
     */
    public void DecreaseCoinsBy(int Coins){
        coins-=Coins;
        UpdateCoins();
    }

    /**
     * Raise the coin's number
     */
    public void RaiseCoinByOne(){
        coins++;
        UpdateCoins();
    }

    /**
     * Decrease the coin's number by one
     */
    public void DecreaseCoinsByOne(){
        coins--;
        UpdateCoins();
    }

    /**
     * Return the player id
     * @return the player id
     */
    public int getId() {
        return id;
    }

    public boolean isLose() {
        return lose;
    }

    public void setLose(boolean lose) {
        this.lose = lose;
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
        UpdateStars();
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
        UpdateStars();
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
