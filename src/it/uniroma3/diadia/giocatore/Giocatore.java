package it.uniroma3.diadia.giocatore;
import  it.uniroma3.diadia.attrezzi.*;


public class Giocatore {
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	Borsa borsa = new Borsa();
	
	
	public Giocatore() {
    	this.cfu = CFU_INIZIALI;
    }
    

    public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
    
	public boolean addBorsa(Attrezzo attrezzo) {
		boolean k = false;
		if(borsa.getPeso() <= borsa.getPesoMax() - attrezzo.getPeso()) {
			borsa.addAttrezzo(attrezzo);
            k= true;
	}
		 return k;
	}
	
	public Attrezzo posaAttrezzo(Attrezzo attrezzo) {
		return borsa.removeAttrezzo(attrezzo.getNome());
		
	}
    
	
    
}








