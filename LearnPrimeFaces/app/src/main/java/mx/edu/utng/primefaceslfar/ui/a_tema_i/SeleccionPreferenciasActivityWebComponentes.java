package mx.edu.utng.primefaceslfar.ui.a_tema_i;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.ui.ActividadPrincipal;

/**
 * Created by Luis Arevalo on 01/03/2016.
 */
public class SeleccionPreferenciasActivityWebComponentes extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.cuestionario_uno);
        Preference btnRegresar = (Preference)findPreference("regresar");
        btnRegresar.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(SeleccionPreferenciasActivityWebComponentes.this, ActividadPrincipal.class));
                finish();
                return false;

            }
        });
    }

}
