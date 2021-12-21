public class App {
    public static void main(String[] args) throws Exception {
        Mesa mesa = new Mesa();

        for(int i = 0; i < 5; i++) {
            new Filosofo(mesa, i).start();
        }
    }
}
