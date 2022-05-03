import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.InetAddress;

public class Client_Gobbi extends Thread{
    @Override
    public void run(){
        Socket socket;
        ObjectOutputStream out;

        try {

            socket = new Socket("255.255.255.255", 4096);
            System.out.println("Client: connesso");
            out = new ObjectOutputStream(socket.getOutputStream());
            int s=99;
            out.writeObject(s);
            System.out.println("Client: numero inviato");
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Non trovo il server");
            System.err.println(e.getMessage());
        }
    }

}
//halo