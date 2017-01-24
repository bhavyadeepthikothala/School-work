

/**
 * @author Emmanuel Ikonne
 */
import java.rmi.*;

public interface Race extends Remote {
    /**
     * 
     * @return
     * @throws RemoteException 
     */
    RaceObject getRace() throws RemoteException;

}
