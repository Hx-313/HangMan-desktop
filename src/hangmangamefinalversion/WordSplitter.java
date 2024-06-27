/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmangamefinalversion;

/**
 *
 * @author Hx Abdullah
 */
public class WordSplitter {
    
   private String word;
    private char[] lettersInWord;

    public WordSplitter(String word) {
        this.word = word;
        splitWordToLetters();
    }

    public void splitWordToLetters() {
        /*
        Splits the word into letters for comparison against letter clicked on keyboard
         */

        this.lettersInWord = this.word.toCharArray();
    }

    public char[] getLettersInWord() {
        return this.lettersInWord;
    }
    public String getWord(){
        return word;
    }
}
