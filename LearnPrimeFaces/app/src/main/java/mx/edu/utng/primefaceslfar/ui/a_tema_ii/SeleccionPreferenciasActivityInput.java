package mx.edu.utng.primefaceslfar.ui.a_tema_ii;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.ui.ActividadPrincipal;

/**
 * Created by Luis Arevalo on 01/03/2016.
 */
public class SeleccionPreferenciasActivityInput extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.cuestionario_dos);
        Preference btnRegresar = (Preference)findPreference("regresar_dos");
        btnRegresar.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(SeleccionPreferenciasActivityInput.this, ActividadPrincipal.class));
                finish();
                return false;

            }
        });
    }
}
