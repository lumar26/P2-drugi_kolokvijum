package festivali;

import java.io.Serializable;

import festivali.izuzeci.MuzickiFestivalException;

public class MuzickiFestival implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String naziv;
	private String mesto;
	private String pobednik;
	
	

	public MuzickiFestival(String naziv, String mesto, String pobednik) {
		super();
		this.naziv = naziv;
		this.mesto = mesto;
		this.pobednik = pobednik;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		if (naziv == null || naziv.equals(""))
			throw new MuzickiFestivalException("Naziv koji se unosi nije odgovarajuci");
		this.naziv = naziv;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		if (mesto == null || mesto.equals(""))
			throw new MuzickiFestivalException("Mesto koje se unosi nije odgovarajuce");
		this.mesto = mesto;
	}

	public String getPobednik() {
		return pobednik;
	}

	public void setPobednik(String pobednik) {
		if (pobednik == null || pobednik.equals(""))
			throw new MuzickiFestivalException("Uneseni pobednik nije odgovarajuci");
		this.pobednik = pobednik;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof MuzickiFestival))
			throw new MuzickiFestivalException("Objekat sa kojim se uporedjuje nije instanca Muzickog festivala");
		return ((MuzickiFestival) obj).getMesto().equals(this.mesto)
				&& ((MuzickiFestival) obj).getNaziv().equals(this.naziv)
				&& ((MuzickiFestival) obj).getPobednik().equals(this.pobednik);
	}
}
