import Sensores.Sensor;

import java.util.ArrayList;
import java.util.HashMap;

public class Centralita {
    private HashMap<Integer, Vivenda> _viviendas;

    public Centralita() {
        _viviendas = new HashMap<>();
    }

    public boolean altaVivenda(Vivenda _vivenda) {
        _viviendas.put(_vivenda.get_id(), _vivenda); //anadir una nueva vivena al hashmap
        return true;
    }
    public boolean bajaVivenda(Vivenda _vivenda) {
        _viviendas.remove(_vivenda.get_id()); //eliminar del hashmap la vivenda fornecida
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

        habitacion.bajaSensor(_idSensor);
        return true;
    }

    public boolean cargarDatos(){
        return true;
    }

    public boolean guardar(){
        return true;
    }
}
