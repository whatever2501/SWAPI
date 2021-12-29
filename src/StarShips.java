
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author L
 */
public class StarShips {
    private String name;
    
    private JsonArray pilotsName;
    private List<String> pilotsNameS = new ArrayList<>();
    private API api = new API();
    private GetRequestRepository repository = new GetRequestRepository(api);
    
    
    public StarShips(String name, JsonArray  pilotsName){
        this.name = name;
        this.pilotsName = pilotsName;
    }

    public String getName() {
        return name;
    }

    public void  getPilotsName() {
        int totalPilots = pilotsName.size(); 
        for(int id = 0; id < totalPilots;id++ ){
            String url = pilotsName.get(id).toString().substring(1,33);
            
            pilotsNameS.add(repository.innerRequest(url).get("name").toString().replace("\"", ""));
           
        }
      
    }

    public List<String> getPilotsNameS() {
        getPilotsName();
        return pilotsNameS;
    }

    

  



  
    
    
}
