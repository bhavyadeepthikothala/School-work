/*
 * This sample shows how to insert into the WIU_Faculty table, and then
 * display all of its rows.
 *
 * This program was originally adapted from one of the samples supplied
 * with Oracle; however, it has been substantially rewritten.
 *
 * Author: Martin Maskarinec
 *
 */

// You need to import the java.sql package to use JDBC
import java.sql.*;
import java.io.*;

class lab4
{

    static BufferedReader keyboard;  // Needed for keyboard I/O.
    static Connection conn; // A connection to the DB must be established
                            // before requests can be handled.  You should
                            // have only one connection.
    static Statement stmt;  // Requests are sent via Statements.  You need
                            // one statement for every request you have
                            // open at the same time.


    static Statement stmt1;

    // "main" is where the connection to the database is made, and
    // where I/O is presented to allow the user to direct requests to
    // the methods that actually do the work.

    public static void main (String args []) throws IOException
    {
    	String username="vspkt100", password = "pt94zUTy";
    	String ename;
    	int original_empno=0;
    	int empno;

    	keyboard = new BufferedReader(new InputStreamReader (System.in));

    	try 
    	{ //Errors will throw a "SQLException" (caught below)

	    // Load the Oracle JDBC driver
    		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

            System.out.println("Registered the driver...");

	    // Connect to the database.  The first argument is the
	    // connection string, the second is your username, the third is
	    // your password. 
            conn = DriverManager.getConnection (
                   "jdbc:oracle:thin:@oracle1.wiu.edu:1521/toolman.wiu.edu",
		    username, password);

            conn.setAutoCommit(false);

            System.out.println("logged into oracle as " + username);

	    // Create a Statement; again, you may have/need more than one.
            stmt = conn.createStatement ();
            stmt1 = conn.createStatement ();
            int choice = 1;
            
            while(choice > 0 && choice < 5)
            {
            	System.out.println("\n$$$$$$$$$$$$$$$$$$$$$$$ MENU $$$$$$$$$$$$$$$$$$$$$$$$\n");
            	System.out.println("1. Create MySides ");
            	System.out.println("2. find Hamburger count");
            	System.out.println("3. find ingredients used in a sandwich");
            	System.out.println("4. convert a relational calculus query to SQL");
            	System.out.println("5. Exit");
            	
            	System.out.print("\n Enter Your Choice:");

            	choice = Integer.parseInt(keyboard.readLine());

	        
            	switch(choice)
            	{
            	case 1 : Mysides();
            	break;

            	case 2 : HamburgerCount();
            	break; 

            	case 3 : System.out.println("\n Enter the name of the sandwich: ");
            	String Sandwich = keyboard.readLine();
            	ingredientUsed(Sandwich);
            	break;

            	case 4 : System.out.println("\n enter the Relational Calculus Query: \n");
            	String RCalc = keyboard.readLine();
            	conversion(RCalc);
            	break;

            	case 5 : System.out.println("\nThank you. Have a great day\n");
            	break;

            	default: System.out.println("\nInvalid Choice\n");
            	}   	
            }
    	}
    	catch(SQLException e)
    	{
    		System.out.println("Caught SQL Exception: \n     " + e);
    	}
    }
    public static void Mysides() throws SQLException
    {
    	ResultSet rset=stmt.executeQuery ("select * from tab");
    	        
        while(rset.next())
        {
        	
        	if(rset.getString(1).equalsIgnoreCase("MYSIDES"))
        	{
        		stmt.executeQuery("Drop table MySides");
        		System.out.println("table dropped");
        		break; 
        	}
        }

        String Create = " Create Table MySides(sidename char(20) Primary Key, calories number(4), price  number(5,2)) ";
        rset = stmt.executeQuery(Create);
        System.out.println("Table Created");
    	stmt.executeUpdate("insert into MySides select * from labdataf16.Sides");
    	System.out.println("Inserted into table");
    	rset = stmt.executeQuery("Select * from MySides");
    	ResultSetMetaData rsmd = rset.getMetaData();
    	int colCount = rsmd.getColumnCount();
    	System.out.println("SIDENAME          " + "CALORIES  "+ "PRICE  ");
    	while(rset.next())
    	{
    		for(int i = 1; i<=colCount; i++)
    		{
    			System.out.print(rset.getString(i) + " ");
    		}
    		System.out.println( );
    	}
    	rset.close();
    }//END METHOD MySides
    
    public static void HamburgerCount() throws SQLException
    {
    	int count = 0;
    	String Query = "SELECT COUNT(SNAME) FROM LABDATAF16.Sandwiches WHERE SNAME LIKE '%hamburger%' GROUP BY SNAME ";
    	ResultSet rset = stmt.executeQuery(Query);
    	while(rset.next())
    	{
    		count++;
    	}
    	
    	System.out.println("no. of sandwiches that are of hamburger type are:  " + count);
    	rset.close();
    }// end of hamburger function
    
    public static void ingredientUsed(String SName) throws SQLException
    {
    	String Query = "SELECT INGREDIENTNAME, INSTOCK " +
                       "FROM LABDATAF16.InSandwich, LABDATAF16.Ingredients " +
    			       "WHERE LABDATAF16.InSandwich.INGREDIENTID = LABDATAF16.Ingredients.INGREDIENTID " +
                       "AND " + " LABDATAF16.InSandwich.SNAME = '" + SName + "'" ;
    	ResultSet rset = stmt.executeQuery(Query);
    	ResultSetMetaData rsmd = rset.getMetaData();
    	int colCount = rsmd.getColumnCount();
    	System.out.println("INGREDIENTNAME      " + "INSTOCK   ");
    	while(rset.next())
    	{
    		for(int i = 1; i<=colCount; i++)
    		{
    			System.out.print(rset.getString(i) + " ");
    		}
    		System.out.println( );
    	}
    }// end of ingredientUsed Function
    
    public static void conversion(String RCQuery) throws SQLException
    {
    	String[] splittedQuery = RCQuery.split("&");
    	String Query = "SELECT " + splittedQuery[1] +
    			       " FROM " + splittedQuery[0] +
    			       " WHERE " + splittedQuery[2];
    	ResultSet rset = stmt.executeQuery(Query);
    	ResultSetMetaData rsmd = rset.getMetaData();
    	int colCount = rsmd.getColumnCount();
    	while(rset.next())
    	{
    		for(int i = 1; i<=colCount; i++)
    		{
    			System.out.print(rset.getString(i) + " ");
    		}
    		System.out.println( );
    	}
    	
    }// end of conversion function
}





