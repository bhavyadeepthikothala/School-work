/*

 *
 * Program Description: This Program performs 3 different tasks requested by the 
 *                      user Using JDBC which is Embedding SQL/ORACLE in JAVA 
 *
 * Author: Bhavya Deepthi Kothala
 *
 */

// importing the java.sql package to use JDBC
import java.sql.*;
import java.io.*;


class lab4
{

    static BufferedReader keyboard; // For taking in the input from the user 

    static Connection conn; // creating the connection
 
    static Statement stmt; // Requests are sent via Statements
  
   /******* In "main" the actual connection to the database is made, and
      the user is allowed to choose from a menu of options to direct requests to
      the methods that actually and retrieve the required data 
      either in the tabular form or in the form of a statement. ***********/

    public static void main (String args []) throws IOException

    {
        String username = "C##bdk104";
        String password = "fx12cALb";
        int choice =0;

        keyboard = new BufferedReader(new InputStreamReader (System.in));

        try 
        { 
           DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

           System.out.println("Registered the driver...");

           conn = DriverManager.getConnection ("jdbc:oracle:thin:@toolman.wiu.edu:1521:orcl",username, password);

           System.out.println("logged into oracle as " + username);

           stmt = conn.createStatement ();
       
           try
           {
             while(choice<5)
             {
               System.out.println("\n ********************************* MENU ****************************************");
               System.out.println("\n1.To find Number of Screens");
               System.out.println("2.To find Number of times each movie is shown");
               System.out.println("3.To find Movies playing on a Date");
               System.out.println("4.To print the Movie Report");
               System.out.println("5.EXIT\n");
               System.out.print("Enter Your Choice:");

               choice = Integer.parseInt(keyboard.readLine());

               while(choice > 5 || choice < 0)
               {
                   System.out.println("\nInvalid Choice. TRY AGAIN\n");
                   System.out.print("Enter Your Choice:");
                   choice = Integer.parseInt(keyboard.readLine());
                }

               switch(choice)
               {
                 case 1: performScreenCount(); //calling method to count no.of screen in the Screen Table 
                              break;

                 case 2: timesShown();// Calling method to retrieve a table that shows how many times a movie is been shown
                              break;

                 case 3: System.out.print("Enter the Date you wish to find the palying movie list(dd-mmm-yy):");// Date should always be entered like DD-MMM-YY
                             String Date =  keyboard.readLine();//takes input from the user
                             playOnDate(Date);
                             break;

                 case 4: movieReport();// calling method to print all the theatersID's and Screen nos the movie is been shown  
                             break;
 
                 case 5: System.out.println("\nThank you." + "\n" +"Have a Great Day\n");
                             break;

                 default: System.out.println(" \nInvalid Choice\n");
               }
             }
           } //end inner try
           catch(SQLException e)
           {
                System.out.println("Caught Inner SQL Exception:\n   " + e); 
           }            
          }//end of try
         
        catch(SQLException e)
        {
           System.out.println("Caught SQL Exception: \n     " + e);
        }
    }//ends main

    /* this is the method to calculate how many time a movie is been shown */

    public static void timesShown() throws SQLException, IOException
    {
         String movieCount = "SELECT " + "MovieName," + "COUNT(*) AS " +"\"#TimesShown \" "
                                            + "FROM " + "C##LabDataF15.Playing Playing," + "C##LabDataF15.Movies Movies"
                                            + " WHERE" + " Playing. MovieID  = Movies.MovieID"
                                            + " GROUP BY(MovieName)"
                                            + " ORDER BY(MovieName)" ;
         System.out.println("\n" + movieCount + "\n");

          System.out.println("Movie Name"+"\t\t" + "#Times Shown"); 

         printTable(movieCount);
     
    }//end method timesShown()

    /***  Method to show all the movies playing on a particular date  ****/

    public static void playOnDate(String GivenDate) throws SQLException, IOException
    {
         String playDate  = "SELECT " + "MovieName," + "TheaterID," + "Screen#"
                                        + " FROM " + "C##LabDataF15.Playing Playing," + "C##LabDataF15.Movies Movies"
                                        + " WHERE" + " Playing. MovieID  = Movies.MovieID" 
                                        + " AND " + "ShowStartTime = " + "'" + GivenDate + "'";

         System.out.println("\n" + playDate + "\n");

         System.out.println("Movie Name"+"\t\t" + "TheaterID    "  + "  Screen#"); 

         printTable(playDate);     

    }//end of method playOnDate

   /********Method to show a movie playing in different theaters on different screens*******/

   public static void movieReport( )throws SQLException, IOException
   {
         String ReportQuery = "SELECT " + "DISTINCT(Playing.MovieID)," + "MovieName," + "TheaterID," + "Screen#"
                                             + " From" + " C##LabDataF15.Movies Movies," + "C##LabDataF15.Playing Playing"
                                             + " WHERE" + " Movies.MovieID = Playing.MovieID"
                                             + " ORDER BY MovieName";
         System.out.println("\n" + ReportQuery + "\n");
         
         ResultSet rset1 = stmt.executeQuery(ReportQuery);
         
        String Previousname  = "   "; 

         while(rset1.next())
         {
                          
              if( Previousname.compareTo(rset1.getString(2)) == 0)
              {
                 
                 System.out.print("( " + rset1.getString(3) + " , " + rset1.getString(4) + " ) " + " ; " );          
                 
              }
              else
              {
              
                System.out.println(); 
            
                Previousname= rset1.getString(2);

                System.out.print(rset1.getString(2) + " : "); 
                                
                System.out.print("( " + rset1.getString(3) + " , " + rset1.getString(4) + " ) " + " ; " );

              }                    
                            
         }
   
   }//end of method movieReport

   /********** Method to count no.of screen in the database *******/

   public static void performScreenCount() throws SQLException, IOException
   {

      String countQuery = "SELECT " + "COUNT(*) " + 
                          "FROM " + "C##LabDataF15.Screen";

       System.out.println("\n" + countQuery + "\n");

          
       printCount(countQuery);
       
    }//end of method screenCount

    /********** Method to print the Counted screens in the form of a Statement instead of a table *******/
      
    public static void printCount(String CQuery) throws SQLException
    {
              
       ResultSet tempRset1 = stmt.executeQuery(CQuery);

       tempRset1.next();
      
       System.out.println("No. of screens = " + tempRset1.getString(1));
       
       tempRset1.close();
          
    }//end of method printCount

    /********** Method to print the results of the executed Queries in the Table Format *********/

    public static void printTable(String Query) throws SQLException
    {
 
        ResultSet tempRset = stmt.executeQuery(Query);
          
        ResultSetMetaData rsmd = tempRset.getMetaData();

        int colcount = rsmd.getColumnCount();

        while (tempRset.next())
        {
          int i =1;
          while(i <= colcount)
          {                                          

             System.out.print((tempRset.getString(i)+"                                                                          ").substring(0,25));
             i++;
             if(i <= colcount)
             {
                 System.out.print(tempRset.getString(i) + "               ");
                 i++;
             }  
          }

          System.out.println();
        }    

     tempRset.close();

    }//end of method printTable

}//end of class

