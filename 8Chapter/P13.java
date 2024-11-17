import java.io.File;
import java.util.Scanner;

public class P13 {
    private File currentDir = null;
    private File[] subFiles = null;

    public P13(String dirName) {
        currentDir = new File(dirName);
    }

    private void showSubDirectories() {
        System.out.println("\t[" + currentDir.getPath() + "]");
        subFiles = currentDir.listFiles();
        for (File f : subFiles) {
            System.out.print((f.isFile() ? "file" : "dir"));
            System.out.printf("%-15s", "\t\t" + f.length() + "바이트");
            System.out.println("\t\t" + f.getName());
        }
    }

    private boolean contains(String filename) {
        for (File f : subFiles) {
            if (f.getName().equalsIgnoreCase(filename))
                return true;
        }
        return false;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** 파일 탐색기입니다. *****");
        showSubDirectories();

        while (true) {
            System.out.print(">>");
            String command = scanner.nextLine().trim();
            if (command.equals("그만"))
                break;
            if (command.equals("..")) {
                String parentPath = currentDir.getParent();
                if (parentPath == null)
                    continue;
                else {
                    currentDir = new File(parentPath);
                    showSubDirectories();
                }
            }
            else {
                if (contains(command)) {
                    File selected = new File(currentDir, command);
                    if (selected.isDirectory()) {
                        currentDir = selected;
                        showSubDirectories();
                    }
                    else {
                        System.out.println("\t디렉터리가 아닙니다.!");
                    }
                }
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        P13 fe = new P13("c:\\");
        fe.run();
    }
}
