package cr.ac.tec.AndroidComunication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client implements Runnable {
    private Socket socket;
    private int port;
    private String ip;
    private DataOutputStream DO;
    private DataInputStream DI;
    public Client(String ip,int Port){
        this.port=Port;
        this.ip=ip;
        connect();

    }

    @Override
    public void run() {
        while (socket==null)connect();
       // while(true){
            try {
                System.out.println("Ingrese al enviar");
                ObjectOutputStream objectOutputStream=new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject("this");



            }
            catch (Exception e){
                connect();
                run();
            }
        //}


    }
    public void connect(){
        try {
            socket=new Socket(ip,port);
            DI=new DataInputStream(socket.getInputStream());
            DO=new DataOutputStream(socket.getOutputStream());


        }
        catch (Exception e){
            System.out.println("Es nulo");
            socket=null;
            DI=null;
            DO=null;

        }

    }

    @Override
    public String toString() {
        return "Client{}";
    }
}
