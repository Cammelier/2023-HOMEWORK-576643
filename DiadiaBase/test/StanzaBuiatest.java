import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuiatest {

	private StanzaBuia camera;
	private Attrezzo lanterna;
	private Attrezzo osso;


	@Before
	public void setUp() throws Exception {
	  camera = new StanzaBuia("camera", "lanterna");
	  lanterna = new Attrezzo("lanterna",1);
	  osso = new Attrezzo("osso",1);
	  camera.addAttrezzo(osso);
	  
	}

	@After
	public void tearDown() throws Exception {
		this.camera = null;
		this.lanterna = null;
	}
	

	@Test
	public void test() {
		System.out.println(this.camera.getDescrizione());
	}

}
