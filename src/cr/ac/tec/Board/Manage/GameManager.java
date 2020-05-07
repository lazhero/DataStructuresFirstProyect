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
import javafx.geometry.HPos;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;


import static cr.ac.tec.Images.GetImages.getImageView;

public class GameManager {
    private static GameManager instance=null;
  private DoubleRoundList<Square> SquareList=new DoubleRoundList<>();
   private DoubleList<Square> Phase1=new DoubleList<>();
    private DoubleList<Square> Phase2=new DoubleList<>();
    private DoubleList<Square> Phase3=new DoubleList<>();
    private DoubleRoundList<Square> Phase4=new DoubleRoundList<>();
   private DoubleRoundList<Player>  PlayerList=new DoubleRoundList<>();
   private DoubleRoundList<Integer> InitCondition=new DoubleRoundList<>();
   private DoubleList<DoubleNode<Square>> PlayersNodes=new DoubleList<>();
    private DoubleList<DoubleNode<Square>> Switching=new DoubleList<>();
    private DoubleList<Boolean> GatesState=new DoubleList<>();
    private DoubleList<Boolean> PlayerReverse=new DoubleList<>();

   private int turns;
   private int rounds;
   private boolean running=false;
   private boolean Backing=false;

   private GameManager(int PlayersNum,int Rounds){
      this.turns=-1;
      this.rounds=Rounds;
       SquareList= PathGenerator.GenerateCircle(10,200,20,50,5,false);
       Phase1=PathGenerator.GeneratePhase1(11,16,3,SquareList,50,5,false);
      Phase1.getNode(Phase1.getLength()-1).setFront(SquareList.getNode(16));
      Phase1.getNode(0).setBack(SquareList.getNode(11));
      Phase2=PathGenerator.GeneratePhase1(20,25,2,SquareList,50,5,true);
      Phase2.getNode(0).setBack(SquareList.getNode(20));
      Phase2.getNode(Phase2.getLength()-1).setFront(SquareList.getNode(25));
      Phase3=PathGenerator.GeneratePhase1(29,34,3,SquareList,50,5,false);
       Phase3.getNode(0).setBack(SquareList.getNode(29));
       Phase3.getNode(Phase3.getLength()-1).setFront(SquareList.getNode(34));
     Phase4=PathGenerator.GenerateCircle(6,310,130,50,5,true);

      GatesState.AddTail(false);
       GatesState.AddTail(true);
       GatesState.AddTail(true);
       GatesState.AddTail(false);
      Switching.AddTail(SquareList.getNode(11));
      Switching.AddTail(SquareList.getNode(20));
      Switching.AddTail(SquareList.getNode(29));
      Switching.AddTail(SquareList.getNode(34));

       int i=1;

      while(i<=PlayersNum){
          String path=null;
          try {
             path="src/Images/Piece"+Integer.toString(i)+".png";
              PlayerList.AddTail(new Player(i,getImageView(path)));
              InitCondition.AddTail(-1);
             PlayersNodes.AddTail(new DoubleNode<Square>(null,SquareList.getNode(SquareList.getLength()-1),SquareList.getNode(0)));
             PlayerReverse.AddTail(false);
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
                       Duration.millis(300 * (Math.abs(i)+1)),
                       (ActionEvent event) -> {
                           DoubleNode<Square> Temp=PlayersNodes.get(PlayerTurn);
                           if (InitCondition.get(PlayerTurn)!= -1) {

                               Temp.getInfo().DeletingPlayer(PlayerList.get(PlayerTurn),40,40);
                           }

                           Temp=GetNextNode(Temp,raise,PlayerReverse.get(PlayerTurn));
                           Temp.getInfo().DrawPlayer(PlayerList.get(PlayerTurn), 40, 40,(Math.abs(f)+1==Math.abs(steps)));
                            InitCondition.ChangeContent(PlayerTurn,InitCondition.get(PlayerTurn)+raise);
                            PlayersNodes.ChangeContent(PlayerTurn,Temp);
                       }
               ));
               i+=raise;
           }
           timeline.setCycleCount(1);
           timeline.setOnFinished(e->{
               PauseTransition pauseTransition=new PauseTransition();
               pauseTransition.setDuration(Duration.millis(1));
               pauseTransition.setAutoReverse(false);
               pauseTransition.setCycleCount(1);
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
           for(int i=0;i<Phase3.getLength();i++){
               Phase3.get(i).Draw(anchorPane);
           }
           for(int i=0;i<Phase4.getLength();i++){
               Phase4.get(i).Draw(anchorPane);
           }
       }
       catch (Exception e){

       }
   }
   public DoubleNode<Square> GetNextNode(DoubleNode<Square> node,int Raise,boolean Reverse){
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
       else if(node==Switching.get(2)){
           if(GatesState.get(2)){
               GatesState.ChangeContent(2,false);
               PlayerReverse.ChangeContent(turns%PlayerReverse.getLength(),false);
               return Phase3.getNode(0);
           }
           else{
               GatesState.ChangeContent(2,true);
               return node.getFront();
           }

       }
       else if(node==Switching.get(3)){
           if(GatesState.get(3)){
               GatesState.ChangeContent(3,false);
               PlayerReverse.ChangeContent(turns%PlayerReverse.getLength(),true);
               return Phase3.getNode(Phase3.getLength()-1);
           }
           else{
               GatesState.ChangeContent(3,true);
               return node.getFront();
           }
       }
       else if(Phase3.FindFirstInstancePosition(node.getInfo())!=-1){
           if(Reverse){
               return node.getBack();
           }
           else{
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
   public void confirm(){
       for(int i=0;i<SquareList.getLength();i++){
           System.out.println("Casilla numero "+ i+" .........................................................................");
           DoubleList<Player> List=SquareList.get(i).ListPlayer();
           if(List.getLength()>0){
               System.out.println("El numero de jugadores registrados es "+SquareList.get(i).getPlayers());
               System.out.println("El len de mi lista es "+List.getLength());
               List.printing();
           }
       }
   }







}
