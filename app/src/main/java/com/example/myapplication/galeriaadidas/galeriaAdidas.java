package com.example.myapplication.galeriaadidas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.myapplication.R;
import com.example.myapplication.modelos.Galeriazapas;
import com.example.myapplication.modelos.MarcasSpinner;
import com.example.myapplication.galeriaNike.galeriaNike;

import java.util.ArrayList;

public class galeriaAdidas extends AppCompatActivity implements View.OnClickListener{

    Spinner spinner;
    Button Btn1,Btn2,Btn3,Btn4,Btn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria_adidas);

        spinner = findViewById(R.id.spinner);

        ArrayList<MarcasSpinner> marcas = new ArrayList<MarcasSpinner>();
        marcas.add(new MarcasSpinner("Selecione una marca"));
        marcas.add(new MarcasSpinner("Jordan"));
        marcas.add(new MarcasSpinner("Adidas"));
        marcas.add(new MarcasSpinner("Nike"));

        ArrayAdapter<MarcasSpinner> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,marcas);
        spinner.setAdapter(adapter);
        sspinner();


        Btn1 = (Button) findViewById(R.id.Btn1);
        Btn1.setOnClickListener(this);

        Btn2 = (Button) findViewById(R.id.Btn2);
        Btn2.setOnClickListener(this);

        Btn3 = (Button) findViewById(R.id.Btn3);
        Btn3.setOnClickListener(this);

        Btn4 = (Button) findViewById(R.id.Btn4);
        Btn4.setOnClickListener(this);

        Btn5 = (Button) findViewById(R.id.Btn5);
        Btn5.setOnClickListener(this);



    }
    @Override
    public void onClick(View view) {
        if(view.getId()==Btn1.getId()){
            startActivity(new Intent(galeriaAdidas.this, ExhibitLow.class));
        }
        else if(view.getId()==Btn2.getId()){
            startActivity(new Intent(galeriaAdidas.this, Yeezysetesientos.class));
        }
        else if(view.getId()==Btn3.getId()){
            startActivity(new Intent(galeriaAdidas.this, Yeezy350.class));
        }
        else if(view.getId()==Btn4.getId()){
            startActivity(new Intent(galeriaAdidas.this, Ozelia.class));
        }
        else if(view.getId()==Btn5.getId()){
            startActivity(new Intent(galeriaAdidas.this, Ozeego.class));
        }
    }

    public void sspinner(){

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==1){
                    startActivity(new Intent(galeriaAdidas.this, Galeriazapas.class));
                }else if(i==2){
                    startActivity(new Intent(galeriaAdidas.this, galeriaAdidas.class));
                }else if(i==3){
                    startActivity(new Intent(galeriaAdidas.this, galeriaNike.class));
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}