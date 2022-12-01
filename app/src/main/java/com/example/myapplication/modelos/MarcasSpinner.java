package com.example.myapplication.modelos;

import java.util.ArrayList;

public class MarcasSpinner {
    private String marcas;
    private String mostrarMarcas;

    public MarcasSpinner(){

    }

    public MarcasSpinner(String marcas){
        this.marcas = marcas;
    }

    public String getMarcas(){
        return marcas;
    }

    public void setMarcas(String marcas){
        this.marcas = marcas;
    }

    @Override
    public String toString(){
        this.mostrarMarcas =  this.mostrarMarcas = marcas;
        return mostrarMarcas;
    }


}
