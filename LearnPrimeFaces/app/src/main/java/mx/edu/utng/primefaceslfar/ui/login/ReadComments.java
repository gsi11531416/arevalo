package mx.edu.utng.primefaceslfar.ui.login;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.ui.FragmentoPerfil;

/**
 * Created by Luis Arevalo on 18/03/2016.
 */
public class ReadComments extends ActionBarActivity {
    TextView usuario;
    Button btnCursoStar;
    String cadena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // note that use read_comments.xml instead of our single_post.xml
        setContentView(R.layout.read_comments);
        usuario = (TextView) findViewById(R.id.txv_principalName);
        cadena = Login.correo.getText().toString();
        btnCursoStar = (Button) findViewById(R.id.btn_inicioCurso);
        btnCursoStar.setOnClickListener(Click);
    }


    View.OnClickListener Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
            Fragment fragment = null;
            fragment = new FragmentoPerfil();
        }
    };



}
