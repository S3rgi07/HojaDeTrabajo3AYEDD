import java.util.Random;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class NumerGenerator {

    Scanner sc = new Scanner(System.in);
    int numberQuantity;
    Random r = new Random();


    public void chooseQuantityOfNumbers() {
        System.out.println("¿Cuántos números quiere generar?");
        System.out.println("1. 10");
        System.out.println("2. 100");
        System.out.println("3. 500");
        System.out.println("4. 1000");
        System.out.println("5. 3000");

        int option = sc.nextInt();

        switch (option) {
            case 1 -> numberQuantity = 10;
            case 2 -> numberQuantity = 100;
            case 3 -> numberQuantity = 500;
            case 4 -> numberQuantity = 1000;
            case 5 -> numberQuantity = 3000;
            default -> {
                System.out.println("Opción inválida");
                numberQuantity = 0;
            }
        }
    }
    
    public void generateNumbers(){
        if (numberQuantity <= 0) {
            System.out.println("No se generaron números.");
            return;
        }


        try (BufferedWriter writer = new BufferedWriter(new FileWriter("numeros.txt"))){

            for (int i = 0; i < numberQuantity; i++){
            int num = r.nextInt(10000);
            writer.write(num + "\n");

            System.out.println("Se generaron " + numberQuantity + " números correctamente.");
        
        }
        
            
        }catch (IOException e) {
            System.out.println("Error al escribir el archivo.");
            e.printStackTrace();
        }

        
    }

    



}
