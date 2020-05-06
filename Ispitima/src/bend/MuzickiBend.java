package bend;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import bend.muzicari.Muzicar;

public class MuzickiBend implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String naziv;
	private List<Muzicar> clanovi;
	private boolean aktivan;
	private List<String> naziviAlbuma;

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv == null || naziv.length() < 2)
			throw new RuntimeException();
		this.naziv = naziv;
	}

	public List<Muzicar> getClanovi() {
		return clanovi;
	}

	public void setClanovi(List<Muzicar> clanovi) {
		if (clanovi == null || clanovi.isEmpty())
			throw new RuntimeException();
		this.clanovi = clanovi;
	}

	public boolean isAktivan() {
		return aktivan;
	}

	public void setAktivan(boolean aktivan) {
		this.aktivan = aktivan;
	}

	public List<String> getNaziviAlbuma() {
		return naziviAlbuma;
	}

	public void setNaziviAlbuma(List<String> naziviAlbuma) {
		if (naziviAlbuma == null || naziviAlbuma.isEmpty())
			throw new RuntimeException();
		this.naziviAlbuma = naziviAlbuma;
	}

	public boolean sadrziAlbum(String album) {
		for (String a : naziviAlbuma) {
			if (a.equals(album))
				return true;
		}
		return false;
	}

	public double prosekGodina() {
		double sum = 0, brojac = 0;
		for (Muzicar muzicar : clanovi) {
			sum += muzicar.getDatumRodjenja().get(Calendar.YEAR);
			brojac++;
		}
		return sum/brojac;
	}

}
