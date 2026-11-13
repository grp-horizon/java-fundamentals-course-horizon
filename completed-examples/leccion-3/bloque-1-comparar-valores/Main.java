public class Main {
    public static void main(String[] args) {
        int energia = 30;
        boolean tieneSueno = energia < 20;
        boolean estaLlena = energia >= 100;
        boolean esTreintaOMas = energia >= 30;
        System.out.println("¿Tiene sueño? " + tieneSueno);
        System.out.println("¿Está llena? " + estaLlena);
        System.out.println("¿Vale 30 o más? " + esTreintaOMas);
        // Con energia = 30: energia < 20 da false y energia >= 30 da true
    }
}
