/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hangmangamefinalversion;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Hx Abdullah
 */
public class MainGamePanel extends javax.swing.JFrame {
QwertyKeyboard qwertyKeyboard;
String Word;

    /**
     * Creates new form MainGamePanel
     */
    public MainGamePanel() {
        Timer timerDelay = new Timer(1000, (ActionListener) new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                 MusicPlayer.stopMusic();
        MusicPlayer.startMusic("C:\\Users\\Hx Abdullah\\Documents\\NetBeansProjects\\mpl semester\\HangmanGameFinalVersion\\src\\hangmangamefinalversion\\2.wav");
      
            }
        });
        timerDelay.setRepeats(false);
        timerDelay.start();
        qwertyKeyboard  = new QwertyKeyboard();
        initComponents();
        Word = getWord();
        
       
        CardLayout cardlayout = new CardLayout();
        MainPanelGame mpg = new MainPanelGame(800,400,container,cardlayout,Word,keyboard ,this);
         container.add(mpg, "1");
         if(ReturnWin.getReturnWin())
         this.setVisible(false);
    }
    
    public String getWord(){
        if (GameMode.getGameMode() == "Easy"){
            EasyWord EW = new EasyWord();
        WordFromHum.setWordFromHum(EW.getWord());
        }else if(GameMode.getGameMode() == "Medium"){
            MediumWord MW = new MediumWord();
        WordFromHum.setWordFromHum(MW.getWord());
        }
        else if(GameMode.getGameMode() == "Hard"){
             HardWord HW = new HardWord();
        WordFromHum.setWordFromHum(HW.getWord());
        }
        return WordFromHum.getWordFromHum();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        keyboard = new keeptoo.KGradientPanel();
        container = new javax.swing.JPanel();
        Header = new keeptoo.KGradientPanel();
        jLabel4 = new javax.swing.JLabel();
        MinMax = new javax.swing.JPanel();
        close = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Max = new javax.swing.JPanel();
        max = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        back = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(800, 700));

        jPanel1.setLayout(new java.awt.BorderLayout());

        keyboard.setkEndColor(new java.awt.Color(25, 29, 74));
        keyboard.setkGradientFocus(700);
        keyboard.setkStartColor(new java.awt.Color(102, 0, 0));
        keyboard.setPreferredSize(new java.awt.Dimension(800, 120));

        javax.swing.GroupLayout keyboardLayout = new javax.swing.GroupLayout(keyboard);
        keyboard.setLayout(keyboardLayout);
        keyboardLayout.setHorizontalGroup(
            keyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        keyboardLayout.setVerticalGroup(
            keyboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
        );

        jPanel1.add(keyboard, java.awt.BorderLayout.PAGE_END);

        container.setBackground(new java.awt.Color(102, 0, 0));
        container.setLayout(new java.awt.CardLayout());
        jPanel1.add(container, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        Header.setBackground(new java.awt.Color(25, 29, 74));
        Header.setkEndColor(new java.awt.Color(15, 19, 75));
        Header.setkGradientFocus(700);
        Header.setkStartColor(new java.awt.Color(102, 0, 0));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/1704309121377 (1).png"))); // NOI18N

        MinMax.setBackground(new java.awt.Color(25, 29, 84));
        MinMax.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        close.setBackground(new java.awt.Color(25, 29, 74));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/delete_32px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });

        javax.swing.GroupLayout closeLayout = new javax.swing.GroupLayout(close);
        close.setLayout(closeLayout);
        closeLayout.setHorizontalGroup(
            closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        closeLayout.setVerticalGroup(
            closeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MinMax.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, -1, -1));

        Max.setBackground(new java.awt.Color(25, 29, 74));

        max.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        max.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/full_screen_32px.png"))); // NOI18N
        max.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                maxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                maxMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                maxMouseExited(evt);
            }
        });

        javax.swing.GroupLayout MaxLayout = new javax.swing.GroupLayout(Max);
        Max.setLayout(MaxLayout);
        MaxLayout.setHorizontalGroup(
            MaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(max, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        MaxLayout.setVerticalGroup(
            MaxLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(max, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MinMax.add(Max, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(25, 29, 74));

        back.setForeground(new java.awt.Color(102, 0, 0));
        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/back_32px.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        MinMax.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(622, Short.MAX_VALUE))
            .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                    .addGap(0, 650, Short.MAX_VALUE)
                    .addComponent(MinMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(HeaderLayout.createSequentialGroup()
                    .addComponent(MinMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(Header, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(800, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
   
    
      public void changeColor(JPanel hover , Color rand){
    hover.setBackground(rand);
}
public void ChangeColor(javax.swing.JLabel hover , Color rand){
    //hover.setBackground(new Color(0,0,0,0));
    hover.setForeground(rand);
    
}
    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        CustomButtonQuit customButtonExample = new CustomButtonQuit();
        customButtonExample.main(null);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        changeColor(close ,new Color(255,94,5));
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        changeColor(close ,new Color(25,29,74));
    }//GEN-LAST:event_jLabel1MouseExited

    private void maxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxMouseClicked
        if(this.getExtendedState()!=Mode.MAXIMIZED_BOTH){
            this.setExtendedState(Mode.MAXIMIZED_BOTH);

        }else
        {
            this.setExtendedState(Mode.NORMAL);

        }
    }//GEN-LAST:event_maxMouseClicked

    private void maxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxMouseEntered
        changeColor(Max ,new Color(255,94,5));
    }//GEN-LAST:event_maxMouseEntered

    private void maxMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_maxMouseExited
        changeColor(Max ,new Color(25,29,74));
    }//GEN-LAST:event_maxMouseExited

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
int result = JOptionPane.showConfirmDialog(this, "Are you sure you want to go back?");
            if (result == 0) {
                new MenuPage().setVisible(true);
        this.dispose();
            }
        
    }//GEN-LAST:event_backMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        changeColor(jPanel4 ,new Color(255,94,5));
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        changeColor(jPanel4 ,new Color(25,29,74));
    }//GEN-LAST:event_backMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainGamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGamePanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainGamePanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KGradientPanel Header;
    private javax.swing.JPanel Max;
    private javax.swing.JPanel MinMax;
    private javax.swing.JLabel back;
    private javax.swing.JPanel close;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private keeptoo.KGradientPanel keyboard;
    private javax.swing.JLabel max;
    // End of variables declaration//GEN-END:variables

    
}
