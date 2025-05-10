import java.io.File;

public class App {
    public static void main(String[] args) {
        String basePath = "C:\\Users\\cesar\\OneDrive\\Universidad\\2 semestre\\Programacion Objetos\\SEM2-prog-objetos\\recursividad\\raiz";
        File baseDirectory = new File(basePath);

        if (baseDirectory.exists() && baseDirectory.isDirectory()) {
            System.out.println("- " + baseDirectory.getName());
            exploreDirectory(baseDirectory, 1);
        } else {
            System.out.println("El directorio especificado no existe o no es válido.");
        }
    }

    public static void exploreDirectory(File directory, int level) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                String indentation = printIndented(file, level);

                if (file.isDirectory()) {
                    System.out.println(indentation + "- " + file.getName());
                    exploreDirectory(file, level + 1);
                } else {
                    System.out.println(indentation + " " + file.getName());
                }
            }
        }
    }

    public static String printIndented(File file, int level) {
        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < level; i++) {
            indentation.append("  ");
        }
        return indentation.toString();
        }
    }