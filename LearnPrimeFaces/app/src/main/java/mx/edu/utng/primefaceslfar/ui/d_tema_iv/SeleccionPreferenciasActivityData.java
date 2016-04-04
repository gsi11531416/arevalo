package mx.edu.utng.primefaceslfar.ui.d_tema_iv;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import mx.edu.utng.primefaceslfar.R;

/**
 * Created by Luis Arevalo on 01/03/2016.
 */
public class SeleccionPreferenciasActivityData extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.cuestionario_uno);
    }
}
