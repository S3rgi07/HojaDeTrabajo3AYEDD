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

    public T[] mergeSort(T[] input) {
        // En progreso
        return null;
    }

}