import java.util.Arrays;
public class Candies {
    public static int minimumCandies(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        for(int candy : candies){
            System.out.print(candy+" ");
        }
        System.out.println();
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        return totalCandies;
    }
    public static void main(String[] args) {
        int[] ratings = {3, 4, 5, 2, 1, 3, 2, 4};
        int minimumCandies = minimumCandies(ratings);
        System.out.println("Minimum number of candies required: " + minimumCandies);
    }
}
