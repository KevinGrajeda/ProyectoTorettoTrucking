package com.example.proyectotorettotrucking;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Spinner tipos,todos;
    EditText informacion;

    public HistoryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_history, container, false);

        tipos = view.findViewById(R.id.spinnerTipo);
        todos = view.findViewById(R.id.spinnerTodo);
        informacion = view.findViewById(R.id.edtInformacion);

        Productos[] Productos = new Productos[10];
        Sucursales[] Sucursales = new Sucursales[5];
        Tractor[] Tractor = new Tractor[4];
        Camion[] Camion = new Camion[6];

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

        Camion[0] = new Camion(0, new int[]{2,3,8},"CRTLO10","FreighLiner",true,25000,"Trailer",true);
        Camion[1] = new Camion(1, new int[]{2,3,8},"KLSL856","FreighLiner",true,12000,"Torthon",true);
        Camion[2] = new Camion(2, new int[]{2,3,10},"HCJE889","Ford",true,8500,"Rabon",true);
        Camion[3] = new Camion(3, new int[]{2,3,8},"CRTLO10","Ford",true,5000,"Camioneta 5 ton.",true);
        Camion[4] = new Camion(4, new int[]{2,3,8},"DACA852","Ford",true,3500,"Camioneta 3.5 ton.",true);
        Camion[5] = new Camion(5, new int[]{2,3,6},"CNNXA84","Nissan",true,1000,"Camioneta 1 ton.",true);

        Tractor[0] = new Tractor(0,new int[]{2,3,15},"DEA86","CHEVRON",false,22000,"Caja","15 metros","Neumatica","Libre",12,false);
        Tractor[1] = new Tractor(1,new int[]{2,3,15},"D86DA","CHEVRON",false,20000,"Caja Refrigerada","15 metros","Neumatica","Libre",12,true);
        Tractor[2] = new Tractor(2,new int[]{2,3,15},"FGR68","FREIGHT",false,22000,"Caja","15 metros","Neumatica","Libre",12,false);
        Tractor[3] = new Tractor(3,new int[]{2,3,15},"AE570","MALIK",false,22000,"Caja Refrigerada","15 metros","Neumatica","Libre",12,true);

        String[] ArrayTipos= new String[]{"Productos","Sucursales","Camiones","Tractores"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item,ArrayTipos);
        tipos.setAdapter(adapter);
        String[] productos = new String[Productos.length];
        String[] sucursales = new String[Sucursales.length];
        String[] camion = new String[Camion.length];
        String[] tractor = new String[Tractor.length];
        tipos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ArrayAdapter<String> adapter;
                switch (i){
                    case 0:
                        for  (int j=0; j<Productos.length; j++){
                            productos[j]=Productos[j].getNombre();
                        }

                        adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item,productos);
                        todos.setAdapter(adapter);
                        break;
                    case 1:
                        for  (int j=0; j<Sucursales.length; j++){
                            sucursales[j]=Sucursales[j].getNombre();
                        }

                        adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item,sucursales);
                        todos.setAdapter(adapter);
                        break;
                    case 2:
                        for  (int j=0; j<Camion.length; j++){
                            camion[j]=Camion[j].getTipo();
                        }

                        adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item,camion);
                        todos.setAdapter(adapter);
                        break;
                    case 3:
                        for  (int j=0; j<Tractor.length; j++){
                            tractor[j]=Tractor[j].getTipo();
                        }

                        adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item,tractor);
                        todos.setAdapter(adapter);
                        break;
                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        todos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    int n = tipos.getSelectedItemPosition();
                    switch (n){
                        case 0:
                               informacion.setText("Id: " + Productos[i].getId() + "\n"
                               +"Nombre: "+Productos[i].getNombre()+"\n"
                               +"Descripcion: "+Productos[i].getDescripcion()+"\n"
                               +"Marca: "+Productos[i].getPeso()+"  g.");
                            break;
                        case 1:
                                informacion.setText("Id: "+Sucursales[i].getId()+"\n"
                                +"Estado: "+Sucursales[i].getEstado()+"\n"
                                +"Ciudad: "+Sucursales[i].getCiudad()+"\n"
                                +"Pais: "+Sucursales[i].getPais());
                            break;
                        case 2:
                                String propio,cerrado;
                                if(Camion[i].isPropio()){
                                    propio="Propio";
                                }
                                else{
                                    propio="No es propio";
                                }
                                if(Camion[i].isCerrado()){
                                    cerrado="Cerrado";
                                }
                                else{
                                    cerrado="No es cerrado";
                                }
                                informacion.setText("Id: "+Camion[i].getId()+"\n"
                                +"Dimensiones: "+Arrays.toString(Camion[i].getDimensiones())+"\n"
                                +"Matricula: "+Camion[i].getMatricula()+"\n"
                                +"Marca: "+Camion[i].getMarca()+"\n"
                                +"Propio: "+propio+"\n"
                                +"Capacidad: "+Camion[i].getCapacidad()+"\n"
                                +"Tipo: "+Camion[i].getTipo()+"\n"
                                +"Cerrado: "+cerrado);
                            break;
                        case 3:
                            String propioT,refrigerado;
                            if(Tractor[i].isPropio()){
                                propioT="Propio";
                            }
                            else{
                                propioT="No es propio";
                            }
                            if(Tractor[i].isRefrigerado()){
                                refrigerado="Refrigerado";
                            }
                            else{
                                refrigerado="No refrigerado";
                            }
                            informacion.setText("Id: "+Tractor[i].getId()+"\n"
                                    +"Dimensiones: "+ Arrays.toString(Tractor[i].getDimensiones())+"\n"
                                    +"Matricula: "+Tractor[i].getMatricula()+"\n"
                                    +"Marca: "+Tractor[i].getMarca()+"\n"
                                    +"Propio: "+propioT+"\n"
                                    +"Capacidad: "+Tractor[i].getCapacidad()+"\n"
                                    +"Tipo: "+Tractor[i].getTipo()+"\n"
                                    +"Refrigerado: "+refrigerado);
                            break;
                    }//Cuantos cases voy a preparar


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }
}