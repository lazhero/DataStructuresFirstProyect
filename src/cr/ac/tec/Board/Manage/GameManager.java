package cr.ac.tec.Board.Manage;

import cr.ac.tec.Board.Count.StarCounter;
import cr.ac.tec.Board.LayoutNewContent;
import cr.ac.tec.Board.PathGenerator.PathGenerator;
import cr.ac.tec.Board.Player;
import cr.ac.tec.Board.Square.Square;
import cr.ac.tec.Events.Tournament;
import cr.ac.tec.Events.YellowEvents.Duel;
import cr.ac.tec.Events.lists.ListOfMiniGames;
import cr.ac.tec.Minigames.DiamondHunter.Classes.DiamondHunterGame;
import cr.ac.tec.Random.Random;
import cr.ac.tecLinkedList.List.DoubleList;
import cr.ac.tecLinkedList.List.DoubleRoundList;
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
    private AnchorPane anchorPane;
  private DoubleRoundList<Square> SquareList=new DoubleRoundList<>();
   private DoubleList<Square> Phase1=new DoubleList<>();
    private DoubleList<Square> Phase2=new DoubleList<>();
    private DoubleList<Square> Phase3=new DoubleList<>();
    private DoubleRoundList<Square> Phase4=new DoubleRoundList<>();
   private DoubleList<Player>  PlayerList=new DoubleList<>();
   private DoubleRoundList<Integer> InitCondition=new DoubleRoundList<>();
   private DoubleList<DoubleNode<Square>> PlayersNodes=new DoubleList<>();
    private DoubleList<DoubleNode<Square>> Switching=new DoubleList<>();
    private DoubleList<Boolean> GatesState=new DoubleList<>();
    private DoubleList<Boolean> PlayerReverse=new DoubleList<>();
    private String PlayersRoute;
    private String ImagesFormat;
    private String StarRoute;
    private double SquareSide;
   private int turns;
   private int rounds;
   private int RoundsCount=1;
   private boolean running=false;
   private boolean Backing=false;
   private DoubleNode<Square> StarHolder;
   boolean StarTaken=false;

   private GameManager(int PlayersNum,int Rounds,double SquareSide,String PlayersRoute,String StarRoute,String ImagesFormat){
       this.SquareSide=SquareSide;
       this.PlayersRoute=PlayersRoute;
       this.StarRoute=StarRoute;
       this.ImagesFormat=ImagesFormat;
      this.turns=-1;
      this.rounds=Rounds;
       SquareList= PathGenerator.GenerateCircle(10,200,20,this.SquareSide,this.SquareSide/10,false);
       Phase1=PathGenerator.GeneratePhase1(11,16,3,SquareList,this.SquareSide,this.SquareSide/10,false);
      Phase1.getNode(Phase1.getLength()-1).setFront(SquareList.getNode(16));
      Phase1.getNode(0).setBack(SquareList.getNode(11));
      Phase2=PathGenerator.GeneratePhase1(20,25,2,SquareList,this.SquareSide,this.SquareSide/10,true);
      Phase2.getNode(0).setBack(SquareList.getNode(20));
      Phase2.getNode(Phase2.getLength()-1).setFront(SquareList.getNode(25));
      Phase3=PathGenerator.GeneratePhase1(29,34,3,SquareList,this.SquareSide,this.SquareSide/10,false);
       Phase3.getNode(0).setBack(SquareList.getNode(29));
       Phase3.getNode(Phase3.getLength()-1).setFront(SquareList.getNode(34));
     Phase4=PathGenerator.GenerateCircle(6,310,130,this.SquareSide,this.SquareSide/10,true);

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
             path=PlayersRoute+Integer.toString(i)+ImagesFormat;
              PlayerList.AddTail(new Player(i,getImageView(path)));
              InitCondition.AddTail(-1);
             PlayersNodes.AddTail(new DoubleNode<Square>(null,SquareList.getNode(SquareList.getLength()-1),SquareList.getNode(0)));
             PlayerReverse.AddTail(false);
         }
         catch (Exception e){}

        i++;
      }

   }
   public static GameManager getInstance(int PlayersNum,int Rounds,double SquareSide,String PlayersRoute,String StarRoute,String ImagesFormat){
       if(instance==null){
           synchronized(GameManager.class){
               if(instance==null){
                   instance=new GameManager(PlayersNum,Rounds,SquareSide,PlayersRoute,StarRoute,ImagesFormat);
               }

           }
       }
       return instance;
   }
   public static GameManager getInstance(int PlayerNum,int Rounds){
       return instance;
   }
   public static GameManager getInstance(){
       return instance;
   }

   public void StartTurn(int steps){
       if((!running || Backing)&& steps!=0) {
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
                            if(Temp==StarHolder){
                                StarTaken=true;
                            }
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
                       new Duel().EventData(getPlayerList().get(PlayerTurn));
                       Player loser=List.get(1);//The loser should be gotten from the event
                       int counter=0;
                       while(Temp.getInfo().getPlayers()>=1){
                           Temp=Temp.getBack();
                           counter--;
                           System.out.println("ATRAS");
                       }


                       MovePlayer(loser,counter);



                   }
                   running=false;
                   PlayersNodes.get(PlayerTurn).getInfo().event(PlayerList.get(PlayerTurn));
                   if(PlayerTurn==PlayerList.getLength()-1){
                       RoundsCount++;
                   }
                   if(StarHolder!= null && StarTaken){
                       try {
                           StarHolder.getInfo().HideStar();
                           StarHolder.getInfo().DrawStar(2*SquareSide,null);
                           StarHolder=null;
                           StarTaken=false;




                       }
                       catch (Exception f){


                       }
                   }
                   if(RoundsCount>=2 && RoundsCount<=rounds && StarHolder==null){
                       StarHolder=getFreePos(SquareList);
                       try{
                           System.out.println("Intente dibujar una estrella");
                           StarHolder.getInfo().DrawStar(this.SquareSide,StarRoute+ImagesFormat);
                           StarHolder.getInfo().ShowStar();
                           new Tournament().TournamentData(getPlayerList());
                       }
                       catch (Exception Ex){

                       }

                   }




               });
               pauseTransition.play();


               });
           timeline.play();



       }

   }
   public void Draw(AnchorPane anchorPane){
       this.anchorPane=anchorPane;
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
           for(int i=0;i<PlayerList.getLength();i++){
               StarCounter starCounter=new StarCounter(100,60,"src/Images/Numero",".png");
               PlayerList.get(i).attachCoinObserver(starCounter);
               //starCounter.getCounter().setCount(0);
               LayoutNewContent.Add(anchorPane,starCounter.getCounter().getAnchorPane(),20,0,0,50);
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
   public void teleport(Player player){
       int pos=-1;
       if(player!=null && PlayerList.FindFirstInstancePosition(player)!=-1){
           pos=player.getId()-1;
       }
       if(pos!=-1 &&InitCondition.get(pos)!=-1) {
           PlayersNodes.get(pos).getInfo().DeletingPlayer(player, this.SquareSide, this.SquareSide);
           if (SquareList.FindFirstInstancePosition(PlayersNodes.get(pos).getInfo()) != -1 || Phase1.FindFirstInstancePosition(PlayersNodes.get(pos).getInfo()) != -1 || Phase2.FindFirstInstancePosition(PlayersNodes.get(pos).getInfo()) != -1 || Phase3.FindFirstInstancePosition(PlayersNodes.get(pos).getInfo()) != -1 || Phase4.FindFirstInstancePosition(PlayersNodes.get(pos).getInfo()) != -1) {
               int random = Random.RandomNumber(5);
               DoubleNode<Square> Temp = null;
               if (random == 1) {
                   Temp = getFreePos(SquareList);
               }
               else if (random == 2) {
                   Temp = getFreePos(Phase1);
               }
               else if (random == 3) {
                   Temp = getFreePos(Phase2);
               }
               else if (random == 4) {
                   Temp = getFreePos(Phase3);
                   boolean condition = false;
                   if (Random.RandomNumber(2) == 1) condition = true;
                   PlayerReverse.ChangeContent(pos, condition);
               }
               else {
                   Temp = getFreePos(Phase4);
               }
               
               PlayersNodes.ChangeContent(pos, Temp);
           }
           PlayersNodes.get(pos).getInfo().DrawPlayer(player, this.SquareSide, this.SquareSide, false);
       }
   }
   public void example(int pos){
       teleport(PlayerList.get(pos));
   }

   public void exchangePosition(Player player1,Player player2){
       System.out.println("Aca estoy");

       int posP1=-1;
       int posP2=-1;
       if(player1!=null && PlayerList.FindFirstInstancePosition(player1)!=-1){
           posP1=player1.getId()-1;
       }
       if(player2!=null && PlayerList.FindFirstInstancePosition(player2)!=-1){
           posP2=player2.getId()-1;
       }
       if(posP1!=-1 && posP2!=-1 && InitCondition.get(posP1)!=-1 && InitCondition.get(posP2)!=-1) {
           DoubleNode<Square> node1 = PlayersNodes.get(posP1);
           DoubleNode<Square> node2 = PlayersNodes.get(posP2);
           node1.getInfo().DeletingPlayer(player1, this.SquareSide, this.SquareSide);
           node2.getInfo().DeletingPlayer(player2, this.SquareSide, this.SquareSide);
           node1.getInfo().DrawPlayer(player2, this.SquareSide, this.SquareSide, false);
           node2.getInfo().DrawPlayer(player1, this.SquareSide, this.SquareSide, false);
           PlayersNodes.ChangeContent(posP1, node2);
           PlayersNodes.ChangeContent(posP2, node1);
       }
   }
   public void prove(int pos){
       int pos1=(pos+1)%PlayerList.getLength();
       exchangePosition(PlayerList.get(pos),PlayerList.get(pos1));
   }
   private DoubleNode<Square> getFreePos(DoubleList<Square> List){
       DoubleNode<Square> Temp=null;
       while(Temp==null || Temp.getInfo().getPlayers()>0){
           Temp=List.getNode(Random.RandomNumber(List.getLength()-1));
       }
       return Temp;
   }
    private DoubleNode<Square> getFreePos(DoubleRoundList<Square> List){
        DoubleNode<Square> Temp=null;
        while(Temp==null || Temp.getInfo().getPlayers()>0){
            Temp=List.getNode(Random.RandomNumber(List.getLength()-1));
        }
        return Temp;
    }
    public AnchorPane getAnchorPane(){
       return this.anchorPane;
    }

    public boolean isRunning() {
        return this.running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public DoubleList<Player> getPlayerList() {
        return PlayerList;
    }

    public int getTurns() {
        return turns;
    }
}
