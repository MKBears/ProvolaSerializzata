import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;

public class Client extends Thread{
    @Override
    public void run(){
        Socket socket;
        ObjectOutputStream out;
        DatagramSocket sokk;
        byte[] addr;

        try {
            Cloud[] clouds = new Cloud[2];
            ArrayList<Student> students = new ArrayList<>();
            clouds[0] = new Cloud(2);
            clouds[1] = new Cloud(2);

            for (int i=0; i<3; i++) {
                students.add(new Student(StudentTypes.DRAGON));
            }
            clouds[0].importStudents(students);
            clouds[1].importStudents(students);
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
            out.writeObject(clouds);
            socket.close();
        } catch (IOException e) {
            System.out.println("Client: Non trovo il server");
            System.err.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
