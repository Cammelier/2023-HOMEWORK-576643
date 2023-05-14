import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBloccatatest {
	private StanzaBloccata camera;
	private Stanza stanza;
	private Stanza atrio;
	Attrezzo piedediporco;
	
	@Before
	public void setUp() throws Exception {
		this.camera = new StanzaBloccata ("camera","sud","piedediporco");
		this.stanza = new Stanza("stanza");
		this.atrio = new Stanza("atrio");
		piedediporco = new Attrezzo("piedediporco",2);
		camera.impostaStanzaAdiacente("sud", stanza);
		camera.impostaStanzaAdiacente("nord", atrio);
		camera.addAttrezzo(piedediporco);

	}

	@After
	public void tearDown() throws Exception {
		this.camera = null;
		this.stanza=null;
		this.atrio=null;
		this.piedediporco = null;
	}
 
	@Test
	public void testbloccata1() {
		assertTrue(this.camera.getStanzaAdiacente("sud").getNome().equals("stanza"));
		
	}
	@Test
	public void testbloccata2() {
		assertFalse(this.camera.getStanzaAdiacente("sud").getNome().equals("atrio"));
		
	}
}