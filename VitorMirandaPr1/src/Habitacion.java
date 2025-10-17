import Sensores.Sensor;

import java.util.ArrayList;

public class Habitacion {
    private static int lastID = 0;
    private int _id;
    private String nombreEstancia;
    ArrayList<Sensor> _sensores =  new ArrayList<>();

    public Habitacion(){}
    public Habitacion( String nombreEstancia) {
        lastID++;
        this._id = lastID;
        this.nombreEstancia = nombreEstancia;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public ArrayList<Sensor> get_sensores() {
        return _sensores;
    }

    public void set_sensores(ArrayList<Sensor> _sensores) {
        this._sensores = _sensores;
    }

    public String getNombreEstancia() {
        return nombreEstancia;
    }

    public void setNombreEstancia(String nombreEstancia) {
        this.nombreEstancia = nombreEstancia;
    }

    public boolean altaSensor(Sensor _sensor){
        if (_sensores.contains(_sensor)) return false; //ya hay un sensor con los atributos fornecidos
        _sensores.add(_sensor);
        return true;
    }

    public boolean bajaSensor(int _idSensor){
        return _sensores.removeIf(s -> s.get_id() == _idSensor); //retorna trull se hay un sensor con el id fornecido
    }

    @Override
    public String toString() {
        return  "\n" + "Id: '" + _id + '\'' + "\n" +
                "Nombre de Estancia: '" + nombreEstancia + '\'';
    }
}
