public class Binary {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        int data = 4;

        int found = binarySearch(arr,data);
        if(found != -1){
            System.out.println("Found at "+found);
        }else{
            System.out.println("Not Found");
        }
    }
    public static int binarySearch(int[] A,int data){
        int low=0;
        int high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == data){
                return mid;
            } else if (A[mid] < data) {
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
