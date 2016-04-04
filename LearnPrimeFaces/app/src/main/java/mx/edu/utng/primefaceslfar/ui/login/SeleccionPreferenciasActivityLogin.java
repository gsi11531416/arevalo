package mx.edu.utng.primefaceslfar.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;

import mx.edu.utng.primefaceslfar.R;
import mx.edu.utng.primefaceslfar.ui.ActividadPrincipal;

/**
 * Created by Luis Arevalo on 01/03/2016.
 */
public class SeleccionPreferenciasActivityLogin extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.login);
        Preference btnRegresar = (Preference)findPreference("iniciar_sesion");
        btnRegresar.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                startActivity(new Intent(SeleccionPreferenciasActivityLogin.this, ActividadPrincipal.class));
                finish();
                return false;

            }
        });
    }
}
