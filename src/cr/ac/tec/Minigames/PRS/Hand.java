package cr.ac.tec.Minigames.PRS;

public class Hand {
    private int value;

    /**
     *
     * @param value
     */
    private Hand(int value){
        this.value=value;
    }

    /**
     *
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
     *
     * @return
     */
    public int getValue(){
        return value;
    }
}
