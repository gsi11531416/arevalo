package mx.edu.utng.primefaceslfar.ui.c_tema_iii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.ui.login.Login;

/**
 * Created by Luis Arevalo on 05/04/2016.
 */
public class OpenLogin extends Fragment {
Button button;
    TextView textView;
public static int cont = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.open_email, container, false);
        button = (Button)v.findViewById(R.id.btn_open_login);
        textView = (TextView)v.findViewById(R.id.txv_opne_login);
        button.setOnClickListener(Click);
        return v;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    View.OnClickListener Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_open_login) {
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
                cont++;
            }

        }
    };
}
