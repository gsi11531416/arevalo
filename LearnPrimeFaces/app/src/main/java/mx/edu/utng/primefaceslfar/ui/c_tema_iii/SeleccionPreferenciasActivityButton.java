package mx.edu.utng.primefaceslfar.ui.c_tema_iii;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import mx.edu.utng.primefaceslfar.R;

/**
 * Created by Luis Arevalo on 01/03/2016.
 */
public class SeleccionPreferenciasActivityButton extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.cuestionario_uno);
    }
}
