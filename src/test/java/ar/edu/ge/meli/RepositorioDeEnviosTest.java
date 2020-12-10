package ar.edu.ge.meli;

import org.junit.Test;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class RepositorioDeEnviosTest {
    private RepositorioDeEnvios repositorioDeEnvios;
    private List<LocalDate> fechas;
    private List<Vehiculo> vehiculos;
    private List<Integer> cantidadPaquetes;
    private List<Double> pesosTotales;

    @Test
    public void debeGenerarReportes() throws EsMuyPesadoException {
        dadoUnEnviosDeHoyCon(3,300, Vehiculo.AUTO);
        cuandoGeneroReporteEnviosFechas();
        cuandoGeneroReporteEnviosVehiculos();
        cuandoGeneroReporteEnviosCantidadPaquetes();
        cuandoGeneroReporteEnviosPesosTotales();
        entoncesReporteTieneFechaHoyConAuto3Paquetes300Kg();
    }

    private void dadoUnEnviosDeHoyCon(int cantidad, double peso, Vehiculo vehiculo) throws EsMuyPesadoException {
        repositorioDeEnvios = mock(RepositorioDeEnvios.class);

        doReturn(1).when(repositorioDeEnvios).getCantidadDeEnviosDelDia();
        doReturn(Arrays.asList(Double.valueOf(peso))).when(repositorioDeEnvios).getPesosEnvios();
        doReturn(Arrays.asList(LocalDate.now())).when(repositorioDeEnvios).getFechasEnvios();
        doReturn(Arrays.asList(vehiculo)).when(repositorioDeEnvios).getVehiculosEnvios();
        doReturn(Arrays.asList(cantidad)).when(repositorioDeEnvios).getCantidadesDePaquetesDeEnvio();
    }

    private void cuandoGeneroReporteEnviosFechas() {
        fechas = repositorioDeEnvios.getFechasEnvios();
    }

    private void cuandoGeneroReporteEnviosVehiculos() throws EsMuyPesadoException {
        vehiculos = repositorioDeEnvios.getVehiculosEnvios();
    }

    private void cuandoGeneroReporteEnviosCantidadPaquetes(){
        cantidadPaquetes = repositorioDeEnvios.getCantidadesDePaquetesDeEnvio();
    }

    private void cuandoGeneroReporteEnviosPesosTotales() {
        pesosTotales = repositorioDeEnvios.getPesosEnvios();
    }

    private void entoncesReporteTieneFechaHoyConAuto3Paquetes300Kg() {
        assertThat(fechas.get(0)).isEqualTo(LocalDate.now());
        assertThat(vehiculos.get(0)).isEqualTo(Vehiculo.AUTO);
        assertThat(cantidadPaquetes.get(0)).isEqualTo(3);
        assertThat(pesosTotales.get(0)).isEqualTo(Double.valueOf(300));
    }
}
