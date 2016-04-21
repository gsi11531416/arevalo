package mx.edu.utng.primefaceslfar.ui.f_tema_vi;

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
public class FragmentOpenQuizOverLay extends Fragment {
    Button btnStarCuestionario, btnResultado;
    TextView resultado, intento;
    SQLControlador dbconeccion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_open_quiz_overlay, container, false);
        btnStarCuestionario = (Button) v.findViewById(R.id.btn_open_quiz_overlay);
        btnResultado = (Button) v.findViewById(R.id.btn_ver_resultado_overlay);
        resultado = (TextView) v.findViewById(R.id.txv_resultado_overlay);
        intento = (TextView)v.findViewById(R.id.txv_intento_overlay);

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
            if (Integer.parseInt(dbconeccion.intento("6")) != 2) {
                if (v.getId() == R.id.btn_open_quiz_overlay) {
                    Intent intent = new Intent(getActivity(), QuizActivityOverLay.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "Intento #" + dbconeccion.intento("6"), Toast.LENGTH_LONG).show();
                }
            } else {
                btnStarCuestionario.setEnabled(false);
                Toast.makeText(getActivity(), "Haz llegado al maximo de intentos", Toast.LENGTH_LONG).show();
            }
            if (v.getId()==R.id.btn_ver_resultado_overlay){
                dbconeccion.abrirBaseDeDatos();
                resultado.setText("Resultado de ultimo Quiz " + dbconeccion.resultado("6"));
                intento.setText("Intento #" + dbconeccion.intento("6"));
                dbconeccion.cerrar();
            }

        }
    };
}
