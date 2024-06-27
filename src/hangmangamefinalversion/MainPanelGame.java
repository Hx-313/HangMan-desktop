/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmangamefinalversion;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.*;
import keeptoo.KGradientPanel;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Hx Abdullah
 */
public class MainPanelGame extends JPanel implements ActionListener {
    
    
    private char[] guessedLetters ;
    private Image[] gallows = new Image[7];
    private int numOfGuesses;
    private boolean gameOver;
    private WordSplitter wordS;
    private String wordToGuess;
    private QwertyKeyboard qwertyKeyboard;
    private int tries = 0;
    private Image Roo ;
    boolean win = false;
   
    JFrame frame;
    
    MainPanelGame(int WIDTH,int HEIGHT,JPanel container,CardLayout cardlauoyt,String Word,KGradientPanel keyboard , JFrame frame ){
        this.qwertyKeyboard =new QwertyKeyboard(); 
        this.frame = frame;
        Roo = new ImageIcon("C:\\Users\\Hx Abdullah\\Documents\\NetBeansProjects\\mpl semester\\HangmanGameFinalVersion\\src\\Icon\\stunned-boy-cartoon-character-free-vector (2).png").getImage();  
        addActionListenerToQwertyKeyboard();
        wordToGuess = Word;
        wordS = new WordSplitter(wordToGuess);
        this.setBackground(new Color(102,0,0));
         numOfGuesses=6;
         container.setBackground(new Color(102,0,0));
         guessedLetters = new char[wordS.getLettersInWord().length];
         keyboard.setLayout(new GridLayout(3, 9));
        qwertyKeyboard.displayButtons(keyboard);
         System.out.println(wordToGuess);
           try{
        for(int i=0;i<=numOfGuesses;i++){
            Image img = new ImageIcon("C:\\Users\\Hx Abdullah\\Documents\\NetBeansProjects\\mpl semester\\HangmanGameFinalVersion\\src\\Gallows\\Gallows" + i + ".gif").getImage();
            this.gallows[i] = img;
           
        }
         }catch(Exception e){
         }
            this.gameOver=false;
    }
    
