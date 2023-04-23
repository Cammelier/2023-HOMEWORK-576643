package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.Comando;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;
public class ComandoGuarda implements Comando {
	private IO io;
	@Override
  public void esegui(Partita partita) {
      io = new IOConsole();
	  Stanza corrente = partita.getStanzaCorrente();
	  io.mostraMessaggio(corrente.getDescrizione());
	   if(!partita.isFinita())
		   io.mostraMessaggio("Partita ancora in corso");
  }
	@Override
	public void setParametro(String parametro) {
	}
	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getNome() {
		
		return "guarda";
	}
}
