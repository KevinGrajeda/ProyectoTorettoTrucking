package com.example.proyectotorettotrucking;

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

public class AgregarPedidoFragment extends Fragment {

    Spinner spnProductos,spnOrigenes,spnDestinos;
    EditText txtCantidad;
    TextView txtProductosAgregados,txtVehiculo;

    Productos[] Productos;
    Camion[] Camiones;
    Sucursales[] Sucursales;
    Tractor[] Tractores;

    String productosAgregados="Productos agregados:\n";
    float pesoTotal=0;

    public AgregarPedidoFragment() {

    }

    /*public static AgregarPedidoFragment newInstance() {
        AgregarPedidoFragment fragment = new AgregarPedidoFragment();
        return fragment;
    }*/

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_agregar_pedido, container, false);

        spnProductos=view.findViewById(R.id.spnProductos);
        spnOrigenes=view.findViewById(R.id.spnOrigenes);
        spnDestinos=view.findViewById(R.id.spnDestinos);
        txtCantidad=view.findViewById(R.id.txtCantidad);
        txtProductosAgregados=view.findViewById(R.id.txtProductosAgregados);
        txtVehiculo=view.findViewById(R.id.txtVehiculo);

        view.findViewById(R.id.btnAgregarProducto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AgregarProducto();
            }
        });

        Productos = new Productos[10];
        Sucursales = new Sucursales[5];
        Tractores = new Tractor[4];
        Camiones = new Camion[6];

        Productos[0] = new Productos(0,"Hojas","Hojas papel bond","Scribe",900);
        Productos[1] = new Productos(1,"Lapices","Lapices N.2","BIC",150);
        Productos[2] = new Productos(2,"Laptop","Laptop gamer","Asus",1200);
        Productos[3] = new Productos(3,"Marcadores","Marcadores para pintarron","BIC",200);
        Productos[4] = new Productos(4,"Playeras","Playera basica","Yazbek",2000);
        Productos[5] = new Productos(5,"Tenis","Tenis hombre","Nike",2500);
        Productos[6] = new Productos(6,"Pizarron","Pizarron blanco","BIC",2500);
        Productos[7] = new Productos(7,"Escritorio","Escritorio 2 metros","IKEA",4500);
        Productos[8] = new Productos(8,"Pantalon","Pantalon levis 505","Levis",2500);
        Productos[9] = new Productos(9,"USB","Usb 16gb","Kingston",700);

        Sucursales[0] = new Sucursales(0,"Puerto Vallarta","Jalisco","Puerto vallarta","Mexico");
        Sucursales[1] = new Sucursales(1,"Ciudad de México","Ciudad de México","Ciudad de México","México");
        Sucursales[2] = new Sucursales(2,"Manzanillo","Colima","Manzanillo","México");
        Sucursales[3] = new Sucursales(3,"Tijuana","Baja California","Tijuana","México");
        Sucursales[4] = new Sucursales(4,"California","California","Los Angeles","USA");

        Camiones[0] = new Camion(0, new int[]{2,3,8},"CRTLO10","FreighLiner",true,25000,"Trailer",true);
        Camiones[1] = new Camion(1, new int[]{2,3,8},"KLSL856","FreighLiner",true,12000,"Torthon",true);
        Camiones[2] = new Camion(2, new int[]{2,3,10},"HCJE889","Ford",true,8500,"Rabon",true);
        Camiones[3] = new Camion(3, new int[]{2,3,8},"CRTLO10","Ford",true,5000,"Camioneta 5 ton.",true);
        Camiones[4] = new Camion(4, new int[]{2,3,8},"DACA852","Ford",true,3500,"Camioneta 3.5 ton.",true);
        Camiones[5] = new Camion(5, new int[]{2,3,6},"CNNXA84","Nissan",true,1000,"Camioneta 1 ton.",true);

        Tractores[0] = new Tractor(0,new int[]{2,3,15},"DEA86","CHEVRON",false,22000,"Caja","15 metros","Neumatica","Libre",12,false);
        Tractores[1] = new Tractor(1,new int[]{2,3,15},"D86DA","CHEVRON",false,20000,"Caja Refrigerada","15 metros","Neumatica","Libre",12,true);
        Tractores[2] = new Tractor(2,new int[]{2,3,15},"FGR68","FREIGHT",false,22000,"Caja","15 metros","Neumatica","Libre",12,false);
        Tractores[3] = new Tractor(3,new int[]{2,3,15},"AE570","MALIK",false,22000,"Caja Refrigerada","15 metros","Neumatica","Libre",12,true);

        String[] productos = new String[10];
        String[] sucursales = new String[5];
        String[] camion = new String[6];
        float[] peso = new float[6];
        for  (int i=0; i<Productos.length; i++){
            productos[i]=Productos[i].getNombre();
        }
        for (int i=0; i<Sucursales.length; i++ ){
            sucursales[i]=Sucursales[i].getNombre();
        }

        /*for(int i=0; i<Camion.length; i++){
            camion[i]=Camion[i].getTipo();
            peso[i] = Camion[i].getCapacidad();
            //Tipo de camiones que hay y su capacidad en arreglos para asiganar automaticamente
            //segun el producto y su cantidad
        }
        */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item,productos);
        spnProductos.setAdapter(adapter);

        adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item,sucursales);
        spnOrigenes.setAdapter(adapter);
        spnDestinos.setAdapter(adapter);

        return view;
    }

    public void AgregarProducto(){
        int cantidad;
        try{
            cantidad=Integer.parseInt(txtCantidad.getText().toString());
        }catch (Exception e){
            Toast.makeText(getActivity(), "Ingresa un numero", Toast.LENGTH_SHORT).show();
            return;
        }
        int posicionProducto=spnProductos.getSelectedItemPosition();
        float peso=cantidad*Productos[posicionProducto].getPeso();
        pesoTotal+=peso;
        productosAgregados+=cantidad+" "+Productos[posicionProducto].getNombre()+"\n";
        txtProductosAgregados.setText(productosAgregados+"\nPeso total: "+(pesoTotal/1000)+"Kg");
        Camion camionSeleccionado=null;
        for(Camion camion : Camiones){
            if((camion.capacidad*1000)<pesoTotal){
                break;
            }else{
                camionSeleccionado=camion;
            }
        }
        if(camionSeleccionado==null){
            Toast.makeText(getActivity(), "no existe camion para este peso", Toast.LENGTH_SHORT).show();
            return;
        }
        txtVehiculo.setText("Vehiculo: "+camionSeleccionado.getTipo());
    }
}