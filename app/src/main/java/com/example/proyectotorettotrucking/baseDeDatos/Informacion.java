package com.example.proyectotorettotrucking.baseDeDatos;

import com.example.proyectotorettotrucking.clases.Camion;
import com.example.proyectotorettotrucking.clases.Producto;
import com.example.proyectotorettotrucking.clases.Sucursal;
import com.example.proyectotorettotrucking.clases.Tractor;
import com.example.proyectotorettotrucking.clases.Usuario;

public class Informacion {
    private Informacion() {
    }

    public static final Producto[] PRODUCTOS = {
            new Producto(0, "Hojas", "Hojas papel bond", "Scribe", 900),
            new Producto(1, "Lapices", "Lapices N.2", "BIC", 150),
            new Producto(2, "Laptop", "Laptop gamer", "Asus", 1200),
            new Producto(3, "Marcadores", "Marcadores para pintarron", "BIC", 200),
            new Producto(4, "Playeras", "Playera basica", "Yazbek", 2000),
            new Producto(5, "Tenis", "Tenis hombre", "Nike", 2500),
            new Producto(6, "Pizarron", "Pizarron blanco", "BIC", 2500),
            new Producto(7, "Escritorio", "Escritorio 2 metros", "IKEA", 4500),
            new Producto(8, "Pantalon", "Pantalon levis 505", "Levis", 2500),
            new Producto(9, "USB", "Usb 16gb", "Kingston", 700),
    };
    public static final Sucursal[] SUCURSALES = {
            new Sucursal(0, "Puerto Vallarta", "Jalisco", "Puerto vallarta", "Mexico",5,2),
            new Sucursal(1, "Ciudad de México", "Ciudad de México", "Ciudad de México", "México",7,1),
            new Sucursal(2, "Manzanillo", "Colima", "Manzanillo", "México",4,0),
            new Sucursal(3, "Tijuana", "Baja California", "Tijuana", "México",1,6),
            new Sucursal(4, "California", "California", "Los Angeles", "USA",0,7),
    };
    public static final Tractor[] TRACTORES = {
            new Tractor(0, new int[]{2, 3, 15}, "DEA86", "CHEVRON", false, 22000, "Caja", "15 metros", "Neumatica", "Libre", 12, false),
            new Tractor(1, new int[]{2, 3, 15}, "D86DA", "CHEVRON", false, 20000, "Caja Refrigerada", "15 metros", "Neumatica", "Libre", 12, true),
            new Tractor(2, new int[]{2, 3, 15}, "FGR68", "FREIGHT", false, 22000, "Caja", "15 metros", "Neumatica", "Libre", 12, false),
            new Tractor(3, new int[]{2, 3, 15}, "AE570", "MALIK", false, 22000, "Caja Refrigerada", "15 metros", "Neumatica", "Libre", 12, true),

    };
    public static final Camion[] CAMIONES = {
            new Camion(0, new int[]{2, 3, 8}, "CRTLO10", "FreighLiner", true, 25000, "Trailer", true),
            new Camion(1, new int[]{2, 3, 8}, "KLSL856", "FreighLiner", true, 12000, "Torthon", true),
            new Camion(2, new int[]{2, 3, 10}, "HCJE889", "Ford", true, 8500, "Rabon", true),
            new Camion(3, new int[]{2, 3, 8}, "CRTLO10", "Ford", true, 5000, "Camioneta 5 ton.", true),
            new Camion(4, new int[]{2, 3, 8}, "DACA852", "Ford", true, 3500, "Camioneta 3.5 ton.", true),
            new Camion(5, new int[]{2, 3, 6}, "CNNXA84", "Nissan", true, 1000, "Camioneta 1 ton.", true),
    };

    public static final Usuario[] USUARIOS = {
            new Usuario(false,"cobian@toretto.com","cobian",0,0),
            new Usuario(false,"javier@toretto.com","javier",1,0),
            new Usuario(false,"arturo@toretto.com","arturo",2,1),
            new Usuario(false,"kevin@toretto.com","kevin",3,1),
    };

}
