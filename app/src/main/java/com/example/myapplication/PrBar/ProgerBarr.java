package com.example.myapplication.PrBar;

import android.os.AsyncTask;

import com.example.myapplication.modelos.Galeriazapas;

public class ProgerBarr extends AsyncTask<Object, Void, Boolean> {
   private Comunicacion comunicacion;

    public ProgerBarr(Comunicacion comunicacion) {
        this.comunicacion = comunicacion;
    }
    @Override
    protected void onPreExecute(){
        comunicacion.toggleProgressBar(true);
    }

    @Override
    protected Boolean doInBackground(Object... objects) {
        try{
            Thread.sleep((int)objects[2]);
            String user = (String) objects[0];
            String pass = (String) objects[1];
            if(user.equals("admin") && pass.equals("admin")){
                return true;
            }else{
                return false;
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    protected void onPostExecute(Boolean bo){
        if(bo){
            this.comunicacion.lanzarActividad(Galeriazapas.class);
            this.comunicacion.showMessage("verificando");
            this.comunicacion.toggleProgressBar(false);
        }else{
            this.comunicacion.showMessage("Datos invalidos");
        }
    }

}
