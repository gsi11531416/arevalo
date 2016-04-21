package mx.edu.utng.primefaceslfar.ui.d_tema_iv;

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
public class FragmentOpenQuizData extends Fragment {
    Button btnStarCuestionario, btnResultado;
    TextView resultado, intento;
    SQLControlador dbconeccion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_open_quiz_data, container, false);
        btnStarCuestionario = (Button) v.findViewById(R.id.btn_open_quiz_data);
        btnResultado = (Button) v.findViewById(R.id.btn_ver_resultado_data);
        resultado = (TextView) v.findViewById(R.id.txv_resultado_data);
        intento = (TextView) v.findViewById(R.id.txv_intento_data);

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
            if (Integer.parseInt(dbconeccion.intento("4")) != 2) {
                if (v.getId() == R.id.btn_open_quiz_data) {
                    Intent intent = new Intent(getActivity(), QuizActivityData.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "Intento #" + dbconeccion.intento("4"), Toast.LENGTH_LONG).show();
                }
            } else {
                btnStarCuestionario.setEnabled(false);
                Toast.makeText(getActivity(), "Haz llegado al maximo de intentos", Toast.LENGTH_LONG).show();
            }
            if (v.getId()==R.id.btn_ver_resultado_data){
                dbconeccion.abrirBaseDeDatos();
                resultado.setText("Resultado de ultimo Quiz " + dbconeccion.resultado("4"));
                intento.setText("Intento #" + dbconeccion.intento("4"));
                dbconeccion.cerrar();
            }

        }
    };
}
