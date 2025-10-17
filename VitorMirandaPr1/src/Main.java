import Sensores.Sensor;
import Sensores.SensorMagnetico;
import Sensores.SensorPresencia;
import Sensores.SensorTemperatura;

public static Integer checkInteger(String text){ //Integer Control de errores
    Scanner scanner = new Scanner(System.in);
    int number = -1;

    try{ //INTENTADO CONVERTIR EL INPUT A ENTERO
        System.out.println(text);
        number = scanner.nextInt();
    } catch (InputMismatchException e) { //EL USUARIO HA PUESTO UN VALOR NO NUMÉRICO
        System.out.println("Respuesta inválida!");
        System.out.println();
        scanner.nextLine();
    }
    return number;
}

public static Integer showMenu(){
    Scanner scanner = new Scanner(System.in);

    System.out.println();
    System.out.println("1. Opciones de VIVENDAS");
    System.out.println("2. Opciones de HABITACION");
    System.out.println("3. Opciones de SENSORES");
    System.out.println("3. Guardar archivos");
    System.out.println("3. Cargar archivos");
    System.out.println("0. Salir");
    System.out.println();

    return checkInteger("Elige la opción: ");
}

public static Integer showSubMenu(String subMenu){
    Scanner scanner = new Scanner(System.in);

    System.out.println();
    System.out.println("1. Anadir " + subMenu);
    System.out.println("2. Eliminar " + subMenu);
    System.out.println("3. Listar " + subMenu);
    System.out.println("0. Retornar al Menu");
    System.out.println();

    return checkInteger("Elige la opción: ");
}


