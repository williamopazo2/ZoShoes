package com.example.myapplication.modelos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

public class perfiljordan4jbalvin extends AppCompatActivity {

    private Button buttoncompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfiljordan4jbalvin);


        /*redireccion boton*/
        buttoncompra = findViewById(R.id.buttoncompra);
        String URL = "https://stockx.com/es-es/air-jordan-1-retro-high-j-balvin";
        buttoncompra.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Uri link = Uri.parse(URL);

                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity(i);
            }
        });
    }
}