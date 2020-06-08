package cr.ac.tec.Board.PathGenerator;

import cr.ac.tec.LinkedList.List.SingleList;
import cr.ac.tec.LinkedList.List.SingleList;

public class CoordU implements NewCoordsFactory {


    @Override
    public SingleList<Double> getCoords(double coordx, double coordy, double sidesize) {
        coordy-=sidesize;
        SingleList<Double> List=new SingleList<>();
        List.AddTail(coordx);
        List.AddTail(coordy);
        return List;
    }
}
