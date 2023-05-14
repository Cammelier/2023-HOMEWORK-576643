import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.*;

public class BorsaTest {
 private Borsa borsa;
 private Attrezzo attrezzo;
	@Before
	public void setUp() throws Exception {
	   this.borsa = new Borsa();
	   this.attrezzo = new Attrezzo("attrezzo",1);
	  
	}

	@After
	public void tearDown() throws Exception {
		this.borsa = null;
		this.attrezzo = null;
	}

	@Test
	
	public void testBorsaddAttrezzo1() {
		assertTrue(borsa.addAttrezzo(new Attrezzo("prova",4)));
	}
	@Test
	public void testBorsaaddAttrezzo2() {
		assertFalse(borsa.addAttrezzo(new Attrezzo("prova",12)));
	}
	@Test
	public void testBorsaaddAttrezzo3() {
		assertTrue(borsa.addAttrezzo(new Attrezzo(" ",-2)));
	}
	@Test
	public void testBorsaremoveAttrezzo1() {
		this.borsa.addAttrezzo(attrezzo);
		assertEquals(this.borsa.removeAttrezzo(attrezzo.toString()),null);
	}
	@Test
	public void testBorsaremoveAttrezzo2() {
		assertEquals(this.borsa.removeAttrezzo(new Attrezzo ("prova",0).getNome()),null);
	}
	
	

}
