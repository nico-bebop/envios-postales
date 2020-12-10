package ar.edu.ge.meli;

import java.time.LocalDate;
import java.util.List;

public class Envio {

    private List<Paquete> paquetes;
    private LocalDate fecha;

    public Envio(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public Envio(List<Paquete> paquetes, LocalDate fecha) {
        this.paquetes = paquetes;
        this.fecha = fecha;
    }

    public List<Paquete> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Paquete> paquetes) {
        this.paquetes = paquetes;
    }

    public int getCantidadDePaquetes() {
        return this.paquetes.size();
    }

    public Double calcularPeso() {
        return null;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
