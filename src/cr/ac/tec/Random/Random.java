package cr.ac.tec.Random;

public class Random {
    public static int RandomNumber(int StateNumber){
            int returning=(int)(Math.random()*(StateNumber));
            return returning+1;
    }
}