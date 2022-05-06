import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Client extends Thread{
    @Override
    public void run(){
        Socket socket;
        Student s;
        AssistantCard a;
        ObjectOutputStream out;
        ObjectInputStream in;
        InetSocketAddress inet;
        DatagramSocket sokk;
        byte[] addr;

        try {
            addr= new byte[4];
            addr[0]=(byte)192;
            addr[1]=(byte)168;
            addr[2]=(byte)16;
            addr[3]=(byte)255;
            sokk=new DatagramSocket();
            System.out.println("Inizializzato");
            byte[] buf = new byte[30];
            // don't wait for request...just send a quote
            //String dString = "Hello_MKbears";
            //buf = dString.getBytes();
            //socket = new Socket(new Proxy(null, new InetSocketAddress("255.255.255.255", 4898)));
            DatagramPacket packet;
            packet= new DatagramPacket(buf, 0, buf.length, InetAddress.getByAddress(addr), 4898);
            sokk.send(packet);
            System.out.println("Ho mandato il mandabile, ora vediamo di ricevere...");
            buf=new byte[1];
            packet= new DatagramPacket(buf, buf.length);
            sokk.receive(packet);
            System.out.println("Ricevuto pacchetto da Marco");
            InetAddress ip= packet.getAddress();
            int port= packet.getPort();
            String connesso="Sono connesso TCP";
            System.out.println("Ho creato la stringa da mandare: porta di Marco "+ port);
            socket= new Socket(ip.getHostAddress(),port);
            //in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(connesso);
            System.out.println("Stringa mandata");
            /*s = new Student(StudentTypes.DRAGON);
             a= new AssistantCard(6, 3);
            out.writeObject(new InetSocketAddress(Inet4Address.getLocalHost(), socket.getPort()));

            try {
                addr = (InetSocketAddress) in.readObject();
                socket = new Socket(addr.getAddress(), addr.getPort());
                System.out.println("Client: connesso");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            out.writeObject(s);
            System.out.println("Client: studente inviato");
            out.writeObject(a);
            System.out.println("Client: carta inviata");*/
            //out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Non trovo il server");
            System.err.println(e.getMessage());
        }
    }

}
