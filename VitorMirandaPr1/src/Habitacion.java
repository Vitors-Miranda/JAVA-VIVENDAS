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
        return  "\n" + "Id: '" + _id + '\'' + "\n" +
                "Nombre de Estancia: '" + nombreEstancia + '\'';
    }
}
