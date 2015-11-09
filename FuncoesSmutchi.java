/**
 * Esta classe contem funcoes que definem os saltos do Smutchi e do Cacador
 * a serem usadas no contexto do jogo "Atras do Smutchi"
 *
 * @author IP
 * @date Outubro de 2015
 */ 
public class FuncoesSmutchi {
	   
	   /**
	    * Que salto deve o Smutchi dar para se manter a uma distancia segura do 
	    * Cacador, mantendo tambem um distanciamento minimo dos limites do 
	    * tabuleiro?
	    * 
	    * @param posS - a posicao atual do Smutchi
	    * @param posC - a posicao atual do Cacador
	    * @param maxS - tamanho maximo do salto do Smutchi
	    * @param dim - dimensao do tabuleiro
	    * @param distSegur - distancia de seguranca entre o Smutchi e o Cacador
	    * @param distMinAoLim - distancia minima que o Smutchi deve manter 
	    *                       entre ele e os limites do tabuleiro
	    *                       
	    * @return O maior salto que o Smutchi pode dar de modo a nao ficar
	    *         demasiado perto de posC (ah distancia distSegur ou superior), 
	    *         num tabuleiro de dimensao dim, nem demasiado perto dos  
	    *         limites do tabuleiro (ah distancia distMinAoLim dos limites  
	    *         do tabuleiro ou superior):
	    *         - se a distancia entre o Smutchi e o Cacador eh menor que a 
	    *           distancia de seguranca (distSegur), entao:
	    *              - se o Smutchi pode fugir na direcao oposta do Cacador 
	    *                 (nao estah a uma distancia igual ou menor que 
	    *                  distMinAoLim do limite), entao:
	    *                  - o salto serah o maximo que ele pode mover-se nessa 
	    *                    direcao
	    *              - senao, 
	    *                  - o salto serah o maximo que ele pode mover-se na 
	    *                    direcao do Cacador
	    *         - senao,
	    *              - se o Smutchi estah demasiado perto de algum dos  
	    *                limites do tabuleiro (soh possivel no inicio)
	    *                  - o salto serah a distancia necessaria para se  
	    *                    colocar ah distancia minima do limite do tabuleiro
	    *              - senao,
	    *                  - o salto serah zero
	    *                  
	    * @requires posS > 0 e posS <= dim e posC > 0 e posC <= dim e maxS > 0
	    *           e dim > 0 e distSegur >= 0 e distMinAoLim >= 0 e posS != posC
	    */
	   public static int saltoSmutchi (int posS, int posC, int maxS, int dim, 
				           int distSegur, int distMinAoLim){
	        int result = 0;

	        // distancia entre o Smutchi e o Cacador:
	        int entreSC = Math.abs(posS - posC) - 1; 
	        // distancia entre o Smutchi e o inicio do tabuleiro:
	        int entreSIni = posS - 1;
	        // distancia entre o Smutchi e o fim do tabuleiro:
	        int entreSFim = Math.abs(dim - posS);
			
	        if (entreSC < distSegur) { // C demasiado perto; tem que se mexer
				
	            // S sem margem de manobra para trahs 
	            if (entreSIni <= distMinAoLim) 

	                result = Math.min(maxS, dim - distMinAoLim - posS);// salto para
	                                                                   // a frente
				
	            // S sem margem de manobra para a frente
	            else if (entreSFim <= distMinAoLim)

	                result = -Math.min(maxS, posS - distMinAoLim - 1);// salto para
	                                                                  // trahs	
	            // S estah ah esquerda de C, longe dos limites
	            else if (posS < posC)
			result = -Math.min (maxS, posS - distMinAoLim - 1);// salto para
	                                                                  // trahs			
	            // S estah ah direita de C, longe dos limites
		    else if (posS > posC)
			result = Math.min (maxS, dim - distMinAoLim - posS);// salto para
	                                                                    // a frente
	         } else { // C nao estah demasiado perto

	            // S fica quieto, a nao ser que esteja demasiado perto
	            // de uma fronteira (soh possivel no inicio)
	            if (entreSIni < distMinAoLim) // distancia de S ao inicio eh 
					          // menor do que o que devia
	                result = Math.min(maxS, distMinAoLim - posS + 1); // minim salto 
	                                                                  // necessario
				                                          // em frente
	            else if (entreSFim < distMinAoLim) // distancia de S ao fim eh 
	                                               // menor do que o que devia                   
	                result = -Math.min (maxS, distMinAoLim - (dim - posS)); // minimo 
	                                                              // salto necessario  
	                                                              // para trahs	
	            else
	                result = 0;
	        }
			
	        return result;
	    }

		
	   /**
	    * Que salto deve o cacador dar para apanhar o Smutchi? O salto deverah
	    * permitir ao cacador "apanhar" o Smutchi no local para onde ele prova-
	    * velmente irah saltar; 
	    * A previsao eh que o Smutchi salte o maximo que pode numa direcao ou noutra
	    * O Cacador nao sabe que o Smutchi respeita distancia aos limites
	    * A escolha de qual dessas duas posicoes possiveis eh feita dependendo de 
	    * um parametro desta funcao.
	    * 
	    * @param posC - a posicao atual do cacador
	    * @param posS - a posicao atual do Smutchi
	    * @param maxC - tamanho maximo do salto do cacador
	    * @param maxS - tamanho maximo do salto do Smutchi
	    * @param dim - dimensao do tabuleiro
	    * @param perto - se o salto eh para ser para lugar esperado do Smutchi 
	    *                mais perto ou mais longe da posicao atual do cacador
	    *                 
	    * @return O salto que o cacador deve dar, num tabuleiro de dimensao dim,
	    *         de modo a tentar alcancar o Smutchi:
	    *         - se o param "perto" for true, este salto deve ser para a posicao
	    *           que se preve que o Smutchi vah alcancar (das duas possiveis)
	    *           mais perto do Cacador
	    *           
	    *         - se o param "perto" for false, este salto deve ser para a posicao
	    *           que se preve que o Smutchi vah alcancar mais longe do Cacador
	    *
	    * @requires posC > 0 e posC <= dim e posS > 0 e posS <= dim e maxC > 0 e
	    *           maxS > 0 e dim > 0 e posS != posC
	    */                         
	   public static int saltoCacador (int posC, int posS, int maxC, int maxS,
				           int dim, boolean perto){
	        int result;

	        // a posicao onde o Smutchi ficarah se saltar em frente:
	        int nextSmutchiFront = posS + Math.min(maxS, dim - posS);
	        // a posicao onde o Smutchi ficarah se saltar para trahs:
	        int nextSmutchiBack = posS - Math.min(maxS, posS - 1);
	        int alvo;
			
	        // o salto do cacador serah para a posicao expectavel do Smutchi mais perto
	        // do cacador se param perto == true e o contrario se param perto == false 
	        if (Math.abs(nextSmutchiFront - posC) < Math.abs(nextSmutchiBack - posC)) {
	                // o cacador estah mais perto da posicao nextSmutchiFront

	                // salto do cacador serah para nextSmutchiFront ou para 
	                // nextSmutchiBack conforme param perto eh == true ou false,
	                // respetivamente:
		       alvo = melhorAlvo (nextSmutchiFront, nextSmutchiBack, perto);

	        } else {
	                // o cacador estah mais perto da posicao nextSmutchiBack ou estah a
	                // distancia igual de nextSmutchiFront e de nextSmutchiBack

	                // salto do cacador serah para nextSmutchiBack ou para 
	                // nextSmutchiFront conforme param perto eh == true ou false,
	                // respetivamente:
		       alvo = melhorAlvo (nextSmutchiBack, nextSmutchiFront, perto);
	        }

	        // o salto serah o maximo possivel para atingir o alvo a partir da posicao
	        // atual do cacador
	        if (posC < alvo)
	               result = Math.min(maxC, alvo - posC);
	        else
	               result = -Math.min(maxC, posC - alvo);

	        return result;
	    }

	   /**
	    * Dadas duas posicoes, retorna uma ou outra conforme um dado boolean
	    * 
	    * @param maisPerto - a posicao mais perto
	    * @param maisLonge - a posicao mais longe
	    * @param paraPerto - true se se pretende a posicao mais perto
	    *                    false caso contrario
	    * @return - posicao maisPerto se paraPerto for true
	    *         - posicao maisLonge se paraPerto for false
	    * @requires maisPerto > 0 e maisPerto <= dim e maisLonge > 0 e
	    *           maisLonge <= dim
	    */                         
	    public static int melhorAlvo (int maisPerto, int maisLonge, 
	                                  boolean paraPerto){
	        int result;
	        if (paraPerto)
	             result = maisPerto;
	        else
	             result = maisLonge;

	        return result;
	   }

}
