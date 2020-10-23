import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();
        DictionaryManagement.insertFromFile(dictionary);
        String choice;
        Scanner sc = new Scanner(System.in);
        boolean stop = false;
        do {
            System.out.println("NAM DEP TRAI DICTIONARY");
            System.out.println("1 - Liệt kê toàn bộ từ ");
            System.out.println("2 - Tìm từ ");
            System.out.println("3 - Xóa từ ");
            System.out.println("4 - Thêm từ ");
            System.out.println("5 - Sửa từ ");
            System.out.println("6 - Searcher ");
            System.out.println("7 - Xuất ra file");
            System.out.println("8 - Đóng chương trình");
            System.out.println("Lựa chọn từ [1-8]");
            choice = sc.nextLine();

            switch (choice) {
                case "1":
                    DictionaryCommandline.showAllWords(dictionary);
                    break;
                case "2":
                    DictionaryManagement.dictionaryLookup(dictionary);
                    break;
                case "3":
                    DictionaryManagement.dictionaryErase(dictionary);
                    break;
                case "4":
                    DictionaryManagement.dictionaryAddWord(dictionary);
                    break;
                case "5":
                    DictionaryManagement.dictionaryEdit(dictionary);
                    break;
                case "6":
                    DictionaryCommandline.dictionaryResearcher(dictionary);
                    break;
                case "7":
                    DictionaryManagement.dictionaryExport(dictionary);
                    break;
                case "8":
                    stop = true;
                default:
                    System.exit(0);
            }
            System.out.println("Bạn có muốn tiếp tục? [Y/N]");
            String decision = sc.nextLine();
            decision.toLowerCase();
            if (decision.equals("y")) {
                stop = false;
            } else {
                System.out.println("Bạn có muốn đóng chương trình? [Y/N]");
                String de2 = sc.nextLine();
                de2 = de2.toLowerCase();
                stop = de2.equals("y");
            }
        }
        while (!stop);
    }
}




