 package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto labirinto;
	private Stanza lastAdded;
    private Map<String,Stanza> nome1stanza;
    
	public LabirintoBuilder() {
		this.labirinto = new Labirinto();
		this.nome1stanza = new HashMap<String,Stanza>(); 
	}
	
	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		Stanza i = new Stanza(nomeStanza);
		this.labirinto.setStanzaCorrente(i);
		this.ultimaStanzaAggiunta(i);
		return this;
	}
	
	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		Stanza v = new Stanza(nomeStanza); 
		this.labirinto.setStanzaVincente(v);
		this.ultimaStanzaAggiunta(v);
		return this;
	}
	
	public LabirintoBuilder addAdiacenza(String nomeStanza1, String nomeStanza2, String direzione) {
		nome1stanza.get(nomeStanza1).impostaStanzaAdiacente(direzione,nome1stanza.get(nomeStanza2));
		return this;
	}
	
	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Attrezzo a = new Attrezzo(attrezzo, peso);
		if(this.lastAdded==null)
			return this;
		this.lastAdded.addAttrezzo(a);
		return this;
	}
	
	public LabirintoBuilder addStanza(String nomeStanza) {
		Stanza s = new Stanza(nomeStanza);
		this.ultimaStanzaAggiunta(s);
		return this;
		
	}
	
	public Labirinto getLabirinto() {
		return  this.labirinto;
	}
	
	public LabirintoBuilder ultimaStanzaAggiunta(Stanza last) {
		this.lastAdded = last;
		this.nome1stanza.put(last.getNome(), last);
		return this;
	}
	
	public LabirintoBuilder addStanzaBuia(String nomeStanza,String attrezzoPerVedere) {
		Stanza b = new StanzaBuia(nomeStanza,attrezzoPerVedere);
		this.ultimaStanzaAggiunta(b);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nomeStanza, String direzione,String attrezzoPerSblocco) {
		Stanza b = new StanzaBloccata(nomeStanza,direzione,attrezzoPerSblocco);
		this.ultimaStanzaAggiunta(b);
		return this;
	}
	
	public LabirintoBuilder addStanzaMagica(String nomeStanza, int soglia) {
		Stanza m = new StanzaMagica(nomeStanza,soglia);
		this.ultimaStanzaAggiunta(m);
		return this;
	}
	
	Map<String,Stanza> getListaStanze(){
		HashMap<String,Stanza> s = new HashMap<String,Stanza>();
		s.putAll(nome1stanza);
		return s;
		
	}
	

	
	

}
