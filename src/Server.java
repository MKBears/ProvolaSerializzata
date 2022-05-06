import java.io.IOException;
import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;
import java.net.*;

public class Server extends Thread{
    @Override
    public void run(){
        ServerSocket sSocket;
        Socket client;
        ObjectInputStream in;
        ObjectOutputStream out;
        InetSocketAddress ip;
        InetSocketAddress ip_mio;
        Student s;
        AssistantCard a;
        DatagramPacket packet;


        try { /////////////////////////////SBAGLIATO IL SERVERRRRRRRRRRR
            sSocket = new ServerSocket();
            ip_mio=new InetSocketAddress(Inet4Address.getLocalHost(),4898);
            sSocket.bind(ip_mio); //qualcosa di sbagliato qui
            System.out.println("Server: pronto all'indirizzo ip  "+sSocket.getLocalSocketAddress());
            ///client = sSocket.accept();
            //System.out.println("Server: connesso, aspetto notizie del client");
            //in = new ObjectInputStream(client.getInputStream());
            byte[] buf = new byte[256];
            packet = new DatagramPacket(buf, buf.length);
            packet = new DatagramPacket(buf, 0, 256);
            String received = new String(packet.getData());
            //ip=(InetSocketAddress) in.readObject();
            System.out.println("Client: ricevuto ip: "+received);
            /*client= new Socket(ip.getAddress(),ip.getPort());
            String h= "Hello Mark";
            out= new ObjectOutputStream(client.getOutputStream());
            out.writeObject(ip_mio);
            s = (Student)in.readObject();
            System.out.println("Server: studente ricevuto: "+s.getType().getName());
            a = (AssistantCard)in.readObject();
            System.out.println("Server: carta ricevuta: "+a.getValue()+", "+ a.getMNSteps());*/
            sSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
