package mx.edu.utng.primefaceslfar.database.puntaje;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import mx.edu.utng.primefaceslfar.R;

/**
 * Created by Luis Arevalo on 05/04/2016.
 */
public class MyActivity extends ActionBarActivity {
public static String cadWebComponets, input, button, data, panel, overlay,menu;
    Button btnAgregarCalificacion, btnVerGrafica;
    public static ListView lista;
    SQLControlador dbconeccion;
    TextView tv_califID, tv_calificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        btnAgregarCalificacion = (Button) findViewById(R.id.btnAgregarMiembro);
        btnVerGrafica = (Button)findViewById(R.id.btn_verGrafica);
        lista = (ListView) findViewById(R.id.listViewMiembros);
       //acción del boton agregar miembro
        btnVerGrafica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iagregar = new Intent(MyActivity.this, GraficarResultado.class);
                startActivity(iagregar);
            }
        });


       /* btnVerGrafica.setOnClickListener(
                Intent  = new Intent(MyActivity.this,GuardarCalificacion.class)

        );*/

        // Tomar los datos desde la base de datos para poner en el curso y después en el adapter
        Cursor cursor = dbconeccion.leerDatos();

        String[] from = new String[] {
                DBHelperPuntuacion.PUNTUACION_ID,
                DBHelperPuntuacion.CALIFICACION,

        };
        int[] to = new int[] {
                R.id.miembro_id,
                R.id.miembro_nombre,

        };

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(
                MyActivity.this, R.layout.formato_fila, cursor, from, to);

        adapter.notifyDataSetChanged();
        lista.setAdapter(adapter);
        cadWebComponets = lista.getItemAtPosition(1).toString();
        input = lista.getItemAtPosition(2).toString();
        button = lista.getItemAtPosition(3).toString();
        data = lista.getItemAtPosition(4).toString();
        panel = lista.getItemAtPosition(5).toString();
        overlay = lista.getItemAtPosition(6).toString();
        menu = lista.getItemAtPosition(7).toString();



        // acción cuando hacemos click en item para poder modificarlo o eliminarlo
        /*lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {

                tv_califID = (TextView) view.findViewById(R.id.miembro_id);
                tv_calificacion = (TextView) view.findViewById(R.id.miembro_nombre);

                String aux_miembroId = tv_califID.getText().toString();
                String aux_miembroNombre = tv_calificacion.getText().toString();

                Intent modify_intent = new Intent(getApplicationContext(), ModificarCalificacion.class);
                modify_intent.putExtra("miembroId", aux_miembroId);
                modify_intent.putExtra("miembroNombre", aux_miembroNombre);
                startActivity(modify_intent);

            }
        });*/
    }  //termina el onCreate
} //termina clase
