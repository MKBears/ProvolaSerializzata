import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;

public class Client extends Thread{
    @Override
    public void run(){
        Socket socket;
        ObjectOutputStream out;
        DatagramSocket sokk;
        byte[] addr;

        try {
            addr= InetAddress.getLocalHost().getAddress();
            addr[3]=(byte)255;
            sokk=new DatagramSocket();
            System.out.println("Client: Inizializzato "+Inet4Address.getLocalHost().getHostAddress());
            byte[] buf = new byte[30];
            DatagramPacket packet;
            packet= new DatagramPacket(buf, 0, buf.length, InetAddress.getByAddress(addr), 4898);
            sokk.send(packet);
            System.out.println("Client: Ho mandato il mandabile, ora vediamo di ricevere...");
            buf=new byte[1];
            packet= new DatagramPacket(buf, buf.length);
            sokk.receive(packet);
            System.out.println("Client: Ricevuto pacchetto");
            InetAddress ip= packet.getAddress();
            int port= packet.getPort();
            String connesso="Sono connesso TCP";
            System.out.println("Client: Ho creato la stringa da mandare: porta di Marco "+ port);
            socket= new Socket(ip.getHostAddress(),port);
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(connesso);
            System.out.println("Client: Stringa mandata");
            socket.close();
        } catch (IOException e) {
            System.out.println("Client: Non trovo il server");
            System.err.println(e.getMessage());
        }
    }

}
