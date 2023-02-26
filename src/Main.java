import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Liga liga;

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n-- MENU --");
            System.out.println("1. Crear nueva liga");
            System.out.println("2. Jugar liga");
            System.out.println("3. Eliminar liga actual");
            System.out.println("4. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // consume el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Introduzca el nombre de la liga: ");
                    String nombreLiga = scanner.nextLine();
                    liga = new LigaFutbol(nombreLiga);
                    System.out.println("Liga creada con éxito.");
                    break;
                case 2:
                    if (liga == null) {
                        System.out.println( "\033[31m"+ "Debe crear una liga primero." + "\033[0m");
                        break;
                    }
                    boolean pausarLiga = false;
                    while (!pausarLiga) {
                        System.out.println("\n-- SUBMENU --");
                        System.out.println("1. Siguiente jornada");
                        System.out.println("2. Consultar tabla");
                        System.out.println("3. Pausar liga");
                        System.out.print("Elija una opción: ");
                        int opcionSubmenu = scanner.nextInt();
                        scanner.nextLine(); // consume el salto de línea

                        switch (opcionSubmenu) {
                            case 1:
                                liga.simularJornada();
                                System.out.println("Jornada jugada.");
                                break;
                            case 2:
                                liga.consultarTabla();
                                break;
                            case 3:
                                pausarLiga = true;
                                break;
                            default:
                                System.out.println( "\033[31m"+ "Opción no válida."  + "\033[0m");
                        }
                    }
                    break;
                case 3:
                    if (liga == null) {
                        System.out.println(  "\033[31m"+ "Debe crear una liga primero." + "\033[0m");
                        break;
                    }
                    System.out.print( "\033[31m" + "¿Está seguro que desea eliminar la liga actual? (s/n): " + "\033[0m");
                    String confirmacion = scanner.nextLine();
                    if (confirmacion.equals("s")) {
                        liga = null;
                        System.out.println("Liga eliminada con éxito.");
                    }
                    break;
                case 4:
                    salir = true;
                    System.out.println("Has finalizado la sesion");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
