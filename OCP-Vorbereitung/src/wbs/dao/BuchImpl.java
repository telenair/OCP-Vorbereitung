package wbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuchImpl implements IBuchDAO {
	String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
	String user = "root";
	String password = "";
	
	@Override
	public void save(Buch buch) throws PersistenceException {
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			PreparedStatement pstmt = conn.prepareStatement("insert into buch (ISBN, TITEL, AUTOR, PREIS) VALUES (?,?,?,?)");
			
			pstmt.setString(1, buch.getIsbn());
			pstmt.setString(2, buch.getTitel());
			pstmt.setString(3, buch.getAutor());
			pstmt.setDouble(4, buch.getPreis());
			try {
				pstmt.execute();
			} catch (SQLException e) {
				throw new PersistenceException("Fehler beim Insert..");
			}
			
		} catch(SQLException e){
			throw new PersistenceException("Fehler beim Verbinden..");
		}

		// TODO Auto-generated method stub

	}

	@Override
	public List<Buch> findAll() throws PersistenceException {
		List<Buch> result=new ArrayList<>(); 
		Object[] eintrag = new Object[4];
		
		try (Connection conn = DriverManager.getConnection(url, user, password)){
			Statement stmt = conn.createStatement();	
			ResultSet rs = stmt.executeQuery("Select * from Buch");
			while (rs.next()) {
				Buch b= new Buch();
				b.setIsbn(rs.getString("ISBN"));
				b.setTitel( rs.getString("TITEL"));
				b.setAutor(rs.getString("AUTOR"));
				b.setPreis(rs.getDouble("PREIS"));
				result.add(b);
			}
		} catch(SQLException e){
			throw new PersistenceException("Fehler beim Lesen..");
		}
		return result;
	}

}
