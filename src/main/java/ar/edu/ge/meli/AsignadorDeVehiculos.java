package ar.edu.ge.meli;

public class AsignadorDeVehiculos {
    public Vehiculo asignarVehiculo(Envio envio) throws EsMuyPesadoException {
        Double peso = envio.calcularPeso();
        if (peso < 5) {
            return Vehiculo.BICICLETA;
        } else if (peso < 50) {
            return Vehiculo.AUTO;
        } else if (peso < 150) {
            return Vehiculo.CAMIONETA;
        }
        else if (envio.getPaquetes().size() == 1 && peso < 0.50){
            return Vehiculo.DRON;
        }
        throw new EsMuyPesadoException();
    }
}
