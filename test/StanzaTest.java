import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;

public class StanzaTest {
  private Stanza atrio;
	@Before
	public void setUp() throws Exception {
		this.atrio = new Stanza("atrio");
		Attrezzo prova = new Attrezzo("prova",3);
		atrio.addAttrezzo(prova);
	}

	@After
	public void tearDown() throws Exception {
		 this.atrio = null;
	    
	}

	@Test
	
	
	public void testStanzaaddAttrezzo1() {
		assertTrue(this.atrio.addAttrezzo(new Attrezzo("prova",0)));
		
	}
	
	public void testStanzaaddAttrezzo2() {
		assertTrue(this.atrio.addAttrezzo(new Attrezzo("prova1",4)));
	}
	
	public void testStanzaaddAttrezzo3() {
		assertTrue(this.atrio.addAttrezzo(new Attrezzo(" ",-2)));
	}
	
	public void testStanzahasAttrezzo1() {
		assertTrue(this.atrio.hasAttrezzo("prova"));
	}
	
	public void testStanzaHasAttrezzo2() {
		assertFalse(this.atrio.hasAttrezzo("prova1"));
		
	}
}

