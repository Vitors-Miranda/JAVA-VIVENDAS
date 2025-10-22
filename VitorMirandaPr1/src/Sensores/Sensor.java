package Sensores;

import java.io.Serializable;
import exceptions.BateriaAgotadaException;

public class Sensor implements Serializable {
    private static int lastID = 0;
    private int _id;
    private String _nombre;
    private String _fabricante;
    private String _modelo;
    private float _bateriaRestante;

    public Sensor() {

    }
    public Sensor(float _bateriaRestante, String _modelo, String _fabricante, String _nombre) {
        lastID++;
        this._bateriaRestante = _bateriaRestante;
        this._modelo = _modelo;
        this._fabricante = _fabricante;
        this._nombre = _nombre;
        this._id = lastID;
    }

    // Comprueba si la batería del sensor está agotada (<= 0).
    //@throws BateriaAgotadaException si la batería es 0 o menos.

    protected void checkBateria() throws BateriaAgotadaException {
        if (this._bateriaRestante <= 0) {
            throw new BateriaAgotadaException(
                    "Batería agotada para el sensor (ID: " + this._id + ", Nombre: " + this._nombre + "). Operación cancelada."
            );
        }
    }

    public static int getLastID() {
        return lastID;
    }
    public static void setLastID(int id) {
        lastID = id;
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

    public String get_nombre() throws BateriaAgotadaException {
        checkBateria();
        return _nombre;
    }

    public void set_nombre(String _nombre) throws BateriaAgotadaException {
        checkBateria();
        this._nombre = _nombre;
    }

    public String get_fabricante() throws BateriaAgotadaException {
        checkBateria();
        return _fabricante;
    }

    public void set_fabricante(String _fabricante) throws BateriaAgotadaException {
        checkBateria();
        this._fabricante = _fabricante;
    }

    public String get_modelo() throws BateriaAgotadaException {
        checkBateria();
        return _modelo;
    }

    public void set_modelo(String _modelo) throws BateriaAgotadaException {
        checkBateria();
        this._modelo = _modelo;
    }

    @Override
    public String toString() {
        // Manejo de la excepción de la batería
        try {
            checkBateria();
            return  "\n" + "id:" + _id + "\n" +
                    "nombre:'" + _nombre + '\'' + "\n" +
                    "fabricante:'" + _fabricante + '\'' + "\n" +
                    "modelo:'" + _modelo + '\'' + "\n" +
                    "bateriaRestante:" + _bateriaRestante;
        } catch (BateriaAgotadaException e) {
            // Devuelve un estado de error si la batería está agotada
            return "\n" + "id:" + _id + "\n" +
                    "nombre:'" + _nombre + '\'' + "\n" +
                    "--- BATERÍA AGOTADA (0%) ---";
        }


    }
}
