

/**
 * @author Bhargava Raviteja Chanduri
 */
import java.rmi.*;
import java.util.Vector;


public interface RaceRemoteInterface extends Remote {

    void addRace(Race g) throws RemoteException;// add race

    Vector getAllRaces() throws RemoteException;// print all races
    
}
