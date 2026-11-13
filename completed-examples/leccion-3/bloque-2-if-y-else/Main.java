public class Main {
    public static void main(String[] args) {
        int energia = 20;
        if (energia < 20) {
            System.out.println("Chispa tiene sueño.");
        } else {
            System.out.println("Chispa quiere jugar.");
        }
        // Con 20 sale "Chispa quiere jugar.": 20 < 20 es falso, porque 20 no es menor que 20
    }
}
