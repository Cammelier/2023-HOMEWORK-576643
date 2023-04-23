import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

public class FabbricaDiComandiFisarmonicatest {
	Comando comandoAiuto;
	Comando comandoVai;
	Comando comandoPrendi;
	Comando comandoPosa;
	Comando comandoFine;
	Comando comandoGuarda;
	@Before
	public void setUp() throws Exception {
		comandoAiuto = new FabbricaDiComandiFisarmonica().costruisciComando("aiuto");
	    comandoVai = new FabbricaDiComandiFisarmonica().costruisciComando("vai sud");
		comandoPrendi = new FabbricaDiComandiFisarmonica().costruisciComando("prendi lanterna");
		comandoPosa = new FabbricaDiComandiFisarmonica().costruisciComando("posa osso");
		comandoFine = new FabbricaDiComandiFisarmonica().costruisciComando("fine");
		comandoGuarda = new FabbricaDiComandiFisarmonica().costruisciComando("guarda");
	}

	@After
	public void tearDown() throws Exception {
		comandoAiuto = null;
		comandoVai = null;
	    comandoPrendi = null;
	    comandoPosa = null;
	    comandoFine = null;
	    comandoGuarda = null;
	}

	@Test
	public void testcomandoAiuto() {
      assertEquals(comandoAiuto.getNome(),"aiuto");
	}
    
	public void testcomandoVai(){
		assertEquals(comandoVai.getNome(),"vai");
		assertEquals(comandoVai.getNome(),"sud");
	}
	
	public void testcomandoPrendi() {
		assertEquals(comandoPrendi.getNome(),"prendi");
		assertEquals(comandoPrendi.getParametro(),"lanterna");
	}
	
	public void testcomandoPosa() {
		assertEquals(comandoPosa.getNome(),"posa");
		assertEquals(comandoPosa.getParametro(),"osso");
	}
	
	public void testcomandoFine() {
		assertEquals(comandoFine.getNome(),"fine");
	}
	
	public void testcomandoGuarda() {
		assertEquals(comandoGuarda.getNome(),"guarda");
		
		
	}
}
