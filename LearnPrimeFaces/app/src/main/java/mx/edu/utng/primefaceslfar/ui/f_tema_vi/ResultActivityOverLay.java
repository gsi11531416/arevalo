package mx.edu.utng.primefaceslfar.ui.f_tema_vi;

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
public class ResultActivityOverLay extends Activity {
    public static String cadOverlay = "";
    public static TextView toverlay = null;
    Button button;
    SQLControlador dbconeccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//get rating bar object
        RatingBar bar = (RatingBar) findViewById(R.id.rb_resutados);
//get text view
        toverlay = (TextView) findViewById(R.id.txv_resultado);
        button = (Button) findViewById(R.id.btn_nextQuestion);

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
                toverlay.setText("0");
                break;
            case 1:
                toverlay.setText("2");
                break;
            case 2:
                toverlay.setText("4");
                break;
            case 3:
                toverlay.setText("6");
                break;
            case 4:
                toverlay.setText("8");
                break;
            case 5:
                toverlay.setText("10");
                break;

        }
        cadOverlay = toverlay.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        cadOverlay = toverlay.getText().toString();
        return true;
    }

    View.OnClickListener Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_save) {
                String intento = dbconeccion.intento("6");
                int i = Integer.parseInt(intento);
                i++;
                intento = String.valueOf(i);
                dbconeccion.actualizarDatos(6, toverlay.getText().toString(), intento);
                Intent main = new Intent(ResultActivityOverLay.this, MyActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
            }

        }
    };
}
