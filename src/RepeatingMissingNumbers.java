public class RepeatingMissingNumbers {
    public static int[] findRepeatingAndMissing(int[] nums) {
        int n = nums.length;
        long sumOfSquares = 0;
        long sumOfActual = 0;
        for (int i = 0; i < n; i++) {
            long num = nums[i];
            sumOfSquares += ((long) num * (long) num);
            sumOfActual += num;
        }
        long expectedSumOfSquares = (long) n * (n + 1) * (2 * n + 1) / 6;
        long expectedSumOfActual = (long) n * (n + 1) / 2;

        long diffSumOfSquares = expectedSumOfSquares - sumOfSquares;
        long diffSumOfActual = expectedSumOfActual - sumOfActual;
        long sumOfAB = diffSumOfSquares / diffSumOfActual;
        int repeating = (int) ((sumOfAB + diffSumOfActual) / 2);
        int missing = (int) (repeating - diffSumOfActual);
        return new int[]{repeating, missing};
    }
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 1, 5};
        int[] result = findRepeatingAndMissing(nums);
        System.out.println("Repeating number: " + result[0]);
        System.out.println("Missing number: " + result[1]);
    }
}