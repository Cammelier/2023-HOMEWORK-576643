package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.IOConsole;

public class ComandoNonValido implements Comando {
	IO io;
	@Override
	public void esegui(Partita partita) {
		io = new IOConsole();
		io.mostraMessaggio("Comando sconosciuto");
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
		
		return null;
	}


}
