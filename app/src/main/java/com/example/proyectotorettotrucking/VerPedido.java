package com.example.proyectotorettotrucking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectotorettotrucking.baseDeDatos.ControladorBaseDatos;
import com.example.proyectotorettotrucking.clases.Pedido;
import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.CAMIONES;
import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.PRODUCTOS;
import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.SUCURSALES;

public class VerPedido extends AppCompatActivity {

    Button accionbtn;
    Button volverbtn;
    TextView pedidostatustxt;

    TextView VerProductosAgregados;
    TextView VerOrigen;
    TextView VerDestino;
    TextView VerDescripcion;
    TextView VerVehiculo;
    TextView VerPrecio;
    Pedido pedido_ = new Pedido();
    ControladorBaseDatos controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pedido);


         accionbtn = findViewById(R.id.btnAccion);

         pedidostatustxt = findViewById(R.id.txtPedidoStatus);
         volverbtn = findViewById(R.id.btnBack);
         VerProductosAgregados = findViewById(R.id.txtVerProductosAgregados);
         VerOrigen = findViewById(R.id.txtVerOrigen);
         VerDestino = findViewById(R.id.txtVerDestino);
         VerDescripcion = findViewById(R.id.txtVerDescripcion);
         VerVehiculo = findViewById(R.id.txtVerVehiculo);
         VerPrecio = findViewById(R.id.txtVerPrecio);

         volverbtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent navegacion = new Intent(VerPedido.this, MenuActivity.class);
                 startActivity(navegacion);
                 finish();
             }
         });

        Bundle pedido = getIntent().getExtras();
        if(pedido != null){
            pedido_ = (Pedido) pedido.getSerializable("pedido");


            if (pedido_.getStatus() == 0){ // Pedido Abierto
                accionbtn.setVisibility(View.VISIBLE);
                pedidostatustxt.setText("Pedido no. "+pedido_.getId()+" EN RUTA");
            }else{
                pedidostatustxt.setText("Pedido no. "+pedido_.getId()+" TERMINADO");
                accionbtn.setVisibility(View.INVISIBLE);
            }

                VerProductosAgregados.setEnabled(false);
                VerProductosAgregados.setText(pedido_.getProductos());
                VerOrigen.setText(SUCURSALES[pedido_.getOrigen()].getNombre());
                VerDestino.setText(SUCURSALES[pedido_.getDestino()].getNombre());
                VerDescripcion.setText(pedido_.getDescripcion());
                VerVehiculo.setText("Vehiculo: " +CAMIONES[pedido_.getVehiculo()].getTipo()+" - "+CAMIONES[pedido_.getVehiculo()].getMarca());
                VerPrecio.setText("Precio: $"+pedido_.getPrecio());
        }

    }
    public void entregarPedido(View view){
            MenuActivity.getInstance().controlador.finalizarPedido(pedido_.getId());
            Toast.makeText(this,"Pedido Finalizado correctamente",Toast.LENGTH_LONG).show();
            Intent navegacion = new Intent(VerPedido.this, MenuActivity.class);
            startActivity(navegacion);
            HomeFragment.getInstance().tableinit(HomeFragment.getInstance().getView());
            finish();
    }
}