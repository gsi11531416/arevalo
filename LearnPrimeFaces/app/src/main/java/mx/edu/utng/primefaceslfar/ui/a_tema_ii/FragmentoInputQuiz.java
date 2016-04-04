package mx.edu.utng.primefaceslfar.ui.a_tema_ii;

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
public class FragmentoInputQuiz extends Fragment {


    public FragmentoInputQuiz() {

    }

TextView t, p;
    Button b;
    int cont = 0;
    String conts = "";
    private Button btnCrearPreferencias;
    private Button btnResultado;

    private SharedPreferences preferencias;
    private TextView txv_uno_b, txv_dos_b, txv_tres_b, txv_cuatro_b, txv_uno_calif_b, txv_dos_calif_b,txv_tres_calif_b,
            txv_cuatro_calif_b;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragmento_imput_quiz, container, false);



        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    View.OnClickListener Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.btn_cuestionario_2) {
                Intent intent = new Intent(getActivity(), SeleccionPreferenciasActivityInput.class);
                startActivity(intent);
            }
        }
    };
}