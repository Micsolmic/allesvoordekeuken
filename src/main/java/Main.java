import java.util.List;

import be.vdab.entities.Artikel;
import be.vdab.services.ArtikelService;

public class Main {

	public static void main(String[] args) {
		
		ArtikelService artService = new ArtikelService();
		List<Artikel> artList = artService.zoekAlle();
		for(Artikel art: artList) {
			
			System.out.println(art.getNaam());
			
		}

	}

}
