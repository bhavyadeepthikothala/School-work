/*************************************************************************************
 * Author: Bhavya Deepthi KOthala
 * Description: This class Defines all the Functions implemented by Employee User
 *************************************************************************************/

import java.sql.*;
import java.io.*;
import java.text.*;
import java.util.Calendar;


public class Employee 
{
    static BufferedReader keyboard; // For taking in the input from the user 

    
    
	public Employee() 
	{
		keyboard = new BufferedReader(new InputStreamReader (System.in));
	}//end Constructor

	//Method to Register Either the Donor or Employee 
	public void Registration(int PID) throws SQLException,IOException
	{
		System.out.println("Enter your ID:");
		int EID = Integer.parseInt(keyboard.readLine());
		System.out.println("IS the person Donor or Recipient?:");
		String type = keyboard.readLine();
		if(type.equalsIgnoreCase("Donor"))
		{
			System.out.println("Enter the Date of Donation:");
			String DOD = keyboard.readLine();
			System.out.println("Enter the Quantity:");
			int Qty = Integer.parseInt(keyboard.readLine());
			
			Statement InsStmt = BloodBank.conn.createStatement();
			
			String InsCmd = "INSERT INTO Donor VALUES("
					        + PID + "," + "'" + DOD + "'"
					        + "," + Qty + "," + EID + ")";
			
			InsStmt.executeUpdate(InsCmd);
			System.out.println(PID + "added to the Donor Table");
		}
		else if(type.equalsIgnoreCase("Recipient"))
		{
			System.out.println("Enter the Date of Purchase:");
			String DOP = keyboard.readLine();
			System.out.println("Enter the Quantity Required:");
			int Qty = Integer.parseInt(keyboard.readLine());
			
			Statement InsStmt = BloodBank.conn.createStatement();
			
			String InsCmd = "INSERT INTO Recipient VALUES("
					        + PID + "," + "'" + DOP + "'"
					        + "," + Qty + "," + EID + ")";
			
			InsStmt.executeUpdate(InsCmd);
			System.out.println(PID + "added to the Recipient Table");
		}
		else
		{
			System.out.println("enter either Donor (or) Recipient");			
		}
	}//end method Registration
	
        //Method to Search the Blood Bank using a Blood Group
	public void searchBank(String BloodGroup) throws SQLException, IOException
	{
		String search = "SELECT BankID,BankName,Description "
				      + "FROM BloodBank "
				      + "WHERE BloodGroup = '" + BloodGroup + "'";
		
		System.out.println("BID" + "\t" + "BBNAME" + "\t\t" + "Description");
		
		ResultSet rset1 = BloodBank.stmt.executeQuery(search);
		while(rset1.next())
		{
			System.out.println(rset1.getString(1)+ "         " + rset1.getString(2)+ "       "  + rset1.getString(3));
		}
	}//end method searchBank
	
        // Method to Display the Test Results for a given Donor
	public void TestResults(String LName, String Gender) throws SQLException, IOException
	{
		String TempQuery = "SELECT TestID FROM Blood,Person "
				         + "Where DonorID = PersonID "
				         + "AND LName = " + "'" + LName + "'"
                         + " AND Gender = " + "'" + Gender + "'";
		ResultSet rset = BloodBank.stmt.executeQuery(TempQuery);
		System.out.println("\t\t  RESULT  \t\t");
		while(rset.next())
		{
			String MainQuery = "SELECT Result FROM Tests"
					         + " WHERE TestID = " + rset.getString(1);
					         
			ResultSet rset1 = BloodBank.secondStmt.executeQuery(MainQuery);
			while(rset1.next())
			{
			    System.out.println("\t\t  " + rset1.getString(1) + "  \t\t");
			}
		}		     
	}//end method TestResults
	
        //Method to Update Orders 
	public void UpdateOrders(int OrderID) throws SQLException,IOException
	{
		String UQuery = "UPDATE Orders"
				      + " SET Status = 'Finished'"
				      + " WHERE OrderID = " + OrderID;
		
		ResultSet rset = BloodBank.stmt.executeQuery(UQuery);
		rset.next();
		System.out.println("The Order has been Updated");
	}// end method UpdateOrders
	
        //Method to Delete Orders
	public void DeleteOrders() throws IOException, SQLException
	{
		DateFormat df = new SimpleDateFormat("dd-MMM-yy");
		java.util.Date dateobj = Calendar.getInstance().getTime();
		String Date = df.format(dateobj);
		System.out.println("Date is : " + Date);
		String DQuery = "DELETE FROM Orders "
				      + "WHERE DeadLine < " 
				      + "'" + Date + "'" +
				      "AND Status = 'Accepted'";
		ResultSet rset = BloodBank.stmt.executeQuery(DQuery);
		rset.next();
		System.out.println("The Order has been Deleted");
	}//end method DeleteOrders
	
        //Method to print the list of all orders
	public void PrintOrders() throws SQLException,IOException
	{
		String PQuery = "SELECT OrderID, Status "
				      + "FROM Orders";
		System.out.println("ORDERID" + "\t\t" + "STATUS");
		ResultSet rset = BloodBank.stmt.executeQuery(PQuery);
		while(rset.next())
		{
			System.out.println(rset.getString(1) + "\t\t" + rset.getString(2));
		}
	}
	
        //Method to Manage Orders
	public void ManageOrders() throws SQLException,IOException
	{
		String MQuery = "UPDATE Orders"
			          + " SET Status = 'Accepted'"
			          + " WHERE Status = 'Null'";
		
		ResultSet rset = BloodBank.stmt.executeQuery(MQuery);
		//rset.next();
		System.out.println("The Order has been Accepted by the Employee");
	}
}//end class
