import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.*;

public class GiocatoreTest {
 private Giocatore giocatore;
 private Attrezzo attrezzo;
 
	@Before
	public void setUp() throws Exception {
		this.giocatore = new Giocatore();
		this.attrezzo = new Attrezzo("attrezzo",1);
		
		
	}

	@After
	public void tearDown() throws Exception {
		this.giocatore = null;
		this.attrezzo = null;
	}

	@Test
	public void testGiocatoreaddBorsa1() {
		assertTrue(this.giocatore.addBorsa(new Attrezzo ("attrezzo",1)));
	}
	@Test
	public void testGiocatoreaddBorsa2() {
		assertFalse(this.giocatore.addBorsa(new Attrezzo("prova",11)));
	}
	@Test
	public void testPosaAttrezzo() {
		assertEquals(this.giocatore.posaAttrezzo(attrezzo),null);
	}
	
	

}
