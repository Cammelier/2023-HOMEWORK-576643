package it.uniroma3.diadia;
import  it.uniroma3.diadia.ambienti.*;
import  it.uniroma3.diadia.giocatore.*;
import  it.uniroma3.diadia.attrezzi.*;
import java.util.Scanner;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	private  Partita partita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private IOConsole ioConsole;



	public DiaDia() {
		this.partita = new Partita();
		this.labirinto = new Labirinto();
		this.giocatore = new Giocatore();
		this.ioConsole = new IOConsole();        
	}


	public void gioca() {
		String istruzione; 


		ioConsole.mostraMessaggio(MESSAGGIO_BENVENUTO);
		istruzione = ioConsole.leggiRiga();	
		if(istruzione.length()<=0) {
			istruzione = istruzione + "sconosciuto";
		}
		while (!processaIstruzione(istruzione)) {
			istruzione = ioConsole.leggiRiga();
			if(istruzione.length()<=0) {
				istruzione=istruzione+"sconosciuto";
			}
		}


	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);



		if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if(comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if(comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			ioConsole.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			ioConsole.mostraMessaggio("Hai vinto");
			return true;
		} else
			return false;
	}   

	// implementazioni dei comandi dell'utente:

	private void prendi(String nomeAttrezzo) {
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		partita.getGiocatore().addBorsa(attrezzo);
		partita.getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
	}

	private void posa(String nomeAttrezzo) {
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		partita.getStanzaCorrente().addAttrezzo(attrezzo);
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
	}


	/**
	 * Stampa informazioni di aiuto
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			ioConsole.mostraMessaggio(elencoComandi[i]+" ");
		ioConsole.mostraMessaggio(" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			ioConsole.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			ioConsole.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.giocatore.getCfu();
			this.giocatore.setCfu(cfu--);
		}
		ioConsole.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		ioConsole.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		IOConsole ioConsole = new IOConsole();
		gioco.gioca();
	}
}