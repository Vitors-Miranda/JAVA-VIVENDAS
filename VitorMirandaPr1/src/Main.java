import Sensores.Sensor;
import Sensores.SensorMagnetico;
import Sensores.SensorPresencia;
import Sensores.SensorTemperatura;
import exceptions.BateriaAgotadaException;
import exceptions.TemperaturaFueraRangoException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;

public static Integer checkInteger(String text){ //Integer Control de errores
    Scanner scanner = new Scanner(System.in);
    int number = -1;

    try{ //INTENTADO CONVERTIR EL INPUT A ENTERO
        System.out.print(text);
        number = scanner.nextInt();
    } catch (InputMismatchException e) { //EL USUARIO HA PUESTO UN VALOR NO NUMÉRICO
        System.out.println("Respuesta inválida! Debe introducir un número entero.");
        System.out.println();
        scanner.nextLine();
    }
    return number;
}

public static Integer showMenu(){

    System.out.println();
    System.out.println("1. Opciones de VIVENDAS");
    System.out.println("2. Opciones de HABITACION");
    System.out.println("3. Opciones de SENSORES");
    System.out.println("4. Guardar archivos");
    System.out.println("5. Cargar archivos");
    System.out.println("0. Salir");
    System.out.println();

    return checkInteger("Elige la opción: ");
}

