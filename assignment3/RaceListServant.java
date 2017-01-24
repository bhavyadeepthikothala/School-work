
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * @author Emmanuel Ikonne
 */
public class RaceListServant implements RaceList {

    private Vector raceList;
    /**
     * 
     * @throws RemoteException 
     */
    public RaceListServant() throws RemoteException {
        raceList = new Vector();
    }
    /**
     * 
     * @param raceObject
     * @throws RemoteException 
     */
    @Override
    public void addRace(RaceObject raceObject) throws RemoteException {
        Race race = new RaceServant(raceObject);
        raceList.addElement(race);
    }

    @Override
    public String printAllRaces() throws RemoteException {
        String races = "";
        for (Object raceList1 : raceList) {
            Race race = (RaceServant) raceList1;
            races += race.getRace().toString() + "\n";
        }
        return races;
    }

    @Override
    public int totalRaces() throws RemoteException {
        return raceList.size();
    }

    /**
     *
     * @return @throws RemoteException
     */
    @Override
    public String longRun() throws RemoteException {
        String longestRaceName = "";
        double distance = 0;
        for (Object raceList1 : raceList) {
            Race race = (RaceServant) raceList1;
            if (race.getRace().distance > distance) {
                distance = race.getRace().distance;
                longestRaceName = race.getRace().name;
            }
        }
        return longestRaceName;
    }

    /**
     *
     * @return @throws RemoteException
     */
    @Override
    public String mostRun() throws RemoteException {
        int count = 1, tempCount;
        Race race = (RaceServant) raceList.get(0);
        String popular = race.getRace().name;
        String temp = "";
        for (int i = 0; i < (raceList.size() - 1); i++) {
            race = (RaceServant) raceList.get(i);
            temp = race.getRace().name;
            tempCount = 0;
            for (int j = 1; j < raceList.size(); j++) {
                race = (RaceServant) raceList.get(j);
                if (temp.equalsIgnoreCase(race.getRace().name)) {
                    tempCount++;
                }
            }
            if (tempCount > count) {
                popular = temp;
                count = tempCount;
            }
        }
        return popular;
    }

   
    /**
     *
     * @return @throws RemoteException
     */
    @Override
    public String satisfiedRace() throws RemoteException {
        String bestSatisfactionRaceName = "";
        double satisfaction = 0;
        double average = 0, temp = 0;
        int count = 0;
        String bestRaceName = " ";
        for (Object raceList1 : raceList) {
            Race race1 = (RaceServant) raceList1;
            for(Object raceList2: raceList){
            	Race race2 = (RaceServant) raceList2;
               if (race1.getRace().name . equalsIgnoreCase(race2.getRace().name)) {
            	   count++;
                   satisfaction += race1.getRace().satisfaction;
                   bestSatisfactionRaceName = race1.getRace().name;
            }
           }
            average = satisfaction / count;
            if(average > temp)
            {
            	temp = average;
            	bestRaceName = race1.getRace().name;
            }
        }
        return bestRaceName;
    }

    @Override
    public int racesSubmitted(String raceName) throws RemoteException {
        int count = 0;
        for (Object raceList1 : raceList) {
            Race race = (RaceServant) raceList1;
            if (race.getRace().name.equalsIgnoreCase(raceName)) {
                count = count + 1;
            }
        }
        return count;
    }
}
