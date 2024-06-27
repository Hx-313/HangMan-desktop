/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmangamefinalversion;

/**
 *
 * @author Hx Abdullah
 */
public class GameStats {
    private  static int tries;
    private static String Name;
    
    public static void setTries(int tries){
        GameStats.tries= tries;
    } 
    public static int getTries(){
        return tries;
    }
    public static void setName(String Name){
        GameStats.Name = Name;
    }
    public static String getName(){
        return Name;
    }
    
}
