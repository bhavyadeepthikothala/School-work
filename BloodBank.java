/********************************************************************************************
 * Author: Bhavya Deepthi Kothala
 * Description: This Program is the user interface for implementing the Blood Bank Management 
                System which allows two Kinds of users to use the Database
                one is Hospital User and the other is the Employee User
 ********************************************************************************************/

import java.sql.*;
import java.io.*;


public class BloodBank 
{
	    static BufferedReader keyboard; // For taking in the input from the user 

	    static Connection conn; // creating the connection
	 
	    static Statement stmt; // Requests are sent via Statements
	    
	    static Employee Emp ;  //An Object for Employee 
	    
	    static Statement secondStmt; // Requests are sent via Statements
	    
	    static Hospital Hosp;  //An Object for Hospital
	  
	   /******* In "main" the actual connection to the database is made, and
	      the user is allowed to choose from a menu of options to direct requests to
	      the methods that actually and retrieve the required data 
	      either in the tabular form or in the form of a statement. ***********/

	    public static void main (String args []) throws IOException

	    {
	        String username = "C##bdk104";
	        String password = "fx12cALb";
	        int choice = 0;

	        keyboard = new BufferedReader(new InputStreamReader (System.in));
	        
	        Emp = new Employee();

	        try 
	        { 
	           DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

	           System.out.println("Registered the driver...");

	           conn = DriverManager.getConnection ("jdbc:oracle:thin:@toolman.wiu.edu:1521:orcl",username, password);

	           System.out.println("logged into oracle as " + username);

	           stmt = conn.createStatement ();
	           
	           secondStmt = conn.createStatement ();
	           
	           try
	           {
	        	  while(choice < 3)
	        	  {
	        		  System.out.println("\n ****************************** MAIN MENU **************************** \n");
	        		  System.out.println("1.Employee");
	        		  System.out.println("2.Hospital");
	        		  System.out.println("3.Exit");
	        		  
	        		  System.out.println("enter your choice:");
	        		  choice = Integer.parseInt(keyboard.readLine());
	        		  
	        		  while(choice > 3 || choice < 0)
	        		  {
	        			  System.out.println("\nInvalid Choice. TRY AGAIN!!!!");
	        			  System.out.println("enter your choice:");
		        		  choice = Integer.parseInt(keyboard.readLine());
	        		  }
	        		  switch(choice)
	        		  {
	        		  case 1 : int Option = 1; //Employee Options
	        		           	        		           
	        		           while(Option > 0 && Option < 5)
	        		           {
	        		        	   System.out.println(" \n*************************** Welcome Employee *********************** \n");
	        		        	   System.out.println("\n *************************** EMPLOYEE MENU **************************\n");
	        		        	   System.out.println("1.Register a Donor/Recipient");
	        		        	   System.out.println("2.Search in the Blood bank for available Blood");
	        		        	   System.out.println("3.Retrieve the Test Results");
	        		        	   System.out.println("4.Manage Orders(Update Status/Delete/Print Pending Orders)");
	        		        	   System.out.println("5.Exit\n");
	        		        	   
	        		        	   System.out.println("enter your Option:");
	        		        	   Option = Integer.parseInt(keyboard.readLine());
	        		        	   
	        		        	   while(Option < 0 || Option > 5)
	        		        	   {
	        		        		   System.out.println("\nInvalid Choice. TRY AGAIN!!!!");
	        		        		   System.out.println("enter your Option:");
	        			        	   Option = Integer.parseInt(keyboard.readLine());
	        		        	   }
	        		        	   
	        		        	   switch(Option)
	        		        	   {
	        		        	   case 1 : int ID = CollectDetails();         
	        		        		        Emp.Registration(ID);
	        		        		        break;
	        		        		       
	        		        	   case 2 : System.out.println("enter the Blood Group you are searching(eg: A-, O+):");
	        		        	            String BloodGrp = keyboard.readLine();
	        		        	            Emp.searchBank(BloodGrp);
	        		        		        break;
	        		        		       
	        		        	   case 3 : System.out.println("enter the Donors Last Name[Eg: Kothala, noah, keys ]:");
	        		        	            String Name = keyboard.readLine();
	        		        	            System.out.println("enter the persons Gender[Eg: F, M, F]:");
	        		        	            String Gen = keyboard.readLine();
	        		        		        Emp.TestResults(Name,Gen);
	        		        		        break;
	        		        		       
	        		        	   case 4: 	int ToDo = 1;
	        		        		        while(ToDo > 0 && ToDo < 4)
    		        	                    { 
	        		        		       		System.out.println("Welcome to ORDERS");
	        		        		       		System.out.println("You have Following Options");
	        		        		       		System.out.println("1. Update an Order Status");
	        		        		       		System.out.println("2. Delete an Order");
	        		        		       		System.out.println("3. Print the list of all Orders ");
	        		        		       		System.out.println("4. Exit");
	        		        		       		System.out.println("What Do you Want To do?:");
	        		        		       	    ToDo = Integer.parseInt(keyboard.readLine());
	        		        		       	    
	        		        		       		while(ToDo < 0 || ToDo > 4)
	        		        		       		{
	        		        		       			System.out.println("\nInvalid Choice. TRY AGAIN!!!!");
	        		        		       			System.out.println("What do you want to Do?:");
	        		        		       			ToDo = Integer.parseInt(keyboard.readLine());
	        		        		       		}
	        		        	           
	        		        		       		if(ToDo == 1)
	        		        		       		{
	        		        		       			System.out.println("Enter the Order ID [Eg:25]: ");
	        		        		       			int OID = Integer.parseInt(keyboard.readLine());
	        		        		       			Emp.UpdateOrders(OID);
	        		        		       		}
	        		        		       		else if(ToDo == 2)
	        		        		       		{
	        		        		       			Emp.DeleteOrders();
	        		        		       		}
	        		        		       		else if(ToDo == 3)
	        		        		       		{
	        		        		       			Emp.PrintOrders();
	        		        		       		}
	        		        		       	}
	        		        	           
	        		        	            break;
	        		        	           
	        		        	   case 5 : System.out.println("Thank you Employee");
	        		        		        break;
	        		        		   
	        		        	   default: System.out.println("Invalid Choice");	       
	        		        	   
	        		        	   }
	        		           }//end while in switch case 1
	        		           break;
	        		           
	        		  case 2 : int Selection = 1;  //Hospital Options
   		           			   Hosp = new Hospital();
		           
   		           			   while(Selection > 0 && Selection < 4)
   		           			   {
   		           				   System.out.println("\n ************************ Welcome Hospital User ********************* \n");
   		           				   System.out.println("\n *************************** HOSPITAL MENU **************************\n");
   		           				   System.out.println("1.Place an Order");
   		           				   System.out.println("2.check Status of the Orders");
   		           				   System.out.println("3.No. Of Orders");
   		           				   System.out.println("4.Exit\n");
   		        	   
   		           				   System.out.println("enter your Selection:");
   		           				   Selection = Integer.parseInt(keyboard.readLine());
   		           				   while(Selection < 0 || Selection > 4)
   		           				   {
   		           					   System.out.println("\nInvalid Choice. TRY AGAIN!!!!");
   		           					   System.out.println("enter your Selection:");
   		           					   Selection = Integer.parseInt(keyboard.readLine());
   		           				   }	
   		           				   switch(Selection)
   		           				   {
   		           				   case 1 : System.out.println("enter the Hospital ID[Eg: 3,5,7]:");
   		           				            int HID = Integer.parseInt(keyboard.readLine());
   		           				            System.out.println("enter the Blood Bank ID[Eg: 1, 2, 3]:");
		           				            int BBID = Integer.parseInt(keyboard.readLine());        				      
   		           				            Hosp.PlaceOrder(HID,BBID);
                                                                    System.out.println("Are you going to Accept the Order:(Y/N)");
                                                                    String acceptance = keyboard.readLine();
                                                                    if(acceptance.equalsIgnoreCase("y"))
                                                                    {
   		           				              Emp.ManageOrders();
                                                                    }
                                                                    else
                                                                    {
                                                                       System.out.println("your Order is Waiting for the Acceptance");
                                                                    }
   		           				            break;
   		           				    
   		           				   case 2 : System.out.println("Enter the Order ID [Eg:9,5,7]: ");
	        		       			        int OID = Integer.parseInt(keyboard.readLine());
   		           					        Hosp.CheckStatus(OID);
   		           				            break;
   		           				    
   		           				   case 3 : Hosp.CountOrders();
   		           				            break;
   		           				      
   		           				   case 4 : System.out.println("Thank you Hospital User");
   		           				            break;
   		           				            
   		           				   default: System.out.println("Invalid Choice");         
   		           				   }
   		           			   }
	        			       break;
	        			       
	        		  case 3 : System.out.println("Thank you for using the System." + "\n" + "Have a Great Day");
	        		           break;
	        		           
	        		  default: System.out.println("Invalid Choice");
	        		  }//end Main Menu Switch 
	        		  
	        	  }//end Main Menu While loop
	        	    
	           }//end inner try
	        
	           catch(SQLException e)
	           {
	                System.out.println("Caught Inner SQL Exception:\n   " + e); 
     
                        //e.printStackTrace(System.err);
    
                        System.err.println("SQLState: " +((SQLException)e).getSQLState());
 
                       System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
	           }            
	     
	        }//end outer try 

	        catch(SQLException e)
	        {
	           System.out.println("Caught SQL Exception: \n     " + e);
	        }
	        
	    }//end main  
	  public static int CollectDetails() throws IOException,SQLException
	  {
		  System.out.println("enter the person ID:");
		  int ID = Integer.parseInt(keyboard.readLine());
		  while(ID <= 0)
		  {
			  System.out.println("enter the person ID:");
			  ID = Integer.parseInt(keyboard.readLine());
		  }
		  System.out.println("enter the persons First Name:");
		  String FName = keyboard.readLine();
		  System.out.println("enter the persons Last Name:");
		  String LName = keyboard.readLine();
		  System.out.println("enter the persons Middle Initial:");
		  String MI = keyboard.readLine();
		  System.out.println("enter the persons Gender:");
		  String Gender = keyboard.readLine();
		  System.out.println("enter the persons Age:");
		  int Age = Integer.parseInt(keyboard.readLine());
		  System.out.println("enter the persons Date of Birth:");
		  String DOB = keyboard.readLine();
		  System.out.println("enter the persons Blood Group:");
		  String BG = keyboard.readLine();
		  System.out.println("enter the persons Street Address:");
		  String Address = keyboard.readLine();
		  System.out.println("enter the persons phone Number:");
		  String Phone = keyboard.readLine();
		  System.out.println("enter the persons Email:");
		  String Email = keyboard.readLine();
		  System.out.println("enter the persons city:");
		  String City = keyboard.readLine();
		  System.out.println("enter the persons State:");
		  String State = keyboard.readLine();
		  System.out.println("enter the persons Zip Code:");
		  int ZipCode = Integer.parseInt(keyboard.readLine());
		  
		  Statement InsStmt = conn.createStatement();
		  
		  String InsCmd = "INSERT INTO Person VALUES("
		                   + ID + "," + "'" + FName + "'" + ","
				           + "'" + LName + "'" + "," + "'" + MI + "'"
				           + "," + "'" + Gender + "'" + "," + Age + ","
				           + "'" + DOB + "'" + "," + "'" + BG + "'"
				           + "," + "'" + Address + "'" + "," + "'"
				           + Phone + "'" + "," + "'" + Email + "'"
				           + "," + "'" + City + "'" + "," + "'" + State 
				           + "'" + "," + ZipCode + ")" ;
		  
		  InsStmt.executeUpdate(InsCmd);
		  System.out.println(ID + "added to the person Table");
		  
		  return ID;
	  }
}//end class
