package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;



public class ComandoAiuto implements Comando {
	private IO io;
	
	
	@Override
	public  void esegui(Partita partita) {
		io = new IOConsole();
		for(int i=0; i<DiaDia.elencoComandi.length; i++) 
			io.mostraMessaggio(DiaDia.elencoComandi[i]+" ");
		io.mostraMessaggio(" ");
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
		return "aiuto";
	}
}