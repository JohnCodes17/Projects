
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tic_tac_toe {
    static ArrayList<Integer> playerMoves = new ArrayList<>();
    static ArrayList<Integer> computerMoves = new ArrayList<>();

    public static void main(String[] args) {
        char[][] board = { { ' ', '|', ' ', '|', ' ' },
                { '-', '|', '-', '|', '-' },
                { ' ', '|', ' ', '|', ' ' },
                { '-', '|', '-', '|', '-' },
                { ' ', '|', ' ', '|', ' ' } };

        Random random = new Random();
        printboard(board);
        char pPiece = 'X';
        char cPiece = 'O';

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Make a move: (1:9)");
            int playerPiece = scanner.nextInt();
            while (true) {
                if (computerMoves.contains(playerPiece) || playerMoves.contains(playerPiece)) {
                    System.out.println("Taken Try again");
                    System.out.println("Make a move: (1:9)");
                    playerPiece = scanner.nextInt();
                } else {
                    break;
                }
            }
            insertMove(playerPiece, board, pPiece);
            playerMoves.add(playerPiece);
            printboard(board);
            System.out.println();
            String result = winCheck();
            if (computerMoves.size() + playerMoves.size() == 9) {
                System.out.println("tie");
                break;
            } else if (!result.isEmpty()) {
                System.out.println(result);
                break;
            }

            int compPiece = random.nextInt(9) + 1;
            while (true) {
                if (playerMoves.contains(compPiece) || computerMoves.contains(compPiece)) {
                    compPiece = random.nextInt(9) + 1;
                } else {
                    break;
                }
            }
            insertMove(compPiece, board, cPiece);
            computerMoves.add(compPiece);
            printboard(board);
            result = winCheck();
            if (computerMoves.size() + playerMoves.size() == 9) {
                System.out.println("tie");
                break;
            } else if (!result.isEmpty()) {
                System.out.println(result);
                break;
            }

        }
    }

    public static void printboard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            System.out.println(board[i]);
        }
    }

    public static String winCheck() {
        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);
        List topColumn = Arrays.asList(1, 4, 7);
        List middleColumn = Arrays.asList(2, 5, 8);
        List bottomColumn = Arrays.asList(3, 6, 9);
        List diagnol1 = Arrays.asList(1, 5, 9);
        List diagnol2 = Arrays.asList(3, 5, 7);

        ArrayList<List> winningMoves = new ArrayList<>();
        winningMoves.add(topRow);
        winningMoves.add(middleRow);
        winningMoves.add(bottomRow);
        winningMoves.add(topColumn);
        winningMoves.add(middleColumn);
        winningMoves.add(bottomColumn);
        winningMoves.add(diagnol1);
        winningMoves.add(diagnol2);

        for (List l : winningMoves) {
            if (playerMoves.containsAll(l)) {
                return "You Win!";
            } else if (computerMoves.containsAll(l)) {
                return "Computer Wins!";
            }
        }
        return "";
    }

    public static void insertMove(int position, char[][] array, char piece) {
        if (position == 1) {
            array[0][0] = piece;
        } else if (position == 2) {
            array[0][2] = piece;
        } else if (position == 3) {
            array[0][4] = piece;
        } else if (position == 4) {
            array[2][0] = piece;
        } else if (position == 5) {
            array[2][2] = piece;
        } else if (position == 6) {
            array[2][4] = piece;
        } else if (position == 7) {
            array[4][0] = piece;
        } else if (position == 8) {
            array[4][2] = piece;
        } else {
            array[4][4] = piece;
        }
    }

}