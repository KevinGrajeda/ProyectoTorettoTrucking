package com.example.proyectotorettotrucking.baseDeDatos;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.example.proyectotorettotrucking.clases.Pedido;

import java.io.OutputStreamWriter;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ControladorBaseDatos {


    private ArrayList<Pedido> pedidos = new ArrayList<>();
    private Context ctx;

    public ControladorBaseDatos(Context ctx) {
        this.ctx = ctx;
        leerPedidos();
    }

    public void finalizarPedido(int id) {
        pedidos.get(id).setStatus(1);
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(ctx.openFileOutput("pedidos.txt", Activity.MODE_PRIVATE));

            for (int i = 0; i < pedidos.size(); i++) {
                Pedido pedido = pedidos.get(i);

                String info = pedido.getId() + "|"
                        + pedido.getDestino() + "|"
                        + pedido.getOrigen() + "|"
                        + pedido.getProductos() + "|"
                        + pedido.getVehiculo() + "|"
                        + pedido.getStatus() + "|"
                        + pedido.getDescripcion() + "|"
                        + pedido.getPrecio() + ";";

                archivo.write(info);
            }
            archivo.flush();
            archivo.close();
        } catch (IOException e) {
            Toast.makeText(ctx, "Error al escribir en el archivo", Toast.LENGTH_SHORT).show();
        }
    }

    public void agregarPedido(Pedido pedido) {
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(ctx.openFileOutput("pedidos.txt", Activity.MODE_PRIVATE | Activity.MODE_APPEND));

            String info = pedidos.size() + "|"
                    + pedido.getDestino() + "|"
                    + pedido.getOrigen() + "|"
                    + pedido.getProductos() + "|"
                    + pedido.getVehiculo() + "|"
                    + pedido.getStatus() + "|"
                    + pedido.getDescripcion() + "|"
                    + pedido.getPrecio() + ";";

            archivo.write(info);

            archivo.flush();
            archivo.close();
            Toast.makeText(ctx, "pedido guardado", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            Toast.makeText(ctx, "Error al escribir en el archivo", Toast.LENGTH_SHORT).show();
        }
        leerPedidos();
    }

    public void leerPedidos() {
        String[] archivos = ctx.fileList();

        if (existeArchivo(archivos, "pedidos.txt")) {
            try {
                InputStreamReader archivoInterno = new InputStreamReader(ctx.openFileInput("pedidos.txt"));
                BufferedReader leerArchivo = new BufferedReader(archivoInterno);
                String linea = leerArchivo.readLine();
                String textoLeido = "";
                while (linea != null) {
                    textoLeido += linea + "\n";
                    linea = leerArchivo.readLine();
                }
                leerArchivo.close();
                archivoInterno.close();
                String[] pedidosInfo = textoLeido.split(";");

                pedidos = new ArrayList<>();
                for (int i = 0; i < pedidosInfo.length - 1; i++) {
                    String[] info = pedidosInfo[i].split("\\|");
                    pedidos.add(new Pedido(
                            Integer.parseInt(info[0]),
                            Integer.parseInt(info[1]),
                            Integer.parseInt(info[2]),
                            info[3],
                            Integer.parseInt(info[4]),
                            Integer.parseInt(info[5]),
                            info[6],
                            Float.parseFloat(info[7])
                    ));
                }
            } catch (IOException e) {
                Toast.makeText(ctx, "Error al leer el archivo", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(ctx, "El archivo no existe", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean existeArchivo(String[] archivo, String s) {
        for (int i = 0; i < archivo.length; i++) {
            if (s.equals(archivo[i])) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void reset() {
        pedidos=new ArrayList<>();
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(ctx.openFileOutput("pedidos.txt", Activity.MODE_PRIVATE));
            archivo.write("");
            archivo.flush();
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
