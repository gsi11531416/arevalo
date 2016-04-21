package mx.edu.utng.primefaceslfar.ui.h_tema_viii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import mx.edu.utng.primefaceslfar.R;

/**
 * Created by Luis Arevalo on 29/03/2016.
 */
public class FragmentOpenQuizMenu extends Fragment{
Button btnStarCuestionario, btnResultado;
    TextView resultado ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_open_quiz_menu, container, false);
        btnStarCuestionario = (Button)v.findViewById(R.id.btn_open_quiz_menu);
        btnResultado = (Button)v.findViewById(R.id.btn_ver_resultado_menu);
        resultado = (TextView)v.findViewById(R.id.txv_resultado_menu);
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
            if (v.getId() == R.id.btn_open_quiz_menu) {
                Intent intent = new Intent(getActivity(), QuizActivityMenu.class);
                startActivity(intent);
            }


           resultado.setText(ResultActivityMenu.cadMenu);

            }
    };
}
