import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Empleado {
    private String nombre;
    private int edad;
    private double salario;

    
    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        if (edad > 0) {
            this.edad = edad;
        } else {
            System.out.println("EDAD NO VALIDA.");
        }
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario > 0) {
            this.salario = salario;
        } else {
            System.out.println("SALARIO NO VALIDO.");
        }
    }

   
    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Salario: $" + salario);
    }
}


class GestorEmpleados {
    private List<Empleado> empleados;

    public GestorEmpleados() {
        empleados = new ArrayList<>();
    }

    
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println("EMPLEADO AGREGADO CORRECTAMENTE.");
    }

   
    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("NO HAY EMPLEADO REGISTRADO.");
        } else {
            System.out.println("\nLISTA DE EMPLEADOS:");
            for (Empleado empleado : empleados) {
                empleado.mostrarInformacion();
            }
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorEmpleados gestor = new GestorEmpleados();

        while (true) {
            System.out.println("---------Menu-------");
            System.out.println("\n1. AGREGAR EMPLEADO");
            System.out.println("2. MOSTRAR EMPLEADO");
            System.out.println("3. SALIR");
            System.out.print("SELECCIONE UNA OPCION: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.print("INGRESE EL NOMBRE DE EL EMPLEADO: ");
                    String nombre = scanner.nextLine();

                    System.out.print("INGRESE LA EDAD DE EL EMPLEADO: ");
                    int edad = scanner.nextInt();

                    System.out.print("INGRESE EL SALARIO DE EL EMPLEADO: ");
                    double salario = scanner.nextDouble();

                    Empleado nuevoEmpleado = new Empleado(nombre, edad, salario);
                    gestor.agregarEmpleado(nuevoEmpleado);
                    break;

                case 2:
                    gestor.mostrarEmpleados();
                    break;

                case 3:
                    System.out.println("SALIENDO DE EL PROGRAMMA...");
                    scanner.close();
                    return;

                default:
                    System.out.println("OPCION NO VALIDA. INTENTE DE NUEVO:");
            }
        }
    }
}
