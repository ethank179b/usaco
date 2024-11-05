import java.io.*;

public class HayPile{
    public static void main(String[] args) throws IOException {
        // Reading input from the file
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));

        // First line contains the number of piles N
        int N = Integer.parseInt(br.readLine());
        int[] piles = new int[N];

        // Reading the heights of the piles
        int totalHeight = 0;
        for (int i = 0; i < N; i++) {
            piles[i] = Integer.parseInt(br.readLine());
            totalHeight += piles[i]; // Calculating total sum of the pile heights
        }

        // Target height for all piles is the average height
        int targetHeight = totalHeight / N;

        // Calculate the total number of hay bale movements
        int totalMoves = 0;
        for (int i = 0; i < N; i++) {
            // Calculate the difference between the current pile height and the target height
            int difference = piles[i] - targetHeight;
            // Add the absolute difference to totalMoves
            totalMoves += Math.abs(difference);
        }

        // Since we count both giving and receiving hay, divide the result by 2
        pw.println(totalMoves / 2);

        // Closing resources
        pw.close();
        br.close();
    }
}
