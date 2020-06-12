package cr.ac.tec.Board.PathGenerator;

import cr.ac.tec.Board.Square.*;
import cr.ac.tec.Random.Random;

public class SquareRandomGenerator {

    /**
     *
     * @param coordx
     * @param coordy
     * @param sidesize
     * @return
     */
    public static Square generate(double coordx, double coordy, double sidesize){
        Square square=null;
        int RandomNumber= Random.RandomNumber(5);
        if(RandomNumber==5){
            if(Random.RandomNumber(3)==1)square= new YellowSquare(coordx,coordy,sidesize);
            else RandomNumber=Random.RandomNumber(4);
        }
        if(RandomNumber==4)square=new GreenSquare(coordx,coordy,sidesize);
        if(RandomNumber==1)square=new BlueSquare(coordx,coordy,sidesize);
        if(RandomNumber==2)square=new BlueSquare(coordx,coordy,sidesize);
        if(RandomNumber==3)square=new RedSquare(coordx,coordy,sidesize);
        return square;
    }
}
