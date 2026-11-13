public class Main {
    public static void main(String[] args) {
        int energia = 40;
        while (energia < 100) {
            energia = energia + 20;
            System.out.println("Energía: " + energia);
        }
        System.out.println("¡Chispa está llena!");
        // Si borras la línea energia = energia + 20; la energía nunca cambia,
        // la condición energia < 100 siempre se cumple y el bucle no termina: pulsa Stop.
    }
}
