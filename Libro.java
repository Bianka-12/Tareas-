import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Libro {
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private String genero;
    private boolean disponible;

    public Libro(String titulo, String autor, int añoPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.genero = genero;
        this.disponible = true;
    }

    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isDisponible() { return disponible; }
    public void prestar() { this.disponible = false; }
    public void devolver() { this.disponible = true; }

    
    public String toString() {
        return "Titulo: " + titulo + ", Autor: " + autor + ", Año: " + añoPublicacion + ", Género: " + genero + ", Disponible: " + (disponible ? "Sí" : "No");
    }
}

class Biblioteca {
    private List<Libro> libros;

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void buscarLibro(String criterio) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(criterio) || libro.getAutor().equalsIgnoreCase(criterio)) {
                System.out.println(libro);
            }
        }
    }

    public void prestarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.isDisponible()) {
                libro.prestar();
                System.out.println("El libro '" + titulo + "' ha sido prestado.");
                return;
            }
        }
        System.out.println("EL LIBRO NO ESTA DISPONIBle O NO EXISTES.");
    }

    public void devolverLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && !libro.isDisponible()) {
                libro.devolver();
                System.out.println("El libro '" + titulo + "' ha sido devuelto.");
                return;
            }
        }
        System.out.println("El libro no está prestado o no existe.");
    }

    public void mostrarLibrosDisponibles() {
        for (Libro libro : libros) {
            if (libro.isDisponible()) {
                System.out.println(libro);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        
        biblioteca.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", 1967, "Novela"));
        biblioteca.agregarLibro(new Libro("1984", "George Orwell", 1949, "Distopía"));
        biblioteca.agregarLibro(new Libro("El principito", "Antoine de Saint-Exupéry", 1943, "Fábula"));
        
        while (true) {
            System.out.println("\n1. Agregar libro\n2. Buscar libro\n3. Prestar libro\n4. Devolver libro\n5. Mostrar libros disponibles\n6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Ingrese el género: ");
                    String genero = scanner.nextLine();
                    biblioteca.agregarLibro(new Libro(titulo, autor, anio, genero));
                    break;
                case 2:
                    System.out.print("Ingrese el título o autor: ");
                    String criterio = scanner.nextLine();
                    biblioteca.buscarLibro(criterio);
                    break;
                case 3:
                    System.out.print("Ingrese el título del libro a prestar: ");
                    String tituloPrestar = scanner.nextLine();
                    biblioteca.prestarLibro(tituloPrestar);
                    break;
                case 4:
                    System.out.print("INGRESE EL TITULO DEL LIBRO HA DEVOLVER: ");
                    String tituloDevolver = scanner.nextLine();
                    biblioteca.devolverLibro(tituloDevolver);
                    break;
                case 5:
                    biblioteca.mostrarLibrosDisponibles();
                    break;
                case 6:
                    System.out.println("SALIENDO...");
                    scanner.close();
                    return;
                default:
                    System.out.println("OPCION NO VALIDA.");
            }
        }
    }
}
