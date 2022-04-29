import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    @Override
    public void run(){
        ServerSocket sSocket;
        Socket client;
        ObjectInputStream in;
        Student s;
        AssistantCard a;

        try {
            sSocket = new ServerSocket(4096);
            System.out.println("Server: pronto");
            client = sSocket.accept();
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
