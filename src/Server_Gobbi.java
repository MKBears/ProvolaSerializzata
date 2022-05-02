import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_Gobbi extends Thread{
    @Override
    public void run(){
        ServerSocket sSocket;
        Socket client;
        ObjectInputStream in;
        ObjectOutputStream out;
        int s;
        AssistantCard a;

        try {
            //InetAddress ip= InetAddress.getLocalHost(); //restituisce l'indirizzo ip del server
            //out.writeObject(ip);
            sSocket = new ServerSocket(4096);
            System.out.println("Server: pronto");
            client = sSocket.accept();
            //out=new ObjectOutputStream(client.getOutputStream());
            System.out.println("Server: connesso");
            in = new ObjectInputStream(client.getInputStream());
            s = (int)in.readObject();
            System.out.println("Server: studente ricevuto: "+s);
            sSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
