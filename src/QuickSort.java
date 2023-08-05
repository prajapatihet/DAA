import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
        System.out.println("Original Array: " + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
    public static void quickSort(int[] A, int low, int high) {
        if (low < high) {
            int pivot = partition(A, low, high);
            quickSort(A, low, pivot - 1);
            quickSort(A, pivot + 1, high);
        }
    }
    private static int partition(int[] A, int low, int high) {
        int pivot_item = A[low];
        int left = low + 1;
        int right = high;
        while (left <= right) {
            // Move left while item <= pivot
            while (left <= right && A[left] <= pivot_item) {
                left++;
            }
            // Move right while item > pivot
            while (left <= right && A[right] > pivot_item) {
                right--;
            }
            if (left < right) {
                swap(A, left, right);
            }
        }
        // right is the final position for the pivot
        A[low] = A[right];
        A[right] = pivot_item;
        return right;
    }
    private static void swap(int[] A, int left, int right) {
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}