package wbs.jdbc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/* 
 * wir bestücken unsere buch-tabelle mit einigen büchern.
 * wir verwenden dazu ein PreparedStatement.
 * die bücher lesen wir aus einer geeigneten csv-datei ein.
 */
public class InsertBooksIntoTableDemo {

	public static void main(String[] args) throws IOException {

		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";

		String path = "resources/sql/insertBooks.sql";
		String sql = new String(Files.readAllBytes(Paths.get(path)));

		String pathBooks = "resources/sql/books.txt";
		File file = new File(pathBooks);
		String token;
		int count = 0;
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// einlesen der csv-datei
			try (Scanner scanner = new Scanner(file)) {
				scanner.useDelimiter("[;\n]");
				while (scanner.hasNext()) {
					token = scanner.next();
					if (token.length() != 0) {
						count++;
						if (count < 4) {
							pstmt.setString(count, token);
						}else{
							pstmt.setDouble(4, Double.parseDouble(token));
							// ausführen
							pstmt.execute();
							count = 0;
						}
					}
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}
