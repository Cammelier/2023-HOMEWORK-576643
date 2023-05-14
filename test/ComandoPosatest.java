 import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosatest {

	private Attrezzo attrezzo;
	private Partita partita;
	private Stanza stanza;
	private ComandoPosa comando;
	private Labirinto labirinto;
	private Borsa borsa;

	@Before
	public void setUp() throws Exception {
		this.labirinto= new Labirinto();
		partita = new Partita(labirinto);
		
		stanza = new Stanza("stanza");
		comando = new ComandoPosa();
		this.borsa= new Borsa();
		attrezzo = new Attrezzo("attrezzo",2);
		this.borsa.addAttrezzo(attrezzo);
		

	}

	@After
	public void tearDown() throws Exception {
        this.attrezzo = null;
		this.partita = null;
		this.comando = null;
		this.stanza = null;
		this.borsa = null;

	}

	@Test
	public void test() {
		this.comando.esegui(this.partita);
	}

}
