package cr.ac.tec.Board.PathGenerator;

import cr.ac.tec.Board.Square.*;
import cr.ac.tec.Random.Random;
import cr.ac.tecLinkedList.List.DoubleRoundList;
import cr.ac.tecLinkedList.List.SingleList;

public class PathGenerator {
    public static DoubleRoundList<Square> GenerateCircle(int SquaresonSide,double posx, double posy,double SquareSide,boolean onEvent){
        int SquaresNumber=SquaresonSide*4-4;
        final int reg=SquaresNumber;
        DoubleRoundList<Square> List=new DoubleRoundList<Square>();
        NewCoordsFactory CoordsFactory=new CoordR();
        posx-=SquareSide;
        while(SquaresNumber>0){
            SingleList<Double> Coords=CoordsFactory.getCoords(posx,posy,SquareSide);
            posx=Coords.get(0);
            posy=Coords.get(1);
            int RandomNumber=Random.RandomNumber(5);
            Square sqr=null;
            if(!onEvent) {
                if (RandomNumber == 5) {
                    if (RandomNumber == Random.RandomNumber(5)) sqr = new YellowSquare(posx, posy, SquareSide);
                    else {
                        RandomNumber = Random.RandomNumber(4);
                    }
                }
                if (RandomNumber == 4) {
                    if (Random.RandomNumber(3) == 3) {
                        sqr = new WhiteSquare(posx, posy, SquareSide);
                    } else {
                        RandomNumber = Random.RandomNumber(3);
                    }
                }
                if (RandomNumber == 1) sqr = new BlueSquare(posx, posy, SquareSide);
                if (RandomNumber == 2) sqr = new GreenSquare(posx, posy, SquareSide);
                if (RandomNumber == 3) sqr = new RedSquare(posx, posy, SquareSide);
                if(SquaresNumber==reg)sqr=new BlueSquare(posx, posy, SquareSide);
            }
            else sqr = new YellowSquare(posx, posy, SquareSide);


            List.AddTail(sqr);
            SquaresNumber--;
            int relocation=(int)((reg-SquaresNumber)/((reg/4)-1));
            System.out.println("La relocacion es "+relocation);
            if(relocation==1 && reg-SquaresNumber==SquaresonSide-1){
                CoordsFactory=new CoordD();
                posx+=SquareSide;
                posy-=SquareSide;
            }
            else if(relocation==2 && reg-SquaresNumber==2*(SquaresonSide-1)){
                CoordsFactory=new CoordL();
                posy+=SquareSide;
                posx+=SquareSide;
            }
            else if(relocation==3 && reg-SquaresNumber==3*(SquaresonSide-1)){
                CoordsFactory=new CoordU();
                posx-=SquareSide;
                posy+=SquareSide;
            }

        }
        return List;
    }
    public static SingleList<Square> GeneratePhase1(int FirstSquare,int LastSquare,int BranchSize ,double posx,double posy,double sidesize,NewCoordsFactory fact1,NewCoordsFactory fact2, NewCoordsFactory fact3){
        SingleList<Square> SquareList=new SingleList<>();
        int mainlen=LastSquare-FirstSquare-1;
        int totalbranch=2*BranchSize;
        final double positionx=posx;
        final double positiony=posy;
        NewCoordsFactory generatecoords=fact1;
        while(mainlen+totalbranch>0){
            if(totalbranch%BranchSize!=0 || mainlen==0){
                if(mainlen==0)generatecoords=fact3;
                if(positionx!=posx || positiony!=posy){
                    SingleList<Double> List=generatecoords.getCoords(posx,posy,sidesize);
                    posx=List.get(0);
                    posy=List.get(1);
                }
                Square square=SquareRandomGenerator.Generate(posx,posy,sidesize);
                SquareList.AddTail(square);
                totalbranch--;


            }
            else{
                generatecoords=fact2;
                SingleList<Double> List=generatecoords.getCoords(posx,posy,sidesize);
                posx=List.get(0);
                posy=List.get(1);
                Square square=SquareRandomGenerator.Generate(posx,posy,sidesize);
                SquareList.AddTail(square);

            }
        }
        return SquareList;
    }
}
