
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;

public class Main {

    public static void main(String[] args) throws Exception {
       API api = new API();
       GetRequestRepository repository = new GetRequestRepository(api);
       
      Charts apperedMost = new Charts (new WhoAppearedMost(repository).getListCharacters());
      ChartFrame pilotsView = apperedMost.PiolotsChart(new StarShipPilots(repository));
      apperedMost.setExtendedState(apperedMost.getExtendedState() | Charts.MAXIMIZED_BOTH);
      
      apperedMost.setVisible(true);
      pilotsView.setVisible(true);
       
     
          
          
      }
}
    
      
      

