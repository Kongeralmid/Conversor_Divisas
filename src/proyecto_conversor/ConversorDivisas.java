package proyecto_conversor;

import java.util.Scanner;

public class ConversorDivisas {
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa la cantidad de pesos colombianos: ");
        double pesos = scanner.nextDouble();

        System.out.println("Elige la divisa a la que deseas convertir:");
        System.out.println("1. Dólar");
        System.out.println("2. Euro");
        System.out.println("3. Libra Esterlina");
        System.out.println("4. Yen Japonés");
        System.out.println("5. Won sur-coreano");
        System.out.print("Ingresa el número de opción: ");
        int opcion = scanner.nextInt();

        double resultado = 0.0;

        switch (opcion) {
            case 1:
                resultado = convertirPesosADolar(pesos);
                break;
            case 2:
                resultado = convertirPesosAEuro(pesos);
                break;
            case 3:
                resultado = convertirPesosALibraEsterlina(pesos);
                break;
            case 4:
                resultado = convertirPesosAYen(pesos);
                break;
            case 5:
                resultado = convertirPesosAWon(pesos);
                break;
            default:
                System.out.println("Opción no válida");
                return;
        }

        System.out.println("El resultado de la conversión es: " + resultado);
    }

    public static double convertirPesosADolar(double pesos) {
        // Supongamos una tasa de cambio de 1 dólar = 3000 pesos colombianos
        double tasaCambio = 3000.0;
        return pesos / tasaCambio;
    }

    public static double convertirPesosAEuro(double pesos) {
        // Supongamos una tasa de cambio de 1 euro = 3500 pesos colombianos
        double tasaCambio = 3500.0;
        return pesos / tasaCambio;
    }

    public static double convertirPesosALibraEsterlina(double pesos) {
        // Supongamos una tasa de cambio de 1 libra esterlina = 4000 pesos colombianos
        double tasaCambio = 4000.0;
        return pesos / tasaCambio;
    }

    public static double convertirPesosAYen(double pesos) {
        // Supongamos una tasa de cambio de 1 yen japonés = 30 pesos colombianos
        double tasaCambio = 30.0;
        return pesos / tasaCambio;
    }

    public static double convertirPesosAWon(double pesos) {
        // Supongamos una tasa de cambio de 1 won sur-coreano = 2.5 pesos colombianos
        double tasaCambio = 2.5;
        return pesos / tasaCambio;
    }
}
