

/**
 * @author Emmanuel Ikonne
 */
import java.rmi.*;


public interface RaceList extends Remote {

    void addRace(RaceObject g) throws RemoteException;

    String printAllRaces() throws RemoteException;
    
    int totalRaces() throws RemoteException;
    
    String longRun()throws RemoteException;
    
    String mostRun() throws RemoteException;
    
    String satisfiedRace() throws RemoteException;
    
    int racesSubmitted(String raceName)throws RemoteException;
    
    
}
