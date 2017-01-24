

/**
 *
 * @author Bhargava Raviteja Chanduri
 */
import java.rmi.*;
import java.io.*;


public class RaceListClient {

    public static void main(String args[]) {
    	
    	
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        RaceList aRaceList = null;
        try {
            aRaceList = (RaceList) Naming.lookup("rmi://uxb4.wiu.edu:1147/chanb1");
            System.out.println("Found server");
            
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            
            if(Integer.parseInt(args[0]) == 1)
            {
            	System.out.println("enter the name of race:");
            	String racename = br.readLine();
            	
            	System.out.println("enter the location of race:");
            	String location = br.readLine();
            	
            	System.out.println("enter the year of race:");
            	int year = Integer.parseInt(br.readLine());
            	
            	System.out.println("enter the distance of race:");
            	Double distance = Double.parseDouble(br.readLine());
            	
            	System.out.println("enter the time:");
            	Double time = Double.parseDouble(br.readLine());
            	
            	System.out.println("enter the personal satisfaction of race:");
            	Double satisfaction = Double.parseDouble(br.readLine());
            		
            	aRaceList.addRace(new RaceObject(racename,location,year,distance,time,satisfaction));

            }

            if(Integer.parseInt(args[0]) == 2)
            {
            	//System.out.println(aRaceList.printAllRaces());
            	
            	System.out.println("Name of race for the longest = " + aRaceList.longRun());

            	System.out.println("Most frequently run race = " + aRaceList.mostRun());
            	
                System.out.println("Race name with Best average personal satisfaction = " + aRaceList.satisfiedRace());

                System.out.println("No. of Chicago Marathon race submissions = " + aRaceList.racesSubmitted("Chicago Marathon"));

                System.out.println("Total no. of race submissions = " + aRaceList.totalRaces());
                
                System.out.println("the Distinct races are : " +  aRaceList.printAllRaces() );
                

            }
            
           
        } catch (RemoteException e) {
            System.out.println("RaceListclient: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lookup: " + e.getMessage());
        }
    }
}
