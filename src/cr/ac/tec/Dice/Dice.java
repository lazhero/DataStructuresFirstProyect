package cr.ac.tec.Dice;

public class Dice {
    private static double diceNumber;

    public static void main(String[] args){
    }

    private static void randomNumber(){
        diceNumber= (int)(Math.random()*((6-1)+1))+1;
        System.out.println(diceNumber);
    }

}
