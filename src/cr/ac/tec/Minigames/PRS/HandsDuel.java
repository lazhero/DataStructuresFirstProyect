package cr.ac.tec.Minigames.PRS;

public class HandsDuel {
    /**
     *
     * @param hand1
     * @param hand2
     * @return
     */
    public static int winner(Hand hand1,Hand hand2){
        int FirstHandValue=hand1.getValue();
        int SecondHandValue= hand2.getValue();
        if((FirstHandValue+1)%3==SecondHandValue){
            return 1;
        }
        else if(FirstHandValue==SecondHandValue){
            return 0;
        }
        else return 2;
    }
}
