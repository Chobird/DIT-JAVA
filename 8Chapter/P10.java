import java.io.*;
import java.util.*;

public class P10 {
    private HashMap<String, String> phoneBook = new HashMap<>();

    public void loadPhoneBook(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("파일이 존재하지 않습니다.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int count = 0;

            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                if (tokens.length == 2) {
                    phoneBook.put(tokens[0], tokens[1]);
                    count++;
                }
            }
            System.out.println("총 " + count + "개의 전화번호를 읽었습니다.");
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }

    public void searchPhoneBook() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("이름>> ");
            String name = scanner.nextLine();

            if (name.equals("그만")) {
                break;
            }

            String phone = phoneBook.get(name);
            if (phone != null) {
                System.out.println(phone);
            } else {
                System.out.println("찾는 이름이 없습니다.");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        P10 app = new P10();
        String filePath = "c:\\temp\\phone.txt";

        app.loadPhoneBook(filePath);
        app.searchPhoneBook();
    }
}
