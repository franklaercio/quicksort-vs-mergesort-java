package main;

/** Entity responsible for sorting numbers
 *
 * This algorithm is main.Quicksort, was created in 1960 by C.A.R. Hoare.
 * In this case used one pivot for compare numbers.
 * Once the pivot is defined, it is possible to know who the elements are smaller than him and bigger than him.
 * Its complexity in the worst case is C(n) = O(n^2)
 * Its complexity in the best case is C(n) = O(n log n)
 *
 * @author Frank Laércio, Ohanna Dezidério
 * @since 2021-03-13
 */
public class Quicksort {

    /** Function public for use main.Quicksort
     *
     * @param numbers
     */
    public static void sorterNumbers(int[] numbers) {
        quickSort(numbers, 0, numbers.length - 1);
    }

    /** Function for sorting elements.
     * In this case we going to get pivot.
     * Call with recursive way quickSort for numbers successors and predecessors of the pivot.
     *
     * @param numbers
     * @param start
     * @param end
     */
    private static void quickSort(int[] numbers, int start, int end) {
        if(start < end) {
            int pivot = partition(numbers, start, end);

            quickSort(numbers, start, pivot - 1);
            quickSort(numbers, pivot + 1, end);
        }
    }

    /** Function for divide elements.
     * In this case we going to compare pivot with next number.
     * Case the element was smaller than pivot.
     *
     * @param numbers
     * @param start
     * @param end
     */
    private static int partition(int[] numbers, int start, int end) {
        int pivot = numbers[end];
        int index = start;

        for (int j = start; j < end; j++) {
            if(numbers[j] < pivot) {
                swap(numbers, index, j);
                index += 1;
            }
        }

        swap(numbers, index, end);

        return index;
    }

    /** Function for change elements.
     *
     * @param numbers
     * @param start
     * @param end
     */
    private static void swap(int[] numbers, int start, int end) {
        int aux = numbers[start];
        numbers[start] = numbers[end];
        numbers[end] = aux;
    }
}
