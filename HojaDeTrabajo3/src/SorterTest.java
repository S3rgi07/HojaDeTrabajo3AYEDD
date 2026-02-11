import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

class SorterTest {

    private Sorter<Integer> sorter;

    @BeforeEach
    void setUp() {
        // Inicializamos el Sorter antes de cada test
        sorter = new Sorter<>();
    }

    @Test
    void testGnomeSort() {
        Integer[] input = { 5, 2, 9, 1, 5, 6 };
        Integer[] expected = { 1, 2, 5, 5, 6, 9 };

        // GnomeSort devuelve el array, así que capturamos el resultado
        Integer[] result = sorter.gnomeSort(input);

        assertArrayEquals(expected, result, "GnomeSort debería ordenar el arreglo correctamente");
    }

    @Test
    void testMergeSort() {
        Integer[] input = { 38, 27, 43, 3, 9, 82, 10 };
        Integer[] expected = { 3, 9, 10, 27, 38, 43, 82 };

        // Tu implementación de MergeSort devuelve un NUEVO array, no modifica el
        // original in-place necesariamente en el primer nivel
        Integer[] result = sorter.mergeSort(input);

        assertArrayEquals(expected, result, "MergeSort debería devolver un arreglo ordenado");
    }

    @Test
    void testQuickSort() {
        Integer[] input = { 10, 7, 8, 9, 1, 5 };
        Integer[] expected = { 1, 5, 7, 8, 9, 10 };

        // QuickSort es void y modifica el array in-place.
        // Requiere pasar los índices bajo y alto.
        sorter.quickSort(input, 0, input.length - 1);

        assertArrayEquals(expected, input, "QuickSort debería ordenar el arreglo in-place");
    }

    @Test
    void testInsertionSort() {
        Integer[] input = { 12, 11, 13, 5, 6 };
        Integer[] expected = { 5, 6, 11, 12, 13 };

        // InsertionSort es void y modifica in-place
        sorter.insertionSort(input);

        assertArrayEquals(expected, input, "InsertionSort debería ordenar el arreglo in-place");
    }

    @Test
    void testRadixSort() {
        // OJO: RadixSort en tu código usa int[] primitivo, no Integer[] genérico.
        // Además es un método estático.
        int[] input = { 170, 45, 75, 90, 802, 24, 2, 66 };
        int[] expected = { 2, 24, 45, 66, 75, 90, 170, 802 };

        Sorter.radixSort(input);

        assertArrayEquals(expected, input, "RadixSort debería ordenar el arreglo de primitivos in-place");
    }

    @Test
    void testEmptyArray() {
        Integer[] input = {};
        Integer[] expected = {};

        // Probamos con uno de los algoritmos para asegurar que no truene con arrays
        // vacíos
        Integer[] result = sorter.mergeSort(input);

        assertArrayEquals(expected, result, "El ordenamiento debería manejar arrays vacíos sin error");
    }

    @Test
    void testAlreadySorted() {
        Integer[] input = { 1, 2, 3, 4, 5 };
        Integer[] expected = { 1, 2, 3, 4, 5 };

        sorter.insertionSort(input);

        assertArrayEquals(expected, input, "Un array ya ordenado debería mantenerse igual");
    }
}