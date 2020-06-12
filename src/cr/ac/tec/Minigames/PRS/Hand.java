package cr.ac.tec.Minigames.PRS;

/**
 *
 */
public class Hand {
    private int value;

    /**
     * @author Andrey Zuñiga
     * @param value
     */
    private Hand(int value){
        this.value=value;
    }

    /**
     *
     * @author Andrey Zuñiga
     * @param value
     * @return
     */
    public static Hand getHand(int value){
        Hand hand=null;
        if(value>-1 && value<3){
            hand=new Hand(value);
        }
        return hand;
    }

    /**
     * Method that obtains value, to know if stone, paper or scissors is chosen
     * @author Andrey Zuñiga
     * @return
     */
    public int getValue(){
        return value;
    }
}
