package mx.edu.utng.primefaceslfar.ui.e_tema_v;

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
public class ResultActivityPanel extends Activity {
    public static String cadPanel = "";
    public static TextView tpanel = null;
    Button button;
    SQLControlador dbconeccion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//get rating bar object
        RatingBar bar = (RatingBar) findViewById(R.id.rb_resutados);
//get text view
        tpanel = (TextView) findViewById(R.id.txv_resultado);
        button = (Button) findViewById(R.id.btn_nextQuestion);
        dbconeccion = new SQLControlador(this);
        dbconeccion.abrirBaseDeDatos();
        button.setOnClickListener(Click);
//get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
//display score
        bar.setRating(score);
        switch (score)
        {
            case 0: tpanel.setText("0"); break;
            case 1: tpanel.setText("2"); break;
            case 2: tpanel.setText("4");break;
            case 3: tpanel.setText("6");break;
            case 4: tpanel.setText("8");break;
            case 5: tpanel.setText("10");break;

        }
        cadPanel = tpanel.getText().toString();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        cadPanel = tpanel.getText().toString();
        return true;
    }
    View.OnClickListener Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_save) {
                String intento = dbconeccion.intento("5");
                int i = Integer.parseInt(intento);
                i++;
                intento = String.valueOf(i);
                dbconeccion.actualizarDatos(5,tpanel.getText().toString(),intento);
                Intent main = new Intent(ResultActivityPanel.this, MyActivity.class)
                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
            }

        }};
}
