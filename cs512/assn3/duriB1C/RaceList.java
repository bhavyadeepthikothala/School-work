

/**
 * @author Bhargava Raviteja Chanduri
 */
import java.rmi.*;


public interface RaceList extends Remote {

    void addRace(RaceObject g) throws RemoteException;

    String printAllRaces() throws RemoteException;
    
    int getTotalRaces() throws RemoteException;
    
    String longestRace()throws RemoteException;
    
    String frequentRace() throws RemoteException;
    
    String satisfactionRace() throws RemoteException;
    
    int raceSubmissions(String raceName)throws RemoteException;
}
