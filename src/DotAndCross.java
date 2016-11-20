import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by rhemon on 11/20/16.
 */
public class DotAndCross {

    private static BufferedReader br;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Dot and Cross");
        System.out.println();

        System.out.print("Player 1 Name : ");
        String player1 = br.readLine();


        System.out.print("Player 2 Name : ");
        String player2 = br.readLine();

        System.out.println();
        System.out.println(player1  + " vs " + player2);

    }
}
