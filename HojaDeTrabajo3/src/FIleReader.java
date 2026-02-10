import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;

public class FIleReader {

    public int[] readNumbersFromFile(String fileName){
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

    int[] result = new int[numbers.size()];
    for (int i = 0; i < numbers.size(); i++){
        result[i] = numbers.get(i);
    }
    return result;
}
}
