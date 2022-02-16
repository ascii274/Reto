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