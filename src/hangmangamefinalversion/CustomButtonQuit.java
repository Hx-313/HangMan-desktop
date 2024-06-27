/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmangamefinalversion;

import javax.swing.JOptionPane;

public class CustomButtonQuit {
    public static void main(String[] args) {
        // Define custom button labels
        Object[] options = {"Quit", "Cancel"};

        int result = JOptionPane.showOptionDialog(
                null,
                "Are you sure you want to exit?",
                "Exit Confirmation",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[1] // Default button (in this case, "Cancel")
        );

        if (result == 0) {
            System.exit(0);
            // Perform quit actions here
        } else {
            System.out.println("Exit canceled.");
            // Perform actions for canceled exit here
        }
    }
}

