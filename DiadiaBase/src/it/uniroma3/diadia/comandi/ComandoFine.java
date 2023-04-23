package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

public class ComandoFine implements Comando {
	private IO io;
	@Override
	public void esegui(Partita partita) {
		io = new IOConsole();
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
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
		return "fine";
	}
}

