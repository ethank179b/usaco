import java.util.*;
/*
1. Parse the Input: Get N (number of cows) and B (budget).
2. Store Prices and Shipping Costs: Store each cow's gift cost and shipping as (price, shipping).
3. Consider Coupon Application:
   - Calculate the total cost for each cow with and without the coupon.
   - For each cow, if using the coupon on their gift, the cost becomes (price / 2) + shipping, otherwise it’s price + shipping.
4. Sorting Strategy:
   - Sort by the total cost without the coupon.
5. Calculate Maximum Gifts:
   - Try applying the coupon to each cow, calculate the remaining budget, and then check the total number of cows that can be gifted within the budget by including as many other cows as possible in ascending order of cost.
6. Return the Maximum Count of Cows Gifted.

 */
public class CowGifts {

    /*
    1. Loop through each cow to apply the coupon, calculate the modified cost list, and determine how many gifts can fit within the budget.
    2. Sorting and Counting: For each coupon application scenario, sort the costs and sum up until the budget B is exceeded.
    3. Maximization: Track the highest number of cows that can receive gifts based on these scenarios.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input N (number of cows) and B (budget)
        int N = scanner.nextInt();
        long B = scanner.nextLong();

        // Arrays to store prices and shipping costs
        int[] prices = new int[N];
        int[] shippings = new int[N];

        for (int i = 0; i < N; i++) {
            prices[i] = scanner.nextInt();
            shippings[i] = scanner.nextInt();
        }

        // List to store total costs without coupon
        ArrayList<Long> costs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            costs.add((long) prices[i] + shippings[i]);
        }

        // Try using the coupon on each cow to maximize the count of gifts
        int maxGifts = 0;

        for (int i = 0; i < N; i++) {
            // Calculate the cost if we use the coupon on the i-th cow
            long couponCost = (prices[i] / 2) + shippings[i];

            // Collect other costs without the coupon
            ArrayList<Long> otherCosts = new ArrayList<>(costs);
            otherCosts.set(i, couponCost);

            // Sort the costs and try to fit as many as possible within the budget B
            Collections.sort(otherCosts);

            long totalCost = 0;
            int giftCount = 0;

            for (long cost : otherCosts) {
                totalCost += cost;
                if (totalCost > B) break; // Stop if we exceed the budget
                giftCount++;
            }

            maxGifts = Math.max(maxGifts, giftCount); // Track the maximum number of gifts
        }

        // Output the result
        System.out.println(maxGifts);

        scanner.close();
    }
}