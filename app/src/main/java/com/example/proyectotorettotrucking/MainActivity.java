package com.example.proyectotorettotrucking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.USUARIOS;
import com.example.proyectotorettotrucking.clases.Usuario;

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
        String correo  = usuario.getText().toString();
        String pass = password.getText().toString();
        int idUsuario=0;
        boolean bandera = false;
        //Toast.makeText(this, correo+" "+pass, Toast.LENGTH_SHORT).show();
        if(correo.isEmpty() || pass.isEmpty()){
            Toast.makeText(this, "Correo o contraseña vacios", Toast.LENGTH_SHORT).show();
        }
        else {
            for (int i = 0; i < USUARIOS.length; i++) {
                //Toast.makeText(this, ""+USUARIOS[i].getContraseña()+" "+USUARIOS[i].getCorreo(), Toast.LENGTH_SHORT).show();
                if (USUARIOS[i].getCorreo().equals(correo) && USUARIOS[i].getContraseña().equals(pass)) {
                    bandera = true;
                    idUsuario = i;
                    break;
                } else {
                    bandera = false;

                }
            }
            if (bandera) {
                usr.setCorreo(correo);
                usr.setContraseña(pass);
                usr.setRole(USUARIOS[idUsuario].getRole());
                usr.setId(USUARIOS[idUsuario].getId());
                usr.setRegistrado(true);
                guardarPreferencias(usr);
                Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos ", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private  void guardarPreferencias(Usuario usr){
        SharedPreferences preferences = getSharedPreferences("usr.dat",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("usuario",usr.getCorreo());
        editor.putString("contraseña",usr.getContraseña());
        editor.putInt("rol",usr.getRole());
        editor.putInt("id",usr.getId());
        editor.putBoolean("registrado",usr.isRegistrado());
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