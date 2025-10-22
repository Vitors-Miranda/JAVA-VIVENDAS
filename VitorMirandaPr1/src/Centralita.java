import Sensores.Sensor;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Centralita {
    private HashMap<Integer, Vivenda> _viviendas;
    private static final String DATA_FILE = "data/centralita.ser"; //Ruta del archivo

    public Centralita() {
        _viviendas = new HashMap<>();
    }

    public boolean altaVivenda(Vivenda _vivenda) {
        _viviendas.put(_vivenda.get_id(), _vivenda); //anadir una nueva vivienda al hashmap
        return true;
    }
    public boolean bajaVivenda(Vivenda _vivenda) {
        try {
            _viviendas.remove(_vivenda.get_id()); //eliminar del hashmap la vivenda fornecida
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public HashMap<Integer, Vivenda> listarVivendas() {
        return this._viviendas; //listar el HashMap
    }
    public ArrayList<Habitacion> listarHabitaciones(int idVivenda) {
        return this._viviendas.
                get(idVivenda).
                get_habitaciones(); //getter que lista el ArrayList de las habitaciones
    }
    public boolean anadirHabitaciones(int _idVivienda, Habitacion habitacion) {
        return this._viviendas.
                get(_idVivienda).
                anadirHabitacion(habitacion);
    }
    public boolean eliminarHabitaciones(int idVivenda, int _idHabitacion) {
        return this._viviendas.
                get(idVivenda).
                eliminarHabitacion(_idHabitacion);

    }
    public ArrayList<Sensor> listarSensores(int _idVivienda, int _idHabitacion) {

        Habitacion habitacion = this._viviendas.
                get(_idVivienda).
                get_habitaciones().stream().
                filter(h -> h.getId() == _idHabitacion).findFirst().orElse(null); //retorna null si no hay habitacion

        if (habitacion == null) return new ArrayList<>(); //retorna una lista vacia

        return habitacion.get_sensores(); //retorna lista de sensores
    }
    public boolean anadirSensor(int _idVivienda, int _idHabitacion, Sensor _sensor) {

        //Obtener la vivenda y la habitación
        Habitacion habitacion = this._viviendas.
                get(_idVivienda).
                get_habitaciones().stream().
                filter(h -> h.getId() == _idHabitacion).findFirst().orElse(null); //retorna null si no hay habitacion

        if (habitacion == null) return false; //no hay una habitacion o vivenda con el id

        habitacion.altaSensor(_sensor);
        return true;

    }
    public boolean eliminarSensor(int _idVivienda, int _idHabitacion, int _idSensor) {
        //Obtener la vivenda y la habitacioón
        Habitacion habitacion = this._viviendas.
                get(_idVivienda).
                get_habitaciones().stream().
                filter(h -> h.getId() == _idHabitacion).findFirst().orElse(null); //retorna null si no hay habitacion

        if (habitacion == null) return false; //no hay una habitacion o vivenda con el id

        return habitacion.bajaSensor(_idSensor);
    }


   //CARGAR DATOS
    @SuppressWarnings("unchecked") // Suprime el warning del casting de HashMap

    public boolean cargarDatos(){
        File dataFile = new File(DATA_FILE);
        if (!dataFile.exists()) {
            System.out.println("No se encontró el archivo " + DATA_FILE + ". Empezando sistema vacío.");
            return false;
        }

        try (FileInputStream fis = new FileInputStream(DATA_FILE);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // 1. Cargar los contadores estáticos (en el mismo orden que se guardaron)
            Vivenda.setLastID((Integer) ois.readObject());
            Habitacion.setLastID((Integer) ois.readObject());
            Sensor.setLastID((Integer) ois.readObject());

            // 2. Cargar el HashMap principal
            _viviendas = (HashMap<Integer, Vivenda>) ois.readObject();

            System.out.println("Datos cargados correctamente desde " + DATA_FILE);
            return true;

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    //GUARDAR DATOS

    public boolean guardar(){

        // Asegurar que el directorio 'data' exista
        File dataDir = new File("data");
        if (!dataDir.exists()) {
            dataDir.mkdirs();
        }

        try (FileOutputStream fos = new FileOutputStream(DATA_FILE);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // 1. Guardar los contadores estáticos
            oos.writeObject(Vivenda.getLastID());
            oos.writeObject(Habitacion.getLastID());
            oos.writeObject(Sensor.getLastID());

            // 2. Guardar el HashMap principal
            oos.writeObject(_viviendas);

            System.out.println("Datos guardados correctamente en " + DATA_FILE);
            return true;

        } catch (IOException e) {
            System.err.println("Error al guardar los datos: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }



















}
