package ar.edu.ge.meli;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeEnvios {
    
    private Integer cantidadDeEnviosDelDia;
    private List<Envio> envios;

    public RepositorioDeEnvios(Integer cantidadDeEnviosDelDia, List<Envio> envios) {
        this.cantidadDeEnviosDelDia = cantidadDeEnviosDelDia;
        this.envios = envios;
    }

    public Integer getCantidadDeEnviosDelDia() {
        return cantidadDeEnviosDelDia;
    }
    
    public void setCantidadDeEnviosDelDia(Integer cantidadDeEnviosDelDia) {
        this.cantidadDeEnviosDelDia = cantidadDeEnviosDelDia;
    }

    public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }

    public void generarReporteEnvios() {

    }

    public List<Double> getPesosEnvios() {
        List<Double> listaPesos = new ArrayList<Double>();
        for (var envio: envios)
        {
            listaPesos.add(envio.calcularPeso());
        }
        return listaPesos;
    }

    public List<LocalDate> getFechasEnvios() {
        List<LocalDate> listaFecha = new ArrayList<LocalDate>();
        for (var envio: envios)
        {
            listaFecha.add(envio.getFecha());
        }
        return listaFecha;
    }

    public List<Vehiculo> getVehiculosEnvios() throws EsMuyPesadoException {
        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        AsignadorDeVehiculos asignador = new AsignadorDeVehiculos();
        for (var envio: envios)
        {
            listaVehiculos.add(asignador.asignarVehiculo(envio));
        }
        return listaVehiculos;
    }

    public List<Integer> getCantidadesDePaquetesDeEnvio() {
        List<Integer> listaPesos = new ArrayList<Integer>();
        for (var envio: envios)
        {
            listaPesos.add(envio.getCantidadDePaquetes());
        }
        return listaPesos;
    }
}
