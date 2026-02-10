public class Main {

    public static void main(String[] args) {

        // Leer números desde el archivo
        NumberFileReader reader = new NumberFileReader();
        Integer[] original = reader.readNumbersFromFile("numeros.txt");

        // Crear sorter
        Sorter<Integer> sorter = new Sorter<>();

        // Gnome Sort
        Integer[] gnome = original.clone();
        sorter.gnomeSort(gnome);

        // Merge Sort
        Integer[] merge = original.clone();
        sorter.mergeSort(merge);

        // Quick Sort
        Integer[] quick = original.clone();
        sorter.quickSort(quick, 0, quick.length - 1);

        // Insertion Sort
        Integer[] insertion = original.clone();
        sorter.insertionSort(insertion);

        // Radix Sort (no comparativo)
        int[] radix = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            radix[i] = original[i];
        }
        Sorter.radixSort(radix);
    }
}
