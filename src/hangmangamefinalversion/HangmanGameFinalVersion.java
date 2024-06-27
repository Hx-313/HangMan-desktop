/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hangmangamefinalversion;

/**
 *
 * @author aHafi
 */
public class HangmanGameFinalVersion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MusicPlayer.startMusic("C:\\Users\\Hx Abdullah\\Documents\\NetBeansProjects\\mpl semester\\HangmanGameFinalVersion\\src\\hangmangamefinalversion\\1.wav");
        new Hangman().setVisible(true);
    }
    
}
