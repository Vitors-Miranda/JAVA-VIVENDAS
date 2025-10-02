//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    //scanner
    Scanner scanner = new Scanner(System.in);
    //constantes
    int option = -1;
    final int HABITACION = 1;
    final int VIVENDA = 2;
    final int SENSORES = 3;
    final int SALIR = 0;

    //menu
    System.out.println("----------------------------");
    System.out.println("Bienvenido!");
    System.out.println("Creado por Vitor Miranda.");
    System.out.println("---------------------------");

    //CREANDO SENSORES
    Sensor sensor1 = new Sensor(100, "LM35DZ", "Texas Instruments", "Sensor de temperatura", 0);
    Sensor sensor2 = new Sensor(0, "HC-SR04", "Kitronik", "Sensor Ultrasónico", 0);
    Sensor sensor3 = new Sensor(50, "DHT11", "Quine", "Sensor Arduido", 0);

    do{
        System.out.println();
        System.out.println("1. Opciones de HABITACION");
        System.out.println("2. Opciones de VIVENDA");
        System.out.println("3. Opciones de SENSORES");
        System.out.println("0. Salir");
        option = scanner.nextInt();

        switch(option){
            case HABITACION:
                break;
            case VIVENDA:
                break;
            case SENSORES:
                System.out.println(sensor1.toString());
                System.out.println("[ENTER] para continuar");
                scanner.nextLine();
                scanner.nextLine();
                break;
            case SALIR:
                System.out.println("Adios!!");
                break;
            default:
                System.out.println("Opcion invalida");
        }
    } while (option != SALIR);
}
