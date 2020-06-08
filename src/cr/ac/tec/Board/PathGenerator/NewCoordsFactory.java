package cr.ac.tec.Board.PathGenerator;

import cr.ac.tec.LinkedList.List.SingleList;

public interface NewCoordsFactory {
    public SingleList<Double> getCoords(double coordx,double coordy,double sidesize);

}
