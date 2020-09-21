import java.util.Scanner;
public class DictionaryManagement {
    public static void insertFromCommandLine(Dictionary dictionary) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int i = 0;
        while(i < n){
            String _target = sc.nextLine();
            String _explain = sc.nextLine();
            Word word = new Word(_target, _explain);
            dictionary.words.add(word);
            i++;
        }
    }
}
