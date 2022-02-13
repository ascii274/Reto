package com.ascii274.reto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Developer {
    private String nombre;
    private String correo;
    private String categoria;
    private String telefono;
    private String fecha;

}