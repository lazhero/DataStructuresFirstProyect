package cr.ac.tec.Board.PathGenerator;

import cr.ac.tecLinkedList.List.SingleList;

public class CoordL implements NewCoordsFactory {


    @Override
    public SingleList<Double> getCoords(double coordx, double coordy,double sidesize) {
        coordx-=sidesize;
        SingleList<Double> List=new SingleList<>();
        List.AddTail(coordx);
        List.AddTail(coordy);
        return List;
    }
}
