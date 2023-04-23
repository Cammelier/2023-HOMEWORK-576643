package it.uniroma3.diadia.ambienti;

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
		if(this.hasAttrezzo(nomeAttrezzo)) {
			Stanza stanza = null;
			for(int i=0; i<this.numeroStanzeAdiacenti; i++)
				if (this.direzioni[i].equals(direzione))
					stanza = this.stanzeAdiacenti[i];
			return stanza;
		}
		else return this;
	}


	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(nomeAttrezzo))
			return "La direzione è bloccata";
		else return super.toString();
	}
}
