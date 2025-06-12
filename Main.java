import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create a BufferedReader object to read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter somethings");

        // Read a single line of input as a String
        String input = br.readLine();

        // Print the input
        System.out.println("You entered: " + input);
    }
}
