package cr.ac.tec.AndroidComunication;

import cr.ac.tec.Info.Info;
import cr.ac.tec.Info.InfoGetter;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;
    private ObjectOutputStream DO;
    private ObjectInputStream DI;
    public ClientHandler(Socket socket, ObjectInputStream DI, ObjectOutputStream DO){
        this.socket=socket;
        this.DI=DI;
        this.DO=DO;
    }

    @Override
    public void run() {
        try {

            Object entry=DI.readObject();
            String info=(String)entry;
            System.out.println("Hice el casting");
            System.out.println("El texto es "+info);
            InfoGetter infoGetter=InfoGetter.getInstance();
            System.out.println(infoGetter.getInfo().getCoins()[0]);
            DO.writeObject(infoGetter.getInfo());
        }
        catch (Exception ignored){
            System.out.println("El mensaje es "+ignored.getMessage());
        }
    }
}
