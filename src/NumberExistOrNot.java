import java.util.Scanner;

public class NumberExistOrNot {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 9, 10};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number which we have to search: ");
        int target = sc.nextInt();
        int result = searchInsert(nums, target);
        System.out.println(result);  // Output: 2
    }
}
