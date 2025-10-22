package Sensores;
import exceptions.BateriaAgotadaException;
import exceptions.TemperaturaFueraRangoException;
import java.io.Serializable;

public class SensorTemperatura extends Sensor implements Serializable {
    private Float _temperatura;
    private Float _temperaturaMaximaFabricante;
    private Float _temperaturaMinimaFabricante;
    private Float _temperaturaMaximaHistorico;
    private Float _temperaturaMinimaHistorico;

    public SensorTemperatura() {
    }

    public SensorTemperatura(String modelo, String fabricante, String nombre, float bateriaRestante, Float _temperatura, Float _temperaturaMaximaFabricante, Float _temperaturaMinimaFabricante)

       throws TemperaturaFueraRangoException {
            super(bateriaRestante, modelo, fabricante, nombre);

            // Validamos que los rangos del fabricante sean lógicos
            if (_temperaturaMinimaFabricante > _temperaturaMaximaFabricante) {
                throw new IllegalArgumentException("La temp. mínima del fabricante no puede ser mayor que la máxima.");
            }
            this._temperaturaMaximaFabricante = _temperaturaMaximaFabricante;
            this._temperaturaMinimaFabricante = _temperaturaMinimaFabricante;

            // Validamos la temperatura inicial
            validarTemperatura(_temperatura);

            this._temperatura = _temperatura;

            // Inicializamos los históricos
            this._temperaturaMaximaHistorico = _temperatura;
            this._temperaturaMinimaHistorico = _temperatura;

        }

    // VALIDACIÓN

    private void validarTemperatura (Float temp) throws TemperaturaFueraRangoException {
        if (temp > this._temperaturaMaximaFabricante || temp < this._temperaturaMinimaFabricante) {
            throw new TemperaturaFueraRangoException(
                    "Temperatura (" + temp + "C) fuera del rango del fabricante (" +
                            _temperaturaMinimaFabricante + "C - " + _temperaturaMaximaFabricante + "C)"
            );
        }

    }



    public Float get_temperaturaMinimaHistorico() throws BateriaAgotadaException {
        checkBateria();
        return _temperaturaMinimaHistorico;
    }

    public void set_temperaturaMinimaHistorico(Float _temperaturaMinimaHistorico) throws BateriaAgotadaException {
        checkBateria();
        this._temperaturaMinimaHistorico = _temperaturaMinimaHistorico;
    }

    public Float get_temperaturaMaximaHistorico() throws BateriaAgotadaException {
        checkBateria();
        return _temperaturaMaximaHistorico;
    }

    public void set_temperaturaMaximaHistorico(Float _temperaturaMaximaHistorico) throws BateriaAgotadaException {
        checkBateria();
        this._temperaturaMaximaHistorico = _temperaturaMaximaHistorico;
    }

    public Float get_temperaturaMinimaFabricante() throws BateriaAgotadaException {
        checkBateria();
        return _temperaturaMinimaFabricante;
    }

    public void set_temperaturaMinimaFabricante(Float _temperaturaMinimaFabricante) throws BateriaAgotadaException {
        checkBateria();
        this._temperaturaMinimaFabricante = _temperaturaMinimaFabricante;
    }

    public Float get_temperaturaMaximaFabricante() throws BateriaAgotadaException {
        checkBateria();
        return _temperaturaMaximaFabricante;
    }

    public void set_temperaturaMaximaFabricante(Float _temperaturaMaximaFabricante) throws BateriaAgotadaException {
        checkBateria();
        this._temperaturaMaximaFabricante = _temperaturaMaximaFabricante;
    }

    public Float get_temperatura() throws BateriaAgotadaException {
        checkBateria();
        return _temperatura;
    }

    public void set_temperatura(Float _temperatura) throws  BateriaAgotadaException,  TemperaturaFueraRangoException {
        checkBateria();
        validarTemperatura(_temperatura);

        // Actualizamos los históricos al cambiar la temperatura
        if (this._temperaturaMaximaHistorico == null || _temperatura > this._temperaturaMaximaHistorico) {
            this._temperaturaMaximaHistorico = _temperatura;
        }
        if (this._temperaturaMinimaHistorico == null || _temperatura < this._temperaturaMinimaHistorico) {
            this._temperaturaMinimaHistorico = _temperatura;
        }

        this._temperatura = _temperatura;
    }

    @Override
    public String toString() {
        // Deja que el toString() de la clase base maneje la batería
        String baseStr = super.toString();

        // Si la base ya indica batería agotada, no mostramos más datos
        if (baseStr.contains("BATERÍA AGOTADA")) {
            return baseStr;
        }

        // Si la batería es válida (no nula), añadimos la info de temperatura
        return  "\n" + super.toString() +
                "Temperatura: '" + _temperatura + '\''  +"\n" +
                "Temperatura Maxima del Fabricante:'" + _temperaturaMaximaFabricante + '\'' + "\n" +
                "Temperatura Minima del Fabricante:'" + _temperaturaMinimaFabricante + '\'' + "\n" +
                "Temperatura Maxima Historico:'" + _temperaturaMaximaHistorico + '\'' + "\n" +
                "Temperatura Minima Historico:" + _temperaturaMinimaHistorico;
    }
}
