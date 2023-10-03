import java.util.Arrays;
public class LargestMinimumDistance {
    public static boolean canPlaceCows(int[] stalls, int C, int minDistance) {
        int count = 1;
        int lastPlaced = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastPlaced >= minDistance) {
                count++;
                lastPlaced = stalls[i];
            }
        }
        return count >= C;
    }
    public static int largestMinimumDistance(int[] stalls, int C) {
        Arrays.sort(stalls);
        int low = 0;
        int high = stalls[stalls.length - 1] - stalls[0];
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlaceCows(stalls, C, mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int N = 5; // Number of stalls
        int C = 4; // Number of cows
        int[] stalls = {1, 2, 4, 8, 9,15,20}; // Stall positions
        int largestMinDistance = largestMinimumDistance(stalls, C);
        System.out.println("Largest minimum distance: " + largestMinDistance);
    }
}