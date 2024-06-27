/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmangamefinalversion;

import java.awt.Font;
import java.io.InputStream;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTable;

/**
 *
 * @author aHafi
 */
public class Fonting {
    Fonting(javax.swing.JLabel label){
        try {
            // Replace "YourCustomFontName" with the actual font name
           InputStream fontStream = getClass().getResourceAsStream("/Fonts/Nosifer-Regular.ttf");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT,fontStream).deriveFont(Font.PLAIN, 18);

            // Apply the custom font to the JLabel
            label.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();    }

    }
     Fonting(javax.swing.JLabel label , int Font_size){
        try {
            // Replace "YourCustomFontName" with the actual font name
           InputStream fontStream = getClass().getResourceAsStream("/Fonts/Nosifer-Regular.ttf");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT,fontStream).deriveFont(Font.PLAIN, Font_size);

            // Apply the custom font to the JLabel
            label.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();    }

    }
     Fonting(JTable table, int Font_size){
        try {
            // Replace "YourCustomFontName" with the actual font name
           InputStream fontStream = getClass().getResourceAsStream("/Fonts/Nosifer-Regular.ttf");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT,fontStream).deriveFont(Font.PLAIN, Font_size);

            // Apply the custom font to the JLabel
            table.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();    }

    }
      Fonting(JPasswordField label , int Font_size){
        try {
            // Replace "YourCustomFontName" with the actual font name
           InputStream fontStream = getClass().getResourceAsStream("/Fonts/Nosifer-Regular.ttf");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT,fontStream).deriveFont(Font.PLAIN, Font_size);

            // Apply the custom font to the JLabel
            label.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();    }

    }
     Fonting(JButton label , int Font_size){
        try {
            // Replace "YourCustomFontName" with the actual font name
           InputStream fontStream = getClass().getResourceAsStream("/Fonts/Nosifer-Regular.ttf");
            Font customFont = Font.createFont(Font.TRUETYPE_FONT,fontStream).deriveFont(Font.PLAIN, Font_size);

            // Apply the custom font to the JLabel
            label.setFont(customFont);
        } catch (Exception e) {
            e.printStackTrace();    }

    }
       
}
