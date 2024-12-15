import java.util.Scanner;

public class FindWord {
    private final static int ROWS = 5;
    private final static int COLS = 5;
    private final static char BASE_CHAR = '-';
    private char [][] board = new char[ROWS][COLS];

    public FindWord() {
        clearBoard();
    }

    private void clearBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = BASE_CHAR;
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void put(int row, int col, int dir, String word) {
        switch (dir) {
            case 0:
                for (int i = 0; i < word.length(); i++) {
                    board[row][col] = word.charAt(i);
                    row--;
                }
                break;
            case 1:
                for (int i = 0; i < word.length(); i++) {
                    board[row][col] = word.charAt(i);
                    row--; col++;
                }
                break;
            case 2:
                for (int i = 0; i < word.length(); i++) {
                    board[row][col] = word.charAt(i);
                    col++;
                }
                break;
            case 3:
                for (int i = 0; i < word.length(); i++) {
                    board[row][col] = word.charAt(i);
                    row++; col++;
                }
                break;
            case 4:
                for (int i = 0; i < word.length(); i++) {
                    board[row][col] = word.charAt(i);
                    row++;
                }
                break;
            case 5:
                for (int i = 0; i < word.length(); i++) {
                    board[row][col] = word.charAt(i);
                    row++; col--;
                }
                break;
            case 6:
                for (int i = 0; i < word.length(); i++) {
                    board[row][col] = word.charAt(i);
                    col--;
                }
                break;
            case 7:
                for (int i = 0; i < word.length(); i++) {
                    board[row][col] = word.charAt(i);
                    row--; col--;
                }
                break;
        }
    }

    private boolean isPossible(int row, int col, int dir, int length) {
        int rowSpan = 0;
        int colSpan = 0;
        switch (dir) {
            case 0:
                rowSpan = row + 1;
                return rowSpan >= length;
            case 1:
                rowSpan = row + 1;
                colSpan = board[row].length - col;
                return rowSpan >= length && colSpan >= length;
            case 2:
                colSpan = board[row].length - col;
                return colSpan >= length;
            case 3:
                rowSpan = board.length - row;
                colSpan = board[row].length - col;
                return rowSpan >= length && colSpan >= length;
            case 4:
                rowSpan = board.length - row;
                return rowSpan >= length;
            case 5:
                rowSpan = board.length - row;
                colSpan = col + 1;
                return rowSpan >= length && colSpan >= length;
            case 6:
                colSpan = col + 1;
                return colSpan >= length;
            case 7:
                rowSpan = row + 1;
                colSpan = col + 1;
                return rowSpan >= length && colSpan >= length;
            default:
                return false;
        }
    }

    private void place(String word) {
        while (true) {
            int row = (int)(Math.random() * board.length);
            int col = (int)(Math.random() * board[row].length);

            int[] dir = new int[8];
            int index = (int)(Math.random() * 8);
            for (int i = 0; i < 8; i++) {
                dir[index] = i;
                index = (index + 1) % 8;
            }

            for (int i = 0; i < 8; i++) {
                if (isPossible(row, col, dir[i], word.length())) {
                    put(row, col, dir[i], word);
                    return;
                }
            }
        }
    }

    private void fill() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == BASE_CHAR) {
                    board[i][j] = (char)(Math.random() * 26 + 'a');
                }
            }
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("단어>> ");
            String word = scanner.next();
            if (word.equals("그만"))
                break;
            else if (word.length() > COLS || word.length() > ROWS) {
                System.out.println("단어가 보드 크기보다 깁니다.");
                continue;
            }
            clearBoard();
            place(word);
            fill();
            printBoard();
        }

        scanner.close();
    }

    public static void main(String[] args) {
        FindWord we = new FindWord();
        we.run();
    }
}
