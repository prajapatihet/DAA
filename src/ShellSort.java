public class ShellSort {
    public static void shellSort(int[] arr) {
        int n = arr.length;
        // Calculate the initial value of h (gap)
        int h = 1;
        while (h <= n / 9) {
            h = 3 * h + 1;
        }
        // Start the sorting process with decreasing value of h
        while (h > 0) {
            // Perform insertion sort for the current gap value h
            for (int i = h; i < n; i++) {
                int valueToInsert = arr[i];
                int j = i;
                // Shifting elements that are greater than valueToInsert
                while (j >= h && arr[j - h] > valueToInsert) {
                    arr[j] = arr[j - h];
                    j -= h;
                }
                // Place valueToInsert in its correct position
                arr[j] = valueToInsert;
            }
            // Reduce the gap for the next iteration
            h = h / 3;
        }
    }
    public static void main(String[] args) {
        int[] arr = {45, 23, 78, 11, 56, 89, 37, 99, 31, 5};
        System.out.println("Original array:");
        printArray(arr);
        shellSort(arr);
        System.out.println("\nSorted array:");
        printArray(arr);
    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}