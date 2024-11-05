import java.util.Scanner;

public class HayPile2 {
    public static void main(String[] args) {
        // Use the Scanner object to receive input
        System.out.println("Input:");
        Scanner scanner = new Scanner(System.in);

        // Read the number of piles N from the first input line
        int N = scanner.nextInt();
        int[] piles = new int[N];

        // Variable to store the total height of all piles
        int totalHeight = 0;

        // Read the height of each pile, store it in the array, and calculate the total height
        for (int i = 0; i < N; i++) {
            piles[i] = scanner.nextInt();
            totalHeight += piles[i];  // Sum up the heights of each pile
        }

        // Target height: the height that all piles should reach
        int targetHeight = totalHeight / N;

        // Variable to store the total number of hay bales to move
        int totalMoves = 0;

        // Calculate the difference between each pile's height and the target height to determine how much hay needs to be moved
        for (int i = 0; i < N; i++) {
            int difference = piles[i] - targetHeight;  // Calculate the difference
            totalMoves += Math.abs(difference);        // Add the absolute value to the total number of moves
        }

        System.out.println("Output:");
        // The total number of moves should be divided by 2 (since moving hay affects both piles)
        System.out.println(totalMoves / 2);

        // Close the Scanner object
        scanner.close();
    }
}
