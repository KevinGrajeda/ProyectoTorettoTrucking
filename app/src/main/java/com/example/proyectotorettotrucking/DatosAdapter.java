package com.example.proyectotorettotrucking;

import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.CAMIONES;
import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.PRODUCTOS;
import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.SUCURSALES;
import static com.example.proyectotorettotrucking.baseDeDatos.Informacion.TRACTORES;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectotorettotrucking.clases.Producto;

import java.util.ArrayList;

public class DatosAdapter extends RecyclerView.Adapter<DatosAdapter.ViewHolderDatos> {

    int tipo;

    public DatosAdapter(int tipo) {
        this.tipo = tipo;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_row,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(position,tipo);
    }

    @Override
    public int getItemCount() {
        switch (tipo) {
            case 0:
                return PRODUCTOS.length;
            case 1:
                return SUCURSALES.length;
            case 2:
                return CAMIONES.length;
            case 3:
                return TRACTORES.length;
            default:
                return 0;
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView encabezado, subtitulo, descripcion, dato01,dato02,dato03;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            encabezado = itemView.findViewById(R.id.nameRow);
            subtitulo = itemView.findViewById(R.id.marcaRow);
            descripcion = itemView.findViewById(R.id.descRow);
            dato01 = itemView.findViewById(R.id.pesoRow);
            dato02 = itemView.findViewById(R.id.dat02Row);
            dato03 = itemView.findViewById(R.id.dat03Row);
        }

        public void asignarDatos(int i, int tipo) {
            switch (tipo){
                case 0:
                    encabezado.setText(PRODUCTOS[i].getNombre());
                    subtitulo.setText(PRODUCTOS[i].getMarca());
                    descripcion.setText(PRODUCTOS[i].getDescripcion());
                    dato01.setText("Peso: " + PRODUCTOS[i].getPeso());
                    dato02.setVisibility(View.GONE);
                    dato03.setVisibility(View.GONE);
                    break;
                case 1:
                    encabezado.setText(SUCURSALES[i].getNombre());
                    subtitulo.setText(SUCURSALES[i].getEstado());
                    descripcion.setText("Ciudad: " + SUCURSALES[i].getCiudad());
                    dato01.setText("Ciudad: " + SUCURSALES[i].getPais());
                    dato02.setVisibility(View.GONE);
                    dato03.setVisibility(View.GONE);
                    break;
                case 2:
                    encabezado.setText(CAMIONES[i].getMarca());
                    subtitulo.setText(CAMIONES[i].getMatricula());
                    descripcion.setText("Tipo: " + CAMIONES[i].getTipo());
                    dato01.setText("Capacidad: " + CAMIONES[i].getCapacidad());
                    dato02.setVisibility(View.GONE);
                    dato03.setVisibility(View.GONE);
                    break;
                case 3:
                    encabezado.setText(TRACTORES[i].getMarca());
                    subtitulo.setText(TRACTORES[i].getMatricula());
                    descripcion.setText("Tipo: " + TRACTORES[i].getTipo());
                    dato01.setText("Capacidad: " + TRACTORES[i].getCapacidad());
                    dato02.setText("Tracción: " + TRACTORES[i].getTraccion());
                    dato02.setVisibility(View.VISIBLE);
                    dato03.setText("Longitud: " + TRACTORES[i].getLongitudCaja());
                    dato03.setVisibility(View.VISIBLE);
                    break;
            }
        }
    }
}
