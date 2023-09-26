public class SubsetSum {
    // Function to find all subsets with the given sum
    public static void findSubsets(int[] arr, int targetSum) {
        boolean[] include = new boolean[arr.length];
        findSubsetsUtil(arr, include, 0, 0, targetSum);
    }
    // Utility function to recursively find subsets
    private static void findSubsetsUtil(int[] arr, boolean[] include, int
            currentIndex, int currentSum, int targetSum) {
        if (currentSum == targetSum) {
// Print the subset
            printSubset(arr, include);
        }
        if (currentIndex == arr.length || currentSum >= targetSum) {
            return;
        }
// Include the current element in the subset
        include[currentIndex] = true;
        findSubsetsUtil(arr, include, currentIndex + 1,currentSum +
                arr[currentIndex], targetSum);
// Exclude the current element from the subset
        include[currentIndex] = false;
        findSubsetsUtil(arr, include, currentIndex + 1,currentSum, targetSum);
    }
    private static void printSubset(int[] arr, boolean[] include) {
        System.out.print("Subset: ");
        for (int i = 0; i < arr.length; i++) {
            if (include[i]) {
                System.out.print(arr[i] + " ");
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int targetSum = 8;
        findSubsets(arr, targetSum);
    }
}