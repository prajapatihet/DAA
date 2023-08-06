public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;
        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        // Extract elements from the heap one by one and place them at the end
        for (int i = n - 1; i > 0; i--) {
            // Swap root (max element) with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize the largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child
        // If the left child is larger than the root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        // If the right child is larger than the current largest
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        // If the largest is not the root
        if (largest != i) {
            // Swap the largest element with the root
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        printArray(arr);
        heapSort(arr);
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

