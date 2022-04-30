import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    @Override
    public void run(){
        ServerSocket sSocket;
        Socket client;
        ObjectInputStream in;
        ObjectOutputStream out;
        Student s;
        AssistantCard a;

        try {
            InetAddress ip= InetAddress.getLocalHost(); //restituisce l'indirizzo ip del server
            //out.writeObject(ip);
            sSocket = new ServerSocket(4096);
            System.out.println("Server: pronto");
            client = sSocket.accept();
            //out=new ObjectOutputStream(client.getOutputStream());
            System.out.println("Server: connesso");
            in = new ObjectInputStream(client.getInputStream());
            s = (Student)in.readObject();
            System.out.println("Server: studente ricevuto: "+s.getType().getName());
            a = (AssistantCard)in.readObject();
            System.out.println("Server: carta ricevuta: "+a.getValue()+", "+ a.getMNSteps());
            sSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
