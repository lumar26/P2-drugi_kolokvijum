package festivali;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ArhivaFestivala implements Arhiviranje {
	private List<MuzickiFestival> festivali = new ArrayList<MuzickiFestival>();

	public void upisiFestivaleUcesnika(String izvodjac, String filename) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));

		for (MuzickiFestival muzickiFestival : festivali) {
			if (izvodjac.equals(muzickiFestival.getPobednik()))
				out.writeObject(muzickiFestival);
		}

		out.close();
	}

	@Override
	public void ucitajFestivaleIzFajla(String filename) {
		String festival = "", naziv = "", mesto = "", pobednik = "";
		try (BufferedReader in = new BufferedReader(new FileReader(filename))) {
			while ((festival = in.readLine()) != null) {
				String[] pom = festival.split("#");
				naziv = pom[0];
				mesto = pom[1];
				pobednik = pom[2];
				festivali.add(new MuzickiFestival(naziv, mesto, pobednik));
			}
		} catch (Exception e) {
		}

	}

	@Override
	public void objediniArhive(List<String> fajlovi, String noviFajl) {
		MuzickiFestival pom = new MuzickiFestival("", "", "");
		List<MuzickiFestival> pomfestivali = new ArrayList<MuzickiFestival>();
		for (String string : fajlovi) {
			try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(string))) ){
				while((pom = (MuzickiFestival) in.readObject()) != null) {
					if (!jeUListi(pom)) {
						pomfestivali.add(pom);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		try(ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(noviFajl)))){
			for (MuzickiFestival muzickiFestival : pomfestivali) {
				out.writeObject(muzickiFestival);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public boolean jeUListi(MuzickiFestival fest) {
		for (MuzickiFestival muzickiFestival : festivali) {
			if (muzickiFestival.equals(fest))
				return true;
		}
		return false;
	}

}
