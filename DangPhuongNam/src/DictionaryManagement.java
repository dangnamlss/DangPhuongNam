import java.io.*;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileWriter;
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

    public static void insertFromFile (Dictionary dictionary) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("C:\\Users\\namde\\OneDrive\\Desktop\\dictionaryJava\\src\\wordAndMeaning.txt"));
            while (br.readLine() != null) {
                String string = br.readLine();
                String[] s;
                s = string.split("\t", 2);
                Word word = new Word(s[0], s[1]);
                dictionary.words.add(word);
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
    }

    public static void dictionaryAddWord(Dictionary dictionary) {
        Scanner sc = new Scanner(System.in);
        String target;
        String mean;
        System.out.println("Nhập từ bạn muốn thêm: ");
        target = sc.nextLine();
        System.out.println("Nhập nghĩa: ");
        mean = sc.nextLine();
        Word newWord = new Word(target, mean);
        dictionary.words.add(newWord);
        try {
            FileWriter fw = new FileWriter("C:\\Users\\namde\\OneDrive\\Desktop\\dictionaryJava\\src\\wordAndMeaning.txt");
            for(int j = 0; j < dictionary.words.size(); j++) {
                fw.write(dictionary.words.get(j).word_target + "\t" + dictionary.words.get(j).word_explain +"\n");
            }
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Thêm thành công");

    }

    public static void dictionaryLookup(Dictionary dictionary) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bạn muốn tìm từ nào?");
        String word = sc.nextLine();
        word = word.toLowerCase();
        boolean notExist = false;
        for (int i = 0; i < dictionary.words.size(); i++) {
            if(word.equals(dictionary.words.get(i).word_target)){
                System.out.print("Nghĩa: ");
                System.out.println(dictionary.words.get(i).word_explain);
                notExist = false;
                break;
            }
            else {
                notExist = true;
            }
        }
        if(notExist) {
            System.out.println("Từ của bạn chưa có trong từ điển ");
            System.out.println("Bạn có muốn thêm vào không?? [Y/N]");
            String decision = sc.nextLine();
            decision = decision.toLowerCase();
            if (decision.equals("y") == true) {
                dictionaryAddWord(dictionary);
                notExist = false;
            } else {
                System.out.println("Từ điển sẽ được cập nhật sớm!!");
            }
        }
    }
    public static void dictionaryErase(Dictionary dictionary) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập từ bạn muốn xóa: ");
        String wordToDelete = sc.nextLine();
        int wordCount = dictionary.words.size();
        boolean notExist = false;
        for(int i = 0; i < wordCount; i++) {
            if(dictionary.words.get(i).word_target.equals(wordToDelete)) {
                dictionary.words.remove(dictionary.words.get(i));
                System.out.println("Xóa thành công");
                try{
                    FileWriter fw = new FileWriter("C:\\Users\\namde\\OneDrive\\Desktop\\dictionaryJava\\src\\wordAndMeaning.txt");
                    for(int j = 0; j < dictionary.words.size(); j++) {
                        fw.write(dictionary.words.get(j).word_target + "\t" + dictionary.words.get(j).word_explain +"\n");
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            else {
                notExist = true;
            }
        }
        if(notExist) {
            System.out.println("Từ của bạn không có trong từ điển");
        }
    }

    public static void dictionaryEdit (Dictionary dictionary) {
        Scanner sc = new Scanner(System.in);
        String wordToEdit;
        System.out.println("Nhập từ bạn muốn sửa: ");
        wordToEdit = sc.nextLine();
        wordToEdit = wordToEdit.toLowerCase();
        boolean notExist = true;
        for(int i = 0; i < dictionary.words.size(); i++) {
            if(dictionary.words.get(i).word_target.equals(wordToEdit)) {
                System.out.println("Nhập từ mới: ");
                String newWordTarget = sc.nextLine();
                System.out.println("Nhập nghĩa: ");
                String meaning = sc.nextLine();
                dictionary.words.get(i).word_target = newWordTarget;
                dictionary.words.get(i).word_explain = meaning;
                System.out.println("Sửa thành công!");
                notExist = false;
                try {
                    FileWriter fw = new FileWriter("C:\\Users\\namde\\OneDrive\\Desktop\\dictionaryJava\\src\\wordAndMeaning.txt");
                    for(int j = 0; j < dictionary.words.size(); j++) {
                        fw.write(dictionary.words.get(j).word_target + "\t" + dictionary.words.get(j).word_explain +"\n");
                    }
                    fw.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        if(notExist) {
            System.out.println("Từ của bạn không có trong từ điển!");
        }
    }


    public static void dictionaryExport(Dictionary dictionary) throws IOException {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\namde\\OneDrive\\Desktop\\dictionaryJava\\src\\output.txt");
            int wordCount = dictionary.words.size();
            for (int i = 0; i < wordCount; i++) {
                fw.write(dictionary.words.get(i).word_target + "\t" + dictionary.words.get(i).word_explain + "\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success");
    }
}
