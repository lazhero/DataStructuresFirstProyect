package cr.ac.tec.Board.PathGenerator;

import cr.ac.tecLinkedList.List.SingleList;

public class NewCoordsSequence {
   public static SingleList<NewCoordsFactory> getNewCoorsSequence(int pos, int square){
       SingleList<NewCoordsFactory> List=new SingleList<>();
       int sideSquare=(square+4)/4;
       int reference=pos/sideSquare;
       if(reference==0){
           List.AddTail(new CoordU());
           List.AddTail(new CoordR());
           List.AddTail(new CoordD());
       }
       else if(reference==1){
           List.AddTail(new CoordR());
           List.AddTail(new CoordD());
           List.AddTail(new CoordL());
       }
       else if(reference==2){
           List.AddTail(new CoordD());
           List.AddTail(new CoordL());
           List.AddTail(new CoordU());
       }
       else{
           List.AddTail(new CoordL());
           List.AddTail(new CoordU());
           List.AddTail(new CoordR());
       }

       return List;
    }
}
