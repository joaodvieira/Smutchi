/**
 * Esta classe joga o jogo "Atras do Smutchi" varias vezes
 * @author IP
 * @date Outubro de 2015
 */
public class AtrasDoSmutchi2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
	    
        /* 
          O metodo imprimeResultados tem os seguintes parametros:
             posicao inicial do Smutchi, posicao inicial do Cacador, 
             salto maximo do Smutchi, salto maximo do Cacador, 
             dimensao do tabuleiro, distancia segura ao Cacador, 
             distancia minima ah fronteira, numero maximo de jogadas
         
          Vamos invocah-lo varias vezes
         */
    	imprimeResultados(14, 9, 7, 5, 15, 4, 3, 20);

    	imprimeResultados(4, 6, 12, 5, 40, 7, 3, 10);

    	imprimeResultados(6, 2, 6, 5, 6, 2, 1, 15);

    	imprimeResultados(6, 19, 5, 5, 30, 2, 5, 15);

    	imprimeResultados(6, 2, 1, 1, 10, 2, 2, 30);

    	imprimeResultados(6, 6, 1, 1, 10, 2, 2, 30);

        imprimeResultados(8, 10, 2, 4, 10, 1, 1, 8);

        imprimeResultados(6, 5, 3, 2, 6, 2, 2, 12);

    } // fim do main
    
    
    /**
     * Imprime no standard output os resultados de jogar o jogo
     * 
     * @param iniS - a posicao inicial do Smutchi
     * @param iniC - a posicao inicial do cacador
     * @param maxS - tamanho maximo do salto do Smutchi
     * @param maxC - tamanho maximo do salto do Cacador
     * @param dim - dimensao do tabuleiro
     * @param distSegur - distancia de seguranca entre o Smutchi e o cacador
     * @param distMinAoLim - distancia minima que o Smutchi deve manter entre
     *                       ele e os limites do tabuleiro
     * @param maxVezes - Numero maximo de jogadas
     */                         
    static void imprimeResultados (int iniS, int iniC, int maxS, int maxC,
	    		                      int dim, int distSegur, int distMinAoLim,
	    		                      int maxVezes){
        System.out.println();
        System.out.println("########################################################");
        System.out.println();
        System.out.println("Executar o metodo");
        System.out.println("JogarSmutchi.jogaJogoSmutchi(" + iniS + ", " + iniC
        		           + ", " + maxS + ", " + maxC + ", " + dim + ", " +  
        		           distSegur + ", " + distMinAoLim + ", " + maxVezes + ")");
        System.out.println("resulta em:");
        JogarSmutchi.jogaJogoSmutchi(iniS, iniC, maxS, maxC, dim, distSegur, 
        		                     distMinAoLim, maxVezes);

	}

}
