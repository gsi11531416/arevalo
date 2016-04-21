package mx.edu.utng.primefaceslfar.ui.g_tema_vii;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.database.puntaje.MyActivity;
import mx.edu.utng.primefaceslfar.database.puntaje.SQLControlador;

/**
 * Created by Luis Arevalo on 29/03/2016.
 */
public class ResultActivityMenu extends Activity {
    // public static String cadWebComponents = "";
    public static TextView tMenu = null;
    public Button button = null;
    SQLControlador dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//get rating bar object
        RatingBar bar = (RatingBar) findViewById(R.id.rb_resutados);
//get text view
        tMenu = (TextView) findViewById(R.id.txv_resultado);
        button = (Button) findViewById(R.id.btn_nextQuestion);
        //cadWebComponents = MyActivity.cadWebComponets;
        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        button.setOnClickListener(Click);
//get score
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
//display score
        bar.setRating(score);
        switch (score) {
            case 0:
                tMenu.setText("0");
                break;
            case 1:
                tMenu.setText("2");
                break;
            case 2:
                tMenu.setText("4");
                break;
            case 3:
                tMenu.setText("6");
                break;
            case 4:
                tMenu.setText("8");
                break;
            case 5:
                tMenu.setText("10");
                break;

        }

    }

    View.OnClickListener Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_save) {
                String intento = dbconeccion.intento("7");
                int i = Integer.parseInt(intento);
                i++;
                intento = String.valueOf(i);
                dbconeccion.actualizarDatos(7, tMenu.getText().toString(), intento);
                Intent main = new Intent(ResultActivityMenu.this, MyActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
            }

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        //cadWebComponents = t.getText().toString();
        return true;
    }
}

