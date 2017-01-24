


import java.io.Serializable;


/**
 * 
 * @author Bhargava Raviteja Chanduri
 */
public class Race  implements Serializable{
    
    private String name;
    private String location;
    private int year;
    private double distance;
    private double time;
    private double satisfaction;
    /**
     * Default Constructor
     */
    public Race() {
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
    public Race(String name, String location, int year, double distance, double time, double satisfaction) {
        this.name = name;
        this.location = location;
        this.year = year;
        this.distance = distance;
        this.time = time;
        this.satisfaction = satisfaction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(double satisfaction) {
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
