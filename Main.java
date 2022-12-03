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

    // view total number of strings inside db
    db.viewTotalStringCount();

    // Make a profitable Web Service
    QueryMatcher queryMatcher = new QueryMatcher();
    List<List<String>> matches = new ArrayList<>();
    // take a field to search
    int dataClassNumber;
    Scanner sc1 = new Scanner(System.in);
    // take a search term
    String searchTerm;
    Scanner sc2 = new Scanner(System.in);
    // check if user decided to exit
    boolean exit = false;
    
    String prompt = "Which dataClass would you like to query?";
    
    while (!exit) {
      dataClassNumber = 0;
      searchTerm = "";
      
      System.out.println(prompt);
      db.viewDataClassStrings();
      System.out.println("    4) EXIT\n");
      
      try{
        dataClassNumber = sc1.nextInt();
      } catch(InputMismatchException ime) {
        System.out.println("Invalid Input");
      } catch(Exception e) {
        System.out.println("Exception Raised");
      }
      
      switch (dataClassNumber) {
        case 1: dataClassNumber = 0;
          break;
        case 2: dataClassNumber = 1;
          break;
        case 3: dataClassNumber = 2;
          break;
        case 4: dataClassNumber = 0;
          exit = true;
          break;
        default: dataClassNumber = 0;
          System.out.println("Number out of bounds");
          break;
      }
      
      if (exit) {
        break;
      }
      
      System.out.println("You have chosen to query dataClass:\n    " + db.dataClasses.get(dataClassNumber).getStrings());

      try {
        searchTerm = sc2.nextLine();
      } catch(InputMismatchException a) {
        System.out.println("Invalid Input!");
      } catch(Exception e) {
        System.out.println("Exception Caught!");
      }

      // use the web service (Search engine)
      matches = queryMatcher.provideService(searchTerm, db, dataClassNumber);
      
      System.out.println("Here are your query matches:\n    " + matches);
      
      System.out.println();
    }
    
    sc1.close();
    sc2.close();
    
    // view usage cost of db
    db.viewUsageCost();

  }
  
}
