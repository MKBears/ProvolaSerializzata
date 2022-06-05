public class Provola {
    private static Server s;
    private static Client c;
    public static void main(String[] args) {
        Provola p = new Provola();
        s = new Server();
        c = new Client();

        p.met();
        //s.start();
        //c.start();
    }

    private synchronized void met(){
        s.start();
        synchronized (c) {
            try {
                c.wait(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            c.start();
        }
    }
}
