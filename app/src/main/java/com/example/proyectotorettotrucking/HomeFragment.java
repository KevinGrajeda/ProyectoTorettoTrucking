package com.example.proyectotorettotrucking;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.proyectotorettotrucking.baseDeDatos.ControladorBaseDatos;
import com.example.proyectotorettotrucking.clases.Pedido;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public ArrayList<Pedido> pedidos;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button salir;
    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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


    /*<TextView
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_weight="2"
    android:gravity="center_horizontal"
    android:padding="10sp"
    android:text="@string/col1"
    android:textColor="@color/white"
    android:textSize="12sp" />
                <com.google.android.material.button.MaterialButton
    android:layout_width="0dp"
    android:layout_height="wrap_content"
    android:layout_weight="1"
    android:gravity="center"
    android:padding="12sp"
    android:textColor="@color/white"
    android:textSize="12sp"
    app:icon="@drawable/ic_baseline_remove_red_eye_24" />

    </TableRow>*/

    public void tableinit(View view){
        ControladorBaseDatos controlador = ((MenuActivity) requireActivity()).controlador;
        this.pedidos = controlador.getPedidos();
        ArrayList<Pedido> pedidosAbiertos = new ArrayList<Pedido>();
        ArrayList<Pedido> pedidosCerrados = new ArrayList<Pedido>();
        for (Pedido pedido:pedidos){
            if (pedido.getStatus() == 0){

            }else{

            }
        }
        TableLayout tl = view.findViewById(R.id.tblViajesActuales);
        for (int i = 25; i > 20; i--) {
            //Table Row
            TableRow tbrow = new TableRow(getContext());
            tbrow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            tbrow.setWeightSum(8); //total row weight

            TableRow.LayoutParams lp1 = new TableRow.LayoutParams();
            lp1.weight = 2;

            lp1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            TextView t1v = new TextView(getContext());
            //*Primer campo
            t1v.setText(""+i);
            t1v.setTextColor(Color.WHITE);
            t1v.setTextSize(12);
            t1v.setLayoutParams(lp1);
            t1v.setGravity(Gravity.CENTER);
            t1v.setPadding(25,0,15,0);
            tbrow.addView(t1v);
            //*Segundo campo
            lp1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 4f);
            TextView t2v = new TextView(getContext());
            t2v.setText("Pto. Vallarta - Guadalajara");
            t2v.setTextColor(Color.WHITE);
            t2v.setTextSize(12);
            t2v.setLayoutParams(lp1);
            t2v.setGravity(Gravity.CENTER);
            t2v.setPadding(10,0,10,0);
            tbrow.addView(t2v);
            //*Tercer campo
            lp1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 2f);
            TextView t3v = new TextView(getContext());
            t3v.setText("$2950.00");
            t3v.setTextColor(Color.WHITE);
            t3v.setTextSize(12);
            t3v.setLayoutParams(lp1);
            t3v.setGravity(Gravity.CENTER);
            t3v.setPadding(10,0,10,0);
            tbrow.addView(t3v);
            //*Cuarto campo
            lp1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);

            MaterialButton t4v = new MaterialButton(getContext());
            t4v.setIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_baseline_remove_red_eye_24));
            t4v.setIconGravity(MaterialButton.ICON_GRAVITY_START);
            t4v.setTextColor(Color.WHITE);
            t4v.setTextSize(10);
            t4v.setLayoutParams(lp1);
            t4v.setGravity(Gravity.CENTER);
            t4v.setPadding(33,0,0,0);
            tbrow.addView(t4v);

            t4v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent navegacion = null;
                    navegacion = new Intent(getContext(), VerPedido.class);
                    navegacion.putExtra("status", 1);
                    startActivity(navegacion);
                }
            });

            tl.addView(tbrow);

        }



        TableLayout tl2 = view.findViewById(R.id.tblViajesTerminados);
        for (int i = 20; i > 0; i--) {
            //Table Row
            TableRow tbrow = new TableRow(getContext());
            tbrow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
            tbrow.setWeightSum(8); //total row weight

            TableRow.LayoutParams lp1 = new TableRow.LayoutParams();
            lp1.weight = 2;

            lp1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);
            TextView t1v = new TextView(getContext());
            //*Primer campo
            t1v.setText(""+i);
            t1v.setTextColor(Color.WHITE);
            t1v.setTextSize(12);
            t1v.setLayoutParams(lp1);
            t1v.setGravity(Gravity.CENTER);
            t1v.setPadding(25,0,15,0);
            tbrow.addView(t1v);
            //*Segundo campo
            lp1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 4f);
            TextView t2v = new TextView(getContext());
            t2v.setText("Calfornia - Chiapas");
            t2v.setTextColor(Color.WHITE);
            t2v.setTextSize(12);
            t2v.setLayoutParams(lp1);
            t2v.setGravity(Gravity.CENTER);
            t2v.setPadding(10,0,10,0);
            tbrow.addView(t2v);
            //*Tercer campo
            lp1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 2f);
            TextView t3v = new TextView(getContext());
            t3v.setText("70000.01");
            t3v.setTextColor(Color.WHITE);
            t3v.setTextSize(12);
            t3v.setLayoutParams(lp1);
            t3v.setGravity(Gravity.CENTER);
            t3v.setPadding(10,0,10,0);
            tbrow.addView(t3v);
            //*Cuarto campo
            lp1 = new TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1f);

            MaterialButton t4v = new MaterialButton(getContext());
            t4v.setIcon(ContextCompat.getDrawable(getContext(), R.drawable.ic_baseline_remove_red_eye_24));
            t4v.setIconGravity(MaterialButton.ICON_GRAVITY_START);
            t4v.setTextColor(Color.WHITE);
            t4v.setTextSize(10);
            t4v.setLayoutParams(lp1);
            t4v.setGravity(Gravity.CENTER);
            t4v.setPadding(33,0,0,0);
            tbrow.addView(t4v);

            t4v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Navegacion();
                }
            });

            tl2.addView(tbrow);

        }
    }
    void Navegacion(){
        Intent navegacion = null;
        navegacion = new Intent(getContext(), VerPedido.class);
        navegacion.putExtra("status", 2);
        startActivity(navegacion);
        getActivity().finish();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        this.tableinit(view);

        //view.findViewById(R.id.btnSalir).setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        salir();
        //    }
        //});

        return view;
    }
/*
    public void salir(){
        SharedPreferences preferences = getActivity().getSharedPreferences("usr.dat",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
        Intent logout = new Intent(getActivity(),MainActivity.class);
        logout.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(logout);
        getActivity().finish();
    }
  */

}