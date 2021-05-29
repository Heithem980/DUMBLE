package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.GetTableData;



public class SQLconnection {
	
	public static Connection conn = null;
	public static PreparedStatement stmt = null;
	public static ResultSet rs = null;

	
	
	
	public static ArrayList<ArrayList<String>> stateSQL(String searchString) {
		
		
		try {

			// driver setup
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			// handle the error
			System.out.println("Exception Driver: " + ex.getMessage());
		}
		
		
		

		try {
		
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dumble_DB", "root", "");
		
		
			String requestQueryT1 = "SELECT * FROM `bearbase` WHERE `Character` LIKE ? OR `Origin` LIKE ? OR `Creator` LIKE ? OR `Notes` LIKE ?";
			String requestQueryT2 = "SELECT * FROM `ikea_names` WHERE `name` LIKE ? OR `description` LIKE ? OR `Column_3` LIKE ? OR `Column_4` LIKE ? OR `Column_5` LIKE ?";
			String requestQueryT3 = "SELECT * FROM `masterscplist` WHERE `SCP` LIKE ? OR `Title` LIKE ? OR `rating` LIKE ? OR `Classification` LIKE ? OR `Type` LIKE ? OR `Related_GOI_s` LIKE ? OR `Location_Notes` LIKE ? OR `Author` LIKE ? OR `Leaked_info` LIKE ? OR `Humanoid_or_Structure` LIKE ? OR `Animal_Computer_or_Extradimensional` LIKE ? OR `Autonomous_or_Cognitohazard` LIKE ? OR `Artifact_Location_or_Sentient` LIKE ? OR `Summary` LIKE ? OR `Gender` LIKE ? OR `None` LIKE ? OR `Ethnicity_Origins` LIKE ?";
		
			ArrayList<ArrayList<String>> allTables = new ArrayList<ArrayList<String>>();
			
			allTables.add(GetTableData.getTable(requestQueryT1, searchString, 4));
			allTables.add(GetTableData.getTable(requestQueryT2, searchString, 5));
			allTables.add(GetTableData.getTable(requestQueryT3, searchString, 17));
		
			
			//conn.close();
			return allTables;

		} catch (SQLException ex) {
		
				System.out.println("SQLException: " + ex.getMessage());
				System.out.println("SQLState: " + ex.getSQLState());
				System.out.println("VendorError: " + ex.getErrorCode());

			}
		return null;
	}
	
	
	
	
	
	

	
}
