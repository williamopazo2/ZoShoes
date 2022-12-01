package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.myapplication.PrBar.Comunicacion;
import com.example.myapplication.general.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivityLogin extends AppCompatActivity implements Comunicacion {

    private ImageButton btn_ig;
    private Button btn_registrar;
    private ProgressBar prbar;
    private MaterialButton btnlogin;
    EditText nombreusuario;
    EditText pass;
    int mov;
    SensorManager sensorManager;
    Sensor sensor;
    SensorEventListener sensorEventListener;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        /*Splash screen */
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        setTheme(R.style.Theme_MyApplication);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        nombreusuario = findViewById(R.id.nombreusuario);
        pass = findViewById(R.id.pw);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameUser = nombreusuario.getText().toString().trim();
                String pw = pass.getText().toString().trim();

                if(nameUser.isEmpty() && pw.isEmpty()){
                    Toast.makeText(MainActivityLogin.this, "Ingresar datos", Toast.LENGTH_SHORT).show();
                }else{
                    loginUser(nameUser,pw);
                }
            }
        });



        /*boton registrar*/
        btn_registrar = findViewById(R.id.btn_registrar);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivityLogin.this, registrar.class));
            }
        });


        /*progres bar*/
        prbar = findViewById(R.id.progresbar);

        /*redireccion botonxd*/
        btn_ig = findViewById(R.id.btn_ig);
        String URL = "https://www.instagram.com/willii_5/";
        btn_ig.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Uri link = Uri.parse(URL);

                Intent i = new Intent(Intent.ACTION_VIEW,link);
                startActivity(i);
            }
        });

        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
        sensor=sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x=sensorEvent.values[0];
                if(x<-5 && mov==0){
                    mov++;
                    Toast.makeText(MainActivityLogin.this, "applicacion solo con sentido vertical ", Toast.LENGTH_SHORT).show();
                }else if(x>5 && mov==1){
                    Toast.makeText(MainActivityLogin.this, "applicacion solo con sentido vertical", Toast.LENGTH_SHORT).show();
                    mov++;
                }
                if(mov==2){
                    mov=0;
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
        start();



    }

    private void loginUser(String nameUser, String pw) {
        mAuth.signInWithEmailAndPassword(nameUser, pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(MainActivityLogin.this, registrar.class));
                    Toast.makeText(MainActivityLogin.this, "Sesion iniciada", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(MainActivityLogin.this, "Error al logear", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void start(){
        sensorManager.registerListener(sensorEventListener,sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    private void stop(){
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onPause() {
        stop();
        super.onPause();
    }

    @Override
    protected void onResume() {
        start();
        super.onResume();
    }

    @Override
    public void toggleProgressBar(Boolean status) {
        if(status){
            prbar.setVisibility(View.VISIBLE);
        }else{
            prbar.setVisibility(View.GONE);
        }
    }

    @Override
    public void lanzarActividad(Class<?> tipoActividad) {
        Intent intent = new Intent(this,tipoActividad);
        startActivity(intent);
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}