/*
    1 - quando um come, o da esquerda e nem da direita pode comer
    2 - ver onde a thread vai dormir sem causar starvesion ou deadlock
*/



public class Filosofo extends Thread {
    private final int TEMPO_MAX = 5000;

    private Mesa mesa;
    private int numFilosofo;
    private boolean garfoEsquerdo;
    private boolean garfoDireito;


    public Filosofo (Mesa mesa, int filosofo) {
		this.mesa = mesa;
		this.numFilosofo = filosofo;
	}

    public void run () {
        while (true) {
            int tempoPensar = (int) (Math.random() * TEMPO_MAX);
            pensar(tempoPensar);
            int tempoComer = (int) (Math.random() * TEMPO_MAX);
            comer(tempoComer);
            mesa.soltarGarfos(numFilosofo);
            System.out.println("Filosofo " + numFilosofo + " parou de comer");
        }
    }

    private void pensar(int tempo) {
        try {
            sleep(tempo);
        } catch (InterruptedException e) {
            System.out.println("Pensou demais");
        }
    }

    private void comer(int tempo) {
        try {
            mesa.pegarGarfos(numFilosofo);
            System.out.println("Filosofo " + numFilosofo + " está comendo");
            sleep(tempo);
        } catch (InterruptedException e) {
            System.out.println("Comeu demais");
        }
    }









}