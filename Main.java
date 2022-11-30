import java.util.*;
import java.util.Scanner;


class Main {
  // Inheritance: QueryMatcher extends Webservice
  // Polymorphism: DataBase allows for constructor overloading
  // Encapsulation: DataClass has getter and setter
  // Abstraction: WebService is an abstract class
  public static void main(String[] args) {

    // create DataBase instance
    Database db = new Database("syncDB");
    db.allocateSpace(3);

    //add DataClass data to the database
    ArrayList<String> s1 = new ArrayList<String>(Arrays.asList("mobile", "mouse","moneypot","monitor","mousepad"));
    DataClass dc1 = new DataClass();
    dc1.setStrings(s1);
    db.addDataClass(dc1);

    ArrayList<String> s2 = new ArrayList<String>(Arrays.asList("bags","baggage","banner","box","cloths"));
    DataClass dc2 = new DataClass();
    dc2.setStrings(s2);
    db.addDataClass(dc2);

    ArrayList<String> s3 = new ArrayList<String>(Arrays.asList("Havana"));
    DataClass dc3 = new DataClass();
    dc3.setStrings(s3);
    db.addDataClass(dc3);

    // Make a profitable Web Service
    QueryMatcher queryMatcher = new QueryMatcher();
    Scanner sc = new Scanner(System.in);
    String prompt1 = "Which query term would you like to use?\n  1) mouse\n  2) bags\n  3) Havana\n  4) Exit Program";
    String prompt2 = "Which data point would you like to query?";
    boolean exit = false;
    
    while (!exit) {
      System.out.println(prompt1);
      int queryChoice = sc.nextInt();
      String query = "";
      
      switch (queryChoice) {
        case 1: query = "mouse";
          break;
        case 2: query = "bags";
          break;
        case 3: query = "Havana";
          break;
        case 4: query = "__exit__";
          exit = true;
          System.out.println("Terminating Web Service");
          break;
        default: query = "mouse";
          System.out.println("Default query \"mouse\" used");
          break;
      }
      
      if (exit) {
        break;
      }
      
      System.out.println("You have chosen the query: " + query);
      System.out.println(prompt2);
      db.viewDataClassStrings();
      int dataClassNumber = sc.nextInt()-1;

      try {
        queryMatcher.provideService(query, db, dataClassNumber);
      } catch (Exception ex) {
        System.out.println("Caught Exception " + ex);
      }
      
      System.out.println();
    }
    
    sc.close();

    // view usage cost of db
    db.viewUsageCost();
  }
  
}
