package com.example.proyectotorettotrucking;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.CAMIONES;
import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.PRODUCTOS;
import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.SUCURSALES;
import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.TRACTORES;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
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
        
        String[] ArrayTipos= new String[]{"Productos","Sucursales","Camiones","Tractores"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item,ArrayTipos);
        tipos.setAdapter(adapter);
        String[] productos = new String[PRODUCTOS.length];
        String[] sucursales = new String[SUCURSALES.length];
        String[] camion = new String[CAMIONES.length];
        String[] tractor = new String[TRACTORES.length];
        tipos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ArrayAdapter<String> adapter;
                switch (i){
                    case 0:
                        for  (int j=0; j<PRODUCTOS.length; j++){
                            productos[j]=PRODUCTOS[j].getNombre();
                        }

                        adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item,productos);
                        todos.setAdapter(adapter);
                        break;
                    case 1:
                        for  (int j=0; j<SUCURSALES.length; j++){
                            sucursales[j]=SUCURSALES[j].getNombre();
                        }

                        adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item,sucursales);
                        todos.setAdapter(adapter);
                        break;
                    case 2:
                        for  (int j=0; j<CAMIONES.length; j++){
                            camion[j]=CAMIONES[j].getTipo();
                        }

                        adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item,camion);
                        todos.setAdapter(adapter);
                        break;
                    case 3:
                        for  (int j=0; j<TRACTORES.length; j++){
                            tractor[j]=TRACTORES[j].getTipo();
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
                               informacion.setText("Id: " + PRODUCTOS[i].getId() + "\n"
                               +"Nombre: "+PRODUCTOS[i].getNombre()+"\n"
                               +"Descripcion: "+PRODUCTOS[i].getDescripcion()+"\n"
                               +"Marca: "+PRODUCTOS[i].getPeso()+"  g.");
                            break;
                        case 1:
                                informacion.setText("Id: "+SUCURSALES[i].getId()+"\n"
                                +"Estado: "+SUCURSALES[i].getEstado()+"\n"
                                +"Ciudad: "+SUCURSALES[i].getCiudad()+"\n"
                                +"Pais: "+SUCURSALES[i].getPais());
                            break;
                        case 2:
                                String propio,cerrado;
                                if(CAMIONES[i].isPropio()){
                                    propio="Propio";
                                }
                                else{
                                    propio="No es propio";
                                }
                                if(CAMIONES[i].isCerrado()){
                                    cerrado="Cerrado";
                                }
                                else{
                                    cerrado="No es cerrado";
                                }
                                informacion.setText("Id: "+CAMIONES[i].getId()+"\n"
                                +"Dimensiones: "+Arrays.toString(CAMIONES[i].getDimensiones())+"\n"
                                +"Matricula: "+CAMIONES[i].getMatricula()+"\n"
                                +"Marca: "+CAMIONES[i].getMarca()+"\n"
                                +"Propio: "+propio+"\n"
                                +"Capacidad: "+CAMIONES[i].getCapacidad()+"\n"
                                +"Tipo: "+CAMIONES[i].getTipo()+"\n"
                                +"Cerrado: "+cerrado);
                            break;
                        case 3:
                            String propioT,refrigerado;
                            if(TRACTORES[i].isPropio()){
                                propioT="Propio";
                            }
                            else{
                                propioT="No es propio";
                            }
                            if(TRACTORES[i].isRefrigerado()){
                                refrigerado="Refrigerado";
                            }
                            else{
                                refrigerado="No refrigerado";
                            }
                            informacion.setText("Id: "+TRACTORES[i].getId()+"\n"
                                    +"Dimensiones: "+ Arrays.toString(TRACTORES[i].getDimensiones())+"\n"
                                    +"Matricula: "+TRACTORES[i].getMatricula()+"\n"
                                    +"Marca: "+TRACTORES[i].getMarca()+"\n"
                                    +"Propio: "+propioT+"\n"
                                    +"Capacidad: "+TRACTORES[i].getCapacidad()+"\n"
                                    +"Llantas: "+TRACTORES[i].getLlantas()+"\n"
                                    +"Longitud caja: "+TRACTORES[i].getLongitudCaja()+"\n"
                                    +"Suspension: "+TRACTORES[i].getSuspension()+"\n"
                                    +"Traccion: "+TRACTORES[i].getTraccion()+"\n"
                                    +"Tipo: "+TRACTORES[i].getTipo()+"\n"
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