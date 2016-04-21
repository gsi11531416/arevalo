package mx.edu.utng.primefaceslfar.ui.g_tema_vii;

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
public class FragmentOpenQuizMenu extends Fragment {
    Button btnStarCuestionario, btnResultado;
    TextView resultado, intento;
    SQLControlador dbconeccion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_open_quiz_menu, container, false);
        btnStarCuestionario = (Button) v.findViewById(R.id.btn_open_quiz_menu);
        btnResultado = (Button) v.findViewById(R.id.btn_ver_resultado_menu);
        resultado = (TextView) v.findViewById(R.id.txv_resultado_menu);
        intento = (TextView)v.findViewById(R.id.txv_intento_menu);

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
            if (Integer.parseInt(dbconeccion.intento("7")) != 2) {
                if (v.getId() == R.id.btn_open_quiz_menu) {
                    Intent intent = new Intent(getActivity(), QuizActivityMenu.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "Intento #" + dbconeccion.intento("7"), Toast.LENGTH_LONG).show();
                }
            } else {
                btnStarCuestionario.setEnabled(false);
                Toast.makeText(getActivity(), "Haz llegado al maximo de intentos", Toast.LENGTH_LONG).show();
            }
            if (v.getId()==R.id.btn_ver_resultado_menu){
                dbconeccion.abrirBaseDeDatos();
                resultado.setText("Resultado de ultimo Quiz " + dbconeccion.resultado("7"));
                intento.setText("Intento #" + dbconeccion.intento("7"));
                dbconeccion.cerrar();
            }

        }
    };
}
