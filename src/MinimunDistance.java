import java.util.*;
public class MinimunDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Number of stalls
        int C = sc.nextInt(); // Number of cows
        int[] positions = new int[N];
        for (int i = 0; i < N; i++) {
            positions[i] = sc.nextInt();
        }
        Arrays.sort(positions);
        int left = 1; // Minimum possible distance between cows
        int right = positions[N - 1] - positions[0]; // Maximum possible distance between cows
        int result = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canPlaceCows(positions, C, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
    private static boolean canPlaceCows(int[] positions, int C, int distance) {
        int cowsPlaced = 1;
        int lastPosition = positions[0];
        for (int i = 1; i < positions.length; i++) {
            if (positions[i] - lastPosition >= distance) {
                cowsPlaced++;
                lastPosition = positions[i];
            }
        }
        return cowsPlaced >= C;
    }
}
