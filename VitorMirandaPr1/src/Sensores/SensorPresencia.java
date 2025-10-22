package Sensores;

import exceptions.BateriaAgotadaException;
import java.io.Serializable;

public class SensorPresencia extends Sensor implements Serializable {
    private boolean _estaActivo;
    private int _distanciaDeteccion;

    public SensorPresencia() {

    }

    public SensorPresencia(String nombre, String fabricante, String modelo, float bateriaRestante, boolean _estaActivo, int _distanciaDeteccion) {
        super(bateriaRestante, modelo, fabricante, nombre);
        this._estaActivo = _estaActivo;
        this._distanciaDeteccion = _distanciaDeteccion;
    }

    public boolean is_estaActivo() throws BateriaAgotadaException {
        checkBateria();
        return _estaActivo;
    }

    public void set_estaActivo(boolean _estaActivo) throws BateriaAgotadaException {
        checkBateria();
        this._estaActivo = _estaActivo;
    }

    public int get_distanciaDeteccion() throws BateriaAgotadaException {
        checkBateria();
        return _distanciaDeteccion;
    }

    public void set_distanciaDeteccion(int _distanciaDeteccion) throws BateriaAgotadaException {
        checkBateria();
        this._distanciaDeteccion = _distanciaDeteccion;
    }

    @Override
    public String toString() {

        String baseStr = super.toString();

        // Si la base ya indica batería agotada, no mostramos más datos
        if (baseStr.contains("BATERÍA AGOTADA")) {
            return baseStr;
        }

        return  baseStr + "\n" +
                "Está activo: '" + _estaActivo + '\'' +"\n" +
                "Distancia de Detección:'" + _distanciaDeteccion + '\'';
    }


}
