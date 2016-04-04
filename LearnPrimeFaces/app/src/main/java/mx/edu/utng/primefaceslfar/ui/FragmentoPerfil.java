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
 * Luis Arevalo
 * Fragmento para la pestaña "PERFIL" De la sección "Mi Cuenta"
 */
public class FragmentoPerfil extends Fragment {
    TextView usuario,correo,mainUSuario;
    String cadUser,cadEmail;
    public FragmentoPerfil() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragmento_perfil, container, false);

        usuario = (TextView)v.findViewById(R.id.texto_nombre);
        correo = (TextView)v.findViewById(R.id.texto_email);
        cadUser = Login.correo.getText().toString();
        cadEmail = Login.pass.getText().toString();
        usuario.setText(Login.name);
        correo.setText(cadUser);
        return v;
    }
}
