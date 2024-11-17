import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class P4 {

    public static void main(String[] args) {
        String filePath = "c:\\windows\\system.ini";
        System.out.println(filePath + " 파일을 읽어 출력합니다");

        try (Scanner fScanner = new Scanner(new FileReader(filePath))) {
            int lineNumber = 1;
            while (fScanner.hasNextLine()) {
                String line = fScanner.nextLine();
                System.out.printf("%4d: %s%n", lineNumber, line);
                lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
