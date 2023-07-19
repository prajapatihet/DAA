public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {15,16,19,22,45,65,77,85};
        int element = 65;
        int index = search(arr,element);
        System.out.println("Element found at "+index);
    }
    public static int search(int[] arr, int element){
        int beg=0;
        int end= arr.length-1;
        while (beg <= end) {
            int mid = (end+beg)/2;
            if (arr[mid]==element){
                return mid;
            } else if (arr[mid]<element) {
                beg = mid +1;
            }else {
                end = mid-1;
            }
        }
        return -1;
    }
}
