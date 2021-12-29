
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.EventQueue;
import java.util.List;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ui.RectangleInsets;
import org.jfree.data.general.DefaultPieDataset;

public class Charts extends JFrame {

    private List<Characters> characters;
    private JFreeChart barChart;
    
    public Charts(List<Characters> characters) {
        this.characters = characters;
        initUI();
    }

    private void initUI() {

        CategoryDataset dataset = createDataset();

        JFreeChart chart = createChart(dataset);
       
        ChartPanel chartPanel = new ChartPanel(chart);
        
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        
        add(chartPanel);

        pack();
        setTitle("SW");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }

    private CategoryDataset createDataset() {

    	DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        
        for(int l = 0; l < characters.size();l++){
                  
                dataset.setValue(characters.get(l).getFilms(), "Movies", characters.get(l).getName());
                    
              }

        return dataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        
        barChart = ChartFactory.createBarChart(
                "Characters that Appeared Most",
                "Characters",
                "Appered in movies",
                dataset,
                PlotOrientation.HORIZONTAL,
                true, true, false);
        return barChart;
    }

    public ChartFrame PiolotsChart(StarShipPilots starshipPilots){
        DefaultPieDataset dataset = new DefaultPieDataset();
                for(String pilots : starshipPilots.getStarship().getPilotsNameS()){
                    
                    dataset.setValue(pilots, 1);
                }
		
	
		// Creation Of Chart.
		JFreeChart chart = ChartFactory.createPieChart("Pilots of Millenium Falcon", dataset, true, // legend?
				true, // tooltips?
				false // URLs?
		);
                
		chart.setTitle("Pilots of Millenium Falcon");
                
		ChartFrame frame = new ChartFrame("Pilots of Millenium Falcon", chart);
                frame.setSize(500, 500);
                frame.setLocation(1000, 500);
		
		return frame;
    }
  
}

