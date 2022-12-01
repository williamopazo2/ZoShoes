package com.example.myapplication.modelos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.myapplication.galeriaNike.galeriaNike;
import com.example.myapplication.galeriaadidas.galeriaAdidas;
import com.example.myapplication.R;

import java.util.ArrayList;

public class Galeriazapas extends AppCompatActivity implements View.OnClickListener{

    Spinner spinner;
    Button Btn1,Btn2,Btn3,Btn4,Btn5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeriazapas);

        setContentView(R.layout.activity_galeriazapas);
        /*metodo del spinner*/
        spinner = findViewById(R.id.spinner);

        ArrayList<MarcasSpinner> marcas = new ArrayList<MarcasSpinner>();
        marcas.add(new MarcasSpinner("Selecione una marca"));
        marcas.add(new MarcasSpinner("Jordan"));
        marcas.add(new MarcasSpinner("Adidas"));
        marcas.add(new MarcasSpinner("Nike"));


        ArrayAdapter<MarcasSpinner> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,marcas);

        spinner.setAdapter(adapter);
        sspinner();

        /*university*/
        Btn1 = (Button) findViewById(R.id.Btn1);
        Btn1.setOnClickListener(this);
        /*jbalvin*/
        Btn2 = (Button) findViewById(R.id.Btn2);
        Btn2.setOnClickListener(this);
        /*jordan x dior*/
        Btn3 = (Button) findViewById(R.id.Btn3);
        Btn3.setOnClickListener(this);
        /*jordan 4 military black*/
        Btn4 = (Button) findViewById(R.id.Btn4);
        Btn4.setOnClickListener(this);
        /*jordan 4 x off white*/
        Btn5 = (Button) findViewById(R.id.Btn5);
        Btn5.setOnClickListener(this);

    }
    /*metodo para crear los staractivitys*/
    @Override
    public void onClick(View view) {
        if(view.getId()==Btn1.getId()){
            startActivity(new Intent(Galeriazapas.this, perfil41.class));
        }
        else if(view.getId()==Btn2.getId()){
            startActivity(new Intent(Galeriazapas.this, perfiljordan4jbalvin.class));
        }
        else if(view.getId()==Btn3.getId()){
            startActivity(new Intent(Galeriazapas.this, jordan1xdior.class));
        }
        else if(view.getId()==Btn4.getId()){
            startActivity(new Intent(Galeriazapas.this, jordan4military.class));
        }
        else if(view.getId()==Btn5.getId()){
            startActivity(new Intent(Galeriazapas.this, jordan4xoffwhite.class));
        }
    }

    /*metodo para llamar al spinner*/
    public void sspinner(){

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){
                    startActivity(new Intent(Galeriazapas.this, Galeriazapas.class));
                }else if(i==2){
                    startActivity(new Intent(Galeriazapas.this, galeriaAdidas.class));
                }else if(i==3){
                    startActivity(new Intent(Galeriazapas.this, galeriaNike.class));
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

}