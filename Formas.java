
public class Formas {
    public void Dibujar() {
        System.out.println("Dibujando una forma...");
    }

class Circulo extends Formas {
    public void Dibujar() {
        System.out.println("Dibujando un Círculo");
    }
}

class Cuadrado extends Formas {
    public void Dibujar() {
        System.out.println("Dibujando un Cuadrado");
    }
}

class Rectangulo extends Formas {
    public void Dibujar() {
        System.out.println("Dibujando un Rectángulo");
    }
}

class Triangulo extends Formas {
    public void Dibujar() {
        System.out.println("Dibujando un Triángulo");
    }
}

public class Main {
    public static void main(String[] args) {
        Formas[] formas = {new Circulo(), new Cuadrado(), new Rectangulo(), new Triangulo()};
        
        for (Formas forma : formas) {
            forma.Dibujar();
        }
    }
}

