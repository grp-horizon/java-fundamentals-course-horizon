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
        chispa.setEnergia(150);
        System.out.println("Energía: " + chispa.getEnergia());
        chispa.setEnergia(-5);
        System.out.println("Energía: " + chispa.getEnergia());
        // setEnergia no deja pasar de 100 ni bajar de 0: salen 100 y 0
    }
}
