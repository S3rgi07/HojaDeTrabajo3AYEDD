import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class NumberFileReader {

    public Integer[] readNumbersFromFile(String fileName){
    ArrayList<Integer> numbers = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
        String line;

        while ((line = reader.readLine()) != null) {
            numbers.add(Integer.parseInt(line));
            
        }

    }catch (IOException e) {
            System.out.println("Error al leer el archivo.");
            e.printStackTrace();

    }

    Integer[] result = new Integer[numbers.size()];
    for (int i = 0; i < numbers.size(); i++){
        result[i] = numbers.get(i);
    }
    return result;
}
}
