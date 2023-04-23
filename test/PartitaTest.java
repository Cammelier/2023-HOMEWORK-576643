import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.Stanza;

public class PartitaTest {
	private Partita partita;
	
    
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
	}

	@After
	public void tearDown() throws Exception {
		this.partita = null;
	}

	@Test
	public void testVinta1() {
		assertFalse(this.partita.vinta());
	}
	
	public void testFinita1() {
		assertFalse(this.partita.isFinita());
	}

}
