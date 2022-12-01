package com.example.myapplication.PrBar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.modelos.Galeriazapas;

public class register extends AppCompatActivity {

    /*variables*/

    private EditText editNombre;
    private EditText editPW;
    private EditText editCorreo;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /*Boton y validacion para pasar a la siguiente pagina*/

        editNombre = (EditText) findViewById(R.id.editNombre);
        registrar = (Button) findViewById(R.id.registrar);
        editPW = (EditText) findViewById(R.id.editPW);
        editCorreo = (EditText) findViewById(R.id.editCorreo);


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editNombre.getText().toString().isEmpty() && !editCorreo.getText().toString().isEmpty() && !editPW.getText().toString().isEmpty()){

                    Intent intent = new Intent(register.this, Galeriazapas.class);
                    intent.putExtra("nombre", editNombre.getText().toString());
                    intent.putExtra("correo", editCorreo.getText().toString());
                    intent.putExtra("contrasenha", editPW.getText().toString());
                    startActivity(intent);

                }else{
                    Toast.makeText(register.this, "Falta Informacion ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}