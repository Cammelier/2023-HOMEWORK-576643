import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoBuildertest {
	private LabirintoBuilder labirintoBuilder;
	private String nomeStanzaIniziale = "atrio";
	private String nomeStanzaVincente = "uscita";
	
	@Before
	public void setUp() throws Exception {
		 labirintoBuilder = new LabirintoBuilder();
		 
		 
	}

	@After
	public void tearDown() throws Exception {
		this.labirintoBuilder = null;
	}

	@Test
	public void test1() {
		Labirinto primo = labirintoBuilder
				.addStanzaIniziale(nomeStanzaIniziale)
				.addStanzaVincente(nomeStanzaVincente)
				.getLabirinto();
		assertEquals(nomeStanzaIniziale,primo.getStanzaCorrente().getNome());
		assertEquals(nomeStanzaVincente,primo.getStanzaVincente().getNome());
	}
	
	@Test
	public void test2() {
		Labirinto secondo = labirintoBuilder
				.addStanzaIniziale(nomeStanzaIniziale).addAttrezzo("attrezzo", 2)
				.getLabirinto();
		assertTrue(secondo.getStanzaCorrente().hasAttrezzo("attrezzo"));		
	}
	
	@Test
	public void testStanzaBloccata() {
		Labirinto bloccato = labirintoBuilder
				            .addStanzaIniziale(nomeStanzaIniziale)
				            .addStanzaBloccata(nomeStanzaVincente, "nord", "attrezzo")
				            .addAdiacenza(nomeStanzaIniziale, nomeStanzaVincente, "sud")
				            .addAdiacenza(nomeStanzaVincente, nomeStanzaIniziale, "nord")
				            .getLabirinto();
	   assertEquals("La direzione è bloccata",bloccato.getStanzaCorrente().getStanzaAdiacente("sud").getDescrizione());
	}
	
	@Test
	public void testStanzaMagica() {
		Labirinto magica = labirintoBuilder
				.addStanza(nomeStanzaIniziale)
				.addStanzaMagica(nomeStanzaVincente, 2).addAttrezzo("prova", 1)
				.addAdiacenza(nomeStanzaIniziale, nomeStanzaVincente, "sud")
				.addAdiacenza(nomeStanzaVincente, nomeStanzaIniziale, "nord")
				.getLabirinto();
		
       assertFalse(magica.getStanzaCorrente().getStanzaAdiacente("sud").getAttrezzi().containsKey("avrop"));
	}
	
	@Test
	public void testStanzaBuia() {
		Labirinto buio = labirintoBuilder
				.addStanzaIniziale(nomeStanzaIniziale)
				.addStanzaBuia(nomeStanzaVincente, "lampada").addAttrezzo("lampada", 2)
				.addAdiacenza(nomeStanzaIniziale, nomeStanzaVincente, "sud")
				.getLabirinto();
		assertNotEquals("Qui c'è buio pesto",buio.getStanzaCorrente().getStanzaAdiacente("sud").getDescrizione());
	}
	
	@Test
	public void testAttrezzoAggiuntoPerUltimo() {
		
	}
}
