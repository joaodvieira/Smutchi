import java.util.Random;

public class JogarSmutchi{

    /**
     * Joga o jogo “Atras do Smutchi”
     * @param iniS - a posicao inicial do Smutchi
     * @param iniC - a posicao inicial do cacador
     * @param maxS - tamanho maximo do salto do Smutchi
     * @param maxC - tamanho maximo do salto do Cacador
     * @param dim - dimensao do tabuleiro
     * @param distSegur - distancia de seguranca entre o Smutchi e o cacador
     * @param distMinAoLim - distancia minima que o Smutchi deve manter entre
     * ele e os limites do tabuleiro
     * @param maxVezes - Numero maximo de jogadas do jogo
     * @requires iniS > 0 e iniS <= dim e iniC > 0 e iniC <= dim e maxS > 0 e
     * maxC > 0 e dim > 0 e distSegur >= 0 e distMinAoLim >= 0 e
     * maxVezes > 0
     */
    public static void jogaJogoSmutchi (int iniS, int iniC, int maxS, int maxC,
					int dim, int distSegur, int distMinAoLim,
					int maxVezes){

    	Random perto = new Random(1);
    	
    	int vezes, posS = iniS, posC = iniC;
    	
    	for(vezes = 0; vezes <= maxVezes && posC != posS; vezes++){

    	   if (vezes <= maxVezes || posC != posS)
    		   System.out.println(barra(dim));
    	    
    	    System.out.println(posicoes(dim, posS, posC));
    	    	    

    	    posS = posS + FuncoesSmutchi.saltoSmutchi(posS, posC, maxS, dim,
    	    					       distSegur, distMinAoLim);

    	    posC = posC + FuncoesSmutchi.saltoCacador(posC, posS, maxC, maxS, dim,
    	    					       perto.nextBoolean());
    	}
    	
    	
    	
    }
    
    /**
     * 
     * @param dim
     * @return
     */
    public static StringBuilder tabuleiro(int dim){
    	StringBuilder tab = new StringBuilder("|");
    	
    	for(int slots = 1;slots <= dim;slots++)
    		tab.append(" |");
    	
    	return tab;
    }
    
    /**
     * 
     * @param dim
     * @return
     */
    public static StringBuilder barra(int dim){
    	
    	StringBuilder bar = new StringBuilder("-");
    	
    	for(int slots = 1;slots <= dim; slots++)
		bar.append("--");
    	
    	return bar;
    }
    
    /**
     * 
     * @param dim
     * @param posSmutchi
     * @param posCacador
     * @return
     */
    public static StringBuilder posicoes(int dim, int posS, int posC){
    	
    	StringBuilder tab = new StringBuilder(tabuleiro(dim));
    	
    	if(posS == posC)
    		tab.replace((posS * 2) - 1, posS * 2, "@");
    	
    	else{
    		tab.replace((posS * 2) - 1, posS * 2, "*");
    		tab.replace((posC * 2) - 1, posC * 2, "C");
    	}
    	
    	return tab;
    }
}
