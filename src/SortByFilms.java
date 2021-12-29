
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author L
 */
public class SortByFilms implements Comparator<Characters> {
      
    @Override
        public int compare(Characters a, Characters b)
    {
            return b.getFilms()-a.getFilms();
    }
     
    
}
