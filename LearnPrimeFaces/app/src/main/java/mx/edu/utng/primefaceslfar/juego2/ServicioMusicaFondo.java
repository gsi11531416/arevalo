package mx.edu.utng.primefaceslfar.juego2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import mx.edu.utng.primefaceslfar.R;


public class ServicioMusicaFondo extends Service {

	public final static int MUSICA_FONDO_MAIN = 0;
	public final static int MUSICA_FONDO_GAMEVIEW = 1;
	MediaPlayer reproductor;
	static int resIdMusica;
	
	void eligeMusicaFondo(int resIdMusica){
		switch(resIdMusica){
		case 0:
			ServicioMusicaFondo.resIdMusica = R.raw.soundmain;
			break;
		case 1:
			ServicioMusicaFondo.resIdMusica = R.raw.sonidosbosqueforest;
			break;
		}
	}

	@Override
	public void onCreate() {
		reproductor = MediaPlayer.create(this, R.raw.sonidosbosqueforest);
		
	}

	@Override
	public int onStartCommand(Intent intenc, int flags, int idArranque) {
		reproductor.setLooping(true);
		reproductor.start();
		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		reproductor.stop();
		reproductor.release();
		reproductor=null;

	}

	@Override
	public IBinder onBind(Intent intencion) {
		return null;
	}
}