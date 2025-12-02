package Modelo;

public class ClientesDTO {
    private String dni;
    private String nombre;
    private int telefono;

    //Getters y Setters

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }


    //Constructor

    public ClientesDTO(String dni, String nombre, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
