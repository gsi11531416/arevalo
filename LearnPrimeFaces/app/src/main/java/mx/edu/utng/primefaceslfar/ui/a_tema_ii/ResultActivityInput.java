package mx.edu.utng.primefaceslfar.ui.a_tema_ii;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

import mx.edu.utng.primefaceslfar.R;

/**
 * Created by Luis Arevalo on 29/03/2016.
 */
public class ResultActivityInput extends Activity {
    public static String cadInput = "";
    public static TextView t = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_input);
//get rating bar object
        RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
//get text view
        t=(TextView)findViewById(R.id.textResult);
//get score
        Bundle b = getIntent().getExtras();
        int score= b.getInt("score");
//display score
        bar.setRating(score);
        switch (score)
        {
            case 1: t.setText("1"); break;
            case 2: t.setText("2");break;
            case 3: t.setText("3");break;
            case 4:t.setText("4");break;
            case 5:t.setText("5");break;

        }
        cadInput = t.getText().toString();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_result, menu);
        cadInput = t.getText().toString();
        return true;
    }
}
