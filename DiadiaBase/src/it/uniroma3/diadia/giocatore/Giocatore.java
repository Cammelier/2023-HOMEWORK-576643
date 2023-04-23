package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.ambienti.Stanza;
import  it.uniroma3.diadia.attrezzi.*;

/**
 * Questa classe crea un giocaotre della partita, si occupa della gestione dei
 * Cfu e di far prendere oggetti o posare oggetti.
 *
 * @author  Carmine Iengo
 * @see Stanza
 * @version base
 */

public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	Borsa borsa = new Borsa();
	
	
	public Giocatore() {
    	this.cfu = CFU_INIZIALI;
    }
    

    public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
    /* aggiunta  di un attrezzo all'interno di una borsa
     * 
     * @return  vero se attrezzo aggiunto 
     */
	public boolean addBorsa(Attrezzo attrezzo) {
		boolean k = false;
		if(borsa.getPeso() <= borsa.getPesoMax() - attrezzo.getPeso()) {
			borsa.addAttrezzo(attrezzo);
            k= true;
	}
		 return k;
	}
	
	public Attrezzo posaAttrezzo(Attrezzo attrezzo) {
		return borsa.removeAttrezzo(attrezzo.getNome());
		
	}
    
	
    
}








