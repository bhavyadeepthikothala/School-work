

/**
 * @author Bhargava Raviteja Chanduri
 */
import java.rmi.*;

public interface Race extends Remote {
   
    RaceObject getRace() throws RemoteException;

}
