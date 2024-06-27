/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hangmangamefinalversion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateRandomWord {


    public  static String RandomWord(String filePath) throws IOException {
        List<String> wordList = readWordsFromFile(filePath);

        if (!wordList.isEmpty()) {
            String randomWord = getRandomWord(wordList);
            return randomWord;
        } else {
            return "empty";
        }
    }

    private static List<String> readWordsFromFile(String filePath) throws IOException {
        List<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception as needed
        }

        return words;
    }

    private static String getRandomWord(List<String> wordList) {
        Random random = new Random();
        int randomIndex = random.nextInt(wordList.size());
        return wordList.get(randomIndex);
    }
    
}
