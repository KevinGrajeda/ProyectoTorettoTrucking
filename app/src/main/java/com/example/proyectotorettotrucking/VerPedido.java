package com.example.proyectotorettotrucking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        Bundle status = getIntent().getExtras();
        int status_ = 0;
        if(status != null){
            status_ = (int) status.getSerializable("status");
            if (status_ == 1){
                accionbtn.setVisibility(View.VISIBLE);
                pedidostatustxt.setText("Pedido no. "+9+" EN RUTA");
                VerProductosAgregados.setEnabled(false);
                VerProductosAgregados.setText("Productos agregados: \n" +
                        "100 Lapices\n" +
                        "400 playeras\n"+
                        "\nPeso total: 815.0 Kg");
                VerOrigen.setText("Puerto Vallarta");
                VerDestino.setText("Tijuana");
                VerDescripcion.setText("Entrega para Unitec");
                VerVehiculo.setText("Vehiculo: Camioneta 1 Ton.");
                VerPrecio.setText("Precio: $28500.00");

            }
            if (status_ == 2){
                accionbtn.setVisibility(View.GONE);
                pedidostatustxt.setText("Pedido no. "+2+" TERMINADO");
                VerProductosAgregados.setText("Productos agregados: \n" +
                        "1000 hojas\n" +
                        "100 pizarron\n"+
                        "\nPeso total: 1150.0 Kg");
                VerOrigen.setText("Ciudad de Mexico");
                VerDestino.setText("California");
                VerDescripcion.setText("Pedido para Estados Unidos");
                VerVehiculo.setText("Vehiculo: Camioneta 3.5 Ton.");
                VerPrecio.setText("Precio: $85000.00");

            }
        }
    }
}