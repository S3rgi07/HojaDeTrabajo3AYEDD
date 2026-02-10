public class Main {

    public static void main(String[] args) {

        // 1. Generar el archivo de números
        NumberGenerator generator = new NumberGenerator();
        generator.chooseQuantityOfNumbers();
        generator.generateNumbers();

        // 2. Leer los números desde el archivo
        NumberFileReader reader = new NumberFileReader();
        Integer[] original = reader.readNumbersFromFile("numeros.txt");

        // Verificación mínima de seguridad
        if (original.length == 0) {
            System.out.println("No se pudieron leer números. Abortando ejecución.");
            return;
        }

        // 3. Crear el sorter
        Sorter<Integer> sorter = new Sorter<>();

        // 4. Gnome Sort
        Integer[] gnome = original.clone();
        sorter.gnomeSort(gnome);

        // 5. Merge Sort
        Integer[] merge = original.clone();
        sorter.mergeSort(merge);

        // 6. Quick Sort
        Integer[] quick = original.clone();
        sorter.quickSort(quick, 0, quick.length - 1);

        // 7. Insertion Sort
        Integer[] insertion = original.clone();
        sorter.insertionSort(insertion);

        // 8. Radix Sort (no comparativo)
        int[] radix = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            radix[i] = original[i];
        }
        Sorter.radixSort(radix);
    }
}
