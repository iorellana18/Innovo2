package com.example.ian.innovo2.model;

import java.io.Serializable;

/**
 * Created by ian on 14-11-17.
 */
@SuppressWarnings("serial")
public class Objeto implements Serializable {
    private String comuna;
    private String nombre;
    private String direccion;
    private String telefono;
    private String categoria;

    public Objeto(String comuna, String nombre, String direccion,
                  String telefono, String categoria){
        setComuna(comuna);
        setNombre(nombre);
        setDireccion(direccion);
        setTelefono(telefono);
        setCategoria(categoria);
    }

    public void setComuna(String comuna){this.comuna=comuna;}
    public String getComuna(){return comuna;}

    public void setNombre(String nombre){this.nombre=nombre;}
    public String getNombre(){return nombre;}

    public void setDireccion(String direccion){this.direccion=direccion;}
    public String getDireccion(){return direccion;}

    public void setTelefono(String telefono){this.telefono=telefono;}
    public String getTelefono(){return telefono;}

    public void setCategoria(String categoria){this.categoria=categoria;}
    public String getCategoria(){return categoria;}
}
