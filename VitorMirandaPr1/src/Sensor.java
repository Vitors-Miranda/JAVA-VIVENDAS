public class Sensor {
    private int _id;
    private String _nombre;
    private String _fabricante;
    private String _modelo;
    private float _bateriaRestante;

    public Sensor() {

    }
    public Sensor(float _bateriaRestante, String _modelo, String _fabricante, String _nombre, int _id) {
        this._bateriaRestante = _bateriaRestante;
        this._modelo = _modelo;
        this._fabricante = _fabricante;
        this._nombre = _nombre;
        this._id = _id;
    }
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public float get_bateriaRestante() {
        return _bateriaRestante;
    }

    public void set_bateriaRestante(float _bateriaRestante) {
        this._bateriaRestante = _bateriaRestante;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public String get_fabricante() {
        return _fabricante;
    }

    public void set_fabricante(String _fabricante) {
        this._fabricante = _fabricante;
    }

    public String get_modelo() {
        return _modelo;
    }

    public void set_modelo(String _modelo) {
        this._modelo = _modelo;
    }

    @Override
    public String toString() {
        return  "id:" + _id + "\n" +
                "nombre:'" + _nombre + '\'' + "\n" +
                "fabricante:'" + _fabricante + '\'' + "\n" +
                "modelo:'" + _modelo + '\'' + "\n" +
                "bateriaRestante:" + _bateriaRestante;
    }
}
