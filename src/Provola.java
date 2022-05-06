public class Provola {
    public static void main(String[] args) {
        Server s = new Server();
        Client c = new Client();

        s.start();
        c.start();
    }

}
