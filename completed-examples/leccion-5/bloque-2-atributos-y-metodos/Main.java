class Mascota {
    String nombre;
    int energia;

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
        Mascota chispa = new Mascota();
        chispa.nombre = "Chispa";
        chispa.energia = 60;
        chispa.mostrarEstado();
        chispa.alimentar();
        chispa.mostrarEstado();
        chispa.jugar(15);
        chispa.mostrarEstado();
        chispa.alimentar();
        chispa.alimentar();
        chispa.mostrarEstado();
    }
}
