package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.*;

/**
 * Questa classe crea un labirinto all'interno del gioco
 *
 * @author  Carmine Iengo
 * @see Stanza
 * @version base
 */

public class Labirinto {
	
	
		public Stanza stanzaVincente;
		public Stanza stanzaIngresso;
		 
		
		public Labirinto(){
			init();
		} 
		
		public void init() {
			Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);

		/* crea stanze del labirinto */
			Stanza atrio = new Stanza("Atrio");
			Stanza aulaN11 = new Stanza("Aula N11");
			Stanza aulaN10 = new Stanza("Aula N10");
			Stanza laboratorio = new Stanza("Laboratorio Campus");
			Stanza biblioteca = new Stanza("Biblioteca");

			/* collega le stanze */
			atrio.impostaStanzaAdiacente("nord", biblioteca);
			atrio.impostaStanzaAdiacente("est", aulaN11);
			atrio.impostaStanzaAdiacente("sud", aulaN10);
			atrio.impostaStanzaAdiacente("ovest", laboratorio);
			aulaN11.impostaStanzaAdiacente("est", laboratorio);
			aulaN11.impostaStanzaAdiacente("ovest", atrio);
			aulaN10.impostaStanzaAdiacente("nord", atrio);
			aulaN10.impostaStanzaAdiacente("est", aulaN11);
			aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
			laboratorio.impostaStanzaAdiacente("est", atrio);
			laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
			biblioteca.impostaStanzaAdiacente("sud", atrio);

			/* pone gli attrezzi nelle stanze */
			aulaN10.addAttrezzo(lanterna);
			atrio.addAttrezzo(osso);

			stanzaIngresso=atrio;
            stanzaVincente=biblioteca;
		}
		
		
		public static LabirintoBuilder newBuilder() {
			return new LabirintoBuilder();
		}
		
		  public void  setStanzaVincente(Stanza stanzaVincente) {
		    	this.stanzaVincente = stanzaVincente;
		    }
		  public void setStanzaCorrente(Stanza stanzaCorrente) {
				this.stanzaIngresso = stanzaCorrente;
			}
			public Stanza getStanzaVincente() {
				return this.stanzaVincente;
			}
			public Stanza getStanzaCorrente() {
				return this.stanzaIngresso;
			}
		
	}



