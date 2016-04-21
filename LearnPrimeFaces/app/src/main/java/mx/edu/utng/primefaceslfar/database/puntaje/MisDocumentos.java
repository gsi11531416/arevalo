package mx.edu.utng.primefaceslfar.database.puntaje;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.ui.FragmentoPerfil;
import mx.edu.utng.primefaceslfar.ui.login.Login;

/**
 * Created by Luis Arevalo on 20/04/2016.
 */
public class MisDocumentos extends AppCompatActivity implements View.OnClickListener {
    Button btn;
    SQLControlador db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pdf);
        btn = (Button) findViewById(R.id.btn_email_send);
        btn.setOnClickListener(this);
        db = new SQLControlador(getApplication());
        db.abrirBaseDeDatos();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_email_send) {

            if (Login.success==1){
                EmailSender emailSender = new EmailSender();
                String user = "crackiman@gmail.com";
                String pass = "elchino1";
                String to = FragmentoPerfil.cadUser;
                String subject = "Resultados obtenidos...";
                String body = "Test 1 " + db.resultado("1").toString() + "\n" +
                        "; Test 2 " + db.resultado("2").toString() + "\n" +
                        "; Test 3 " + db.resultado("3").toString() + "\n" +
                        "; Test 4 " + db.resultado("4").toString() + "\n" +
                        "; Test 5 " + db.resultado("5").toString() + "\n" +
                        "; Test 6 " + db.resultado("6").toString() + "\n" +
                        "; Test 7 " + db.resultado("7").toString() + "\n";
                //String body = "Hola";
                emailSender.execute(user, pass, to, subject,
                        body, "/sdcard/PDF/demo.pdf");

            }else {
                startActivity(new Intent(this, Login.class));
            }


        }
    }
}
