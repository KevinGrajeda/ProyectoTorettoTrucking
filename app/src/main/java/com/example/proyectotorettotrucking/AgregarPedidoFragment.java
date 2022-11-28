package com.example.proyectotorettotrucking;

import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.CAMIONES;
import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.PRODUCTOS;
import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.SUCURSALES;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectotorettotrucking.clases.Camion;

public class AgregarPedidoFragment extends Fragment {

    Spinner spnProductos, spnOrigenes, spnDestinos;
    EditText txtCantidad;
    TextView txtProductosAgregados, txtVehiculo;

    String productosAgregados = "Productos agregados:\n";
    float pesoTotal = 0;

    public AgregarPedidoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregar_pedido, container, false);

        spnProductos = view.findViewById(R.id.spnProductos);
        spnOrigenes = view.findViewById(R.id.spnOrigenes);
        spnDestinos = view.findViewById(R.id.spnDestinos);
        txtCantidad = view.findViewById(R.id.txtCantidad);
        txtProductosAgregados = view.findViewById(R.id.txtVerProductosAgregados);
        txtVehiculo = view.findViewById(R.id.txtVerVehiculo);

        view.findViewById(R.id.btnAgregarProducto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarProducto();
            }
        });

        String[] nombresProducto = new String[PRODUCTOS.length];
        String[] nombresSucursales = new String[SUCURSALES.length];

        for (int i = 0; i < PRODUCTOS.length; i++) {
            nombresProducto[i] = PRODUCTOS[i].getNombre();
        }
        for (int i = 0; i < SUCURSALES.length; i++) {
            nombresSucursales[i] = SUCURSALES[i].getNombre();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, nombresProducto);
        spnProductos.setAdapter(adapter);

        adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, nombresSucursales);
        spnOrigenes.setAdapter(adapter);
        spnDestinos.setAdapter(adapter);

        return view;
    }

    public void AgregarProducto() {
        int cantidad;
        try {
            cantidad = Integer.parseInt(txtCantidad.getText().toString());
        } catch (Exception e) {
            Toast.makeText(getActivity(), "Ingresa un numero", Toast.LENGTH_SHORT).show();
            return;
        }
        int posicionProducto = spnProductos.getSelectedItemPosition();
        float peso = cantidad * PRODUCTOS[posicionProducto].getPeso();
        pesoTotal += peso;
        productosAgregados += cantidad + " " + PRODUCTOS[posicionProducto].getNombre() + "\n";
        txtProductosAgregados.setText(productosAgregados + "\nPeso total: " + (pesoTotal / 1000) + "Kg");
        Camion camionSeleccionado = null;
        for (Camion camion : CAMIONES) {
            if ((camion.getCapacidad() * 1000) < pesoTotal) {
                break;
            } else {
                camionSeleccionado = camion;
            }
        }
        if (camionSeleccionado == null) {
            Toast.makeText(getActivity(), "no existe camion para este peso", Toast.LENGTH_SHORT).show();
            return;
        }
        txtVehiculo.setText("Vehiculo: " + camionSeleccionado.getTipo());
    }
}