    @Override
     public void paintComponent(Graphics g) {

        Graphics2D g2D = (Graphics2D) g.create();
        super.paintComponent(g2D);

        char[] wordToChar = this.wordS.getLettersInWord();
        int space = 10;
        int placeholderLength = this.calculatePlaceholderLength(this.wordS.getWord(), space);
        int x1 = this.calculateX1(placeholderLength, this.wordS.getWord(), space);
        int y1 = 300/ 2 + 240;
        int x2 = x1 + placeholderLength;
        int y2 = y1;
        int fontSize = this.calculatePlaceholderLength(this.wordS.getWord(), space);
        
        Font font = fonting(fontSize);

        int gallowsX = (800/ 2) - this.gallows[0].getWidth(null) / 2;
        int gallowsY = 5;
        g2D.drawImage(Roo,620,90,null);
        g2D.drawImage(this.gallows[(this.numOfGuesses - 6) * -1], gallowsX, gallowsY, null);

        g2D.setPaint(Color.WHITE);
        g2D.setStroke(new BasicStroke(5));
        g2D.setFont(font);

        this.drawLetterPlaceholders(g2D, wordToChar, x1, y1, x2, y2, space, placeholderLength);

        this.drawGuessedLetters(g2D, x1, y1, x2, space, placeholderLength);

        if (this.gameOver && !this.guessedWordEqualsWord()) {
            this.drawMissingLetters(g2D, x1, y1, x2, space, placeholderLength);
        }

        if (this.gameOver) {
            this.drawGameOverText(g2D);
            GameStats.setTries(this.tries);
            
             Timer timer = new Timer(1500, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ReturnWin.setReturnWin(true);
                    if(GameStats.getName() ==null){
                        
                    new NewJFrame(frame).setVisible(true);
                   
                }else{
                         new FinalScreen(frame).setVisible(true);
                         frame.setVisible(false);
                    }
                }
            });
            timer.setRepeats(false);
            timer.start();
            
        }
    }
     
     public Font fonting(int Font_size){
        Font customFont ;
         try {
            // Replace "YourCustomFontName" with the actual font name
           InputStream fontStream = getClass().getResourceAsStream("/Fonts/Nosifer-Regular.ttf");
             customFont = Font.createFont(Font.TRUETYPE_FONT,fontStream).deriveFont(Font.PLAIN, Font_size);
                     return customFont;

            // Apply the custom font to the JLabe
        } catch (FontFormatException | IOException e) {
        return null;
                }
    }
     
     private void addActionListenerToQwertyKeyboard() {
        for (QwertyButton qwertyButton : qwertyKeyboard.getButtons()) {
            qwertyButton.addActionListener(this);
             qwertyButton.addMouseListener(new MouseAdapter(){
              @Override
              public void mouseEntered(MouseEvent e)  {
                 if(!qwertyButton.getWin()){
                  qwertyButton.setBackground(new Color(255,94,5));
                 }
              }
              @Override
              public void mouseExited(MouseEvent e){
                 if(!qwertyButton.getWin()){
                 
                  qwertyButton.setBackground(new Color(25,29,74));
                  
                 }
                  
              }
            });
        }
    }
     
    private void drawLetterPlaceholders(Graphics2D g2D, char[] wordToChar, int x1, int y1, int x2, int y2, int space, int placeholderLength) {

        int placeholderX1 = x1;
        int placeholderX2 = x2;
        int placeholderY1 = y1;
        int placeholderY2 = y2;

        for (int i=0; i<wordToChar.length; i++) {
            char ch = wordToChar[i];
            int charX = placeholderX1 + (placeholderLength / 2) - (g2D.getFontMetrics().stringWidth(String.valueOf(ch).toUpperCase()) / 2);
            int charY = placeholderY1 - 10;

            if (String.valueOf(ch).matches("[a-zA-Z0-9]")) {
                g2D.drawLine(placeholderX1, placeholderY1, placeholderX2, placeholderY2);
            }
            else {
                g2D.drawString(String.valueOf(ch).toUpperCase(), charX, charY);
            }

            placeholderX1 = placeholderX2 + space;
            placeholderX2 = placeholderX1 + placeholderLength;
        }
    }

    private void drawGuessedLetters(Graphics2D g2D, int x1, int y1, int x2, int space, int placeholderLength) {

        int charX1 = x1;
        int charX2 = x2;

        for (int i=0; i<this.guessedLetters.length; i++) {
            char ch = this.guessedLetters[i];
            int x = charX1 + (placeholderLength / 2) - (g2D.getFontMetrics().stringWidth(String.valueOf(ch).toUpperCase()) / 2);
            int y = y1 - 10;

            if (String.valueOf(ch).matches("[a-zA-Z0-9]")) {
                g2D.drawString(String.valueOf(ch).toUpperCase(), x, y);
            }
            charX1 = charX2 + space;
            charX2 = charX1 + placeholderLength;
        }
    }

    private void drawMissingLetters(Graphics2D g2D, int x1, int y1, int x2, int space, int placeholderLength) {

        g2D.setPaint(Color.RED);

        int charX1 = x1;
        int charX2 = x2;

        for (int i=0; i<this.wordS.getLettersInWord().length; i++) {
            char ch = this.wordS.getLettersInWord()[i];
            int x = charX1 + (placeholderLength / 2) - (g2D.getFontMetrics().stringWidth(String.valueOf(ch).toUpperCase()) / 2);
            int y = y1 - 10;

            if (String.valueOf(ch).matches("[a-zA-Z0-9]") && this.guessedLetters[i] != this.wordS.getLettersInWord()[i]) {
                g2D.drawString(String.valueOf(ch).toUpperCase(), x, y);
            }
            charX1 = charX2 + space;
            charX2 = charX1 + placeholderLength;
        }
    }

    private String gameOverText() {

        return this.gameOver && this.guessedWordEqualsWord() ? "Congratulation ... You win(:" : "YOU LOSE!... Hard Luck  :(";
    }

    private void drawGameOverText(Graphics2D g2D) {

        String text = this.gameOverText();
        String fontName = g2D.getFont().getFontName();
        int fontSize = 50;
        Font font = new Font(fontName, Font.BOLD, fontSize);
        g2D.setFont(font);

        int textX = (800 / 2) - (g2D.getFontMetrics().stringWidth(text) / 2);
        int textY = (500/ 2) - (g2D.getFontMetrics().getHeight() / 2);

        if (text.equals("Congratulation ... You win(:")) {
            g2D.setPaint(Color.GREEN);
        }
        else {
            g2D.setPaint(Color.red);
        }
        g2D.drawString(text, textX, textY);
    }

    private int calculatePlaceholderLength(String word, int space) {
        /*
        Calculates the length of the letter placeholder based on the screen width, space between placeholders and the
        length of the word to dynamically adjust the placeholder size to fit the screen.
         */

        int placeholderLength;
        if (word.length() <= 10) {
            placeholderLength = ((800 - 40) / 10) - space;
        }
        else {
            placeholderLength = ((800 - 20) / word.length()) - space;
        }
        return placeholderLength;
    }

    private int calculateX1(int placeholderLength, String word, int space) {

        int x = (800/ 2) - ((placeholderLength * word.length() + space * (word.length() + 1)) / 2);
        return x;
    }

    private boolean checkLetter(char buttonValue) {

        for (int i=0; i<this.guessedLetters.length; i++) {
            if (buttonValue == wordS.getLettersInWord()[i]) {
                
                return true;
            }
        }
        return false;
    }

    private void updateLetters(char buttonValue) {

        for (int i=0; i<this.guessedLetters.length; i++) {
            if (buttonValue == this.wordS.getLettersInWord()[i]) {
                this.guessedLetters[i] = this.wordS.getLettersInWord()[i];
            }
        }
    }

    private void updateScreen(QwertyButton qwertyButton) {
        Color color;

        boolean letterInWord = checkLetter(qwertyButton.getValue());
       
       if (letterInWord) {
           
           updateLetters(qwertyButton.getValue());
            color = Color.green;
        }
        else {
            this.numOfGuesses--;
            tries++;
            color = Color.red;
        }
       
       qwertyButton.setEnabled(false);
       qwertyButton.setBackground(color);
       qwertyButton.setForeground(Color.BLACK);
       win = true;
       qwertyButton.setWin(win);
       
        repaint();
    }

    private void checkForWin() {

        if (this.numOfGuesses == 0) {
            this.qwertyKeyboard.disableKeyboard();
            this.gameOver = true;
        }

        if (this.guessedWordEqualsWord()) {
            this.qwertyKeyboard.disableKeyboard();
            this.gameOver = true;
        }
    }

    private boolean guessedWordEqualsWord() {

        String word = this.wordS.getWord();
        String guessedWord = String.valueOf(this.guessedLetters);

        return guessedWord.equals(word);
    }

   

    public void setRandomWord(WordSplitter word) {
        this.wordS = word;
    }

    public void setGuessedLetters(WordSplitter word) {
        char[] wordToChar = word.getLettersInWord();
        this.guessedLetters = new char[wordToChar.length];

        for (int i=0; i<wordToChar.length; i++) {
            if (!String.valueOf(wordToChar[i]).matches("[a-zA-Z0-9]")) {
                this.guessedLetters[i] = wordToChar[i];
            }
        }
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
     
        for (QwertyButton qwertyButton : this.qwertyKeyboard.getButtons()) {
            
            if (e.getSource() == qwertyButton) {

                this.updateScreen(qwertyButton);
                this.checkForWin();
            }
        }
    }
}


   

