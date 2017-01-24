/**
 *
 * @author Bhargava Raviteja Chanduri
 */
import java.rmi.*;
import java.util.Vector;

public class RMIClient {

    public static void main(String args[]) {

        try {
            System.setSecurityManager(new RMISecurityManager());
            RaceRemoteInterface raceRemoteInterface = (RaceRemoteInterface) Naming.lookup("rmi://localhost/RaceRemoteInterface");
            System.out.println("Found RMI Server");
            
            Race raceObj = new Race("New York Mini 10K", "NY", 2010, 10.0, 69.9, 7.3);
            raceRemoteInterface.addRace(raceObj);

            raceObj = new Race("Chicago Marathon", "Chicago", 2011, 42.2, 240.3, 9.1);
            raceRemoteInterface.addRace(raceObj);
            
            raceObj = new Race("New York Mini 10K", "NY", 2011, 10.0, 65.2, 8.0);
            raceRemoteInterface.addRace(raceObj);

            raceObj = new Race("NYC Marathon", "NY", 2013, 42.2, 265.3, 7.9);
            raceRemoteInterface.addRace(raceObj);
            
            raceObj = new Race("WIU Old Stompin' Ground Runaround", "Macomb", 2014, 5.0, 23, 8.5);
            raceRemoteInterface.addRace(raceObj);
            
            raceObj = new Race("Chicago Marathon", "Chicago", 2014, 42.2, 260.0, 8.1);
            raceRemoteInterface.addRace(raceObj);
            
            raceObj = new Race("WIU Fallen Soldiers 5K", "Macomb", 2015, 5.0, 24.0, 8.4);
            raceRemoteInterface.addRace(raceObj);
            
            raceObj = new Race("New York Mini 10K", "NY", 2011, 10.0, 59.2, 6.9);
            raceRemoteInterface.addRace(raceObj);

            Vector races = raceRemoteInterface.getAllRaces();

            ///////////////////////////////////////// Longest Race
            System.out.println("======== Longest Race Name ======== ");
            String name = "";
            double distance = 0;
            for (Object race : races) {
                Race raceObject = (Race) race;
                if (raceObject.getDistance() > distance) {
                    distance = raceObject.getDistance();
                    name = raceObject.getName();
                }
            }
            System.out.println(name);

            ///////////////////////////////////////// Best average personal satisfaction Race Name
            System.out.println("======== Best average personal satisfaction Race Name ======== ");

            double satisfaction = 0;
            for (Object race : races) {
                Race raceObject = (Race) race;
                if (raceObject.getSatisfaction() > satisfaction) {
                    satisfaction = raceObject.getDistance();
                    name = raceObject.getName();
                }
            }
            System.out.println(name);

            ///////////////////////////////////////// Race Submissions for Race Name
            System.out.println("======== Race Submissions for Chicago Marathon Race ======== ");
            int count = 0;
            for (Object race : races) {
                Race raceObject = (Race) race;
                if (raceObject.getName().equalsIgnoreCase("Chicago Marathon")) {
                    count = count + 1;
                }
            }
            System.out.println("Total Submissions: " + count);

            ///////////////////////////////////////// Total Submissions
            System.out.println("======== Total Race Submissions  ======== ");

            System.out.println("Total Race Submissions = " + races.size());

            ///////////////////////////////////////// Print Race Details
            System.out.println("======== Print Race Details ======== ");

            for (Object race : races) {
                Race raceObject = (Race) race;
                System.out.println(raceObject.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
