package cr.ac.tec.Board.Manage;

import cr.ac.tec.Board.PathGenerator.PathGenerator;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Board.Square.Square;
import cr.ac.tec.Images.GetImages;
import cr.ac.tecLinkedList.List.DoubleList;
import cr.ac.tecLinkedList.List.DoubleRoundList;
import cr.ac.tecLinkedList.List.SingleList;
import cr.ac.tecLinkedList.Nodes.DoubleNode;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import static cr.ac.tec.Images.GetImages.getImageView;

public class GameManager {
  private DoubleRoundList<Square> SquareList=new DoubleRoundList<>();
   private DoubleList<Square> Phase1=new DoubleList<>();
   private DoubleRoundList<Player>  PlayerList=new DoubleRoundList<>();
   private DoubleRoundList<Integer> PositionOnBoard=new DoubleRoundList<>();


   private int turns;
   private int rounds;
   //private Timeline timeline=new Timeline();
   private boolean running=false;

   public GameManager(int PlayersNum,int Rounds){
      this.turns=-1;
      this.rounds=Rounds;
      int i=1;

      while(i<=PlayersNum){
          String path=null;
          try {
             path="src/Images/Piece"+Integer.toString(i)+".png";
              PlayerList.AddTail(new Player(i,getImageView(path)));
              PositionOnBoard.AddTail(-1);

         }
         catch (Exception e){}

        i++;
      }
      SquareList= PathGenerator.GenerateCircle(10,150,50,50,5,false);
      Phase1=PathGenerator.GeneratePhase1(11,16,3,SquareList,50,5);
   }

   public void StartTurn(int steps){
       if(!running) {
           running=true;
           turns++;
           int PlayerTurn = turns % PlayerList.getLength();
           System.out.println("Jugador " + PlayerTurn);
           Timeline timeline=new Timeline();
           int raise;
           if(steps>0){
               raise=1;
           }
           else raise=-1;
           int i = 0;
           while (Math.abs(i) < Math.abs(steps)) {
               final int f=i;
               timeline.getKeyFrames().add(new KeyFrame(
                       Duration.millis(200 * (Math.abs(i)+1)),
                       (ActionEvent event) -> {
                           int PosNow = PositionOnBoard.get(PlayerTurn);
                           if (PosNow != -1) {
                               //System.out.println("La posicion de que me borre es "+PosNow);
                               SquareList.get(PosNow).DeletingPlayer(PlayerList.get(PlayerTurn),40,40);
                           }
                           PosNow = (PosNow + 1) % SquareList.getLength();
                           PositionOnBoard.ChangeContent(PlayerTurn, PosNow);

                           SquareList.get(PosNow).DrawPlayer(PlayerList.get(PlayerTurn), 40, 40,(Math.abs(f)+1==Math.abs(steps)));
                           //System.out.println(PosNow);
                       }
               ));
               i+=raise;
           }
           timeline.setCycleCount(1);
           timeline.setOnFinished(e->{running=false;
               System.out.println("ya termine");
               PositionOnBoard.printing();
               });
           timeline.play();



       }

   }
   public void Draw(AnchorPane anchorPane){
       try{
           for(int i=0;i<SquareList.getLength();i++){
               SquareList.get(i).Draw(anchorPane);
           }
           for(int i=0;i<Phase1.getLength();i++){
               Phase1.get(i).Draw(anchorPane);
           }
       }
       catch (Exception e){

       }
   }






}
