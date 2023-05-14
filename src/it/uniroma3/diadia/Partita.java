package it.uniroma3.diadia;
import  it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.Giocatore;


/**
 * Questa classe modella una partita del gioco
 *
 * @author  Carmine Iengo
 * @see Stanza
 * @version base
 */

public class Partita {

	static final private int CFU_INIZIALI = 20;


	private Labirinto labirinto;
	private boolean finita;
	private int cfu;
	private Giocatore giocatore;

 
	public Partita(Labirinto labirinto){

		this.labirinto = labirinto;
		this.giocatore = new Giocatore();
		this.finita = false;
		this.cfu = CFU_INIZIALI;

	}

	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.labirinto.stanzaVincente = stanzaVincente;
		
	}
	
	public Stanza getStanzaVincente() {
		return labirinto.stanzaVincente;
		
	}

    
 

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.labirinto.stanzaIngresso = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return labirinto.stanzaIngresso;
	}

	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente() == this.labirinto.getStanzaCorrente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (cfu == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}

	public boolean giocatoreIsVivo() {
		if(this.giocatore.getCfu()==0)
		return false;
		return true;
	}
	
	public void setLabirinto(Labirinto labirinto) {
		this.labirinto = labirinto;
	}


}
