package Sensores;

import exceptions.BateriaAgotadaException;
import java.io.Serializable;

public class SensorMagnetico extends Sensor implements Serializable {
    boolean _estaActivo;

    public SensorMagnetico() {
    }

    public SensorMagnetico(float _bateriaRestante, String _modelo, String _fabricante, String _nombre, boolean _estaActivo) {
        super(_bateriaRestante, _modelo, _fabricante, _nombre);
        this._estaActivo = _estaActivo;
    }

    public boolean is_estaActivo() throws BateriaAgotadaException {
        checkBateria();
        return _estaActivo;
    }

    public void set_estaActivo(boolean _estaActivo) throws BateriaAgotadaException {
        checkBateria();
        this._estaActivo = _estaActivo;
    }

    @Override
    public String toString() {
        String baseStr = super.toString();

        // Si la base ya indica batería agotada, no mostramos más datos
        if (baseStr.contains("BATERÍA AGOTADA")) {
            return baseStr;
        }

        return baseStr + "\nEstá Activo: '" + _estaActivo + '\'';
    }

}
