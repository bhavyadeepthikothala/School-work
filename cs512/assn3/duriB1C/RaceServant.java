

/**
 * @author Bhargava Raviteja Chanduri
 */
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class RaceServant extends UnicastRemoteObject implements Race {

    RaceObject raceObject;
    /**
     * 
     * @param raceObject
     * @throws RemoteException 
     */
    public RaceServant(RaceObject raceObject) throws RemoteException {
        this.raceObject = raceObject;
    }
    /**
     * 
     * @return
     * @throws RemoteException 
     */
    @Override
    public RaceObject getRace() throws RemoteException {
        return raceObject;
    }
}
