package com.example.demo.models;


public class Municipios {
    private String cabecera;
    private String cveInegi;
    private int id;
    private String nombre;

    public String getCabecera() {
        return cabecera;
    }

    public void setCabecera(String cabecera) {
        this.cabecera = cabecera;
    }

    public String getCveInegi() {
        return cveInegi;
    }

    public void setCveInegi(String cveInegi) {
        this.cveInegi = cveInegi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
