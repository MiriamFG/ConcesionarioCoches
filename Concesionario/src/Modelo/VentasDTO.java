package Modelo;

import java.util.Date;

public class VentasDTO {
    private int idVenta;
    private ClientesDTO cliente;
    private CocheDTO coche;
    private Date fecha;

    //Getters y Setters

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public CocheDTO getCoche() {
        return coche;
    }

    public void setCoche(CocheDTO coche) {
        this.coche = coche;
    }

    public ClientesDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClientesDTO cliente) {
        this.cliente = cliente;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }



//Constructor


    public VentasDTO(Date fecha, CocheDTO coche, ClientesDTO cliente, int idVenta) {
        this.fecha = fecha;
        this.coche = coche;
        this.cliente = cliente;
        this.idVenta = idVenta;
    }
}
