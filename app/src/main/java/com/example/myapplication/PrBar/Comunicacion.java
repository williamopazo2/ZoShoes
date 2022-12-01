package com.example.myapplication.PrBar;

public interface Comunicacion {
    void toggleProgressBar(Boolean status);
    void lanzarActividad(Class<?> tipoActividad);
    void showMessage(String msg);
}
