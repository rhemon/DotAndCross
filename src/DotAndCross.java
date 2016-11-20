import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rhemon on 11/20/16.
 */
public class DotAndCross {

    private static BufferedReader br;

    private static List<List<String>>  board;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Dot and Cross");
        System.out.println();

        // Prints How-Tos
        System.out.println("A simple Dot and Cross game between two players");
        System.out.println("To input for moves players must provide first row number (1,2,3) and then column letter (A, B, C), Example : 1A.");
        System.out.println();

        //Player variables
        String player1 = "";
        String player2 = "";

        // Collects player names
        while(player1.isEmpty()) {
            System.out.print("Player 1 Name (X) : ");
            player1 = br.readLine().trim();
        }
        while (player2.isEmpty()) {
            System.out.print("Player 2 Name (O) : ");
            player2 = br.readLine().trim();
        }
        System.out.println();
        System.out.println(player1  + " vs " + player2);
        System.out.println();

        // initialize board
        board = Arrays.asList(Arrays.asList("-", "-", "-"), Arrays.asList("-", "-", "-"), Arrays.asList("-", "-", "-"));
        printBoard();
        System.out.println();

        boolean game = true;
        int totalTurns = 9;
        int playerTurn = 1;
        String playerTag = "X";
        String printMessage = "";

        // Game Loop - runs till there is no winner or as long as there are turns left
        while (game && totalTurns > 0) {
            // Fixing player variables according to the turn
            if (playerTurn == 1) {
                printMessage = player1+"'s Move : ";
                playerTag = "X";
                playerTurn = 2;
            } else if (playerTurn == 2) {
                printMessage = player2+"'s Move : ";
                playerTag = "O";
                playerTurn = 1;
            }

            String rc = playerMove(printMessage);
            board.get(Integer.parseInt(String.valueOf(rc.charAt(0)))).set(Integer.parseInt(String.valueOf(rc.charAt(2))), playerTag);
            System.out.println();
            printBoard();
            System.out.println();

            // Starts looking for winner from 5th turn
            if (totalTurns <= 5) {
                String v = findWinner();
                if (v.equals("X")) {
                    System.out.println(player1 + " Wins!");
                    game = false;
                } else if (v.equals("O")) {
                    System.out.println(player2 + " Wins!");
                    game = false;
                }
            }

            totalTurns--;
        }

        // if draw
        if (game) {
            System.out.println("Draw");
        }
    }

    // Prints every row in board array in a new line
    private static void printBoard() {
        System.out.println("   A  B  C");
        int i = 1;
        for (List<String> row : board) {
            System.out.println(String.valueOf(i) + " " + row.toString());
            i++;
        }
    }

    // Returns integer index for the row
    // if invalid returns -1
    private static int decodeR(char r){
        switch (r) {
            case '1':
                return 0;
            case '2':
                return 1;
            case '3':
                return 2;
            default:
                System.out.println("Please input a proper row number");
                return -1;
        }
    }

    // Returns integer index for the columm
    // if invalid returns -1
    private static int decodeC(char c) {
        switch (c) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            default:
                System.out.println("Please input a proper column letter. It must be block letter");
                return -1;
        }
    }


    // Collects the player move and verifies it as a valid move
    // message argument is the printed string that tells which player's move it is
    private static String playerMove(String message) throws IOException{
        boolean moveNotTaken = false;
        int i = -1, j = -1;
        while ((i==-1 || j==-1) || !moveNotTaken) {
            System.out.print(message);
            String move = br.readLine();
            try {
                char r = move.charAt(0);
                char c = move.charAt(1);

                // Checking if move is within valid range
                i = decodeR(r);
                j = decodeC(c);

                // Confirming that move is not used already
                if (i != -1 && j != -1){
                    if (board.get(i).get(j).equals("-")) {
                        moveNotTaken = true;
                    } else {
                        System.out.println("Already Used");
                    }
                }
            } catch (java.lang.StringIndexOutOfBoundsException e) {
                System.out.println("Must provide both row and column");
            }

        }
        return String.valueOf(i) + "," +String.valueOf(j);
    }

    private static String findWinner() {
        // check row wise
        for (List<String> row : board) {
            if (row.get(0) == row.get(1) && row.get(1) == row.get(2)) {
                return row.get(0);
            }
        }
        // check column wise
        for (int i = 0; i<3; i++) {
            if (board.get(0).get(i) == board.get(1).get(i) && board.get(1).get(i) == board.get(2).get(i)) {
                return board.get(0).get(i);
            }
        }
        // check diagonally
        if (board.get(0).get(0) == board.get(1).get(1) && board.get(1).get(1) == board.get(2).get(2)) {
            return board.get(0).get(0);
        }
        if (board.get(0).get(2) == board.get(1).get(1) && board.get(1).get(1) == board.get(2).get(0)){
            return board.get(0).get(2);
        }

        return "";
    }
}
