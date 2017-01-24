/*****************************************************************************************
 *Author: Bhavya Deepthi KOthala
 *Description: This class defines all the Functionalities for the Hospital User
 *****************************************************************************************/

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.*;


public class Hospital 
{
	static BufferedReader keyboard;
	
	public Hospital() 
	{
		keyboard = new BufferedReader(new InputStreamReader (System.in));
	}//end of Constructor
	
        // Method to Place an Order for the Blood from the Blood Bank
	public void PlaceOrder(int HID, int BBID) throws SQLException, IOException
	{
	 	int OrderID = getEnum();
	 	
	 	System.out.println("enter the Blood Group[eg:O+,O-,A-]:");
	 	String BG = keyboard.readLine();
	 	
	 	System.out.println("enter the Quantity Required[Eg: 3,5,1]:");
	 	int qty = Integer.parseInt(keyboard.readLine());
	 	
	 	System.out.println("enter the Date of Order:");
	 	DateFormat df = new SimpleDateFormat("dd-MMM-yy");
		java.util.Date dateobj = Calendar.getInstance().getTime();
		String Date = df.format(dateobj);
		System.out.println("Date is : " + Date);
		
		System.out.println("enter the Dead Line:");
	 	String DeadLine = keyboard.readLine();
	 	
	 	Statement InsStmt = BloodBank.conn.createStatement();
	 	
	 	String InsCmd = "INSERT INTO Orders VALUES("
                      + OrderID + "," + HID + ","
		              + BBID + "," + "'" + BG + "'"
		              + "," + qty + "," 
		              + "'" + Date + "'" + "," + "'" + DeadLine + "'"
		              + "," +  "NULL" + ")" ;

	    InsStmt.executeUpdate(InsCmd);
	    
	    System.out.println("Your Order has been Inserted");
	    
	}//end method PlaceOrder

        //Method to check the Status of the Order the Hospital placed 
	public void CheckStatus(int OID) throws IOException, SQLException
	{
		String CQuery = "SELECT OrderID, Status "
				      + "FROM Orders"
				      + " WHERE OrderID = " + OID;
		
		System.out.println("ORDERID" + "\t\t" + "STATUS");
		
		ResultSet rset = BloodBank.stmt.executeQuery(CQuery);
		while(rset.next())
		{
			System.out.println(rset.getString(1) + "\t\t" + rset.getString(2));
		}
	}//end method CheckStatus
	
        // Method to print the Orders by that particular Hospital
	public void CountOrders() throws SQLException, IOException
	{
		String CountQuery = "SELECT HID, COUNT(*) "
				          + "FROM Orders "
				          + "GROUP BY HID "
				          + "ORDER BY HID";
		
		System.out.println("HospitalID" + "\t"+ "Count");
		
		ResultSet rset = BloodBank.stmt.executeQuery(CountQuery);
		while(rset.next())
		{
			System.out.println(rset.getString(1) + "\t\t" + rset.getString(2));
		}
		
	}//end method CountOrders
	
        //Method to generate an Order ID by the System
	public static int getEnum() throws SQLException
	{
		ResultSet GetENum = BloodBank.stmt.executeQuery("SELECT NVL(MAX(OrderID),0) + 1 FROM Orders");
		GetENum.next();
		return GetENum.getInt(1);
	}
}
