package mx.edu.utng.primefaceslfar.juego2;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.List;

public class TempSprite {
	// posici�n donde se empieza a dibujar el bitmap, top-left, est� posici�n
	// coincide con la pulsaci�n menos el ancho del bitmap, se dibuja entonces
	// el centro del bitmap donde hemos pulsado
	private float x;
	private float y;
	private Bitmap bmp;
	// cantidad de veces que se llama gameview.dibujaCanvas = fps de
	// GameLoopThread
	// llamado tambi�n ticks de update de este sprite
	private int lifeFps = 15;
	private List<TempSprite> temps;

	/**
	 * Sprite Temporal \n temps = lista de sprites temporales donde estan
	 * gameView = referencia a la view X y Y = posici�n donde se hace click *
	 **/
	public TempSprite(List<TempSprite> temps, GameView gameView, float x,
			float y, Bitmap bmp) {

		this.x = x - bmp.getWidth() / 2;
		this.y = y - bmp.getHeight() / 2;
		this.bmp = bmp;
		this.temps = temps;
	}

	// dibujaGrafico(), equivalente a onDraw() en tutoriales
	public void dibujaSprite(Canvas canvas) {
		update();
		canvas.drawBitmap(bmp, x, y, null);
	}

	private void update() {
		if (--lifeFps < 1) {
			temps.remove(this);
		}
	}
}
