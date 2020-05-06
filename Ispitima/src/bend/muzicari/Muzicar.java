package bend.muzicari;

import java.io.Serializable;
import java.util.GregorianCalendar;

public class Muzicar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String imePrezime;
	private String uloga;
	private GregorianCalendar datumRodjenja;

	public String getImePrezime() {
		return imePrezime;
	}

	public void setImePrezime(String imePrezime) {
		if (imePrezime == null || imePrezime.length() < 3)
			throw new RuntimeException();
		this.imePrezime = imePrezime;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		if (uloga == null || uloga.length() < 3)
			throw new RuntimeException();
		this.uloga = uloga;
	}

	public GregorianCalendar getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(GregorianCalendar datumRodjenja) {
		if (datumRodjenja.before(new GregorianCalendar()) && datumRodjenja == null
				&& datumRodjenja.after(new GregorianCalendar(1800, 1, 1)))
			this.datumRodjenja = datumRodjenja;
		else
			throw new RuntimeException();
	}
	
	@Override
	public String toString() {
		
		return "Ime: " + imePrezime + "; uloga: " + uloga + "; datum rodjenja: " + datumRodjenja;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Muzicar)) return false;
		return ((Muzicar)obj).getImePrezime().equals(this.imePrezime);
	}

}
