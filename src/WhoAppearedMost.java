
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author L
 */
public class WhoAppearedMost {

       private List<Characters>listCharacters = new ArrayList<>();;
       

    public WhoAppearedMost(GetRequestRepository repository) {
        
      JsonObject jsonObject = repository.getAll("people", null);
      int total = jsonObject.get("count").getAsInt();
      
      listCharacters = new ArrayList<>();
      
      JsonArray characters = jsonObject.getAsJsonArray("results");
      
      int charactersFound =0;
      int page = 2;
      
      for(int id = 0; charactersFound < total; id++){
          
          String name = characters.get(id).getAsJsonObject().get("name").toString();
          int films = characters.get(id).getAsJsonObject().get("films").getAsJsonArray().size();
          
          listCharacters.add(new Characters(name,films));
          charactersFound++;
        
          if(id == 9){
              id = -1; 
              characters = repository.innerRequest("https://swapi.dev/api/people/?page="+page).getAsJsonArray("results");
              page++;     
          }
          
      }
      Collections.sort(listCharacters,new SortByFilms());  
    
    }

    public List<Characters> getListCharacters() {
        return listCharacters;
    }
       
   
    
}
