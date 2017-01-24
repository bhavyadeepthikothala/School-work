/**
 * This is the RMI Server class for our assignment
 *
 * @author Bhargava Raviteja Chanduri
 */
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {

    public static void main(String args[]) {

        try {
            System.out.println("Starting RMI Server");
            System.setSecurityManager(new RMISecurityManager());
            RaceRemoteInterface raceRemoteInterface = new RaceRemoteImpl();
            Naming.rebind("RaceRemoteInterface", raceRemoteInterface);
            System.out.println("RMI server ready");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
