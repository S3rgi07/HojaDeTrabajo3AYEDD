public class Sorter<T extends Comparable<T>> {
    public T[] gnomeSort(T[] input) {
        Integer index = 0;
        while (index < input.length) {
            if (index == 0)
                index++;
            if (input[index].compareTo(input[index - 1]) >= 0) {
                index++;
            } else {
                T temp = input[index];
                input[index] = input[index - 1];
                input[index - 1] = temp;
                index--;
            }
        }
        return input;
    }

    // Merge Sort

    public T[] mergeSort(T[] input) {
        if (input.length <= 1) {
            return input;
        }
        int mid = input.length / 2;
        T[] left = java.util.Arrays.copyOfRange(input, 0, mid);
        T[] right = java.util.Arrays.copyOfRange(input, mid, input.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private T[] merge(T[] left, T[] right) {
        T[] result = java.util.Arrays.copyOf(left, left.length + right.length);
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }

    // Quick Sort

    // Método principal que llama a la recursión
    public void sort(int[] arr, int bajo, int alto) {
        if (bajo < alto) {
            // pi es el índice de partición
            // arr[pi] está ahora en el lugar correcto
            int pi = partition(arr, bajo, alto);

            // Ordena recursivamente los elementos antes y después de la partición
            sort(arr, bajo, pi - 1);
            sort(arr, pi + 1, alto);
        }
    }

    /*
     * Esta función toma el último elemento como pivote,
     * coloca el pivote en su posición correcta en el arreglo ordenado,
     * y coloca todos los menores a la izquierda y los mayores a la derecha
     */
    int partition(int[] arr, int bajo, int alto) {
        int pivote = arr[alto];
        int i = (bajo - 1); // Índice del elemento más pequeño

        for (int j = bajo; j < alto; j++) {
            // Si el elemento actual es menor o igual al pivote
            if (arr[j] <= pivote) {
                i++;

                // Intercambiar arr[i] y arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Intercambiar arr[i+1] y arr[alto] (el pivote)
        int temp = arr[i + 1];
        arr[i + 1] = arr[alto];
        arr[alto] = temp;

        return i + 1;
    }

    // Método auxiliar para imprimir
    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
