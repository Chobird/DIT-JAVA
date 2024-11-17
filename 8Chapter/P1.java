import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class P1 {

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        File file = new File("c:\\temp\\phone.txt");
        try {
            fileWriter = new FileWriter(file);
            Scanner scanner = new Scanner(System.in);

            System.out.println("전화번호 입력 프로그램입니다.");
            while (true) {
                System.out.print("이름 전화번호 >> ");
                String line = scanner.nextLine();
                if (line.equals("그만"))
                    break;
                fileWriter.write(line + "\r\n");
            }
            System.out.println(file.getPath() + "에 저장하였습니다.");

            scanner.close();
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
