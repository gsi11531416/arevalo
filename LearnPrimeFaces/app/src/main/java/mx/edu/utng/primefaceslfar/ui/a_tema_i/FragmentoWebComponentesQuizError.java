package mx.edu.utng.primefaceslfar.ui.a_tema_i;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import mx.edu.utng.primefaceslfar.R;


/**
 * Fragmento para la pestaña "TARJETAS" de la sección "Mi Cuenta"
 */
public class FragmentoWebComponentesQuizError extends Fragment {


    public FragmentoWebComponentesQuizError() {

    }



TextView t, p;
    Button b;
    private Button btnCrearPreferencias;
    private Button btnResultado;

    private SharedPreferences preferencias;

    private  TextView prueba, nombre;

    private TextView txv_uno, txv_dos, txv_tres, txv_cuatro, txv_uno_calif, txv_dos_calif,txv_tres_calif,txv_cuatro_calif;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragmento_web_componentes_cuestionario, container, false);

        btnCrearPreferencias = (Button)v.findViewById(R.id.btn_cuestionario);


        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    View.OnClickListener Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_cuestionario) {
                startActivity(new Intent(getActivity(), QuizActivityWebComponets.class));
            }

        }
    };
}