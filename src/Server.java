import java.io.IOException;
import java.io.ObjectInputStream;

import java.net.*;

public class Server extends Thread{
    @Override
    public void run(){
        ServerSocket sSocket;
        Socket client;
        ObjectInputStream in;
        InetSocketAddress ip_mio;
        DatagramPacket packet;
        DatagramSocket sock;


        try { /////////////////////////////SBAGLIATO IL SERVERRRRRRRRRRR
            sSocket = new ServerSocket();
            ip_mio=new InetSocketAddress(Inet4Address.getLocalHost(),4898);
            sSocket.bind(ip_mio);
            sock = new DatagramSocket(4898);
            System.out.println("Server: Creato datagram socket");
            byte[] buf = new byte[1];
            System.out.println("Server: Creato buffer");
            packet = new DatagramPacket(buf, 0, 1);
            System.out.println("Server: Creato pacchetto");
            System.out.println("Server: pronto @ "+ip_mio.getAddress().getHostAddress());
            sock.receive(packet);
            System.out.println("Server: Ricevuto pacchetto");
            System.out.println("Server: ricevuto messaggio broadcast: "+packet.getAddress()+", "+packet.getPort());
            DatagramPacket packet1 = new DatagramPacket(buf, 0, buf.length, packet.getAddress(), packet.getPort());
            sock.send(packet1);
            client = sSocket.accept();
            in = new ObjectInputStream(client.getInputStream());
            try {
                System.out.println("Server: Connesso: "+in.readObject());
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
