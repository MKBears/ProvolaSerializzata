import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Thread{
    @Override
    public void run(){
        Socket socket;
        Student s;
        AssistantCard a;
        ObjectOutputStream out;

        try {
            socket = new Socket("10.169.151.169", 4898);
            System.out.println("Client: connesso");
            out = new ObjectOutputStream(socket.getOutputStream());
            s = new Student(StudentTypes.DRAGON);
            a = new AssistantCard(6, 3);
            out.writeObject(s);
            System.out.println("Client: studente inviato");
            out.writeObject(a);
            System.out.println("Client: carta inviata");
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Non trovo il server");
            System.err.println(e.getMessage());
        }
    }

}
