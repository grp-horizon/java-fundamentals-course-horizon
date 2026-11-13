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
        Mascota luna = new Mascota("Luna", 90);
        luna.mostrarEstado();
        luna.jugar(10);
        luna.mostrarEstado();
    }
}
