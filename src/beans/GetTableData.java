package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.SQLconnection;

public class GetTableData {
	
	public static Connection conn = SQLconnection.conn;
	public static PreparedStatement stmt = SQLconnection.stmt;
	public static ResultSet rs = SQLconnection.rs;
	
	
public static ArrayList<String> getTable (String query, String searchString, int columns) {
		
		
		
		ArrayList<String> table = new ArrayList<String>();
		
		
		 try {
			 PreparedStatement stmt  = conn.prepareStatement(query);
			
			for(int i = 1; i <= columns; i++) {
				
				
				stmt.setString(i, "%" + searchString + "%");
				
			}
			
			ResultSet rs = stmt.executeQuery();
			
			String row = "";
			
			
			while (rs.next()) {
				
				for(int i = 1; i <= columns; i++) {
					
					if(!(rs.getString(i) == null)) {
						row += rs.getString(i)+ " / ";

					}
					
					
				}
				
				
				
				
				table.add(row);
				
			    row = "";
			    
			 } rs.close();
			 
			 
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
			
			
			return table;
		
	}
	
	
	
	


}
