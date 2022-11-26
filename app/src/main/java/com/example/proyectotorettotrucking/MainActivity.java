package com.example.proyectotorettotrucking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    EditText usuario, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.txtUsuario);
        password = findViewById(R.id.txtPassword);
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                Intent intent;
                if (nuevoUsuario()){
                    intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        };
        Timer tiempo = new Timer();
        tiempo.schedule(tarea,10);

    }
    public void ingresarMenu(View view){
        Usuario usr = new Usuario();
        usr.setCorreo(usuario.getText().toString());
        usr.setContraseña(password.getText().toString());
        usr.setRegistrado(true);
        guardarPreferencias(usr);
        Intent intent = new Intent(MainActivity.this,MenuActivity.class);
        startActivity(intent);
        finish();
    }

    private  void guardarPreferencias(Usuario usr){
        SharedPreferences preferences = getSharedPreferences("usr.dat",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("usuario",usr.getCorreo());
        editor.putString("contraseña",usr.getContraseña());
        editor.putBoolean("registrado", usr.isRegistrado());
        editor.apply();
    }
    public void salirMenu(View view){
        finish();
    }

    private boolean nuevoUsuario(){
        SharedPreferences preferences = getSharedPreferences("usr.dat", MODE_PRIVATE);
        return preferences.getBoolean("registrado",false);
    }
}