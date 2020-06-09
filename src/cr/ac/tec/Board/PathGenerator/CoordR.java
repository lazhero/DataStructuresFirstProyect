package cr.ac.tec.Board.PathGenerator;

import cr.ac.tec.LinkedList.List.SingleList;

public class CoordR implements NewCoordsFactory {

    /**
     *
     * @param coordx
     * @param coordy
     * @param sidesize
     * @return
     */
    @Override
    public SingleList<Double> getCoords(double coordx, double coordy,double sidesize) {
        coordx+=sidesize;
        SingleList<Double> List=new SingleList<>();
        List.AddTail(coordx);
        List.AddTail(coordy);
        return List;
    }
}
