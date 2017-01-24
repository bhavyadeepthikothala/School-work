

/**
 *
 * @author Bhargava Raviteja Chanduri
 */
import java.rmi.*;



public class RaceListClient {

    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        RaceList aRaceList = null;
        try {
            aRaceList = (RaceList) Naming.lookup("rmi://localhost/RaceList");
            System.out.println("Found server");

            aRaceList.addRace(new RaceObject("New York Mini 10K", "NY", 2010, 10.0, 69.9, 7.3));

            aRaceList.addRace(new RaceObject("Chicago Marathon", "Chicago", 2011, 42.2, 240.3, 9.1));

            aRaceList.addRace(new RaceObject("New York Mini 10K", "NY", 2011, 10.0, 65.2, 8.0));

            aRaceList.addRace(new RaceObject("NYC Marathon", "NY", 2013, 42.2, 265.3, 7.9));

            aRaceList.addRace(new RaceObject("WIU Old Stompin' Ground Runaround", "Macomb", 2014, 5.0, 23, 8.5));

            aRaceList.addRace(new RaceObject("Chicago Marathon", "Chicago", 2014, 42.2, 260.0, 8.1));

            aRaceList.addRace(new RaceObject("WIU Fallen Soldiers 5K", "Macomb", 2015, 5.0, 24.0, 8.4));

            aRaceList.addRace(new RaceObject("New York Mini 10K", "NY", 2011, 10.0, 59.2, 6.9));

            System.out.println("Longest Race Name = " + aRaceList.longestRace());

            System.out.println("Best average personal satisfaction Race Name = " + aRaceList.satisfactionRace());

            System.out.println("Chicago Marathon race submissions = " + aRaceList.raceSubmissions("Chicago Marathon"));

            System.out.println("Total race submissions = " + aRaceList.getTotalRaces());

            System.out.println(aRaceList.printAllRaces());

           
        } catch (RemoteException e) {
            System.out.println("RaceListclient: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Lookup: " + e.getMessage());
        }
    }
}
