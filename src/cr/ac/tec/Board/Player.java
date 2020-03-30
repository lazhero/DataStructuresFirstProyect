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
    Player(int id, Node node){
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
}
