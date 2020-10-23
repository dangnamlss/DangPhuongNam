import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class DictionaryCommandline {
    static void showAllWords(Dictionary dictionary){
        System.out.println ("No   | English        | Vietnamese        ");
        int n = dictionary.words.size();
        for(int i = 0; i < n; i ++){
            System.out.printf("%-5d", i+1);
            System.out.print("| ");
            System.out.printf("%-15s", dictionary.words.get(i).word_target);
            System.out.print("| ");
            System.out.printf("%s", dictionary.words.get(i).word_explain);
            System.out.print("\n");
        }
    }

    static void dictionaryBasic(Dictionary dictionary){
        DictionaryManagement.insertFromCommandLine(dictionary);
        DictionaryCommandline.showAllWords(dictionary);
    }

    static void dictionaryAdvanced(Dictionary dictionary) throws IOException {
        DictionaryManagement.insertFromFile(dictionary);
        DictionaryCommandline.showAllWords(dictionary);
        DictionaryManagement.dictionaryLookup(dictionary);
    }

    public static void dictionaryResearcher (Dictionary dictionary) {
        System.out.println("Nhập vào từ muốn tìm: ");
        Scanner sc = new Scanner(System.in);
        String wordToFind = sc.nextLine();
        String list = "";

        for(int i = 0; i < dictionary.words.size(); i++) {
            if(dictionary.words.get(i).word_target.startsWith(wordToFind)) {
                list += dictionary.words.get(i).word_target + "\n";
            }
        }
        System.out.println(list);
    }
}
