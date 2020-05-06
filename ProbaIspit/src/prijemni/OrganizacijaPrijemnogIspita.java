package prijemni;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import prijemni.izuzeci.PrijemniException;

public class OrganizacijaPrijemnogIspita {
	private List<PrijemniIspit> ustanove = new ArrayList<PrijemniIspit>();

	public void ucitajIzFajlaUListu(String filename) {
		try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)));) {
			PrijemniIspit pom = new PrijemniIspit();
			while ((pom = (PrijemniIspit) in.readObject()) != null) {
				if (pom.getBrojPrijavljenih() > 0)
					ustanove.add(pom);
			}
		} catch (IOException | ClassNotFoundException e) {
			throw new PrijemniException("Greska pri citanju iz fajla");
		}
	}

	public List<PrijemniIspit> vratiUspesnePrijemneIspite() {
		List<PrijemniIspit> uspesni = new ArrayList<PrijemniIspit>();
		for (PrijemniIspit prijemniIspit : ustanove) {
			if(viseU18NegoU17(prijemniIspit.getNazivUstanove())) uspesni.add(prijemniIspit);
		}
		
		return uspesni;
	}

	private boolean viseU18NegoU17(String nazivUstanove) {
		int trenutna = 0, prethodna = 0;
		for (PrijemniIspit prijemniIspit : ustanove) {
			if(prijemniIspit.getGodinaUpisa() == 2018 && prijemniIspit.getNazivUstanove().equals(nazivUstanove))
			   trenutna = prijemniIspit.getBrojPrijavljenih();
			
		}
		for (PrijemniIspit prijemniIspit1 : ustanove) {
			if(prijemniIspit1.getGodinaUpisa() == 2017 && prijemniIspit1.getNazivUstanove().equals(nazivUstanove))
			   prethodna = prijemniIspit1.getBrojPrijavljenih();
			
		}
		
		return trenutna>prethodna;
		
	}
}
