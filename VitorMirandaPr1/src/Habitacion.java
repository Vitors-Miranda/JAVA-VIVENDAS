import java.util.ArrayList;

public class Habitacion {
    private int _id;
    private String nombreEstancia;
    ArrayList<Sensor> _sensores;

    public Habitacion(){}
    public Habitacion(int id, ArrayList<Sensor> _sensores, String nombreEstancia) {
        this._id = id;
        this._sensores = _sensores;
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

    public boolean altaSensorPresencia(SensorPresencia _sensor){
        return true;
    }
    public boolean altaSensorTemperatura(SensorTemperatura  _sensor){
        return true;
    }
    public boolean altaSensorMagnetico(SensorMagnetico  _sensor){
        return true;
    }
    public boolean altaSensor(Sensor _sensor){
        return true;
    }
    public boolean bajaSensorPresencia(SensorPresencia _sensor){
        return true;
    }
    public boolean bajaSensorTemperatura(SensorTemperatura  _sensor){
        return true;
    }
    public boolean bajaSensorMagnetico(SensorMagnetico  _sensor){
        return true;
    }
    public boolean bajaSensor(Sensor _sensor){
        return true;
    }

    @Override
    public String toString() {
        return  "Id: '" + _id + '\'' + "\n" +
                "Nombre de Estancia: '" + nombreEstancia + '\'';
    }
}
