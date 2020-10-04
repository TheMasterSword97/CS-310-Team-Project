package edu.jsu.mcis.tas_fa20;

public class Badge {

private String description;
private String id;
    
    public Badge(String id, String description){
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getID(){
        return id;
    }
    
    @Override
    public String toString(){
        StringBuilder badge = new StringBuilder();
        
        badge.append("#").append(id).append(" ");
        badge.append("(").append(description).append(")");
        
        return(badge.toString());
    }
    
}
