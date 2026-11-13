public class Main {
    public static void main(String[] args) {
        int energia = 80;
        System.out.println(energia);
        energia = energia - 10;
        System.out.println(energia);
        energia = energia + 20;
        System.out.println(energia);
        // Chispa juega 10 minutos más: cada minuto gasta 2 puntos, así que se restan 20
        energia = energia - 20;
        System.out.println(energia);
    }
}
