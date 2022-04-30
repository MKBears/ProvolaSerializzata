import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client_Gobbi extends Thread{
    public void run(){
        try {
        Scanner sc= new Scanner(System.in);

        DatagramSocket ds = new DatagramSocket();

        InetAddress ip = InetAddress.getLocalHost();
        byte buf[] = null;

        System.out.println("Scrivere qualcosa sotto");
        String inp = sc.nextLine();

        // convert the String input into the byte array.
        buf = inp.getBytes();

        // Step 2 : Create the datagramPacket for sending the data.
        DatagramPacket DpSend = new DatagramPacket(buf, buf.length, ip, 4898);

        // Step 3 : invoke the send call to actually send the data.

            ds.send(DpSend);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
