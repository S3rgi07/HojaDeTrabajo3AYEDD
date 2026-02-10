public class Main {

    public static void main(String[] args) {

        NumberGenerator generator = new NumberGenerator();
        generator.chooseQuantityOfNumbers();
        generator.generateNumbers();

        NumberFileReader reader = new NumberFileReader();
        Integer[] original = reader.readNumbersFromFile("numeros.txt");

        if (original == null || original.length == 0) {
            System.out.println("No se pudieron leer números.");
            return;
        }

        System.out.println("Se leyeron " + original.length + " números.");

        Sorter<Integer> sorter = new Sorter<>();

        Integer[] gnome = original.clone();
        sorter.gnomeSort(gnome);
        System.out.println("Gnome Sort ejecutado.");

        Integer[] merge = original.clone();
        merge = sorter.mergeSort(merge);
        System.out.println("Merge Sort ejecutado.");

        Integer[] quick = original.clone();
        sorter.quickSort(quick, 0, quick.length - 1);
        System.out.println("Quick Sort ejecutado.");

        Integer[] insertion = original.clone();
        sorter.insertionSort(insertion);
        System.out.println("Insertion Sort ejecutado.");

        int[] radix = new int[original.length];
        for (int i = 0; i < original.length; i++) {
            radix[i] = original[i];
        }
        Sorter.radixSort(radix);
        System.out.println("Radix Sort ejecutado.");

        System.out.println("Programa finalizado correctamente.");
    }
}
