package it.uniroma3.diadia;
import  it.uniroma3.diadia.ambienti.*;
import  it.uniroma3.diadia.attrezzi.*;
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
	private Partita partita;
		
	public Partita(){

        this.labirinto = new Labirinto();
        labirinto.init();
        this.giocatore = new Giocatore();
		this.finita = false;
		this.cfu = CFU_INIZIALI;
		
	}
	
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	 
	
	public Stanza getStanzaVincente() {
		return this.labirinto.stanzaVincente;
	}

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.labirinto.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return labirinto.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.getStanzaCorrente()== this.getStanzaVincente();
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

	
}
