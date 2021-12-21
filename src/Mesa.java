public class Mesa {
    private Estados estados;
    private final int QUANTIDADE_FILOSOFOS = 5;
    private final int PRIMEIRO_FILOSOFO = 0;
    private final int ULTIMO_FILOSOFO = QUANTIDADE_FILOSOFOS - 1;

    boolean[] garfos = new boolean[QUANTIDADE_FILOSOFOS];
    Estados[] filosofos = new Estados[QUANTIDADE_FILOSOFOS];

    public Mesa() {
        for(int i = 0; i < QUANTIDADE_FILOSOFOS; i++) {
            garfos[i] = true;
            filosofos[i] = Estados.PENSANDO;
        }
    }

    synchronized void pegarGarfos(int numFilosofo) {
        int posicaoDireita = getDireita(numFilosofo);
        int posicaoEsquerda = getEsquerda(numFilosofo);

        while (filosofos[posicaoDireita] == Estados.COMENDO || filosofos[posicaoEsquerda] == Estados.COMENDO) {
            try {

                System.out.println("Filosofo " + numFilosofo + " tentou comer");
                wait();
            } catch (InterruptedException e) {
                System.out.println("morreu tentando comer");
            }
        }

        garfos[posicaoDireita] = false;
        garfos[posicaoEsquerda] = false;
        filosofos[numFilosofo] = Estados.COMENDO;
    }

    synchronized void soltarGarfos(int numFilosofo) {
        int posicaoDireita = getDireita(numFilosofo);
        int posicaoEsquerda = getEsquerda(numFilosofo);

        garfos[posicaoDireita] = true;
        garfos[posicaoEsquerda] = true;

        filosofos[numFilosofo] = Estados.PENSANDO;
        notifyAll();
    }


    public int getDireita(int numFilosofo) {
        if(numFilosofo == ULTIMO_FILOSOFO) return PRIMEIRO_FILOSOFO;
        return numFilosofo + 1;
    }

    public int getEsquerda(int numFilosofo) {
        if(numFilosofo == PRIMEIRO_FILOSOFO) return ULTIMO_FILOSOFO;
        return numFilosofo - 1;
    }
}
