class Mascota {
    private String nombre;
    private int energia;

    public Mascota(String nombre, int energia) {
        this.nombre = nombre;
        setEnergia(energia);
    }

    public String getNombre() {
        return nombre;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        if (energia < 0) {
            this.energia = 0;
        } else if (energia > 100) {
            this.energia = 100;
        } else {
            this.energia = energia;
        }
    }

    public void alimentar() {
        setEnergia(energia + 20);
    }

    public void jugar(int minutos) {
        setEnergia(energia - minutos * 2);
    }

    public void mostrarEstado() {
        System.out.println(nombre + " tiene " + energia + " de energía.");
    }
}

public class Main {
    public static void main(String[] args) {
        Mascota chispa = new Mascota("Chispa", 80);
        Mascota luna = new Mascota("Luna", 50);
        Mascota rayo = new Mascota("Rayo", 20);

        chispa.mostrarEstado();
        luna.mostrarEstado();
        rayo.mostrarEstado();

        chispa.jugar(10);
        luna.alimentar();
        rayo.alimentar();
        rayo.alimentar();

        chispa.mostrarEstado();
        luna.mostrarEstado();
        rayo.mostrarEstado();
    }
}
