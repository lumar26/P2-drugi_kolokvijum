package prijemni;

import prijemni.izuzeci.PrijemniException;

public class PrijemniIspit {

	private String nazivUstanove;
	private int godinaUpisa;
	private int brojMesta;
	private int brojPrijavljenih;
	
	public String getNazivUstanove() {
		return nazivUstanove;
	}
	public void setNazivUstanove(String nazivUstanove) {
		if (nazivUstanove == null || nazivUstanove.length() < 5) throw new PrijemniException("greska");
		this.nazivUstanove = nazivUstanove;
	}
	public int getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(int godinaUpisa) {
		if (godinaUpisa <= 0) throw new PrijemniException("greska");
		this.godinaUpisa = godinaUpisa;
	}
	public int getBrojMesta() {
		return brojMesta;
	}
	public void setBrojMesta(int brojMesta) {
		if (brojMesta <= 0) throw new PrijemniException("greska");
		this.brojMesta = brojMesta;
	}
	public int getBrojPrijavljenih() {
		return brojPrijavljenih;
	}
	public void setBrojPrijavljenih(int brojPrijavljenih) {
		if (brojPrijavljenih <= 0) throw new PrijemniException("greska");
		this.brojPrijavljenih = brojPrijavljenih;
	}
	
	@Override
	public String toString() {
		
		return "NAziv ustanoce: " + this.nazivUstanove + "; godina: " + godinaUpisa + "; broj mesta: " + this.brojMesta + "; broj prijavljenih: " 
				+"; relativni djavo: " + brojMesta/brojPrijavljenih;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof PrijemniIspit)) return false;
		return ((PrijemniIspit)obj).getNazivUstanove().equals(this.nazivUstanove) && 
				((PrijemniIspit)obj).getBrojMesta() == brojMesta && ((PrijemniIspit)obj).getBrojPrijavljenih() == this.brojPrijavljenih;
	}
	
}
