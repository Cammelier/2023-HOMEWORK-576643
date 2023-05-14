import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPrenditest {
  private Attrezzo attrezzo;
  private Partita partita;
  private ComandoPosa comando;
  private Labirinto labirinto;
  
	@Before
	public void setUp() throws Exception {
	this.labirinto= new Labirinto();
	this.partita=new Partita(labirinto);
	 comando = new ComandoPosa();
	 attrezzo = new Attrezzo("attrezzo",2); 
	 this.partita.getGiocatore().addBorsa(attrezzo);
		
	}

	@After
	public void tearDown() throws Exception {
       this.attrezzo = null;
       this.partita= null;
	}

	@Test
	public void test() {
	this.comando.esegui(this.partita);
	}
	
	}
