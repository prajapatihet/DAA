public class NumberIsAvailable {
    public static void main(String[] args) {
        int[] sortedArray = {1, 3, 5, 6};
        int target = 5;

        int index1 = linearSearch(sortedArray, target);
        System.out.println(index1);
    }
    public static int linearSearch(int[] sortedArray, int target) {
        for(int i=0;i<sortedArray.length;i++){
            if(sortedArray[i] == target){
                return i;
            }
        }
        return sortedArray.length;
    }
}
