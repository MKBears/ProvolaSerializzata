import java.io.IOException;
import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
    @Override
    public void run(){
        ServerSocket sSocket;
        Socket client;
        ObjectInputStream in;
        ObjectOutputStream out;
        InetSocketAddress ip;
        InetSocketAddress ip_mio;


        try {
            sSocket = new ServerSocket();
            ip_mio=new InetSocketAddress(sSocket.getInetAddress(),sSocket.getLocalPort());
            sSocket.bind(ip_mio);
            System.out.println("Server: pronto all'indirizzo ip  "+sSocket.getLocalSocketAddress());
            client = sSocket.accept();
            System.out.println("Server: connesso");
            in = new ObjectInputStream(client.getInputStream());
            ip=(InetSocketAddress) in.readObject();
            System.out.println("Client: ricevuto ip: "+ip);
            client= new Socket(ip.getAddress(),ip.getPort());
            String h= "Hello Mark";
            out= new ObjectOutputStream(client.getOutputStream());
            out.writeObject(ip_mio);
            sSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
