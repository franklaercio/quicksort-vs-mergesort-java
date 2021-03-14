import main.Mergesort;
import main.Quicksort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergesortTest {

    @Test
    public void testShouldBeOrderOrderedNumbers() {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10};
        int[] expected = {1,2,3,4,5,6,7,8,9,10};

        Mergesort.sorterNumbers(numbers);

        Assertions.assertArrayEquals(expected, numbers);
    }

    @Test
    public void testShouldBeOrderInverseNumbers() {
        int[] numbers = {10,9,8,7,6,5,4,3,2,1};
        int[] expected = {1,2,3,4,5,6,7,8,9,10};

        Mergesort.sorterNumbers(numbers);

        Assertions.assertArrayEquals(expected, numbers);
    }

    @Test
    public void testShouldBeOrderRandomNumbers() {
        int[] numbers = {8,5,2,3,3,6,7,8,10,15};
        int[] expected = {2,3,3,5,6,7,8,8,10,15};

        Mergesort.sorterNumbers(numbers);

        Assertions.assertArrayEquals(expected, numbers);
    }
}
