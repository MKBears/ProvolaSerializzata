import java.io.IOException;

import java.net.*;

public class Server_Gobbi extends Thread{
    public void run() {
        DatagramSocket ds;
        byte[] receive;
        DatagramPacket DgReceive;
        try {
            ds = new DatagramSocket(4898);
            receive = new byte[12345];

            //creo un datagram packet per ricevere i dati
            DgReceive = new DatagramPacket(receive, receive.length);
            ds.receive(DgReceive);

            System.out.println("Server pronto");
            //stampo quello che ho ricevuto
            System.out.println("Client: - " + data(receive));

            receive = new byte[12345];
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        // A utility method to convert the byte array
        // data into a string representation.
        public static StringBuilder data(byte[] a)
        {
            if (a == null)
                return null;
            StringBuilder ret = new StringBuilder();
            int i = 0;
            while (a[i] != 0)
            {
                ret.append((char) a[i]);
                i++;
            }
            return ret;
        }
}