void main() {
    //scanner
    Scanner scanner = new Scanner(System.in);

    //constantes
    int option = -1;
    final int VIVENDA = 1;
    final int HABITACION = 2;
    final int SENSORES = 3;
    final int GUARDAR = 4;
    final int CARGAR = 5;
    final int SALIR = 0;

    //Bienvenido
    System.out.println("----------------------------");
    System.out.println("Bienvenido a la Centralita!");
    System.out.println("---------------------------");

    //1. CREANDO CENTRALITA
    Centralita centralita = new Centralita();

    //2. CREANDO VIVENDAS
    Vivenda vivenda1 = new Vivenda("vivenda1", 10);

    //3. CREANDO HABITACIONES
    Habitacion habitacion1 = new Habitacion("habitacion1");

    //4. CREANDO SENSORES
    Sensor sensor1 = new SensorMagnetico(100, "LM35DZ", "Texas Instruments", "Sensores.Sensor de temperatura", true);
    Sensor sensor2 = new SensorMagnetico(0, "HC-SR04", "Kitronik", "Sensores.Sensor Ultrasónico", false);
    Sensor sensor3 = new SensorMagnetico(50, "DHT11", "Quine", "Sensores.Sensor Arduido", true);

    //5. ANADINDO A LA CENTRALITA
    vivenda1.anadirHabitacion(habitacion1);
    centralita.altaVivenda(vivenda1);
    centralita.anadirSensor(1, 1, sensor1);
    centralita.anadirSensor(1, 1, sensor2);

    //6. INICIALIZACION DE COLLECIONES VACIAS
    HashMap<Integer, Vivenda> vivendas = new HashMap<>();
    ArrayList<Habitacion> habitaciones = new ArrayList<>();
    ArrayList<Sensor> sensores = new ArrayList<>();

    do{

        //Menu
        option = showMenu();

        switch(option){
            case VIVENDA:
                do {
                    option = showSubMenu("Vivendas");  //SubMenu Vivenda

                    switch(option){
                        case 1: //ANADIR VIVENDA
                            System.out.print("Nombre: "); //Input del NOMBRE
                            String nombre = scanner.next();

                            int habitantes = checkInteger("Numero de habitantes: "); //Input del Número de Habitantes

                            Vivenda _vivenda = new Vivenda(nombre, habitantes); //Creando vivenda
                            centralita.altaVivenda(_vivenda); //Anadindo a la centralita
                            break;

                        case 2: //ELIMINAR VIVENDA
                            vivendas = centralita.listarVivendas();
                            System.out.println(vivendas); //Exibiendo las vivenda para el usuario elegir el ID.

                            System.out.print("Introduzca el id de la vivenda a ser eliminada: "); //Input del id de la vivenda
                            int id = scanner.nextInt();

                            Vivenda _selected = vivendas.get(id); //Selecionar la vivenda

                            centralita.bajaVivenda(_selected); //Eliminar de la centralita
                            break;

                        case 3: //LISTAR VIVENDA
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
                System.out.println(vivendas); //Exibiendo las vivenda para el usuario elegir el ID.

                System.out.print("Introduzca el id de la vivenda: ");
                int idVivenda = scanner.nextInt(); //para manipular la habitacion es necesario elegir una vivenda

                do {
                    option = showSubMenu("Habitaciones"); //SubMenu Habitacion

                    switch(option){

                        case 1: //ANADIR HABITACION
                            System.out.print("Nombre: ");
                            String nombre = scanner.next();

                            Habitacion _habitacion = new Habitacion(nombre);
                            centralita.anadirHabitaciones(idVivenda, _habitacion);
                            break;

                        case 2: //ELIMINAR HABITACION
                            habitaciones = centralita.listarHabitaciones(idVivenda);
                            System.out.println(habitaciones);

                            System.out.print("Introduzca el id de la habitacion a ser eliminada: ");
                            int idHabitacion = scanner.nextInt();

                            centralita.eliminarHabitaciones(idVivenda, idHabitacion);

                            break;

                        case 3: //LISTAR HABITACION
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
                idVivenda = scanner.nextInt(); //para manipular los sensores es necesario elegir una vivenda.

                //MOSTRANDO HABITACIONES
                habitaciones = centralita.listarHabitaciones(idVivenda);
                System.out.println(habitaciones);

                System.out.print("Introduzca el id de la habitacion: ");
                int idHabitacion = scanner.nextInt(); //para manipular los sensores es necesario elegir una habitacion.

                do {
                    option = showSubMenu("Sensores"); //SubMenu Sensor

                    switch(option){
                        case 1: // ANADIR SENSOR
                            Sensor sensor = new Sensor();
                            System.out.print("Nombre: ");
                            String nombre = scanner.next();

                            System.out.print("Fabricante: ");
                            String fabricante = scanner.next();

                            System.out.print("Modelo: ");
                            String modelo = scanner.next();

                            System.out.print("Batería restante (%): ");
                            float bateria = scanner.nextFloat();

                            //EXIBIENDO LOS TIPOS DE SENSORES PARA EL CLIENTE ELIGIR
                            System.out.println("Cual es el tipo del Sensores.Sensor?");
                            System.out.println("1. Sensores.Sensor de Presencia");
                            System.out.println("2. Sensores.Sensor de Temperatura");
                            System.out.println("3. Sensores.Sensor Magnetico");
                            option = scanner.nextInt();

                            switch(option){
                                case 1: //1. POLIMORFISMO DEL SENSOR DE PRESENCIA
                                    System.out.print("¿Está activo? (true/false): ");
                                    boolean activoP = scanner.nextBoolean();
                                    System.out.print("Distancia de detección (0-5): ");
                                    int distancia = scanner.nextInt();
                                    sensor = new SensorPresencia(nombre, fabricante, modelo, bateria, activoP, distancia);
                                    break;

                                case 2://1. POLIMORFISMO DEL SENSOR DE TEMPERATURA
                                    System.out.print("Temperatura actual: ");
                                    float t = scanner.nextFloat();
                                    System.out.print("Temp. máxima fabricante: ");
                                    float tmaxF = scanner.nextFloat();
                                    System.out.print("Temp. mínima fabricante: ");
                                    float tminF = scanner.nextFloat();
                                    sensor = new SensorTemperatura(modelo, fabricante, nombre, bateria, t, tmaxF, tminF);
                                    break;

                                case 3://1. POLIMORFISMO DEL SENSOR MAGNETICO
                                    System.out.print("¿Está activo? (true/false): ");
                                    boolean activoM = scanner.nextBoolean();
                                    sensor = new SensorMagnetico(bateria, modelo, fabricante, nombre, activoM);
                                    break;
                            }

                            centralita.anadirSensor(idVivenda,idHabitacion, sensor);
                            break;

                        case 2: //ELIMINAR SENSORES
                            sensores = centralita.listarSensores(idVivenda, idHabitacion);
                            System.out.println(sensores);

                            System.out.print("Introduzca el id del sensor a ser eliminado: ");
                            int idSensor = scanner.nextInt();

                            centralita.eliminarSensor(idVivenda, idHabitacion, idSensor);
                            break;

                        case 3: //LISTAR SENSORES
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
                System.out.println("----------------------");
                System.out.println("Creado por Vitor Miranda y Pedro henrique");
                System.out.println("----------------------");
                break;
            default:
                System.out.println("Opcion invalida");
        }
    } while (option != SALIR);
}
