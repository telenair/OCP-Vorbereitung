package wbs.jdbc.dao;

import java.util.List;

public class BuchDAODemo {

	public static void main(String[] args) {
		/*
		 * wir testen die beiden Methoden
		 */
		IBuchDAO buchDAO=DAOFactory.getBuchDAO();
		Buch buch = new Buch();
		buch.setIsbn("978-3938484210");
		buch.setAutor("Friedrich Nietsche");
		buch.setTitel("Also sprach Zar");
		buch.setPreis(25.78);
		
		try {
			buchDAO.save(buch);
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		List<Buch> buecher=buchDAO.findAll();
		for(Buch b:buecher){
			System.out.println(b);
		}
		
		
	}

}
