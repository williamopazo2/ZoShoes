package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.general.MainActivity;
import com.example.myapplication.general.register;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class registrar extends AppCompatActivity {

    EditText name;
    EditText password;
    EditText email;
    Button registrar;
    FirebaseFirestore bd;
    FirebaseAuth bdaut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        /*Boton y validacion para pasar a la siguiente pagina*/
        registrar = findViewById(R.id.registrar);

        name =  findViewById(R.id.txtUser);
        password = findViewById(R.id.txtPassword);
        email = findViewById(R.id.txtEmail);

        bd = FirebaseFirestore.getInstance();
        bdaut = FirebaseAuth.getInstance();



        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameUser = name.getText().toString().trim();
                String emailUser = email.getText().toString().trim();
                String pw = password.getText().toString().trim();

                if(nameUser.isEmpty() && emailUser.isEmpty() && pw.isEmpty()){
                    Toast.makeText(registrar.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }else{
                    registerUser(nameUser,emailUser,pw);
                }
            }
        });
    }

    private void registerUser(String nameUser, String emailUser, String pw) {
        bdaut.createUserWithEmailAndPassword(emailUser, pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                String id = bdaut.getCurrentUser().getUid();
                Map<String, Object> map = new HashMap<>();
                map.put("id",id);
                map.put("user",nameUser);
                map.put("email",emailUser);
                map.put("password",pw);

                bd.collection("user").document(id).set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        finish();
                        startActivity(new Intent(registrar.this, MainActivity.class));
                        Toast.makeText(registrar.this, "Usuario registrado correctamente", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(registrar.this, "Error al guardar", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(registrar.this, "Error al registrar", Toast.LENGTH_SHORT).show();
            }
        });
    }


}