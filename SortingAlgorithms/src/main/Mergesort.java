package main;

/** Entity responsible for sorting numbers
 *
 * This algorithm is main.Mergesort, was created in 1945 by John von Neumann.
 * In this case used middle position and separates into smaller vectors.
 * Once the middle is defined, the mergesort algorithm is called recursively and joins the lists.
 * Its complexity in the worst case is C(n) = O(n^2)
 * Its complexity in the best case is C(n) = O(n log n)
 *
 * @author Frank Laércio, Ohanna Dezidério
 * @since 2021-03-13
 */
public class Mergesort {

    /** Function public for use main.Mergesort
     *
     * @param numbers
     */
    public static void sorterNumbers(int[] numbers) {
        mergeSort(numbers, 0, numbers.length - 1);
    }

    /** Function for sorting elements.
     * In this case we going to get middle position.
     * Call with recursive way mergesort for numbers and joins the lists.
     *
     * @param numbers
     * @param start
     * @param end
     */
    private static void mergeSort(int[] numbers, int start, int end) {
        // Stop condition
        if(start >= end){
            return;
        }

        // Get middle position
        int middle = start + ((end-start)/2);

        mergeSort(numbers, start, middle);
        mergeSort(numbers, middle + 1, end);

        merge(numbers, start, middle, end);
    }

    /** Function for merge elements.
     * In this case going to go define left list and right list.
     * After that we will compare the numbers of the two lists and we going to do a merge.
     *
     * @param numbers
     * @param start
     * @param end
     */
    private static void merge(int[] numbers, int start, int middle, int end) {
        int lengthLeft = middle - start + 1;
        int lengthRight = end - middle;

        int[] left = new int[lengthLeft];
        int[] right = new int[lengthRight];

        // Copy numbers of left middle
        for (int i = 0; i < lengthLeft; i++) {
            left[i] = numbers[start + i];
        }

        // Copy numbers of right middle
        for (int j = 0; j < lengthRight; j++) {
            right[j] = numbers[middle + 1 + j];
        }

        int topLeft = 0, topRight = 0, k = start;

        // Sorting numbers
        while (topLeft < lengthLeft && topRight < lengthRight) {
            if (left[topLeft] <= right[topRight]) {
                numbers[k] = left[topLeft];
                topLeft++;
            } else {
                numbers[k] = right[topRight];
                topRight++;
            }
            k++;
        }

        // Adding numbers that have not been distorted in the merge
        while (topLeft < lengthLeft) {
            numbers[k] = left[topLeft];
            topLeft++;
            k++;
        }

        // Adding numbers that have not been distorted in the merge
        while (topRight < lengthRight) {
            numbers[k] = right[topRight];
            topRight++;
            k++;
        }
    }
}
