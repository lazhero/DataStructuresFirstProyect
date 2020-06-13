package cr.ac.tec.Board;

public class PlayerPrueba {
    int stars=0;
    int coins=0;
    String name;

    public PlayerPrueba(String name){
        this.name=name;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setCoins(int coins) {
        this.coins+= coins;
    }

    public int getStars() {
        return stars;
    }

    public int getCoins() {
        return coins;
    }

    public String getName() {
        return name;
    }

    public int finalCoins(){
        return coins + stars*3;
    }
}
