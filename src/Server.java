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
        String received;
        DatagramSocket sock;


        try { /////////////////////////////SBAGLIATO IL SERVERRRRRRRRRRR
            sSocket = new ServerSocket();
            ip_mio=new InetSocketAddress(Inet4Address.getLocalHost(),4898);
            sSocket.bind(ip_mio); //qualcosa di sbagliato qui
            //System.out.println("Server: pronto all'indirizzo ip  "+sSocket.getLocalSocketAddress());
            sock = new DatagramSocket(4898);
            System.out.println("Creato datagram socket");
            //System.out.println("Server: connesso, aspetto notizie del client");
            byte[] buf = new byte[1];
            System.out.println("Creato buffer");
            packet = new DatagramPacket(buf, 0, 1);
            System.out.println("Creato pacchetto");
            sock.receive(packet);
            System.out.println("Ricevuto pacchetto");
            received = new String(packet.getData());
            //ip=(InetSocketAddress) in.readObject();
            System.out.println("Server: ricevuto messaggio broadcast: "+packet.getAddress()+", "+packet.getPort());
            DatagramPacket packet1 = new DatagramPacket(buf, 0, buf.length, packet.getAddress(), packet.getPort());
            sock.send(packet1);
            client = sSocket.accept();
            in = new ObjectInputStream(client.getInputStream());
            try {
                System.out.println("Connesso: "+(String)in.readObject());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            /*client= new Socket(ip.getAddress(),ip.getPort());
            String h= "Hello Mark";
            out= new ObjectOutputStream(client.getOutputStream());
            out.writeObject(ip_mio);
            s = (Student)in.readObject();
            System.out.println("Server: studente ricevuto: "+s.getType().getName());
            a = (AssistantCard)in.readObject();
            System.out.println("Server: carta ricevuta: "+a.getValue()+", "+ a.getMNSteps());*/
            //sSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
