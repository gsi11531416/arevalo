package mx.edu.utng.primefaceslfar.ui.a_tema_ii;

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
public class ResultActivityInput extends Activity {
    public static String cadInput = "";
    public static TextView tInput = null;
    SQLControlador dbconeccion;
    Button buttonInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//get rating bar object
        RatingBar bar = (RatingBar) findViewById(R.id.rb_resutados);
        //Boton Para Guardar
        buttonInput = (Button) findViewById(R.id.btn_save);
        //get text view
        tInput = (TextView) findViewById(R.id.txv_resultado);
        cadInput = MyActivity.input;
        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        buttonInput.setOnClickListener(Click);
//get score
        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
//display score
        bar.setRating(score);
        switch (score) {
            case 0:
                tInput.setText("0");
                break;
            case 1:
                tInput.setText("2");
                break;
            case 2:
                tInput.setText("4");
                break;
            case 3:
                tInput.setText("6");
                break;
            case 4:
                tInput.setText("8");
                break;
            case 5:
                tInput.setText("10");
                break;

        }
        cadInput = tInput.getText().toString();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        cadInput = tInput.getText().toString();
        return true;
    }

    View.OnClickListener Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_save) {
                String intento = dbconeccion.intento("2");
                int i = Integer.parseInt(intento);
                i++;
                intento = String.valueOf(i);
                dbconeccion.actualizarDatos(2, tInput.getText().toString(), intento);
                Intent main = new Intent(ResultActivityInput.this, MyActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
            }

        }
    };
}
