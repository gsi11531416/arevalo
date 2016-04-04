package mx.edu.utng.primefaceslfar.ui.d_tema_iv;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import mx.edu.utng.primefaceslfar.R;


/**
 * Fragmento para la pestaña "TARJETAS" de la sección "Mi Cuenta"
 */
public class FragmentoDataQuiz extends Fragment {


    public FragmentoDataQuiz() {

    }



TextView t, p;
    Button b;
    int cont = 0;
    String conts = "";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragmento_panel_quiz, container, false);
        t = (TextView)v.findViewById(R.id.lbl_uno);
        b = (Button)v.findViewById(R.id.btn_verificar_actividad1_1);
        p = (TextView)v.findViewById(R.id.lbl_puntaje);
        b.setOnClickListener(Click);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    View.OnClickListener Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton r,r2,r3;
            r = (RadioButton)getView().findViewById(R.id.java);
            r2 = (RadioButton)getView().findViewById(R.id.prime);
            r3 = (RadioButton)getView().findViewById(R.id.nada);
            if (r.isChecked()){
                t.setText("Incorrecto");
                r2.setEnabled(false);
                r3.setEnabled(false);
                cont--;
                conts = String.valueOf(cont);
                p.setText(conts);
            }else if (r2.isChecked()){
                t.setText("Incorrecto");
                r2.setEnabled(false);
                r3.setEnabled(false);
                cont--;
                conts = String.valueOf(cont);
                p.setText(conts);
            }else{
                t.setText("Correcto");
                r.setEnabled(false);
                r3.setEnabled(false);
                cont++;
                conts = String.valueOf(cont);
                p.setText(conts);

            }
        }
    };
}