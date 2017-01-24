

/**
 * This is the RMI Server class for our assignment
 *
 * @author Emmanuel Ikonne
 */
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class RaceListServer {

    public static void main(String args[]) {
        System.setSecurityManager(new RMISecurityManager());
        try {
            RaceList aRaceList = new RaceListServant();
            RaceList stub = (RaceList) UnicastRemoteObject.exportObject(aRaceList, 0);
            Naming.rebind("rmi://uxb4.wiu.edu:1932/ikone2", aRaceList);
            System.out.println("RaceList server ready");
        } catch (Exception e) {
            System.out.println("RaceList server main " + e.getMessage());
        }

    }
}
