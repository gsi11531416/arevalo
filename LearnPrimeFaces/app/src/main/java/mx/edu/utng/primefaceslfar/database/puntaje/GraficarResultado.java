package mx.edu.utng.primefaceslfar.database.puntaje;

/**
 * Created by Luis Arevalo on 18/04/2016.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class GraficarResultado extends AppCompatActivity {
    SQLControlador dbConect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dbConect = new SQLControlador(getApplication());
        dbConect.abrirBaseDeDatos();
        //Valores a mostrar en la gráfica

        ArrayList<BarEntry> entradas = new ArrayList<>();
        entradas.add(new BarEntry(Integer.parseInt(dbConect.resultado("1")), 0));
        entradas.add(new BarEntry(Integer.parseInt(dbConect.resultado("2")), 1));
        entradas.add(new BarEntry(Integer.parseInt(dbConect.resultado("3")), 2));
        entradas.add(new BarEntry(Integer.parseInt(dbConect.resultado("4")), 3));
        entradas.add(new BarEntry(Integer.parseInt(dbConect.resultado("5")), 4));
        entradas.add(new BarEntry(Integer.parseInt(dbConect.resultado("6")), 5));
        entradas.add(new BarEntry(Integer.parseInt(dbConect.resultado("7")), 6));

        //Creamos el conjunto de datos a partir de las entradas

        BarDataSet dataset = new BarDataSet(entradas, "# Calificaciones");

        //Etiquetas para el eje X

        ArrayList<String> etiquetas = new ArrayList<String>();
        etiquetas.add("Web Components");
        etiquetas.add("Input");
        etiquetas.add("Button");
        etiquetas.add("Data");
        etiquetas.add("Panel");
        etiquetas.add("OverLay");
        etiquetas.add("Menu");

        //Aplicamos una plantillas de colores al conjunto de datos
        dataset.setColors(ColorTemplate.LIBERTY_COLORS);

        //Definimos la gráfica

        BarChart grafica = new BarChart(getApplicationContext());
        setContentView(grafica);

        //Incluimos los datos y etiquetas en la gráfica

        BarData datos = new BarData(etiquetas, dataset);
        grafica.setData(datos);

        //Añadimos una descripción a la gráfica
        grafica.setDescription("# Calificaciones de Test por Tema");

        //Aplicamos una animación al eje Y
        grafica.animateY(5000);


        //Incluímos una línea límite
        LimitLine linea = new LimitLine(6);
        YAxis ejeY = grafica.getAxisLeft();
        ejeY.addLimitLine(linea);

        dbConect.cerrar();
        //guardar grafica en Galeria
        //grafica.getChartBitmap();
        //grafica.saveToPath("MRGN","");


    }
}

