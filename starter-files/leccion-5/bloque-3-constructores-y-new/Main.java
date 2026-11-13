class Mascota {
    String nombre;
    int energia;

    Mascota(String nombre, int energia) {
        this.nombre = nombre;
        this.energia = energia;
    }

    void alimentar() {
        energia = energia + 20;
    }

    void jugar(int minutos) {
        energia = energia - minutos * 2;
    }

    void mostrarEstado() {
        System.out.println(nombre + " tiene " + energia + " de energía.");
    }
}

public class Main {
    public static void main(String[] args) {
        Mascota chispa = new Mascota("Chispa", 80);
        chispa.mostrarEstado();
        chispa.jugar(10);
        chispa.mostrarEstado();
    }
}
