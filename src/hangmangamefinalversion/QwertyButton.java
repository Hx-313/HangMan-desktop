/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmangamefinalversion;

/**
 *
 * @author Hx Abdullah
 */
import java.awt.Color;
import javax.swing.*;

public class QwertyButton extends JButton {
    private char value;
    boolean flag  = false;
     

    public QwertyButton(char value) {
        this.value = value;

        this.setFocusable(false);
        this.setText(String.valueOf(this.value));
    }
    public void setWin(boolean win){
        flag = win;
        
    }
    public boolean getWin(){
        return flag;
    }
  

    // Constructors and other methods...


   
    public char getValue() {
        return this.value;
    }
}
