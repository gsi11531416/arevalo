package mx.edu.utng.primefaceslfar.juego2;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import mx.edu.utng.primefaceslfar.R;


public class PreferenciasJuego extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias_juego);
    }
}
