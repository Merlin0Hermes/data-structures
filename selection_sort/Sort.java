

public class Sort {

    public static void sort(int[] arr) {
        
        for (int i = 0; i < arr.length; ++i) {

        }
    }

    private static int findSmallest(int[] arr, int start) {
        int smallestIndex = 0;
        for (int i = start; i < arr.length; ++i) {
            if (arr[i] < arr[smallestIndex]) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }



    public static void main(String[] args) {
        
	
    }
}
