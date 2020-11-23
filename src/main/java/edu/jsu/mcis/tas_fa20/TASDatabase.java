package edu.jsu.mcis.tas_fa20;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;

public class TASDatabase {
    public TASDatabase(){
        Connection conn = null;
        PreparedStatement pstUpdate = null;
        PreparedStatement pstSelect = null,	
        ResultSet resultset = null;
        ResultSetMetaData metadata = null;

        String query;
        boolean hasresults;
        int resultCount, columnCount = 0;   
        try {
            String username = "tasuser";
            String password = "Password123#@!";
			String server = ("jdbc:mysql://localhost/tas");
            System.out.println("Connecting to " + server);
            conn = DriverManager.getConnection(server, username, password);
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			
            if (conn.isValid(0)) {
                System.out.println("Connected!");
            }
			
        }catch (Exception z) {
            System.err.println(z.toString());
        } 
    }
	
	public int insertPunch(Punch p)
    {
        try {
            
            query = "INSERT INTO punch (originaltimestamp,terminalid,punchtypeid,badgeid) VALUES(?, ?, FROM_UNIXTIME(?/1000), ?)";
            pstUpdate = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstUpdate.setShort(1, util.UnsignedByteHandler.getAsShort(p.getTerminalID()));
	    pstUpdate.setShort(2, util.UnsignedByteHandler.getAsShort(p.getPunchTypeID()));
            pstUpdate.setLong(3, p.getOriginalTimeStamp());
            pstUpdate.setString(4, p.getBadgeID());         
            pstUpdate.execute();  
		
            resultSet = pstUpdate.getGeneratedKeys();       
            if (resultSet.next()) {
                int rs = resultSet.getInt(1);
                return rs;               
            }          
            else throw new Exception(
                    "Failed To Insert: \n" + p.printOriginalTimestamp()
            );                    
        } catch (Exception e) {
            System.err.println(e.toString());
        }       
        return 0;        
    }
}

