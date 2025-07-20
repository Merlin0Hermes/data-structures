import static org.junit.Assert.assertArrayEquals;


public class TestSort {

    @org.junit.Test
    public void testSort() {
        int[] input = {8, 5, 2, 1, 6, 7};
        int[] expected = {1, 2, 5, 6, 7, 8};

        Sort.sort(input);
        assertArrayEquals(input, expected);
    }

}