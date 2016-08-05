package wbs.jdbc.dao;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DAOFactory {
	
	public static IBuchDAO getBuchDAO() throws PersistenceException{
		
		return new BuchImpl();
	}
}
