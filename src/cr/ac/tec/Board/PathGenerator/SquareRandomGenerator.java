package cr.ac.tec.Board.PathGenerator;

import cr.ac.tec.Board.Square.BlueSquare;
import cr.ac.tec.Board.Square.RedSquare;
import cr.ac.tec.Board.Square.Square;
import cr.ac.tec.Board.Square.YellowSquare;
import cr.ac.tec.Random.Random;

public class SquareRandomGenerator {
    public static Square Generate(double coordx, double coordy,double sidesize){
        Square square=null;
        int RandomNumber= Random.RandomNumber(4);
        if(RandomNumber==4){
            if(Random.RandomNumber(3)==1)square= new YellowSquare(coordx,coordy,sidesize);
            else RandomNumber=Random.RandomNumber(3);
        }
        if(RandomNumber==1)square=new BlueSquare(coordx,coordy,sidesize);
        if(RandomNumber==2)square=new BlueSquare(coordx,coordy,sidesize);
        if(RandomNumber==3)square=new RedSquare(coordx,coordy,sidesize);
        return square;

    }
}
