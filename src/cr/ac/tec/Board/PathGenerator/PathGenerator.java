package cr.ac.tec.Board.PathGenerator;

import cr.ac.tec.Board.Square.*;
import cr.ac.tec.Random.Random;
import cr.ac.tecLinkedList.List.DoubleList;
import cr.ac.tecLinkedList.List.DoubleRoundList;
import cr.ac.tecLinkedList.List.List;
import cr.ac.tecLinkedList.List.SingleList;

public class PathGenerator {
    public static DoubleRoundList<Square> GenerateCircle(int SquaresonSide,double posx, double posy,double SquareSide,double SpaceBetween,boolean onEvent){
        int SquaresNumber=SquaresonSide*4-4;
        final int reg=SquaresNumber;
        DoubleRoundList<Square> List=new DoubleRoundList<Square>();
        NewCoordsFactory CoordsFactory=new CoordR();
        posx-=SquareSide;
        while(SquaresNumber>0){
            SingleList<Double> Coords=CoordsFactory.getCoords(posx,posy,SquareSide+SpaceBetween);
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
                posx+=SquareSide+SpaceBetween;
                posy-=SquareSide+SpaceBetween;
            }
            else if(relocation==2 && reg-SquaresNumber==2*(SquaresonSide-1)){
                CoordsFactory=new CoordL();
                posy+=SquareSide+SpaceBetween;
                posx+=SquareSide+SpaceBetween;
            }
            else if(relocation==3 && reg-SquaresNumber==3*(SquaresonSide-1)){
                CoordsFactory=new CoordU();
                posx-=SquareSide+SpaceBetween;
                posy+=SquareSide+SpaceBetween;
            }

        }
        return List;
    }
    public static DoubleList<Square> GeneratePhase1(int FirstSquare, int LastSquare, int BranchSize , List<Square> MainPath, double sidesize, double SpaceBetween,boolean JustEvents) {
        DoubleList<Square> SquareList=new DoubleList<>();
        double posx=MainPath.get(FirstSquare).getCoordx();
        double posy=MainPath.get(FirstSquare).getCoordy();
        int mainlen=LastSquare-FirstSquare-1;
        int totalbranch=2*BranchSize;
        SingleList<NewCoordsFactory> ReceivingFactory=NewCoordsSequence.getNewCoorsSequence(LastSquare,MainPath.getLength());
        NewCoordsFactory fact1=ReceivingFactory.get(0);
        NewCoordsFactory fact2=ReceivingFactory.get(1);
        NewCoordsFactory fact3=ReceivingFactory.get(2);
        NewCoordsFactory generatecoords=fact1;
        while(mainlen+totalbranch>0){
            if(totalbranch%BranchSize!=0 || mainlen==0 || totalbranch==2*BranchSize){
                if(mainlen==0)generatecoords=fact3;
                if(totalbranch==BranchSize){
                   SingleList<Double> receiving=Adjust.adjust(fact2,fact3,sidesize+SpaceBetween);
                   posx+=receiving.get(0);
                   posy+=receiving.get(1);
                }
                SingleList<Double> List=generatecoords.getCoords(posx,posy,sidesize+SpaceBetween);
                posx=List.get(0);
                posy=List.get(1);
                Square square=SquareRandomGenerator.Generate(posx,posy,sidesize);
                if(JustEvents){
                    square=new YellowSquare(posx,posy,sidesize);
                }
                SquareList.AddTail(square);
                totalbranch--;
            }
            else{
                generatecoords=fact2;
                SingleList<Double> List=generatecoords.getCoords(posx,posy,sidesize+SpaceBetween);
                posx=List.get(0);
                posy=List.get(1);
                Square square=SquareRandomGenerator.Generate(posx,posy,sidesize);
                if(JustEvents){
                    square=new YellowSquare(posx,posy,sidesize);
                }
                SquareList.AddTail(square);
                mainlen--;

            }
        }
        return SquareList;
    }

}
