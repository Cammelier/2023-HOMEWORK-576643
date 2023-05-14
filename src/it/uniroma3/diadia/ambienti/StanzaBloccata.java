package it.uniroma3.diadia.ambienti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class StanzaBloccata extends Stanza{

	String nomeAttrezzo;
	String nomeDirezione;


	public StanzaBloccata(String nome, String direzioneBloccata, String nomeAttrezzoSblocco) {
		super(nome);
		this.nomeAttrezzo=nomeAttrezzoSblocco;
		this.nomeDirezione=direzioneBloccata;
		
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(!this.hasAttrezzo(nomeAttrezzo))
			return this;
		else
		return super.getStanzaAdiacente(direzione);
	}
 

	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(nomeAttrezzo))
			return "La direzione è bloccata";
		else return super.toString();
	}
}
