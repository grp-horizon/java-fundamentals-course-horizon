public class Main {
    public static void main(String[] args) {
        int energia = 20;
        for (int i = 0; i < 3; i++) {
            energia = energia + 20;
            System.out.println("Energía: " + energia);
        }
        System.out.println("Energía final: " + energia);
    }
}
