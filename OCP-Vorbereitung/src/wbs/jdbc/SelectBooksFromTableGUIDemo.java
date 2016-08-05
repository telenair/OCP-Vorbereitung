package wbs.jdbc;

import java.sql.Connection;
import javax.swing.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectBooksFromTableGUIDemo {
	
	private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Buchdatenbank");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
//        JLabel label = new JLabel("Buch suchen:");
//        frame.getContentPane().add(label);

//        JDesktopPane deskPane = new JDesktopPane();
//        frame.add(deskPane);
        
        
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        
        JMenuItem suchen = new JMenuItem("Buch suchen");
        menu.add(suchen);
        
        JSeparator sep = new JSeparator();
        menu.add(sep);
        
        JMenuItem eingeben = new JMenuItem("Buch eintragen");
        menu.add(eingeben);
        
        JSeparator sep1 = new JSeparator();
        menu.add(sep1);
        
        JMenuItem delete = new JMenuItem("Buch löschen");
        menu.add(delete);
        
        bar.add(menu);
        frame.setJMenuBar(bar);
         
        //Display the window.
        frame.pack();
        frame.setVisible(true);
        frame.setSize(400, 400);
    }

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		String query = "select ISBN, TITEL, AUTOR, PREIS from buch";
		Statement stmt = null;
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
		            public void run() {
		                createAndShowGUI();
		            }
		        });		
		
		//*****************************************
		
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			stmt = conn.createStatement();	
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String isbn = rs.getString("ISBN");
				String titel = rs.getString("TITEL");
				String autor = rs.getString("AUTOR");
				double preis = rs.getDouble("PREIS");
				System.out.println(isbn + ";" + titel + ";" + autor + ";"
						+ preis);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
	}
}
