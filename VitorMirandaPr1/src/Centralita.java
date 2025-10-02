import java.util.ArrayList;
import java.util.HashMap;

public class Centralita {
    private HashMap<Integer, Vivenda> _viviendas;

    public Centralita() {}

    public boolean altaVivenda(Vivenda _vivenda) {
        return true;
    }
    public boolean bajaVivenda(Vivenda _vivenda) {
        return true;
    }
    public HashMap<Integer, Vivenda> listarVivendas() {
        return this._viviendas;
    }
    public ArrayList<Habitacion> listarHabitaciones(int idVivenda) {
        return this._viviendas.
                get(idVivenda).
                get_habitaciones();
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
        return this._viviendas.
                get(_idVivienda).
                get_habitaciones().
                get(_idHabitacion).
                get_sensores();
    }
    public boolean anadirSensor(int _idVivienda, int _idHabitacion, Sensor _sensor) {
        //habitaciones
        Habitacion habitacion = this._viviendas.
                get(_idVivienda).
                get_habitaciones().
                get(_idHabitacion);

        //
        ArrayList<Sensor> sensores = habitacion.get_sensores();
        sensores.add(_sensor);
        this._viviendas.
                get(_idVivienda).
                get_habitaciones().
                get(_idHabitacion).set_sensores(sensores);

        return sensores.getLast() == _sensor;
    }
    public boolean eliminarSensor(int _idVivienda, int _idHabitacion, int _idSensor) {
        //habitaciones
        Habitacion habitacion = this._viviendas.
                get(_idVivienda).
                get_habitaciones().
                get(_idHabitacion);

        //
        ArrayList<Sensor> sensores = habitacion.get_sensores();

        return sensores.remove(_idSensor) != null;
    }

    public boolean cargarDatos(){
        return true;
    }

    public boolean guardar(){
        return true;
    }
}
