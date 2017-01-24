import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/**
 * @author Bhargava Raviteja Chanduri
 */
public class RaceRemoteImpl extends UnicastRemoteObject implements RaceRemoteInterface {

    private Vector races;

    /**
     *
     * @throws RemoteException
     */
    public RaceRemoteImpl() throws RemoteException {
        races = new Vector();
    }

    /**
     *
     * @param raceObject
     * @throws RemoteException
     */
    @Override
    public void addRace(Race raceObject) throws RemoteException {
        races.addElement(raceObject);
    }

    @Override
    public Vector getAllRaces() throws RemoteException {
        String raceDetails = "";
        for (Object race : races) {
            Race raceObject = (Race) race;
            raceDetails += raceObject.toString() + "\n";
        }
        return races;
    }

}
