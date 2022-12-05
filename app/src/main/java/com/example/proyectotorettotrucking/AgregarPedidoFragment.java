package com.example.proyectotorettotrucking;

import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.CAMIONES;
import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.PRODUCTOS;
import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.SUCURSALES;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectotorettotrucking.baseDeDatos.ControladorBaseDatos;
import com.example.proyectotorettotrucking.clases.Camion;
import com.example.proyectotorettotrucking.clases.Pedido;
import com.example.proyectotorettotrucking.clases.Sucursal;

public class AgregarPedidoFragment extends Fragment {

    Spinner spnProductos, spnOrigenes, spnDestinos;
    EditText txtCantidad, txtDescripcion;
    TextView txtVerProductosAgregados, txtVehiculo, txtPrecio;
    Camion camionSeleccionado = new Camion();


    String productosAgregados = "Productos agregados:\n";
    float pesoTotal = 0;
    float precio = 0;

    public AgregarPedidoFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_agregar_pedido, container, false);

        spnProductos = view.findViewById(R.id.spnProductos);
        spnOrigenes = view.findViewById(R.id.spnOrigenes);
        spnDestinos = view.findViewById(R.id.spnDestinos);
        txtCantidad = view.findViewById(R.id.txtCantidad);
        txtVerProductosAgregados = view.findViewById(R.id.txtVerProductosAgregados);
        txtDescripcion = view.findViewById(R.id.txtVerDescripcion);
        txtVehiculo = view.findViewById(R.id.txtVerVehiculo);
        txtPrecio = view.findViewById(R.id.txtVerPrecio);

        view.findViewById(R.id.btnAgregarProducto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarProducto();
                calcularPrecio();
            }
        });
        spnOrigenes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                calcularPrecio();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spnDestinos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                calcularPrecio();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

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

    private void calcularPrecio() {
        Sucursal origen = SUCURSALES[spnOrigenes.getSelectedItemPosition()];
        Sucursal destino = SUCURSALES[spnDestinos.getSelectedItemPosition()];
        float distancia = (float) Math.sqrt(Math.pow(destino.getX() - origen.getX(), 2) + Math.pow(destino.getY() - origen.getY(), 2));
        precio = (distancia * 10000) + ((pesoTotal / 1000) * 10);
        if (origen.getId() != destino.getId()) {
            txtPrecio.setText("$ " + precio);
        }
    }

    public void agregarProducto() {
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

        for (Camion camion : CAMIONES) {
            System.out.println("Capacidad"+camion.getCapacidad() * 1000);
            System.out.println("Peso total"+pesoTotal);
            if ((camion.getCapacidad() * 1000) < pesoTotal) {
                camionSeleccionado = null;
                pesoTotal-=peso;
                break;
            } else {
                camionSeleccionado = camion;

            }
        }
        if (camionSeleccionado == null) {
            Toast.makeText(getActivity(), "No existe camion para este peso", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            productosAgregados += cantidad + " " + PRODUCTOS[posicionProducto].getNombre() + "\n";
            txtVerProductosAgregados.setText(productosAgregados + "\nPeso total: " + (pesoTotal / 1000) + "Kg");
        }
        txtVehiculo.setText(camionSeleccionado.getTipo());
    }

    public void terminarPedido() {
        if (spnOrigenes.getSelectedItemPosition() == spnDestinos.getSelectedItemPosition()) {
            Toast.makeText(getActivity(), "No puedes tener el mismo origen y destino", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pesoTotal == 0) {
            Toast.makeText(getActivity(), "No hay productos agregados", Toast.LENGTH_SHORT).show();
            return;
        }
        if(txtDescripcion.getText().toString().equals("")){
            Toast.makeText(getActivity(), "Agrega una descripcion", Toast.LENGTH_SHORT).show();
            return;
        }
        Pedido pedido = new Pedido();
        pedido.setProductos(productosAgregados);
        pedido.setOrigen(spnOrigenes.getSelectedItemPosition());
        pedido.setDestino(spnDestinos.getSelectedItemPosition());
        pedido.setVehiculo(camionSeleccionado.getId());
        pedido.setPrecio(precio);
        pedido.setDescripcion(txtDescripcion.getText().toString());
        pedido.setStatus(0);
        ControladorBaseDatos controlador = ((MenuActivity) requireActivity()).controlador;
        controlador.agregarPedido(pedido);
        limpiar();
        HomeFragment.getInstance().tableinit(HomeFragment.getInstance().getView());
    }

    public void limpiar(){
        productosAgregados = "Productos agregados:\n";
        pesoTotal = 0;
        precio = 0;
        camionSeleccionado = new Camion();
        spnProductos.setSelection(0);
        spnOrigenes.setSelection(0);
        spnDestinos.setSelection(0);
        txtCantidad.setText("");
        txtVerProductosAgregados.setText(productosAgregados);
        txtPrecio.setText("");
        txtVehiculo.setText("");
        txtDescripcion.setText("");
    }

    public void limpiarLight(){
        productosAgregados = "Productos agregados:\n";
        pesoTotal = 0;
        precio = 0;
        camionSeleccionado = new Camion();
        spnProductos.setSelection(0);
        txtCantidad.setText("");
        txtVerProductosAgregados.setText(productosAgregados);
        txtPrecio.setText("");
        txtVehiculo.setText("");
    }
}