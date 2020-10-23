package sample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {

    public ArrayList<Word> insertFromFile() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\namde\\OneDrive\\Desktop\\dictionaryGPU\\data\\wordAndMeaning"));
            while (br.readLine() != null) {
                String string = br.readLine();
                String[] s;
                s = string.split("\t", 4);
                Word word = new Word(s[0], s[1], s[2], s[3]);
                super.words.add(word);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return words;
    }

}
