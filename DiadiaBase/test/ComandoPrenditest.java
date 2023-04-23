import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

public class ComandoPrenditest {

	private Attrezzo attrezzo;
	private Partita partita;
	private Stanza stanza;
	private ComandoPrendi comando;

	@Before
	public void setUp() throws Exception {

		partita = new Partita();
		stanza = new Stanza("stanza");
		comando = new ComandoPrendi();
		attrezzo = new Attrezzo("attrezzo",2);
		this.stanza.addAttrezzo(attrezzo);

	}

	@After
	public void tearDown() throws Exception {
        this.attrezzo = null;
		this.partita = null;
		this.comando = null;
		this.stanza = null;
	}

	@Test
	public void test() {
		this.comando.esegui(this.partita);
	}

}
