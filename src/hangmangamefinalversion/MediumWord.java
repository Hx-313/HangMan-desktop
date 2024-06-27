/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmangamefinalversion;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aHafi
 */
public class MediumWord extends Word {
    private String word;
    MediumWord(){
      setWord();
    }
    @Override
    public void setWord() {
        String path = "C:\\Users\\Hx Abdullah\\Documents\\NetBeansProjects\\mpl semester\\HangmanGameFinalVersion\\src\\Words\\MEDIUM.txt";
        try {
            
            word = GenerateRandomWord.RandomWord(path);
           
        } catch (IOException ex) {
            Logger.getLogger(EasyWord.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public String getWord() {
        return word;
    }
    
}

