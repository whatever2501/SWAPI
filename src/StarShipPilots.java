
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author L
 */
public class StarShipPilots {
    private StarShips starship;
    public StarShipPilots(GetRequestRepository repository) {
     
        JsonObject JsonObjectStarShips = repository.getAll("starships", null);
         JsonArray StarShips = JsonObjectStarShips.getAsJsonArray("results");
      
      int page = 2;
      String StarShipsName = "";
      for(int id = 0; !StarShipsName.equals("\"Millennium Falcon\""); id++){

          StarShipsName = StarShips.get(id).getAsJsonObject().get("name").toString();
          if(id == 9){
               id = -1;
              StarShips = repository.innerRequest("https://swapi.dev/api/starships/?page="+page).getAsJsonArray("results");
              
              page++;
          }      
              JsonArray pilots = StarShips.get(id).getAsJsonObject().get("pilots").getAsJsonArray();
               starship = new StarShips(StarShipsName,pilots);    
         
    }
    
}

    public StarShips getStarship() {
        
        return starship;
    }
}
