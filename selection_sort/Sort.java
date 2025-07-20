

public class Sort {

    public static void sort(int[] arr) {
        
        for (int i = 0; i < arr.length; ++i) {
            int smallestIndex = findSmallest(arr, i);
            
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
