package cr.ac.tec.Board;

import javafx.scene.Node;

public class Player {
    int id;
    Node node;
    int stars;
    int coins;
    Player(int id, Node node){
        this.id=id;
        this.node=node;
        this.stars=0;
        this.coins=0;
    }

    public int getCoins() {
        return coins;
    }

    public int getId() {
        return id;
    }
    public Node getNode(){
        return this.node;
    }
    public void setStars(int stars) {
        this.stars = stars;
    }
    public void raiseStars(int raising){
        stars+= raising;
    }
    public void decreaseStars(int decreasing){
        stars-=decreasing;
    }
}
