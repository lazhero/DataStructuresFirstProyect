package cr.ac.tec.Board.PathGenerator;

import cr.ac.tecLinkedList.List.DoubleRoundList;
import cr.ac.tecLinkedList.List.SingleList;

public interface NewCoordsFactory {
    public SingleList<Double> getCoords(double coordx,double coordy,double sidesize);

}
