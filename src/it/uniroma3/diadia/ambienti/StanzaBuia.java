package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza {
	private Attrezzo attrezzo;
	private IO io;
	private String nomeAttrezzoLuce;

	public StanzaBuia(String nome,String nomeAttrezzoLuce) {
		super(nome);
	    nomeAttrezzoLuce="lanterna"; 
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(nomeAttrezzoLuce))
		return super.toString(); 
		return "Qui c'è un buio pesto";
	}
}
