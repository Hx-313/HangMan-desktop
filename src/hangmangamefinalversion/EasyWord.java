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
public class EasyWord extends Word{
private String word;
    public EasyWord(){
      setWord();
    }
    @Override
    public void setWord() {
        String path = "C:\\Users\\Hx Abdullah\\Documents\\NetBeansProjects\\mpl semester\\HangmanGameFinalVersion\\src\\Words\\EASY.txt";
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
