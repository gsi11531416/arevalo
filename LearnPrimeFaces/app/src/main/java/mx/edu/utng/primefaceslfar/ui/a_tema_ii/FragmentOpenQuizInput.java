package mx.edu.utng.primefaceslfar.ui.a_tema_ii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.ui.a_tema_i.ResultActivityWebComponents;

/**
 * Created by Luis Arevalo on 29/03/2016.
 */
public class FragmentOpenQuizInput extends Fragment{
Button btnStarCuestionario, btnResultado;
    TextView resultado ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_open_quiz_web_componets, container, false);
        btnStarCuestionario = (Button)v.findViewById(R.id.btn_open_quiz_web_componets);
        btnResultado = (Button)v.findViewById(R.id.btn_ver_resultado);
        resultado = (TextView)v.findViewById(R.id.txv_resultado_web_components);
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
            if (v.getId() == R.id.btn_open_quiz_web_componets) {
                Intent intent = new Intent(getActivity(), QuizActivityInput.class);
                startActivity(intent);
            }


           resultado.setText(ResultActivityWebComponents.cadWebComponents);

            }
    };
}
