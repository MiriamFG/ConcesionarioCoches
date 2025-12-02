package Modelo;

import java.util.Date;

public class VentasDTO {
    private int idVenta;
    private String cliente;
    private String coche;
    private Date fecha;
    private double precioVenta;

    //Getters y Setters

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCoche() {
        return coche;
    }

    public void setCoche(String coche) {
        this.coche = coche;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }


    //Constructor

    public VentasDTO(int idVenta, String cliente, String coche, Date fecha, double precioVenta) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.coche = coche;
        this.fecha = fecha;
        this.precioVenta = precioVenta;
    }
}
