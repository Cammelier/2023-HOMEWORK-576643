 import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class Partitatest  {
	private Partita partita;
	private Labirinto labirinto;
    
	@Before
	public void setUp() throws Exception {
		this.labirinto = new Labirinto();
		this.partita = new Partita(labirinto);
		
	}

	@After
	public void tearDown() throws Exception {
		this.partita = null;
	}

	@Test
	public void testVinta1() {
		assertTrue(this.partita.vinta());
	}
	@Test
	public void testFinita1() {
		assertTrue(this.partita.isFinita());
	}

}
