package Sensores;

public class SensorPresencia extends Sensor {
    private boolean _estaActivo;
    private int _distanciaDeteccion;

    public SensorPresencia() {

    }

    public SensorPresencia(String nombre, String fabricante, String modelo, float bateriaRestante, boolean _estaActivo, int _distanciaDeteccion) {
        super(bateriaRestante, modelo, fabricante, nombre);
        this._estaActivo = _estaActivo;
        this._distanciaDeteccion = _distanciaDeteccion;
    }

    public boolean is_estaActivo() {
        return _estaActivo;
    }

    public void set_estaActivo(boolean _estaActivo) {
        this._estaActivo = _estaActivo;
    }

    public int get_distanciaDeteccion() {
        return _distanciaDeteccion;
    }

    public void set_distanciaDeteccion(int _distanciaDeteccion) {
        this._distanciaDeteccion = _distanciaDeteccion;
    }

    @Override
    public String toString() {
        return  "\n" + super.toString() +
                "Está activo: '" + _estaActivo + '\'' +"\n" +
                "Distancia de Detección:'" + _distanciaDeteccion + '\'';
    }
}
