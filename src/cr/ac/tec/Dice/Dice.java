package cr.ac.tec.Dice;

public class Dice {
    private static double diceNumber;


    static void rollDice(){
        randomNumber();
        Animation xd = new Animation();
        Animation.playAnimation();
        if (diceNumber==1){
            SetTimer.setTimer(4900);
            //Animation.stopAnimation();

        }
    }



    private static void randomNumber(){
        diceNumber= (int)(Math.random()*((6-1)+1))+1;
        diceNumber=1;
        System.out.println(diceNumber);
    }

}
