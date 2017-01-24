
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * @author Bhargava Raviteja Chanduri
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
    public int getTotalRaces() throws RemoteException {
        return raceList.size();
    }

    /**
     *
     * @return @throws RemoteException
     */
    @Override
    public String longestRace() throws RemoteException {
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
    public String frequentRace() throws RemoteException {
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
    public String satisfactionRace() throws RemoteException {
        String bestSatisfactionRaceName = "";
        double satisfaction = 0;
        for (Object raceList1 : raceList) {
            Race race = (RaceServant) raceList1;
            if (race.getRace().satisfaction > satisfaction) {
                satisfaction = race.getRace().distance;
                bestSatisfactionRaceName = race.getRace().name;
            }
        }
        return bestSatisfactionRaceName;
    }

    @Override
    public int raceSubmissions(String raceName) throws RemoteException {
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
