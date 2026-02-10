import java.util.Arrays;

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
public void quickSort(T[] input, int bajo, int alto) {
    if (bajo < alto) {
        int pi = partition(input, bajo, alto);

        quickSort(input, bajo, pi - 1);
        quickSort(input, pi + 1, alto);
    }
}

/*
 * Esta función toma el último elemento como pivote,
 * coloca el pivote en su posición correcta en el arreglo ordenado,
 * y coloca todos los menores a la izquierda y los mayores a la derecha
 */
private int partition(T[] arr, int bajo, int alto) {
    T pivote = arr[alto];
    int i = bajo - 1;

    for (int j = bajo; j < alto; j++) {
        // Comparación usando Comparable
        if (arr[j].compareTo(pivote) <= 0) {
            i++;

            // Intercambiar arr[i] y arr[j]
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    // Colocar el pivote en su posición correcta
    T temp = arr[i + 1];
    arr[i + 1] = arr[alto];
    arr[alto] = temp;

    return i + 1;
}

    // Counting Sort según el dígito representado por exp
    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // array ordenado
        int[] count = new int[10]; // dígitos 0-9

        // 1. Contar ocurrencias de cada dígito
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // 2. Convertir count en posiciones acumuladas
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 3. Construir el array de salida (de atrás hacia adelante → estabilidad)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // 4. Copiar el resultado al array original
        System.arraycopy(output, 0, arr, 0, n);
    }

    // Insertion Sort (comparativo)
public void insertionSort(T[] arr) {

    // Empezamos desde el segundo elemento
    for (int i = 1; i < arr.length; i++) {

        T key = arr[i];      // Elemento a insertar
        int j = i - 1;

        // Mover los elementos mayores que key una posición a la derecha
        while (j >= 0 && arr[j].compareTo(key) > 0) {
            arr[j + 1] = arr[j];
            j--;
        }

        // Insertar key en su posición correcta
        arr[j + 1] = key;
    }
}


//Radix Sort
    public static void radixSort(int[] arr) {
        // 1. Encontrar el número máximo
        int max = getMax(arr);

        // 2. Aplicar counting sort para cada dígito
        // exp = 1 -> unidades, 10 -> decenas, 100 -> centenas...
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Devuelve el valor máximo del array
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

}