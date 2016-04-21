package mx.edu.utng.primefaceslfar.ui.h_tema_viii;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

import mx.edu.utng.primefaceslfar.R;

/**
 * Created by Luis Arevalo on 29/03/2016.
 */
public class ResultActivityMenu extends Activity {
    public static String cadMenu = "";
    public static TextView tMenu = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.rb_resutados);
//get text view
        tMenu=(TextView)findViewById(R.id.txv_resultado);
//get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
//display score
        bar.setRating(score);
        switch (score)
        {
            case 1: tMenu.setText("1"); break;
            case 2: tMenu.setText("2");break;
            case 3: tMenu.setText("3");break;
            case 4: tMenu.setText("4");break;
            case 5: tMenu.setText("5");break;

        }
        cadMenu = tMenu.getText().toString();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        cadMenu = tMenu.getText().toString();
        return true;
    }
}
