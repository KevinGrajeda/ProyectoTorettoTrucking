package com.example.proyectotorettotrucking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText usuario, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.txtUsuario);
        password = findViewById(R.id.txtPassword);

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
}