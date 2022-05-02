public class Cami {
    public static void main(String[] args) {
        Server_Gobbi g= new Server_Gobbi();
        Client_Gobbi c= new Client_Gobbi();

        g.start();
        c.start();
    }
}
