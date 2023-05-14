package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
    String nomeAttrezzo;
   @Override
	public void esegui (Partita partita) {
		Attrezzo attrezzo = partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
		partita.getGiocatore().addBorsa(attrezzo);
		partita.getStanzaCorrente().removeAttrezzo(attrezzo);
	   
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getParametro() {
		
		return this.nomeAttrezzo;
	}

	@Override
	public String getNome() {
		
		return "prendi";
	}
}
