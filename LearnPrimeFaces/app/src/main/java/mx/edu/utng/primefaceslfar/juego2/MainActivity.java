package mx.edu.utng.primefaceslfar.juego2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import mx.edu.utng.primefaceslfar.R;

public class MainActivity extends ActionBarActivity {

	public static IAlmacenPuntuaciones almacen;
	//private boolean isPlayMusica;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_game_ii);
		initBotones();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		// Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
		Log.i("MainActivity", "onResume");
		//Se inicializa la variable almacen en onResume() para que se actualice el tipo de almacenamiento 
		//cuando volvemos de las preferencias
		SharedPreferences pref = this.getSharedPreferences(
				"org.example.asteroides_preferences", Context.MODE_PRIVATE);

		almacen = new AlmacenPuntuacionesFicheroInt(this);
		/*switch (pref.getString("almacen", "1")) {
		case "0":
			almacen = new AlmacenPuntuacionesFicheroInt(this);
		break;
		case "1":
			almacen = new AlmacenPuntuacionesSW_AsyncTask(this);
			break;		
		}*/
		//Log.i("MainActivity", "se leen las preferencias de :" + pref.getString("almacen", "0"));
	}

	private void initBotones() {
		TextView titulo = (TextView)findViewById(R.id.tituloApp);
		Typeface typeface= Typeface.createFromAsset(this.getAssets(), "fuentes/zombiefont.ttf");
		titulo.setTypeface(typeface);
		
		Animation animacion = AnimationUtils.loadAnimation(this,
				R.anim.desplazamiento_derecha);

		
		//titulo.setText(texto);
		Button btn = (Button)findViewById(R.id.btnArrancar);
		btn.setTypeface(typeface);
		btn.startAnimation(animacion);
		
		btn = (Button)findViewById(R.id.btnConfigurar);
		btn.setTypeface(typeface);
		animacion = AnimationUtils.loadAnimation(this,
				R.anim.desplazamiento_izquierda);
		btn.startAnimation(animacion);
		
		btn = (Button)findViewById(R.id.btnAcercaDe);
		btn.setTypeface(typeface);
		animacion = AnimationUtils
				.loadAnimation(this, R.anim.desplazamiento_up);
		btn.startAnimation(animacion);
		
		btn = (Button)findViewById(R.id.btnPuntuaciones);
		animacion = AnimationUtils
				.loadAnimation(this, R.anim.desplazamiento_up);
		btn.setTypeface(typeface);
		btn.startAnimation(animacion);

	}

	public void lanzarAcercaDe(View view) {		
		Intent i = new Intent(this, AcercaDe.class);
		startActivity(i);
	}

	public void lanzarPreferencias(View view) {
		Intent i = new Intent(this, PreferenciasJuego.class);
		startActivity(i);
	}

	public void lanzarJuego(View view) {
		Intent i = new Intent(this, Game.class);
		startActivityForResult(i, 1234);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == 1234 && resultCode == RESULT_OK && data != null) {
			int puntuacion = data.getExtras().getInt("puntuacion");
			int eliminados = data.getExtras().getInt("eliminados");
			DialogoNombre diao = DialogoNombre.newInstance(puntuacion, eliminados, System.currentTimeMillis(), this);
			diao.show(getSupportFragmentManager(), "tag");			
		}
	}

	public void lanzarPuntuaciones(View view) {
		Intent i = new Intent(this, PuntuacionesJuego.class);
		startActivity(i);
	}
}
