/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author L
 */
public class Characters  {
    
    private String name;
    private int films;
    
    Characters(String name, int films){
        this.name = name;
        this.films = films;
        
    }

    public String getName() {
        
        return name.replace("\"", "");
    }

    public int getFilms() {
        return films;
    }

    
    
    
    
   
 
}
