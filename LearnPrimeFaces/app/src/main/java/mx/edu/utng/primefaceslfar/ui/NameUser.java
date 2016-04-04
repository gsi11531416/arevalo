package mx.edu.utng.primefaceslfar.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.ui.login.Login;

/**
 * Created by Luis Arevalo on 18/03/2016.
 */
public class NameUser extends Fragment {
    TextView mainUSuario ;
    String cadUser;

    public NameUser() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cabecera_drawer, container, false);

       mainUSuario = (TextView)v.findViewById(R.id.txv_principalName);

        cadUser = Login.correo.getText().toString();
       mainUSuario.setText("Bienvenido "+cadUser);
        return v;
    }
}
