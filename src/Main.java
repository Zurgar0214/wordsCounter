import App.File;
import App.FileLoader;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<File> filesArray;
        System.out.println("Ingrese la ruta completa, incluyendo el nombre de la carpeta: ");
        String path = scanner.next();
        System.out.println("Ingrese la palabra que desea buscar: ");
        String wordToSearch = scanner.next();
        filesArray = FileLoader.loadFile(path);
        System.out.println("------------------------------------------------------------");
        if (!filesArray.isEmpty()) {
            int totalTimes = 0;
            for(File file : filesArray) {
                totalTimes += file.count(wordToSearch);
                System.out.printf("La palabra %s se repite %d veces en el archivo %s \n", wordToSearch, file.count(wordToSearch), file.getFileName());
            }
            System.out.printf("En total, la palabra %s se repite %d veces \n", wordToSearch, totalTimes);
        } else {
            System.out.println("Ocurrió un error al leer los archivos. No se encontraron resultados");
        }
        System.out.println("------------------------------------------------------------");
    }
}