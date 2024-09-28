import org.junit.Test;
import static org.junit.Assert.*;

public class Pz1Test {

    @Test
    public void testGenerateArray() {
        int size = 5;
        int[] array = Pz1.generateArray(size);
        assertEquals(size, array.length);

        for (int num : array) {
            assertTrue(num >= -100 && num <= 100);
        }
    }

    @Test
    public void testManualArrayInput() {

        int[] inputArray = {1, 2, 3, 4, 5};
        int[] array = inputArray;
        assertEquals(5, array.length);
        assertArrayEquals(inputArray, array);
    }

    @Test
    public void testCountElementsLessThanSeven() {
        int[] array = {10, 6, 5, 8, -2};
        int count = Pz1.countElementsLessThanSeven(array);
        assertEquals(3, count);
    }

    @Test
    public void testProductBetweenZeros() {
        int[] arrayWithZeros = {1, 0, 3, 4, 0, 5};
        try {
            int product = Pz1.productBetweenZeros(arrayWithZeros);
            assertEquals(12, product);
        } catch (Exception e) {
            fail("Виняток не повинен бути викинутий для масиву з двома нулями");
        }


        int[] arrayWithOneZero = {1, 0, 3, 4, 5};
        try {
            Pz1.productBetweenZeros(arrayWithOneZero);
            fail("Повинен бути виняток, якщо немає двох нулів");
        } catch (Exception e) {
            assertEquals("Має бути два нулі в масиві.", e.getMessage());
        }
    }
}
