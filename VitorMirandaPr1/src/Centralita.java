import java.util.ArrayList;
import java.util.HashMap;

public class Centralita {
    private HashMap<Integer, Vivenda> _viviendas;

    public Centralita() {
        _viviendas = new HashMap<>();
    }

    public boolean altaVivenda(Vivenda _vivenda) {
        _viviendas.put(_vivenda.get_id(), _vivenda);
        return true;
    }
    public boolean bajaVivenda(Vivenda _vivenda) {
        _viviendas.remove(_vivenda.get_id());
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

        Habitacion habitacion = this._viviendas.
                get(_idVivienda).
                get_habitaciones().stream().filter(h -> h.getId() == _idHabitacion).findFirst().orElse(null);;

        return habitacion.get_sensores();
    }
    public boolean anadirSensor(int _idVivienda, int _idHabitacion, Sensor _sensor) {
        Habitacion habitacion = this._viviendas.
                get(_idVivienda).
                get_habitaciones().stream().filter(h -> h.getId() == _idHabitacion).findFirst().orElse(null);

        if (habitacion == null) {
            return false;
        } else {
            ArrayList<Sensor> sensores = habitacion.get_sensores();
            sensores.add(_sensor);
            habitacion.set_sensores(sensores);
            return true;
        }
    }
    public boolean eliminarSensor(int _idVivienda, int _idHabitacion, int _idSensor) {
        //habitaciones
        Habitacion habitacion = this._viviendas.
                get(_idVivienda).
                get_habitaciones().stream().filter(h -> h.getId() == _idHabitacion).findFirst().orElse(null);

        if (habitacion == null) {
            return false;
        } else {
            ArrayList<Sensor> sensores = habitacion.get_sensores();
            sensores.removeIf(s -> s.get_id() == _idSensor);
            habitacion.set_sensores(sensores);
            return true;
        }


    }

    public boolean cargarDatos(){
        return true;
    }

    public boolean guardar(){
        return true;
    }
}
