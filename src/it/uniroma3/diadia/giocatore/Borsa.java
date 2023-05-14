package it.uniroma3.diadia.giocatore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.*;

/**
 * Questa classe crea una borsa associata ad un giocatore,nella quale 
 * vengono salvati gli oggetti presi dal giocatore.
 *
 * @author  Carmine Iengo
 * @see Stanza
 * @version base
 */

public class Borsa {

	public final static int DEFAULT_PESO_MAX_BORSA = 10; 
	private Map<String, Attrezzo> attrezzi;
	private int pesoMax;
	private int pesoAttuale;
	

	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA); 
		this.attrezzi = new HashMap<>();
		this.pesoAttuale=0;
	}

	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<>();
	}
    
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		this.attrezzi.put(attrezzo.getNome(),attrezzo);
		pesoAttuale += attrezzo.getPeso();
		return true;
	}

	public int getPesoMax() {
		return pesoMax;
	}

	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		
		return this.attrezzi.get(nomeAttrezzo);
	}

	public int getPeso() {
		return pesoAttuale;
  		
	}
	
	public boolean isEmpty() {
		return this.attrezzi.size() == 0;
	}
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
		
		}
	
	
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append("\n");
			s.append(this.getContenutoOrdinatoPerNome().toString());
			s.append("\n");
			s.append(this.getContenutoRaggruppatoPerPeso().toString());
			s.append("\n");
			s.append(this.getSortedSetOrdinatoPerPeso().toString());
		} else
		s.append("Borsa vuota");
		return s.toString();
	}
	
	
	/*List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> l = new ArrayList<>();
		l.addAll(this.attrezzi.values());
		Collections.sort(l, new ComparatoreAttrezziPerPeso());
		return l;
	}*/
	
	SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		TreeSet<Attrezzo> s = new TreeSet<>();
		s.addAll(this.attrezzi.values());
		return s;
	}
	
	Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> m = new TreeMap<>();
		for(Attrezzo a : this.attrezzi.values()) {
			if(m.containsKey(a.getPeso()))
				m.get(a.getPeso()).add(a);
		else {
			Set<Attrezzo> s = new HashSet<Attrezzo>();
			s.add(a);
			m.put(a.getPeso(), s);
		}
		}
		return m ;
	}
	
	SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		TreeSet <Attrezzo> t = new TreeSet(new ComparatoreAttrezziPerPeso());
		t.addAll(this.attrezzi.values());
		return t ;
		
	}
}


