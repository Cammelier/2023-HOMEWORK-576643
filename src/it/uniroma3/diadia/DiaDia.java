package it.uniroma3.diadia;
import  it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.comandi.*;
import  it.uniroma3.diadia.giocatore.*;

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

public class DiaDia  {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	public static final String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","guarda"};

	private static IOConsole IO;

	private Partita partita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	private IO io;
	



	public DiaDia(IO io) {
		this.partita = new Partita();
		this.labirinto = new  Labirinto();
		this.giocatore = new Giocatore();
		this.io = new IOConsole();
		
	}
	
	private boolean processaIstruzione(String istruzione) {
		   Comando comandoDaEseguire;
		   
		   FabbricaDiComandiFisarmonica factory = new FabbricaDiComandiFisarmonica();
		   comandoDaEseguire = factory.costruisciComando(istruzione);
		   comandoDaEseguire.esegui(this.partita);
		   if (this.partita.vinta())
		           io.mostraMessaggio("Hai vinto!");
		   if (!this.partita.giocatoreIsVivo())
		           io.mostraMessaggio("Hai esaurito i CFU...");
		   return this.partita.isFinita();
		}


	public void gioca() {
		String istruzione;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);
		istruzione = io.leggiRiga();	
		if(istruzione.length()<=0) {
			istruzione = istruzione + "sconosciuto";
		}
		while (!processaIstruzione(istruzione)) {
			istruzione = io.leggiRiga();
			if(istruzione.length()<=0) {
				istruzione=istruzione+"sconosciuto";
			}
		}
		
	}
  


	public static void main(String[] argc) {
		IO io= new IOConsole();
		DiaDia gioco = new DiaDia(io);
		gioco.gioca();
	}
}
	
	


	
