import java.util.*;


class Database {
  
  public String name;
  public int size;
  public float usageCost;
  public ArrayList<DataClass> dataClasses;

  // Initialize Database
  public Database(){
    this.name = "";
    this.size = 0;
    this.usageCost = 0.0f;
    this.dataClasses = new ArrayList<DataClass>();
    System.out.println("Created " + name + "!");
  }

  // Overloading
  public Database(String name){
    this.name = name;
    this.size = 0;
    this.usageCost = 0.0f;
    this.dataClasses = new ArrayList<DataClass>();
    System.out.println("Created " + name + "!");
  }

  // Provide storage space
  public void allocateSpace(int space) {
    
    System.out.println("Allocating " + space + " units of storage to your Database");
    
    for (int i = 0; i < space; i++) {
      DataClass dataClass = new DataClass();
      ArrayList<String> empty_strings = new ArrayList<String>(Arrays.asList());
      dataClass.setStrings(empty_strings);
      
      this.dataClasses.add(dataClass);
      this.usageCost += 1.0f;
      this.size += 1;
    }
    
  }

  public void viewDataClassStrings() {
    int counter = 1;
    for (DataClass dc : this.dataClasses) {
      System.out.println(counter + ") " + dc.getStrings());
      counter += 1;
    }
  }

  public void addDataClass(DataClass dataClass) {
    
    boolean addedSuccessfully = false;
    
    for (int i = 0; i < this.size; i++) {
      
      if (this.dataClasses.get(i).getStrings().size() == 0) {
        System.out.println("Adding query at index: " + i);
        this.dataClasses.set(i, dataClass);
        this.usageCost += 0.15f;
        addedSuccessfully = true;
        break;
      } else {
        this.usageCost += 0.01f;
      }
    
    }
    
    if (!addedSuccessfully) {
      System.out.println("Not enough storage, please upgrade Database or consider purchasing another Instance");
    }
  
  }

  public void viewTotalStringCount() {
    
    int total = 0;
    
    for (DataClass dataClass : this.dataClasses) {
      total += dataClass.getStrings().size();
    }
    System.out.println("Total String Count: " + total);
  }
  
  public void viewUsageCost() {
    System.out.println("Current usage cost: " + this.usageCost);
  }

}
