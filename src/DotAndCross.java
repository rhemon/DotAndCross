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

        System.out.print("Player 1 Name (X) : ");
        String player1 = br.readLine();


        System.out.print("Player 2 Name (O) : ");
        String player2 = br.readLine();

        System.out.println();
        System.out.println(player1  + " vs " + player2);
        System.out.println();

        board = Arrays.asList(Arrays.asList("-", "-", "-"), Arrays.asList("-", "-", "-"), Arrays.asList("-", "-", "-"));
        printBoard();

        boolean game = true;
        int totalTurns = 9;
        int playerTurn = 1;

        while (game) {
            playerMove();
            break;
        }
    }

    private static void printBoard() {
        System.out.println("   A  B  C");
        int i = 1;
        for (List<String> row : board) {
            System.out.println(String.valueOf(i) + " " + row.toString());
            i++;
        }
    }

    private static void playerMove() throws IOException{
        boolean rClear = false, cClear = false;
        while ((!rClear || !cClear)) {
            System.out.print("Player 1 Move : ");
            String move = br.readLine();
            char r = move.charAt(0);
            char c = move.charAt(1);
            if ((r=='1' || r=='2' || r=='3')) {
                rClear = true;
            } else {
                System.out.println("Please input a proper row number");
            }
            if ((c=='A' || c=='B' || c=='C')) {
                cClear = true;
            } else {
                System.out.println("Please input a proper column letter (make sure it's block letter");
            }
        }

    }
}
