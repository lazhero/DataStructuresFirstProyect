package cr.ac.tec.AndroidComunication;

import cr.ac.tec.LinkedList.List.DoubleList;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private ServerSocket server;
    private int port;
    private DoubleList<ClientHandler> clients;


    public Server(int port){

        this.port=port;
        try{
            server=new ServerSocket(port);
        }
        catch (Exception e){
            server=null;
        }
        clients=new DoubleList<>();


    }

    @Override
    public void run() {
        while(true && server!=null){
            try {
                System.out.println("Esperando al cliente");
                Socket temp= server.accept();
                System.out.println("Cliente encontrado");
                ObjectOutputStream DO=new ObjectOutputStream(temp.getOutputStream());
                ObjectInputStream DI=new ObjectInputStream(temp.getInputStream());
                Thread thread=new Thread(new ClientHandler(temp,DI,DO));
                thread.start();
            }
            catch (Exception e){}

        }

    }
}
