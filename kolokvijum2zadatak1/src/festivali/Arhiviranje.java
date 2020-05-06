package festivali;

import java.util.List;

public interface Arhiviranje {
	public void ucitajFestivaleIzFajla(String filename);
	public void objediniArhive(List<String> fajlovi, String noviFajl);
}
