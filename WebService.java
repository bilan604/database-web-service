import java.util.*;


abstract class WebService {
  
  abstract List<List<String>> provideService(String searchWord, Database db, int dataClassNumber);
  
}
