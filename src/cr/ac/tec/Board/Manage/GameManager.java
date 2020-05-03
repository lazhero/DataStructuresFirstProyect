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
    private static GameManager instance=null;
  private DoubleRoundList<Square> SquareList=new DoubleRoundList<>();
   private DoubleList<Square> Phase1=new DoubleList<>();
    private DoubleList<Square> Phase2=new DoubleList<>();
   private DoubleRoundList<Player>  PlayerList=new DoubleRoundList<>();
   private DoubleRoundList<Integer> InitCondition=new DoubleRoundList<>();
   private DoubleList<DoubleNode<Square>> PlayersNodes=new DoubleList<>();
    private DoubleList<DoubleNode<Square>> Switching=new DoubleList<>();
    private DoubleList<Boolean> GatesState=new DoubleList<>();


   private int turns;
   private int rounds;
   private boolean running=false;
   private boolean Backing=false;

   private GameManager(int PlayersNum,int Rounds){
      this.turns=-1;
      this.rounds=Rounds;
       SquareList= PathGenerator.GenerateCircle(10,150,50,50,5,false);
       Phase1=PathGenerator.GeneratePhase1(11,16,3,SquareList,50,5,false);
      Phase1.getNode(Phase1.getLength()-1).setFront(SquareList.getNode(16));
      Phase1.getNode(0).setBack(SquareList.getNode(11));
      Phase2=PathGenerator.GeneratePhase1(20,25,2,SquareList,50,5,true);
      Phase2.getNode(0).setBack(SquareList.getNode(20));
      Phase2.getNode(Phase2.getLength()-1).setFront(SquareList.getNode(25));
       GatesState.AddTail(false);
       GatesState.AddTail(true);
      Switching.AddTail(SquareList.getNode(11));
      Switching.AddTail(SquareList.getNode(20));
       int i=1;

      while(i<=PlayersNum){
          String path=null;
          try {
             path="src/Images/Piece"+Integer.toString(i)+".png";
              PlayerList.AddTail(new Player(i,getImageView(path)));
              InitCondition.AddTail(-1);
             PlayersNodes.AddTail(new DoubleNode<Square>(null,SquareList.getNode(SquareList.getLength()-1),SquareList.getNode(0)));

         }
         catch (Exception e){}

        i++;
      }

   }
   public static GameManager getInstance(int PlayersNum,int Rounds){
       if(instance==null){
           synchronized(GameManager.class){
               if(instance==null){
                   instance=new GameManager(PlayersNum,Rounds);
               }

           }
       }
       return instance;
   }

   public void StartTurn(int steps){
       if(!running || Backing) {
           running=true;
           Backing=false;
           turns++;
           int PlayerTurn = turns % PlayerList.getLength();
           Timeline timeline=new Timeline();
           final int raise;
           if(steps>0){
               raise=1;
           }
           else{
               raise=-1;
           }
           int i=0;
           System.out.println("Estoy en en turno del jugador "+PlayerTurn);
           while (Math.abs(i) < Math.abs(steps)) {
               final int f=i;
               timeline.getKeyFrames().add(new KeyFrame(
                       Duration.millis(600 * (Math.abs(i)+1)),
                       (ActionEvent event) -> {
                           DoubleNode<Square> Temp=PlayersNodes.get(PlayerTurn);
                           if (InitCondition.get(PlayerTurn)!= -1) {

                               Temp.getInfo().DeletingPlayer(PlayerList.get(PlayerTurn),40,40);
                           }

                           Temp=GetNextNode(Temp,raise);
                           Temp.getInfo().DrawPlayer(PlayerList.get(PlayerTurn), 40, 40,(Math.abs(f)+1==Math.abs(steps)));
                            InitCondition.ChangeContent(PlayerTurn,5);
                            PlayersNodes.ChangeContent(PlayerTurn,Temp);
                       }
               ));
               i+=raise;
           }
           timeline.setCycleCount(1);
           timeline.setOnFinished(e->{
               PauseTransition pauseTransition=new PauseTransition();
               pauseTransition.setDuration(Duration.millis(3000));
               pauseTransition.setOnFinished(k->{
                   DoubleNode<Square> Temp=PlayersNodes.get(PlayerTurn);
                   if (Temp.getInfo().getPlayers()>1 && Temp.getInfo().getPlayers()<=2){
                       DoubleList<Player> List=Temp.getInfo().ListPlayer();

                       Player loser=List.get(1);//The loser should be gotten from the event
                       int counter=0;
                       while(Temp.getInfo().getPlayers()>=1){
                           Temp=Temp.getBack();
                           counter--;
                       }


                       MovePlayer(loser,counter);



                   }

                   running=false;

               });
               pauseTransition.play();


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
           for(int i=0;i<Phase2.getLength();i++){
               Phase2.get(i).Draw(anchorPane);
           }
       }
       catch (Exception e){

       }
   }
   public DoubleNode<Square> GetNextNode(DoubleNode<Square> node,int Raise){
       if(node==Switching.get(0)){
           if(GatesState.get(0)) {
               GatesState.ChangeContent(0,false);
               return Phase1.getNode(0);
           }
           else{
               GatesState.ChangeContent(0,true);
               return node.getFront();
           }
       }
       else if(node==Switching.get(1)){
           if(GatesState.get(1)){
               GatesState.ChangeContent(1,false);
               return Phase2.getNode(0);
           }
           else {
               GatesState.ChangeContent(1,true);
               return node.getFront();
           }
       }
       else{
           if(Raise==-1){
               return node.getBack();
           }
           return node.getFront();
       }

   }
   public void MovePlayer(Player player,int Steps){
       Backing=true;
       final int Backup=turns;
       turns=PlayerList.FindFirstInstancePosition(player)-1;
       StartTurn(Steps);
       turns=Backup;

   }







}
