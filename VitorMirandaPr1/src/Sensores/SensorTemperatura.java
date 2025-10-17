package Sensores;

public class SensorTemperatura extends Sensor {
    private Float _temperatura;
    private Float _temperaturaMaximaFabricante;
    private Float _temperaturaMinimaFabricante;
    private Float _temperaturaMaximaHistorico;
    private Float _temperaturaMinimaHistorico;

    public SensorTemperatura(){}
    public SensorTemperatura(String modelo, String fabricante, String nombre, float bateriaRestante, Float _temperatura, Float _temperaturaMaximaFabricante, Float _temperaturaMinimaFabricante) {
        super(bateriaRestante, modelo, fabricante, nombre);
        this._temperatura = _temperatura;
        this._temperaturaMaximaFabricante = _temperaturaMaximaFabricante;
        this._temperaturaMinimaFabricante = _temperaturaMinimaFabricante;
    }

    public Float get_temperaturaMinimaHistorico() {
        return _temperaturaMinimaHistorico;
    }

    public void set_temperaturaMinimaHistorico(Float _temperaturaMinimaHistorico) {
        this._temperaturaMinimaHistorico = _temperaturaMinimaHistorico;
    }

    public Float get_temperaturaMaximaHistorico() {
        return _temperaturaMaximaHistorico;
    }

    public void set_temperaturaMaximaHistorico(Float _temperaturaMaximaHistorico) {
        this._temperaturaMaximaHistorico = _temperaturaMaximaHistorico;
    }

    public Float get_temperaturaMinimaFabricante() {
        return _temperaturaMinimaFabricante;
    }

    public void set_temperaturaMinimaFabricante(Float _temperaturaMinimaFabricante) {
        this._temperaturaMinimaFabricante = _temperaturaMinimaFabricante;
    }

    public Float get_temperaturaMaximaFabricante() {
        return _temperaturaMaximaFabricante;
    }

    public void set_temperaturaMaximaFabricante(Float _temperaturaMaximaFabricante) {
        this._temperaturaMaximaFabricante = _temperaturaMaximaFabricante;
    }

    public Float get_temperatura() {
        return _temperatura;
    }

    public void set_temperatura(Float _temperatura) {
        this._temperatura = _temperatura;
    }

    @Override
    public String toString() {
        return  "\n" + super.toString() +
                "Temperatura: '" + _temperatura + '\''  +"\n" +
                "Temperatura Maxima del Fabricante:'" + _temperaturaMaximaFabricante + '\'' + "\n" +
                "Temperatura Minima del Fabricante:'" + _temperaturaMinimaFabricante + '\'' + "\n" +
                "Temperatura Maxima Historico:'" + _temperaturaMaximaHistorico + '\'' + "\n" +
                "Temperatura Minima Historica:" + _temperaturaMinimaHistorico;
    }
}
