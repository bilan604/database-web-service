import java.util.*;


class QueryMatcher extends WebService {

  @Override
  public List<List<String>> provideService(String searchWord, Database db, int dataClassNumber) {

    ArrayList<String> products = db.dataClasses.get(dataClassNumber).getStrings();

    Collections.sort(products);
    List<List<String>> ans = new ArrayList<>();
    
    for (int i = 1; i <= searchWord.length(); i++) {
      String query = searchWord.substring(0, i);
      List<String> query_matches = new ArrayList<>();
      
      for (String product : products) {
        if (query.length() <= product.length()) {
          if (query.equals(product.substring(0, i))) {
            query_matches.add(product);
            if (query_matches.size() == 3) {
              break;
            }
          }
        }
      }
      
      ans.add(query_matches);
    }
    
    // add to total usage cost
    db.usageCost += 8.0f;
    return ans;
    
  }
  
}
