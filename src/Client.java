import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;

public class Client extends Thread{
    @Override
    public void run(){
        Socket socket;
        Student s;
        AssistantCard a;
        ObjectOutputStream out;
        ObjectInputStream in;

        try {
            socket = new Socket("255.255.255.255", 4898);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            s = new Student(StudentTypes.DRAGON);
            a = new AssistantCard(6, 3);
            out.writeObject(new InetSocketAddress(Inet4Address.getLocalHost(), socket.getPort()));

            try {
                socket = new Socket((Proxy)in.readObject());
                System.out.println("Client: connesso");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
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
