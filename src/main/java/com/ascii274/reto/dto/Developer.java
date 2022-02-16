package com.ascii274.reto.dto;

public class Developer {
    private String nombre;
    private String correo;
    private Categoria categoria;
    private String telefono;
    private String fecha;

    public Developer(String nombre, String correo, Categoria categoria, String telefono, String fecha) {
        this.nombre = nombre;
        this.correo = correo;
        this.categoria = categoria;
        this.telefono = telefono;
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Developer [" +
                "nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", categoria=" + categoria +
                ", telefono='" + telefono + '\'' +
                ", fecha='" + fecha + '\'' +
                ']';
    }
}