
import java.rmi.RemoteException;
import java.util.Vector;

/**
 * @author Bhargava Raviteja Chanduri
 */
public class RaceListServant implements RaceList {

    private Vector raceList;
    public RaceListServant() throws RemoteException {
        raceList = new Vector();
    }
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
        /*int i=0;
        racename[i] = "";
        for (Object raceList1 : raceList) 
        {
        	Race race = (RaceServant) raceList1;
            	
        	for(int j=0;j<racename.length;j++)
        	{
        		if(race.getRace().name.equalsIgnoreCase(racename[j] ))
        			break;
        		else 
        		{
        			
        			racename[i] = race.getRace().name; i++;
        		}
        	}       	
        }
        for(int j=0;j<racename.length;j++)
        {
        	System.out.print(racename[j]+"  ");
        	
        }*/
        
        return races;
    }

    public String longRun() throws RemoteException {
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

    public String mostRun() throws RemoteException {
        int count = 0, tempCount = 0;
        
        String popular = " ";
        
        for (Object racelist1: raceList) 
        {
            Race race1 = (RaceServant) racelist1;
            for(Object racelist2: raceList)
            {
            	Race race2 = (RaceServant) racelist2;
            	if (race1.getRace().name.equalsIgnoreCase(race2.getRace().name))
            	{
            		count++;
            		popular = race1.getRace().name;
            	}
            }
            
            if (tempCount < count) 
            {
                tempCount = count;
                popular = race1.getRace().name;        
            }
        }
        return popular;
    }

    public String satisfiedRace() throws RemoteException {
        String bestSatisfactionRaceName = "";
        double satisfaction = 0;
        double average = 0, temp = 0;
        int count = 0;
        String bestRaceName = " ";
        for (Object raceList1 : raceList) {
            Race race1 = (RaceServant) raceList1;
            for(Object raceList2: raceList){
            	Race race2 = (RaceServant) raceList2;
               if (race1.getRace().name . equalsIgnoreCase(race2.getRace().name)) {
            	   count++;
                   satisfaction += race1.getRace().satisfaction;
                   bestSatisfactionRaceName = race1.getRace().name;
            }
           }
            average = satisfaction / count;
            if(average > temp)
            {
            	temp = average;
            	bestRaceName = race1.getRace().name;
            }
        }
        return bestRaceName;
    }

    public int racesSubmitted(String raceName) throws RemoteException {
        int count = 0;
        for (Object raceList1 : raceList) {
            Race race = (RaceServant) raceList1;
            if (race.getRace().name.equalsIgnoreCase(raceName)) {
                count = count + 1;
            }
        }
        return count;
    }

    /*public void printAllDistinct() throws RemoteException
    {
    	String[] UName = new String[15];
    	int i = 0;
    	for(Object raceList3 : raceList)
    	{
    		Race race3 = (RaceServant) raceList3;
    		UName[i] = race3.getRace().name;
    		for(Object raceList4: raceList)
    		{
            	Race race4 = (RaceServant) raceList4;
            	if(UName[i] . equalsIgnoreCase(race4.getRace().name))
            	{
            		break;
            	}
            	else
            	{
            		//UName[i] = race3.getRace().name;	
            		i++;
            	}
    		}
    		
    	}
    	for (int j=0;j < UName.length; j++ )
    	{
    		System.out.print(UName[j]);
    	}
    }*/

    public int totalRaces() throws RemoteException {
        return raceList.size();
    }

}  

