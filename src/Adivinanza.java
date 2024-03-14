import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class Adivinanza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Generar un numero aleatorio del 1 al 20
        Random random = new Random();
        int numeroAdivinar = random.nextInt(21);

        //pedir al usuario que diga un numero
        System.out.println("Bienvenido al juego de adivina el numero!");
        int intentos=0;
        boolean adivinado = false;
        System.out.println("Inserta un numero del 0 al 20");
        while(!adivinado){
            System.out.println("Introduce un numero: ");
            int numeroUsuario = scanner.nextInt();
            intentos++;
            if(numeroUsuario==numeroAdivinar){
                adivinado=true;
                System.out.printf("Enhorabuena has acertado en %d intentos el numero era %d", intentos, numeroAdivinar);
                //escribir en txt el numero de intentos
                escribirArchivo("juego.txt", "Usuario", intentos);
            }else{
                System.out.printf("No es %d, prueba otra vez", numeroUsuario);
            }
        }
        scanner.close();
    }
    //funcion para escribir el archivo
    private static void escribirArchivo(String nombreArchivo, String nombreUsuario, int intentos){
        try(PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo, true))){
            writer.println(nombreUsuario + ":" + intentos + "intentos");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}