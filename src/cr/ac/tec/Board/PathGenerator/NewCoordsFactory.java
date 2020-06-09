package cr.ac.tec.Board.PathGenerator;

import cr.ac.tec.LinkedList.List.SingleList;

public interface NewCoordsFactory {

    /**
     *
     * @param coordx
     * @param coordy
     * @param sidesize
     * @return
     */
    public SingleList<Double> getCoords(double coordx,double coordy,double sidesize);

}
