package com.example.examendispmoviles.Modelo;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Datos implements Serializable {
    String nombre;
    String edad;
    String altura;
    String peso;
    String sexo;

    public Datos(String nombre, String edad, String altura, String peso, String sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.sexo = sexo;
    }

    public Datos() {
        this.nombre = "";
        this.edad = "";
        this.altura = "";
        this.peso = "";
        this.sexo = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    @NonNull
    @Override
    public String toString() {
        return nombre + " " + edad + " " + altura + " " + peso + " " + sexo;
    }
}