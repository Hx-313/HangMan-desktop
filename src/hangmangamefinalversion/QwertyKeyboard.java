/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmangamefinalversion;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class QwertyKeyboard extends JButton {

    private char[] letters = {
            'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
            'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L',
            'Z', 'X', 'C', 'V', 'B', 'N', 'M'
    };
    private QwertyButton[] buttons = new QwertyButton[26];

    public QwertyKeyboard() {
        

        for (int i=0; i<this.letters.length; i++) {
            this.buttons[i] = new QwertyButton(this.letters[i]);
              this.buttons[i].setBackground(new Color(25,29,74));
            this.buttons[i].setForeground(new Color(255,255,255));
            
            
        }
    }
   
    public void displayButtons(JPanel keyboardPanel) {

        for (QwertyButton button : this.buttons) {
            keyboardPanel.add(button);
        }
    }

    public void resetKeyboard() {

        for (QwertyButton button : this.buttons) {
            button.setEnabled(true);
            button.setBackground(null);
        }
    }

    public void disableKeyboard() {

        for (QwertyButton button : this.buttons) {
            button.setEnabled(false);
        }
    }

    public QwertyButton[] getButtons() {

        return this.buttons;
    }
}