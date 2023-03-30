import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import it.uniroma3.diadia.ambienti.*;

public class LabirintoTest {

	private Labirinto labirinto;
	private Stanza Atrio;
	private Stanza Biblioteca;
	
	@Before
	public void setUp() throws Exception {
		this.labirinto = new Labirinto();
		this.Atrio = new Stanza("Atrio");
		this.Biblioteca = new Stanza("Biblioteca");
		labirinto.init();
	}

	@After
	public void tearDown() throws Exception {
		this.labirinto = null;
		this.Atrio = null;
		this.Biblioteca = null;
	}

	@Test
	
    public void testGetStanzaCorrente() {
    	assertEquals(this.labirinto.stanzaIngresso.getNome(),Atrio.getNome());
    }
	
	@Test
	
	public void testGetStanzaVincente() {
		assertEquals(this.labirinto.stanzaVincente.getNome(),Biblioteca.getNome());
	}
	
	
    
  
	
   
}
