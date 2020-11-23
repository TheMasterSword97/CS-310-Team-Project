package edu.jsu.mcis.tas_fa20;

import java.util.*;
import java.test.SimpleDateFormat;


public class Punch {
    private int id;
    private byte terminalID;
    private String badgeID;
    private Long originalTimeStamp;
    private byte punchTypeID;
    
    private String punchTypeTitle;
    
    private String timeStampString;
    private static final SimpleDateFormat timeStampFormat = new SimpleDateFormat("EEE MM/dd/yyyy HH:mm:ss");
    
    private String adjustmentType;
    
  public Punch(String badgeID, Map<String, Byte> byteParams) {
        this(
                0,
                byteParams.get("terminalID"),
                badgeID,
                null,
                byteParams.get("punchTypeID")
        );
    } 
     private Punch(int id, byte terminalID, String badgeID, Long originalTimeStamp, byte punchTypeID) {
        this.id = id;
        this.terminalID = terminalID;
        this.badgeID = badgeID;
        this.originalTimeStamp = originalTimeStamp;
        this.punchTypeID = punchTypeID;
        
        buildPunchTypeTitle();
        
        buildTimeStampString();
        
        adjustmentType = null;
    }
    public int getID(){
        return id;
    }
    
    public int getTerminalID(){
        return terminalID;
    }
    
    public String getBadgeID(){
        return badgeID;
    }
    
    public Long getOriginalTimeStamp(){
        return originalTimeStamp;
    }
    
    public int getPunchTypeID(){
        return punchTypeID;
    }
    
    public String getAdjustmentType(){
        return adjustmentType;
    }
    
    private void buildPunchTypeTitle() {
        
        switch(punchTypeID) {
            
            case 0:
                punchTypeTitle = "CLOCKED OUT";
                break;
                
            case 1:
                punchTypeTitle = "CLOCKED IN";
                break;
                
            case 2:
                punchTypeTitle = "TIMED OUT";
                break;
                
        }
        
    }
    
    private void buildTimeStampString() {
        timeStampString = (timeStampFormat.format(new Date(originalTimeStamp))).toUpperCase();
    }
    
    public String printOriginalTimestamp() {
        StringBuilder punch = new StringBuilder();
        
        punch.append('#').append(badgeID).append(' ').append(punchTypeTitle);
        punch.append(": ").append(timeStampString);
        return (punch.toString());
    }
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

