import java.util.ArrayList;

public class Vivenda {
    private static int lastID = 0;
    private int _id;
    private String _nombre;
    private int _num_habitantes;
    private ArrayList<Habitacion> _habitaciones = new ArrayList<Habitacion>();
    public Vivenda(){}
    public Vivenda( String nombre, int num_habitantes) {
        lastID++;
        this._id = lastID;
        this._nombre = nombre;
        this._num_habitantes = num_habitantes;
    }


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public ArrayList<Habitacion> get_habitaciones() {
        return _habitaciones;
    }

    public void set_habitaciones(ArrayList<Habitacion> _habitaciones) {
        this._habitaciones = _habitaciones;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String nombre) {
        this._nombre = nombre;
    }

    public int getNum_habitantes() {
        return _num_habitantes;
    }

    public void setNum_habitantes(int num_habitantes) {
        this._num_habitantes = num_habitantes;
    }

    public boolean anadirHabitacion(Habitacion habitacion){
        return _habitaciones.add(habitacion);
    }

    public boolean eliminarHabitacion(int _id){
        return _habitaciones.removeIf(h -> h.getId() == _id); //retorna true si hay una habitacion con el id fornecido

    }

    @Override
    public String toString() {
        return  "\n" + "Id:" + _id + "\n" +
                "Nombre:'" + _nombre + '\'' + "\n" +
                "Numero de Habitantes:'" + _num_habitantes + '\'';
    }
}
