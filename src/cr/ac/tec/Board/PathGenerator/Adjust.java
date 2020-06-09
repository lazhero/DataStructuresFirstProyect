package cr.ac.tec.Board.PathGenerator;


import cr.ac.tec.LinkedList.List.SingleList;

public class Adjust {
    /**
     *
     * @param first
     * @param second
     * @return
     */
    public static boolean edgetoadjust(NewCoordsFactory first,NewCoordsFactory second){
        if((first instanceof CoordR && second instanceof CoordD) ||(first instanceof CoordL && second instanceof CoordU))return true;
        else return false;
    }

    /**
     *
     * @param first
     * @param second
     * @param sidesize
     * @return
     */
    public static SingleList<Double> adjust(NewCoordsFactory first,NewCoordsFactory second,double sidesize){
        //if((first instanceof CoordR && second instanceof CoordD)||(first instanceof CoordD && second instanceof CoordL))return sidesize;
       // else return -sidesize;
        SingleList<Double> List=new SingleList<>();
        if(first instanceof CoordR && second instanceof CoordD){
            List.AddTail(sidesize);
            List.AddTail(-sidesize);
        }
        if(first instanceof CoordD && second instanceof CoordL){
            List.AddTail(sidesize);
            List.AddTail(sidesize);
        }
        if(first instanceof CoordL && second instanceof CoordU){
            List.AddTail(-sidesize);
            List.AddTail(sidesize);
        }
        if(first instanceof CoordU && second instanceof CoordR){
            List.AddTail(-sidesize);
            List.AddTail(-sidesize);
        }
        return List;
    }
}
