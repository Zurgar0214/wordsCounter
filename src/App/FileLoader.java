package App;
// Import Java

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class FileLoader {
    public static ArrayList<App.File> loadFile(String directoryPath) {
        ArrayList<App.File> filesContentList = new ArrayList<App.File>();
        File folder = new File(directoryPath);
        for (File file : folder.listFiles()) {
            if (getFileExtension(file).equals("txt") ||
                getFileExtension(file).equals("csv") ||
                getFileExtension(file).equals("xml") ||
                getFileExtension(file).equals("json")) {
                try {
                    Scanner fileScanner = new Scanner(file);
                    String fileContent = fileScanner.useDelimiter("\\A").next();
                    filesContentList.add(new App.File(fileContent.split(" "), file.getName()));
                    fileScanner.close();
                } catch(FileNotFoundException fileUnavailable) {
                    System.out.println("No ha sido posible encontrar el archivo");
                }
            } else {
                System.out.printf("El archivo %s no tiene una extensión válida.\n", file.getName());
                System.exit(0);
            }
        }
        return filesContentList;
    }

    public static String getFileExtension(File file) {
        String extension = null;
        String fileName = file.getName();
        int indexPoint = fileName.lastIndexOf(".");

        if (indexPoint > 0 && indexPoint < fileName.length() - 1) {
            extension = fileName.substring(indexPoint + 1);
        }

        return extension;
    }
}
