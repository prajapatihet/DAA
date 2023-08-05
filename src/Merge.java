import java.util.Arrays;

public class Merge {
    public static void main(String[] args){
        int[] arr = {5,9,1,4,2,3,7};
        System.out.println("Original Array: "+ Arrays.toString(arr));
        int[] temp = new int[arr.length];
        mergesort(arr,temp,0,arr.length-1);
        System.out.println("Sorted Array "+Arrays.toString(arr));
    }

    public static void mergesort(int A[], int[] temp, int low,int high){
        int mid;
        if (low<high){
            mid = (low+high)/2;
            mergesort(A,temp,low,mid);
            mergesort(A,temp,mid+1,high);
            Merges(A,temp,low,mid+1,high);

        }
    }
    public static void Merges(int[] A, int[] temp, int low, int mid, int high){
        int i,left_end,size,temp_pos;
        left_end = mid-1;
        temp_pos = low;
        size = high-low+1;

        while ((low<=left_end) && (mid<=high)){
            if(A[low]<=A[mid]){
                temp[temp_pos] = A[low];
                temp_pos++;
                low++;
            }else {
                temp[temp_pos] = A[mid];
                temp_pos++;
                mid++;
            }
        }

        while (low<=left_end){
            temp[temp_pos] = A[low];
            low++;
            temp_pos++;
        }
        while(mid<=high){
            temp[temp_pos] = A[mid];
            mid++;
            temp_pos++;
        }
        for (i=0;i<size;i++){
            A[high] = temp[high];
            high--;
        }

    }
}
