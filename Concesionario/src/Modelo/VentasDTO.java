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


    public VentasDTO(CocheDTO coche, ClientesDTO cliente, int idVenta) {
        this.fecha = new Date();
        this.coche = coche;
        this.cliente = cliente;
        this.idVenta = idVenta;
    }

    public String toString(){
        return "ID: " + idVenta + "\n" +
                "=============================================================================================================" + "\n" +
                "Coche:" + coche  +
                "=============================================================================================================" + "\n" +
                "Cliente: " + "\n" + cliente  +
                "=============================================================================================================" + "\n" +
                "Fecha: " + fecha;
    }

}
