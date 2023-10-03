import java.util.Scanner;
public class FindDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Move slow by one step and fast by two steps until they meet in the cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // Move slow to the start and move both slow and fast by one step until they meet again
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow; // The meeting point is the duplicate number
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array (N+1): ");
        int n = scanner.nextInt();
        int[] nums = new int[n + 1];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i <= n; i++) {
            nums[i] = scanner.nextInt();
        }

        int duplicate = findDuplicate(nums);
        System.out.println("The duplicate number is: " + duplicate);
    }
}