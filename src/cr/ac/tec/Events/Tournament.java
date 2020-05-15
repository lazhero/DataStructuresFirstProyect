package cr.ac.tec.Events;

import cr.ac.tec.Board.Manage.GameManager;
import cr.ac.tec.Events.YellowEvents.Duel;

public class Tournament {

    public void Tournament() {

     /**
        GameManager gameManager = GameManager.getInstance(0,0);


        if(gameManager.getPlayerList().getLength()==2){
            new minigame(player1,player2);
            if (player1){
                player1.setcoins(player1.getcoins()+3);
                player2.setCoins(player2.getcoins()+1);
            }else{
                player2.setcoins(player2.getcoins()+3);
                player1.setCoins(player1.getcoins()+1);

            }

        }else if(gameManager.getPlayerList().getLength()==3){
            new minigame(player1,player2);
            if (player1){
                new minigame(player2,player3);
                if(player2){
                    new minigame(player1,player2);
                    if (player1){
                        player1.setcoins(player1.getcoins()+3);
                        player2.setcoins(player2.getcoins()+2);
                        player3.setcoins(player3.getcoins()+1);
                    }else{
                        player2.setcoins(player2.getcoins()+3);
                        player1.setcoins(player1.getcoins()+2);
                        player3.setcoins(player3.getcoins()+1);
                    }
                }else{
                    new minigame(player1,player3);
                    if (player1){
                        player1.setcoins(player1.getcoins()+3);
                        player3.setcoins(player3.getcoins()+2);
                        player2.setcoins(player2.getcoins()+1);
                    }else{
                        player3.setcoins(player3.getcoins()+3);
                        player1.setcoins(player1.getcoins()+2);
                        player2.setcoins(player2.getcoins()+1);
                    }
                }
            }else{
                new minigame(player1,player3);
                if(player1){
                    new minigame(player1,player2);
                    if (player1){
                        player1.setcoins(player1.getcoins()+3);
                        player2.setcoins(player2.getcoins()+2);
                        player3.setcoins(player3.getcoins()+1);
                    }else{
                        player2.setcoins(player2.getcoins()+3);
                        player1.setcoins(player1.getcoins()+2);
                        player3.setcoins(player3.getcoins()+1);
                    }
                }else{
                    new minigame(player3,player2);
                    if (player3){
                        player3.setcoins(player3.getcoins()+3);
                        player2.setcoins(player2.getcoins()+2);
                        player1.setcoins(player1.getcoins()+1);
                    }else{
                        player2.setcoins(player2.getcoins()+3);
                        player3.setcoins(player3.getcoins()+2);
                        player1.setcoins(player1.getcoins()+1);
                    }
                }
            }

        } else if (gameManager.getPlayerList().getLength()==4) {
            new minigame(player1,player2);
            new minigame(player3,player4);
            if(player1 && player3){
                new minigame(player1,player3);
                new minigame(player2,player4);
                if(player1&&player2){
                    player1.setcoins(player1.getcoins()+5);
                    player3.setcoins(player3.getcoins()+3);
                    player2.setCoins(player2.getcoins()+2);
                    player4.setCoins(player4.getcoins()+1);
                }else if(player1&&player4){
                    player1.setcoins(player1.getcoins()+5);
                    player3.setcoins(player3.getcoins()+3);
                    player4.setCoins(player4.getcoins()+2);
                    player2.setCoins(player2.getcoins()+1);
                }else if(player3&&payer2){
                    player3.setcoins(player3.getcoins()+5);
                    player1.setcoins(player1.getcoins()+3);
                    player2.setCoins(player2.getcoins()+2);
                    player4.setCoins(player4.getcoins()+1);
                }else if(player3&&player4){
                    player3.setcoins(player3.getcoins()+5);
                    player1.setcoins(player1.getcoins()+3);
                    player4.setCoins(player4.getcoins()+2);
                    player2.setCoins(player2.getcoins()+1);
                }
            }else if(player1 && player4){
                new minigame(player1,player4);
                new minigame(player2,player3);
                if(player1&&player2){
                    player1.setcoins(player1.getcoins()+5);
                    player4.setcoins(player4.getcoins()+3);
                    player2.setCoins(player2.getcoins()+2);
                    player3.setCoins(player3.getcoins()+1);
                }else if(player1&&player3){
                    player1.setcoins(player1.getcoins()+5);
                    player3.setcoins(player3.getcoins()+3);
                    player4.setCoins(player4.getcoins()+2);
                    player2.setCoins(player2.getcoins()+1);
                }else if(player4&&player2){
                    player4.setcoins(player4.getcoins()+5);
                    player1.setcoins(player1.getcoins()+3);
                    player2.setCoins(player2.getcoins()+2);
                    player3.setCoins(player3.getcoins()+1);
                }else if(player4&&player3){
                    player4.setcoins(player4.getcoins()+5);
                    player1.setcoins(player1.getcoins()+3);
                    player3.setCoins(player3.getcoins()+2);
                    player2.setCoins(player2.getcoins()+1);
                }
            }else if(player2 && player3){
                new minigame(player2,player3);
                new minigame(player1,player4);
                if(player2&&player1){
                    player2.setcoins(player2.getcoins()+5);
                    player3.setcoins(player3.getcoins()+3);
                    player1.setCoins(player1.getcoins()+2);
                    player4.setCoins(player4.getcoins()+1);
                }else if(player2&&player4){
                    player2.setcoins(player2.getcoins()+5);
                    player3.setcoins(player3.getcoins()+3);
                    player4.setCoins(player4.getcoins()+2);
                    player1.setCoins(player1.getcoins()+1);
                }else if(player3&&payer1){
                    player3.setcoins(player3.getcoins()+5);
                    player2.setcoins(player2.getcoins()+3);
                    player1.setCoins(player1.getcoins()+2);
                    player4.setCoins(player4.getcoins()+1);
                }else if(player3&&player4){
                    player3.setcoins(player3.getcoins()+5);
                    player2.setcoins(player2.getcoins()+3);
                    player4.setCoins(player4.getcoins()+2);
                    player1.setCoins(player1.getcoins()+1);
                }
            }else if(player2 && player4){
                new minigame(player2,player4);
                new minigame(player1,player3);
                if(player2&&player1){
                    player2.setcoins(player2.getcoins()+5);
                    player4.setcoins(player4.getcoins()+3);
                    player1.setCoins(player1.getcoins()+2);
                    player3.setCoins(player3.getcoins()+1);
                }else if(player2&&player3){
                    player2.setcoins(player2.getcoins()+5);
                    player4.setcoins(player4.getcoins()+3);
                    player3.setCoins(player3.getcoins()+2);
                    player1.setCoins(player1.getcoins()+1);
                }else if(player4&&payer1){
                    player4.setcoins(player4.getcoins()+5);
                    player2.setcoins(player2.getcoins()+3);
                    player1.setCoins(player1.getcoins()+2);
                    player3.setCoins(player3.getcoins()+1);
                }else if(player4&&player3){
                    player4.setcoins(player4.getcoins()+5);
                    player2.setcoins(player2.getcoins()+3);
                    player3.setCoins(player3.getcoins()+2);
                    player1.setCoins(player1.getcoins()+1);
                }
            }
        }
        */
    }
    public void TournamentData(){

        
    }


}
