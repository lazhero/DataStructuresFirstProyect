package cr.ac.tec.Random;

/**
 * In this class a random number is generated
 * @author Miguel Mesen
 */

public class Random {
    /**
     * Method generates a random number
     * @author Miguel Mesen
     * @param StateNumber
     * @return random number
     */
    public static int RandomNumber(int StateNumber){
            int returning=(int)(Math.random()*(StateNumber));
            return returning+1;
    }
}
