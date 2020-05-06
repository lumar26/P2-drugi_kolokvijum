package bend;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class RegistarBendova {
	private List<MuzickiBend> bendovi;

	public RegistarBendova(List<MuzickiBend> bendovi) {
		if (bendovi != null)
			this.bendovi = bendovi;
		else this.bendovi = new ArrayList<MuzickiBend>();
	}
	
	public void pronadjiBend(String nazivAlbuma) {
		try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("izvestaj.out")));){
			for (MuzickiBend muzickiBend : bendovi) {
				if(muzickiBend.sadrziAlbum(nazivAlbuma)) out.writeObject(muzickiBend);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public MuzickiBend vratiNajstarije() {
		double max = 0;
		MuzickiBend pom = new MuzickiBend();
		for (MuzickiBend muzickiBend : bendovi) {
			if(muzickiBend.prosekGodina() > max) {
				max = muzickiBend.prosekGodina();
				pom = muzickiBend;
			}
		}
		
		return pom;
	}
}
