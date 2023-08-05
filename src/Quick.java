import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 9, 2 ,4,3};
        System.out.println("Original Array "+ Arrays.toString(arr));
        quicksort(arr,0,arr.length-1);
        System.out.println("Sorted Array "+Arrays.toString(arr));
    }

    public static void quicksort(int[] A, int low, int high) {
        if(low<high){
            int pivot = partition(A, low, high);
            quicksort(A,low,pivot-1);
            quicksort(A,pivot+1,high);
        }
    }
    private static int partition(int[] A, int low, int high){
        int pivot_item = A[low];
        int left = low+1;
        int right = high;
        while(left<=right){
            while(left<=right && A[left] <= pivot_item){
                left++;
            }
            while(left<=right && A[right] > pivot_item){
                right--;
            }
            if(left<right){
                swap(A,left,right);
            }
        }
        A[low]=A[right];
        A[right] = pivot_item;
        return right;
    }
    private static void swap(int[] A, int left, int right){
        int temp = A[left];
        A[left] = A[right];
        A[right] = temp;
    }
}