public static Integer showSubMenu(String subMenu){

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

    //5. AÑADIENDO A LA CENTRALITA
    vivenda1.anadirHabitacion(habitacion1);
    centralita.altaVivenda(vivenda1);

    centralita.anadirSensor(vivenda1.get_id(), habitacion1.getId(), sensor1);
    centralita.anadirSensor(vivenda1.get_id(), habitacion1.getId(), sensor2);
    centralita.anadirSensor(vivenda1.get_id(), habitacion1.getId(), sensor3);

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
                        case 1: //ANADIR VIVIENDA
                            System.out.print("Nombre: "); //Input del NOMBRE
                            String nombre = scanner.next();

                            int habitantes = checkInteger("Numero de habitantes: "); //Input del Número de Habitantes

                            Vivenda _vivenda = new Vivenda(nombre, habitantes); //Creando vivenda
                            centralita.altaVivenda(_vivenda); //Anadindo a la centralita
                            break;

                        case 2: //ELIMINAR VIVENDA
                            vivendas = centralita.listarVivendas();
                            System.out.println(vivendas); //Exibiendo las vivIendas para el usuario elegir el ID.

                            System.out.print("Introduzca el id de la vivienda a ser eliminada: "); //Input del id de la vivenda
                            int id = scanner.nextInt();

                            Vivenda _selected = vivendas.get(id); //Selecionar la vivenda

                            if(centralita.bajaVivenda(_selected)){ //Eliminar de la centralita
                                System.out.println("Vivenda eliminada.");
                            }else {
                                System.out.println("ID de Vivenda no encontrado.");
                            }
                            break;

                        case 3: //LISTAR VIVENDA
                            vivendas = centralita.listarVivendas();
                            if(vivendas.isEmpty()){
                                System.out.println("No hay vivendas registradas.");
                            }
                            System.out.println(vivendas);
                            break;
                        case SALIR:
                            option = -1; //Vuelve al menú principal
                            break;
                        default:
                            System.out.println("Opción inválida");
                    }
                } while (option != -1);
                break;

            case HABITACION:
                vivendas = centralita.listarVivendas();
                if (vivendas.isEmpty()){
                    System.out.println("No hay vivendas registradas. Añada una vivienda primero.");
                    break;
                }
                System.out.println(vivendas); //Exibiendo las vivenda para el usuario elegir el ID.

                //Para manipular la habitacion es necesario elegir una vivenda válida.
                int idVivenda = checkInteger("Introduzca el id de la vivenda: ");

                if (centralita.listarVivendas().get(idVivenda) == null) {
                    System.out.println("ID de vivenda no válido.");
                    break;
                }

                do {
                    option = showSubMenu("Habitaciones"); //SubMenu Habitacion

                    switch(option){

                        case 1: //ANADIR HABITACION
                            System.out.print("Nombre: ");
                            String nombre = scanner.next();

                            Habitacion _habitacion = new Habitacion(nombre);
                            centralita.anadirHabitaciones(idVivenda, _habitacion);
                            System.out.println("Habitación añadida con ID: " + _habitacion.getId());
                            break;

                        case 2: //ELIMINAR HABITACION
                            habitaciones = centralita.listarHabitaciones(idVivenda);
                            if (habitaciones.isEmpty()){
                                System.out.println("No hay habitaciones registradas en esta vivienda.");
                            }
                            System.out.println(habitaciones);

                            int idHabitacion = checkInteger("Introduzca el id de la habitacion a ser eliminada: ");

                            if (centralita.eliminarHabitaciones(idVivenda, idHabitacion)){
                                System.out.println("Habitación eliminada.");
                            }else {
                                System.out.println("ID de habitación no encontrado.");
                            }
                            break;

                        case 3: //LISTAR HABITACION
                            habitaciones = centralita.listarHabitaciones(idVivenda);
                            if (habitaciones.isEmpty()){
                                System.out.println("No hay habitaciones en esta vivienda.");
                            }else {
                                System.out.println(habitaciones);
                            }
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
                if (vivendas.isEmpty()){
                    System.out.println("No hay vivendas registradas. Añada una vivienda primero.");
                    break;
                }
                System.out.println(vivendas);

                //Para manipular los sensores es necesario elegir una vivenda.
                idVivenda = checkInteger("Introduzca el id de la vivenda: ");
                if (centralita.listarVivendas().get(idVivenda) == null) {
                    System.out.println("ID de vivenda no válido.");
                    break;
                }

                //MOSTRANDO HABITACIONES
                habitaciones = centralita.listarHabitaciones(idVivenda);
                if (habitaciones.isEmpty()){
                    System.out.println("No hay habitaciones. Añada una habitación primero.");
                    break;
                }
                System.out.println(habitaciones);

                //Para manipular los sensores es necesario elegir una habitacion.
                int idHabitacion = checkInteger("Introduzca el id de la habitacion: ");

                do {
                    option = showSubMenu("Sensores"); //SubMenu Sensor

                    switch(option){
                        case 1: // AÑADIR SENSOR
                            try {
                                Sensor sensor = new Sensor();
                                System.out.print("Nombre: ");
                                String nombre = scanner.next();

                                System.out.print("Fabricante: ");
                                String fabricante = scanner.next();

                                System.out.print("Modelo: ");
                                String modelo = scanner.next();

                                float bateria = -1;
                                while (bateria < 0 || bateria > 100) {
                                    // Usamos checkInteger y luego casteamos a float
                                    bateria = (float) checkInteger("Batería restante (0-100): ");

                                }


                                //EXIBIENDO LOS TIPOS DE SENSORES PARA EL CLIENTE ELEGIR
                                System.out.println("Cuál es el tipo del Sensor?");
                                System.out.println("1. Sensor de Presencia");
                                System.out.println("2. Sensor de Temperatura");
                                System.out.println("3. Sensor Magnético");
                                int tipoSensor = checkInteger("Elige el tipo: ");

                                switch (tipoSensor) {
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

                                    default:
                                        System.out.println("Tipo de sensor no válido.");
                                        break;
                                }
                                if (sensor != null) {
                                    centralita.anadirSensor(idVivenda, idHabitacion, sensor);
                                    System.out.println("Sensor añadido con ID: " + sensor.get_id());
                                }
                            }catch (Exception e) {
                                System.err.println("\nHa ocurrido un error inesperado: " + e.getMessage());
                            }
                                    break;

                        case 2: //ELIMINAR SENSORES
                            //Como este bloque solo maneja IDs, no añado try-catch
                            sensores = centralita.listarSensores(idVivenda, idHabitacion);
                            if (sensores.isEmpty()){
                                System.out.println("No hay sensores en esta habitación.");
                                break;
                            }
                            System.out.println(sensores);

                            int idSensor = checkInteger("Introduzca el id del sensor a ser eliminado: ");

                            if (centralita.eliminarSensor(idVivenda, idHabitacion, idSensor)) {
                                System.out.println("Sensor eliminado.");
                            } else {
                                System.out.println("ID de sensor no encontrado.");
                            }
                            break;


                        case 3: //LISTAR SENSORES
                            sensores = centralita.listarSensores(idVivenda, idHabitacion);
                            if (sensores.isEmpty()){
                                System.out.println("No hay sensores en esta habitación.");
                            }else{

                                //Iteramos y llamamos a toString() individualmente
                                // Esto permite que el toString() de Sensor maneje la BateriaAgotadaException

                                System.out.println("Sensores de la habitación ID "+idHabitacion+":");
                                for (Sensor sensor : sensores) {
                                    System.out.println(sensor.toString()); // toString() es capaz de manejar su propio error
                                }
                            }
                            break;
                        case SALIR:
                            option = -1;
                            break;

                        default:
                            System.out.println("Opción no válida");
                    }
                } while (option != -1);
                break;


            case GUARDAR:
                System.out.println("Guardando datos en el archivo...");
                centralita.guardar();
                break;

            case CARGAR:
                System.out.println("Cargando datos desde el archivo...");
                centralita.cargarDatos();
                System.out.println("Datos cargados. ");
                break;

            case SALIR:
                System.out.println("----------------------");
                System.out.println("Creado por Vitor Miranda y Pedro Henrique");
                System.out.println("----------------------");
                break;
            default:
                System.out.println("Opcion invalida");
        }
    } while (option != SALIR);

    scanner.close(); //Cerrar el scaner principal
}
