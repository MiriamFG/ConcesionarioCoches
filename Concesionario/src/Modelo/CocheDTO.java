package Modelo;

public class CocheDTO {
    private String marca;
    private String modelo;
    private String matricula;
    private double precio;
    private int anho;
    private int kilometros;
    private boolean vendido;

    //Getters y Setters

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }

    public double getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }


    //Constructor

    public CocheDTO(String marca, String modelo, String matricula, double precio, int anho, int kilometros) {
        this.kilometros = kilometros;
        this.anho = anho;
        this.precio = precio;
        this.matricula = matricula;
        this.modelo = modelo;
        this.marca = marca;
    }
}
