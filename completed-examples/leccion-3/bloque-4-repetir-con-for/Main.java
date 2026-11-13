public class Main {
    public static void main(String[] args) {
        int energia = 20;
        for (int i = 0; i < 2; i++) {
            energia = energia + 20;
            System.out.println("Energía: " + energia);
        }
        System.out.println("Energía final: " + energia);
        // Con 2 vueltas salen 2 líneas con "Energía:" (y la línea final)
    }
}
