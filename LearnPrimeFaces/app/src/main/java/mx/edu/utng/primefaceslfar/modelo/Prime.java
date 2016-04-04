package mx.edu.utng.primefaceslfar.modelo;


import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.primefaceslfar.R;

/**
 * Modelo de datos estático para alimentar la aplicación
 */
public class Prime {
    //private float precio;
    private String nombre;
    private int idDrawable;

    public Prime(String nombre, int idDrawable) {
        //this.precio = precio;
        this.nombre = nombre;
        this.idDrawable = idDrawable;
    }

    public static final List<Prime> PRIMEFACES = new ArrayList<Prime>();
    public static final List<Prime> UNO = new ArrayList<>();
    public static final List<Prime> DOS = new ArrayList<>();
    public static final List<Prime> TRES = new ArrayList<>();

    static {
        PRIMEFACES.add(new Prime("", R.drawable.img_inicio_0));
        PRIMEFACES.add(new Prime("PrimeFaces", R.drawable.img_inicio_1));
        PRIMEFACES.add(new Prime("Iconoes", R.drawable.img_inicio_2));
        PRIMEFACES.add(new Prime("Estilos", R.drawable.img_inicio_3));
        PRIMEFACES.add(new Prime("Diseño", R.drawable.img_inicio_4));




    }



    public String getNombre() {
        return nombre;
    }

    public int getIdDrawable() {
        return idDrawable;
    }
}
