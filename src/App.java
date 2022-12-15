import java.util.Random;
import java.util.Set;
import java.util.HashSet;

public class App {
    public static void main(String[] args) throws Exception {
        int length = 1000000; // length of the array
        int[] array = new int[length];
        Set<Integer> set = new HashSet<>(length);
        Random rand = new Random();

        // generate random numbers and add them to the set
        while (set.size() < length) {
            set.add(rand.nextInt());
        }

        // copy the elements of the set to the array
        Integer[] tempArray = set.toArray(new Integer[0]);
        for (int i = 0; i < tempArray.length; i++) {
            array[i] = tempArray[i];
        }

        // print the first 10 elements of the array
        for (int i = 0; i < 10; i++) {
            System.out.println(array[i]);
        }
        // measure the time it takes for linear search to find the target
        int target = array[array.length / 2]; // middle element of the array
        long startTime = System.nanoTime();
        int linearIndex = linearSearch(array, target);
        long endTime = System.nanoTime();
        long linearDuration = endTime - startTime;

        // measure the time it takes for binary search to find the target
        startTime = System.nanoTime();
        int binaryIndex = binarySearch(array, target);
        endTime = System.nanoTime();
        long binaryDuration = endTime - startTime;

        // print the results
        System.out.println("Linear search took " + linearDuration + " nanoseconds");
        System.out.println("Binary search took " + binaryDuration + " nanoseconds");
        
    }

    

    

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;

    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (array[middle] == target) {
                return middle;
            } else if (array[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

}
