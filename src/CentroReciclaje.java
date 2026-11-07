public class CentroReciclaje {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = leerCantidadCargas(scanner); 
        
        double[] pesos = cargarPesos(scanner, n);
        double totalPeso = calcularSumaPesos(pesos);
        int cantEntre5y80 = contarEnRango(pesos, 5.0, 80.0);
        int cantMayor80 = contarMayoresQue(pesos, 80.0);
        double promedio = calcularPromedio(totalPeso, n);
        double mayorPeso = buscarMayorPeso(pesos);
        int cantMayorPromedio = contarMayoresQue(pesos, promedio);
        int primeraPosMayor = buscarPrimeraPosicionMayor(pesos, mayorPeso);

        mostrarResultadoFinal(pesos, cantEntre5y80, cantMayor80, totalPeso, promedio, mayorPeso, cantMayorPromedio, primeraPosMayor);
        
        scanner.close(); 
        
    }
    public static int leerCantidadCargas(Scanner scanner) {
        int cantidad = 0;
        boolean valido = false;
        while (!valido) {
            System.out.print("Ingrese la cantidad de cargas (entre 3 y 20): ");
            if (scanner.hasNextInt()) {
                cantidad = scanner.nextInt();
                if (cantidad >= 3 && cantidad <= 20) {
                    valido = true;
                } else {
                    System.out.println("se produjo un error, la cantidad de cargas debe de estar entre 3 y 20.");
                }
            } else {
                System.out.println("se produjo un error : Debe ingresar un número entero válido.");
                scanner.next(); 
            }
        }
        return cantidad;
    }

    public static boolean verificarRangoPeso(double peso) {
        return peso >= 5.0 && peso <= 200.0;
    }

    public static double[] cargarPesos(Scanner scanner, int n) {
        double[] pesos = new double[n];
        for (int i = 0; i < n; i++) {
            boolean valido = false;
            while (!valido) {
                System.out.print("Ingrese el peso de la carga " + (i + 1) + " (entre 5 y 200 kg): ");
                if (scanner.hasNextDouble()) {
                    double peso = scanner.nextDouble();
                    if (verificarRangoPeso(peso)) {
                        pesos[i] = peso;
                        valido = true;
                    } else {
                        System.out.println("se produjo un error: El peso debe estar entre 5 y 200 kg.");
                    }
                } else {
                    System.out.println("se produjo un error: Debe ingresar un valor positivo");
                    scanner.next(); 
                }
            }
        }
        return pesos;
    }

    public static double calcularSumaPesos(double[] pesos) {
        double suma = 0;
        for (int i = 0; i < pesos.length; i++) {
            suma += pesos[i];
        }
        return suma;
    }

    public static int contarEnRango(double[] pesos, double min, double max) {
        int contador = 0;
        for (int i = 0; i < pesos.length; i++) {
            if (pesos[i] >= min && pesos[i] <= max) {
                contador++;
            }
        }
        return contador;
    }

    public static int contarMayoresQue(double[] pesos, double limite) {
        int contador = 0;
        for (int i = 0; i < pesos.length; i++) {
            if (pesos[i] > limite) {
                contador++;
            }
        }
        return contador;
    }

    public static double calcularPromedio(double suma, int n) {
        if (n == 0) return 0;
        return suma / n;
    }

    public static double buscarMayorPeso(double[] pesos) {
        if (pesos.length == 0) return 0;
        double mayor = pesos[0];
        for (int i = 1; i < pesos.length; i++) {
            if (pesos[i] > mayor) {
                mayor = pesos[i];
            }
        }
        return mayor;
    }

    public static int buscarPrimeraPosicionMayor(double[] pesos, double mayorPeso) {
        for (int i = 0; i < pesos.length; i++) {
            if (pesos[i] == mayorPeso) {
                return i + 1; 
            }
        }
        return -1;
    }
    public static void mostrarResumenFinal(double[] pesos, int cantEntre5y80, int cantMayor80, 
                                            double totalPeso, double promedio, double mayorPeso, 
                                            int cantMayorPromedio, int primeraPosMayor) {

        System.out.println(" ");
        
        // Listado numerado de todos los pesos registrados
        System.out.println("Listado de pesos registrados:");
        for (int i = 0; i < pesos.length; i++) {
            System.out.println("  - Carga " + (i + 1) + ": " + pesos[i] + " kg");
        }
        
        System.out.println("Resultados de los cálculos:");
        System.out.println("1. Cantidad de cargas entre 5 y 80 kg: " + cantEntre5y80);
        System.out.println("2. Cantidad de cargas superiores a 80 kg: " + cantMayor80);
        System.out.println("3. Peso total recibido: " + totalPeso + " kg");
        System.out.println("4. Promedio de peso por carga: " + promedio + " kg");
        System.out.println("5. Mayor peso registrado: " + mayorPeso + " kg");
        System.out.println("6. Cargas con peso superior al promedio: " + cantMayorPromedio);
        System.out.println("7. Primera aparición del mayor peso: Carga N° " + primeraPosMayor);
    }
    
}