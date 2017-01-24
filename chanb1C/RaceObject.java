


import java.io.Serializable;


/**
 * 
 * @author Bhargava Raviteja Chanduri
 */
public class RaceObject  implements Serializable{
    
    public String name;
    public String location;
    public int year;
    public double distance;
    public double time;
    public double satisfaction;
    /**
     * Default Constructor
     */
    public RaceObject() {
    }
    /**
     * 
     * @param name
     * @param location
     * @param year
     * @param distance
     * @param time
     * @param satisfaction 
     */
    public RaceObject(String name, String location, int year, double distance, double time, double satisfaction) {
        this.name = name;
        this.location = location;
        this.year = year;
        this.distance = distance;
        this.time = time;
        this.satisfaction = satisfaction;
    }
    
    /**
     * This method will print the race data
     */
     public String toString(){
         return "Name = "+name+" "
                 + "Location = "+location+" "
                 + "Year = "+year+" "
                 + "Distance = "+distance+" "
                 + "Time Taken = "+ time+" "
                 + "Personal Satisfaction = "+ satisfaction;
     }
}
