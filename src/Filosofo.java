public class Filosofo extends Thread {
    Mesa mesa;
    int numFilosofo; 

    public Filosofo (Mesa mesa, int filosofo) {
		this.mesa = mesa;
		this.numFilosofo = filosofo;
	}
}