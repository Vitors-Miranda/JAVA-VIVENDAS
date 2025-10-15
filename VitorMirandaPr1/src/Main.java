//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.



void main() {
    //scanner
    Scanner scanner = new Scanner(System.in);

    //constantes
    int option = -1;
    final int VIVENDA = 1;
    final int HABITACION = 2;
    final int SENSORES = 3;
    final int SALIR = 0;

    System.out.println("----------------------------");
    System.out.println("Bienvenido a la Centralita!");
    System.out.println("Creado por Vitor Miranda y Pedro Henrique.");
    System.out.println("---------------------------");

    //1. CREANDO CENTRALITA
    Centralita centralita = new Centralita();

    //2. CREANDO VIVENDAS
    Vivenda vivenda1 = new Vivenda("vivenda1", 10);

    //3. CREANDO HABITACIONES
    Habitacion habitacion1 = new Habitacion("habitacion1");

    //CREANDO SENSORES
    Sensor sensor1 = new SensorMagnetico(100, "LM35DZ", "Texas Instruments", "Sensor de temperatura", true);
    Sensor sensor2 = new SensorMagnetico(0, "HC-SR04", "Kitronik", "Sensor Ultrasónico", false);
    Sensor sensor3 = new SensorMagnetico(50, "DHT11", "Quine", "Sensor Arduido", true);

    //añadindo valores a la centralita
    vivenda1.anadirHabitacion(habitacion1);
    centralita.altaVivenda(vivenda1);
    centralita.anadirSensor(1, 1, sensor1);
    centralita.anadirSensor(1, 1, sensor2);


    HashMap<Integer, Vivenda> vivendas = new HashMap<>();
    ArrayList<Habitacion> habitaciones = new ArrayList<>();
    ArrayList<Sensor> sensores = new ArrayList<>();

    do{

        //Menu
        System.out.println();
        System.out.println("1. Opciones de VIVENDAS");
        System.out.println("2. Opciones de HABITACION");
        System.out.println("3. Opciones de SENSORES");
        System.out.println("3. Guardar archivos");
        System.out.println("3. Cargar archivos");
        System.out.println("0. Salir");
        option = scanner.nextInt();


        switch(option){
            case VIVENDA:
                do {
                    //SubMenu VIVENDA
                    System.out.println("1. Anadir Vivenda");
                    System.out.println("2. Eliminar Vivendas");
                    System.out.println("3. Listar Vivendas");
                    System.out.println("0. Salir");
                    option = scanner.nextInt();

                    switch(option){
                        case 1: //ANADIR
                            System.out.print("Nombre: ");
                            String nombre = scanner.next();

                            System.out.print("Numero de habitantes: ");
                            int habitantes = scanner.nextInt();

                            Vivenda _vivenda = new Vivenda(nombre, habitantes);
                            centralita.altaVivenda(_vivenda);
                            break;

                        case 2: //ELIMINAR
                            vivendas = centralita.listarVivendas();
                            System.out.println(vivendas);

                            System.out.print("Introduzca el id de la vivenda a ser eliminada: ");
                            int id = scanner.nextInt();

                            Vivenda _selected = vivendas.get(id);

                            centralita.bajaVivenda(_selected);
                            break;
                        case 3: //LISTAR
                            vivendas = centralita.listarVivendas();
                            System.out.println(vivendas);
                            break;
                        case SALIR:
                            option = -1;
                            break;
                        default:
                            System.out.println("Opcion invalida");
                    }
                } while (option != -1);
                break;

            case HABITACION:
                vivendas = centralita.listarVivendas();
                System.out.println(vivendas);

                System.out.print("Introduzca el id de la vivenda: ");
                int idVivenda = scanner.nextInt();

                do {
                    //SubMenu VIVENDA
                    System.out.println("1. Anadir Habitacion");
                    System.out.println("2. Eliminar Habitacion");
                    System.out.println("3. Listar Habitaciones");
                    System.out.println("0. Salir");
                    option = scanner.nextInt();

                    switch(option){

                        case 1: //ANADIR
                            System.out.print("Nombre: ");
                            String nombre = scanner.next();

                            Habitacion _habitacion = new Habitacion(nombre);
                            centralita.anadirHabitaciones(idVivenda, _habitacion);
                            break;

                        case 2: //ELIMINAR
                            habitaciones = centralita.listarHabitaciones(idVivenda);
                            System.out.println(habitaciones);

                            System.out.print("Introduzca el id de la habitacion a ser eliminada: ");
                            int idHabitacion = scanner.nextInt();

                            centralita.eliminarHabitaciones(idVivenda, idHabitacion);

                            break;
                        case 3: //LISTAR
                            habitaciones = centralita.listarHabitaciones(idVivenda);
                            System.out.println(habitaciones);
                            break;
                        case SALIR:
                            option = -1;
                            break;
                        default:
                            System.out.println("Opcion invalida");
                    }
                } while (option != -1);
                break;
            case SENSORES:
                //MOSTRANDO VIVENDAS
                vivendas = centralita.listarVivendas();
                System.out.println(vivendas);

                System.out.print("Introduzca el id de la vivenda: ");
                idVivenda = scanner.nextInt();

                //MOSTRANDO HABITACIONES
                habitaciones = centralita.listarHabitaciones(idVivenda);
                System.out.println(habitaciones);

                System.out.print("Introduzca el id de la habitacion: ");
                int idHabitacion = scanner.nextInt();


                do {
                    //SubMenu
                    System.out.println("1. Anadir Sensor");
                    System.out.println("2. Eliminar Sensor");
                    System.out.println("3. Listar Sensores");
                    System.out.println("0. Salir");
                    option = scanner.nextInt();

                    switch(option){
                        case 1: // ANADIR
                            Sensor sensor = new Sensor();
                            System.out.print("Nombre: ");
                            String nombre = scanner.next();

                            System.out.print("Fabricante: ");
                            String fabricante = scanner.next();

                            System.out.print("Modelo: ");
                            String modelo = scanner.next();

                            System.out.print("Batería restante (%): ");
                            float bateria = scanner.nextFloat();

                            System.out.println("Cual es el tipo del Sensor?");
                            System.out.println("1. Sensor de Presencia");
                            System.out.println("2. Sensor de Temperatura");
                            System.out.println("3. Sensor Magnetico");
                            option = scanner.nextInt();

                            switch(option){
                                case 1:
                                    System.out.print("¿Está activo? (true/false): ");
                                    boolean activoP = scanner.nextBoolean();
                                    System.out.print("Distancia de detección (0-5): ");
                                    int distancia = scanner.nextInt();
                                    sensor = new SensorPresencia(nombre, fabricante, modelo, bateria, activoP, distancia);
                                    break;
                                case 2:
                                    System.out.print("Temperatura actual: ");
                                    float t = scanner.nextFloat();
                                    System.out.print("Temp. máxima fabricante: ");
                                    float tmaxF = scanner.nextFloat();
                                    System.out.print("Temp. mínima fabricante: ");
                                    float tminF = scanner.nextFloat();
                                    sensor = new SensorTemperatura(modelo, fabricante, nombre, bateria, t, tmaxF, tminF);
                                    break;
                                case 3:
                                    System.out.print("¿Está activo? (true/false): ");
                                    boolean activoM = scanner.nextBoolean();
                                    sensor = new SensorMagnetico(bateria, modelo, fabricante, nombre, activoM);
                                    break;
                            }

                            centralita.anadirSensor(idVivenda,idHabitacion, sensor);
                            break;

                        case 2: //ELIMINAR
                            sensores = centralita.listarSensores(idVivenda, idHabitacion);
                            System.out.println(sensores);

                            System.out.print("Introduzca el id del sensor a ser eliminado: ");
                            int idSensor = scanner.nextInt();

                            centralita.eliminarSensor(idVivenda, idHabitacion, idSensor);
                            break;

                        case 3: //LISTAR
                            sensores = centralita.listarSensores(idVivenda, idHabitacion);
                            System.out.println(sensores);
                            break;
                        case SALIR:
                            option = -1;
                            break;

                        default:
                            System.out.println("Opcion invalida");
                    }
                } while (option != -1);
                break;
            case SALIR:
                System.out.println("Adios!!");
                break;
            default:
                System.out.println("Opcion invalida");
        }
    } while (option != SALIR);
}
