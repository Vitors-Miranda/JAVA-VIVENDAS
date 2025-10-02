public class SensorMagnetico extends Sensor{
    boolean _estaActivo;

    public SensorMagnetico() {
    }

    public SensorMagnetico(float _bateriaRestante, String _modelo, String _fabricante, String _nombre, int _id, boolean _estaActivo) {
        super(_bateriaRestante, _modelo, _fabricante, _nombre, _id);
        this._estaActivo = _estaActivo;
    }

    public boolean is_estaActivo() {
        return _estaActivo;
    }

    public void set_estaActivo(boolean _estaActivo) {
        this._estaActivo = _estaActivo;
    }

    @Override
    public String toString() {
        return  "Está Activo: '" + _estaActivo + '\'';
    }

}
