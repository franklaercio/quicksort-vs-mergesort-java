package main;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

/** Entity responsible for executing the sorting algorithms
 *
 * @author Frank Laércio, Ohanna Dezidério
 * @since 2021-03-13
 */
public class Main {
    public static void main(String[] args) {
        int[] instances = {5, 10, 20, 40, 80, 160, 320, 640, 1280, 2560};

        System.out.println("main.Quicksort for sorting numbers:");

        for (int i = 0; i < instances.length; i++) {
            int[] orderNumbers = sortedNumbers(instances[i]);

            Instant startTimeQuicksort = Instant.now();

            Quicksort.sorterNumbers(orderNumbers);

            Instant endTimeQuicksort = Instant.now();

            System.out.print(Duration.between(startTimeQuicksort, endTimeQuicksort).toNanos() + " ns for ");
            System.out.print(instances[i] + " numbers\n");
        }

        System.out.println("\nmain.Quicksort for random numbers:");

        for (int i = 0; i < instances.length; i++) {
            int[] orderNumbers = randomNumbers(instances[i]);

            Instant startTimeQuicksort = Instant.now();

            Quicksort.sorterNumbers(orderNumbers);

            Instant endTimeQuicksort = Instant.now();

            System.out.print(Duration.between(startTimeQuicksort, endTimeQuicksort).toNanos() + " ns for ");
            System.out.print(instances[i] + " numbers\n");
        }

        System.out.println("\nmain.Mergesort for sorting numbers:");

        for (int i = 0; i < instances.length; i++) {
            int[] orderNumbers = sortedNumbers(instances[i]);

            Instant startTimeQuicksort = Instant.now();

            Mergesort.sorterNumbers(orderNumbers);

            Instant endTimeQuicksort = Instant.now();

            System.out.print(Duration.between(startTimeQuicksort, endTimeQuicksort).toNanos() + " ns for ");
            System.out.print(instances[i] + " numbers\n");
        }

        System.out.println("\nmain.Mergesort for random numbers:");

        for (int i = 0; i < instances.length; i++) {
            int[] orderNumbers = randomNumbers(instances[i]);

            Instant startTimeQuicksort = Instant.now();

            Mergesort.sorterNumbers(orderNumbers);

            Instant endTimeQuicksort = Instant.now();

            System.out.print(Duration.between(startTimeQuicksort, endTimeQuicksort).toNanos() + " ns for ");
            System.out.print(instances[i] + " numbers\n");
        }
    }

    /** Function responsible for creating ordered numbers
     *
     * @author Frank Laércio, Ohanna Dezidério
     * @since 2021-03-13
     *
     * @param size
     */
    private static int[] sortedNumbers(int size) {
        int[] numbers = new int[size];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i;
        }

        return numbers;
    }

    /** Function responsible for creating random numbers
     *
     * @author Frank Laércio, Ohanna Dezidério
     * @since 2021-03-13
     *
     * @param size
     */
    private static int[] randomNumbers(int size) {
        int[] numbers = new int[size];

        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(size);
        }

        return numbers;
    }
}
