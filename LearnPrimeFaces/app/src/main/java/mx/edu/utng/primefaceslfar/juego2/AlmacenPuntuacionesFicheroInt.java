package mx.edu.utng.primefaceslfar.juego2;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Vector;

import mx.edu.utng.primefaceslfar.R;

public class AlmacenPuntuacionesFicheroInt implements IAlmacenPuntuaciones {
	private static String FICHERO = "puntuaciones_juego.txt";
	private Context context;
	private final static String TAG = AlmacenPuntuacionesFicheroInt.class.getSimpleName();

	public AlmacenPuntuacionesFicheroInt(Context context) {
		this.context = context;
	}

	public void guardarPuntuacion(int puntos, int eliminados, String nombre, long fecha) {
		try {
			FileOutputStream f = context.openFileOutput(FICHERO,
					Context.MODE_APPEND);
			Log.i("AlmacenPuntuacionesFicheroInterno", "Fihero almacenado en: "+ f.toString() );
			String texto = puntos + " puntos , Pj: " + nombre + " , " +context.getResources().getString(R.string.deadZombies) +" "+ eliminados + "\n" ;
			f.write(texto.getBytes());
			f.close();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
		}
	}

	public Vector<String> listaPuntuaciones(int cantidad) {
		Vector<String> result = new Vector<String>();
		try {
			FileInputStream f = context.openFileInput(FICHERO);
			BufferedReader entrada = new BufferedReader(
					new InputStreamReader(f));
			int n = 0;
			String linea;
			do {
				linea = entrada.readLine();
				if (linea != null) {
					result.add(linea);
					n++;
				}
			} while (n < cantidad && linea != null);
			f.close();
		} catch (Exception e) {
			Log.e(TAG, e.getMessage(), e);
		}
		return result;
	}
}
