package mx.edu.utng.primefaceslfar.ui.c_tema_iii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.database.puntaje.SQLControlador;

/**
 * Created by Luis Arevalo on 29/03/2016.
 */
public class FragmentOpenQuizButton extends Fragment {
    Button btnStarCuestionario, btnResultado;
    TextView resultado, intento;
    SQLControlador dbconeccion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_open_quiz_button, container, false);
        btnStarCuestionario = (Button) v.findViewById(R.id.btn_open_quiz_button);
        btnResultado = (Button) v.findViewById(R.id.btn_ver_resultado_button);
        resultado = (TextView) v.findViewById(R.id.txv_resultado_button);
        intento = (TextView) v.findViewById(R.id.txv_intento_button);

        dbconeccion = new SQLControlador(getActivity());
        dbconeccion.abrirBaseDeDatos();

        btnStarCuestionario.setOnClickListener(Click);
        btnResultado.setOnClickListener(Click);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    View.OnClickListener Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (Integer.parseInt(dbconeccion.intento("3")) != 2) {
                if (v.getId() == R.id.btn_open_quiz_button) {
                    Intent intent = new Intent(getActivity(), QuizActivityButton.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "Intento #" + (dbconeccion.intento("3") + 1), Toast.LENGTH_LONG).show();
                }
            }else{
                btnStarCuestionario.setEnabled(false);
                Toast.makeText(getActivity(), "Haz llegado al maximo de intentos", Toast.LENGTH_LONG).show();
            }
            if (v.getId() == R.id.btn_ver_resultado_button) {
                dbconeccion.abrirBaseDeDatos();
                resultado.setText("Resultado de ultimo Quiz " + dbconeccion.resultado("3"));
                intento.setText("Intento #" + dbconeccion.intento("3"));
                dbconeccion.cerrar();
            }


        }
    };
}
