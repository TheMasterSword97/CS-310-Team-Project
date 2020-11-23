
package edu.jsu.mcis.tas_fa20;



import java.time.temporal.ChronoUnit;
import java.time.LocalTime;

public class Shift {
    private byte id;
    private LocalTime stop;
    private LocalTime start;
	private LocalTime lunchstart;
    private LocalTime lunchstop;
    private int interval;
    private long shiftduration;
	private long lunchduration;
	private byte interval;
    private byte gracePeriod;
    private byte dock;
    private String description;
		
    public Shift(int id, LocalTime stop, LocalTime start, LocalTime lunchstart, LocalTime lunchstop, int lunchdeduct, int graceperiod, int dock, int interval, long shiftduration, long lunchduration, String description){
        this.id = id;
        	this.start = start;
        	this.stop = stop;
		this.lunchstart = lunchstart;
       		this.lunchstop = lunchstop;
			this.lunchdeduct = lunchdeduct;
	this.graceperiod = graceperiod;
        this.dock = dock;
        this.interval = interval;
       this.shiftduration = shiftduration;
       this.lunchduration = lunchduration;
			this.description = description;
    }
    public Shift (Map<String, Byte> byteParams, Map <String, LocalTime> localTimeParams, short lunchDeduct, String description) {
        this(
                byteParams.get("id"),
			localTimeParams.get("start"),
                	localTimeParams.get("stop"),
			localTimeParams.get("lunchStart"),
                	localTimeParams.get("lunchStop"),
				lunchDeduct("lunchdeduct")
		byteParams.get("gracePeriod"),
                byteParams.get("dock"),
                byteParams.get("interval"),
                		description("description")
        );
    }
    public int getID(){
        return id;
    }
    public LocalTime getStart(){
        return start;
    }
    public LocalTime getStop(){
        return stop;
    }  
	public LocalTime getLunchStart(){
        return lunchstart;
    }   
    public LocalTime getLunchStop(){
        return lunchstop;
    }
	public int getLunchDeduct(){
        return lunchdeduct;
    }
    public int getGracePeriod(){
        return graceperiod;
    }   
    public int getDock(){
        return dock;
    }
    public int getInterval(){
        return interval;
    }  
    public long getLunchDuration(){
        return lunchduration;
    }
	public String getDescription(){
        return description;
    }
    public void setID(int id){
        this.id = id;
    }
	public void setStart(LocalTime start){
        this.start = start;
    }   
	public void setStop(LocalTime stop){
        this.stop = stop;
    }
    public void setLunchStart(LocalTime lunchstart){
        this.lunchstart = lunchstart;
    }   
    public void setLunchStop(LocalTime lunchstop){
        this.lunchstop = lunchstart;
    }
    public void setLunchDeduct(int lunchdeduct){
        this.lunchdeduct = lunchdeduct;
    }    
    public void setDescription(String description){
        this.description = description;
    }        
    public void setGracePeriod(int graceperiod){
        this.graceperiod = graceperiod;
    }   
    public void setDock(int dock){
        this.dock = dock;
    }
    public void setInterval(int interval){
        this.interval = interval;
    }
    public void setLunchDuration(){
        this.lunchduration = ChronoUnit.MINUTES.between(lunchstart, lunchstop);
    }
    public void setShiftDuration(){
        this.shiftduration = ChronoUnit.MINUTES.between(start, stop);
    }
    
    @Override
    public String toString(){
        StringBuilder shift = new StringBuilder();
        shift.append(description).append(": ").append(start).append(" - ").append(stop).append(" (").append(shiftduration).append(" minutes);");
        shift.append(description).append(" Lunch: ").append(lunchstart).append(" - ").append(lunchstop).append(" (").append(lunchduration).append(" minutes);");
        return (shift.toString());
    }
}