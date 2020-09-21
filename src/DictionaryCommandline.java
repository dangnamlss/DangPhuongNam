import java.util.ArrayList;
public class DictionaryCommandline {
    static void showAllWords(Dictionary dictionary){
        System.out.println ("No   | English        | Vietnamese        ");
        int n = dictionary.words.size();
        for(int i = 0; i < n; i ++){
        /*    System.out.print(i+1);
            System.out.print("    | ");
            System.out.print(dictionary.words.get(i).word_target);
            System.out.print("        | ");
            System.out.print(dictionary.words.get(i).word_explain);
            System.out.print("\n");

         */
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
}
