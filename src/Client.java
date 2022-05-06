import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.io.*;

public class Client extends Thread{
    @Override
    public void run(){
        Socket socket;
        Student s;
        AssistantCard a;
        ObjectOutputStream out;
        ObjectInputStream in;
        InetSocketAddress inet;

        try {
            socket=new Socket();
            inet=new InetSocketAddress(Inet4Address.getLocalHost(),4500);
            socket.bind(inet);
            byte[] buf = new byte[256];
            // don't wait for request...just send a quote
            String dString = "Hello";
            buf = dString.getBytes();
            InetSocketAddress addr;
            //socket = new Socket(new Proxy(null, new InetSocketAddress("255.255.255.255", 4898)));
            DatagramPacket packet;
            packet= new DatagramPacket(buf, 0, buf.length, InetAddress.getByName("255.255.255.255"), 4500);
            /*in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(packet);*/
            System.out.println("Ho mandato il mandabile");
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
            out.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Non trovo il server");
            System.err.println(e.getMessage());
        }
    }

}
