import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 38, 27, 43, 3, 9, 82, 10 };
        System.out.println("Original Array: " + Arrays.toString(arr));
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
    public static void mergeSort(int[] A, int[] temp, int left, int right) {
        int mid;
        if (right > left) {
            mid = (right + left) / 2;
            mergeSort(A, temp, left, mid);
            mergeSort(A, temp, mid + 1, right);
            merge(A, temp, left, mid + 1, right);
        }
    }
    public static void merge(int[] A, int[] temp, int left, int mid, int right) {
        int i, left_end, size, temp_pos;
        left_end = mid - 1;
        temp_pos = left;
        size = right - left + 1;

        while ((left <= left_end) && (mid <= right)) {
            if (A[left] <= A[mid]) {
                temp[temp_pos] = A[left];
                temp_pos = temp_pos + 1;
                left = left + 1;
            } else {
                temp[temp_pos] = A[mid];
                temp_pos = temp_pos + 1;
                mid = mid + 1;
            }
        }
        while (left <= left_end) {
            temp[temp_pos] = A[left];
            left = left + 1;
            temp_pos = temp_pos + 1;
        }
        while (mid <= right) {
            temp[temp_pos] = A[mid];
            mid = mid + 1;
            temp_pos = temp_pos + 1;
        }
        for (i = 0; i < size; i++) {
            A[right] = temp[right];
            right = right - 1;
        }
    }
}