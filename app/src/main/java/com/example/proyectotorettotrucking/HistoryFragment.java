package com.example.proyectotorettotrucking;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    Spinner tipos;
    RecyclerView informacion;

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
        informacion = view.findViewById(R.id.lstInfo);
        informacion.setLayoutManager(new LinearLayoutManager(view.getContext(),LinearLayoutManager.VERTICAL,false));

        
        String[] ArrayTipos= new String[]{"Productos","Sucursales","Camiones","Tractores"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item,ArrayTipos);
        tipos.setAdapter(adapter);

        tipos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                ArrayAdapter<String> adapter;
                switch (i){
                    case 0://Productos
                        DatosAdapter datosAdapter = new DatosAdapter(0);
                        informacion.setAdapter(datosAdapter);
                        break;
                    case 1://Sucursales
                        datosAdapter = new DatosAdapter(1);
                        informacion.setAdapter(datosAdapter);
                        break;
                    case 2://Camiones
                        datosAdapter = new DatosAdapter(2);
                        informacion.setAdapter(datosAdapter);
                        break;
                    case 3://Tractores
                        datosAdapter = new DatosAdapter(3);
                        informacion.setAdapter(datosAdapter);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }
}