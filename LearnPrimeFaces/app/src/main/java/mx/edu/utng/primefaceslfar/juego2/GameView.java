package mx.edu.utng.primefaceslfar.juego2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import mx.edu.utng.primefaceslfar.R;

public class GameView extends SurfaceView {
	private Bitmap bmpBlood;
	private SurfaceHolder holder;
	public GameLoopThread gameLoopThread;
	private List<SpriteZombies> sprites = new ArrayList<SpriteZombies>();
	private List<TempSprite> temps = new ArrayList<TempSprite>();
	private long lastClick;
	// private SpriteCar car;
	private Sprite girl;
	private long periodoNewZombies;
	private Bitmap fondo;
	private Activity padre;
	private int dificultad;
	private int frecuenciaZombies;
	SoundPool soundPool;
	int idRugido1, idRugido2, idRugido3, idRugido4, idRugido6;
	private boolean isPlayFX;

	public GameView(Context context) {
		super(context);

		SharedPreferences pref = context.getSharedPreferences(
				"eprod.game.killtheall_preferences", Context.MODE_PRIVATE);

		switch (pref.getString("dificultad", "1")) {
		case "0":
			dificultad = 1;
			break;
		case "2":
			dificultad = 2;
			break;
		default:
			dificultad = 3;
		}
		frecuenciaZombies = 10000 / dificultad;

		isPlayFX = pref.getBoolean("efectos", true);

		soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);

		idRugido1 = soundPool.load(context, R.raw.zombiesounds1, 0);

		idRugido2 = soundPool.load(context, R.raw.zombiesounds2, 0);
		idRugido3 = soundPool.load(context, R.raw.zombiesounds3, 0);
		idRugido4 = soundPool.load(context, R.raw.zombiesounds4, 0);
		idRugido6 = soundPool.load(context, R.raw.zombiesounds6, 0);

		gameLoopThread = new GameLoopThread(this);
		holder = getHolder();
		holder.addCallback(new SurfaceHolder.Callback() {

			@Override
			public void surfaceDestroyed(SurfaceHolder holder) {
				//boolean retry = true;
				/*
				 * gameLoopThread.setRunning(false); while (retry) { try {
				 * gameLoopThread.join(); retry = false; } catch
				 * (InterruptedException e) { Log.e("GameView", e.toString()); }
				 * }
				 */
				gameLoopThread.pause();
				gameLoopThread.setInBackground(true);
				Log.i("GameView", "surfaceDestroyed();");
			}

			@Override
			public void surfaceCreated(SurfaceHolder holder) {
				if (gameLoopThread.isInBackground()) {
					gameLoopThread.setInBackground(false);
					Log.i("GameView",
							"surfaceCreated() -> estaba en background");
				} else {
					createSprites();
					gameLoopThread.setRunning(true);
					gameLoopThread.start();
					Log.i("GameView", "surfaceCreated() -> se inicia thread");
				}

			}

			@Override
			public void surfaceChanged(SurfaceHolder holder, int format,
					int width, int height) {
			}
		});
		bmpBlood = BitmapFactory.decodeResource(getResources(),
				R.drawable.blood2);
		fondo = BitmapFactory.decodeResource(getResources(), R.drawable.fondo);
	}

	private void chof() {
		if (isPlayFX) {
			try {
				Random rnd = new Random();
				int sorteo = rnd.nextInt(5);
				switch (sorteo) {
				case 0:
					soundPool.play(idRugido1, 1, 1, 0, 0, 1);
					break;
				case 1:
					soundPool.play(idRugido2, 1, 1, 0, 0, 1);
					break;
				case 2:
					soundPool.play(idRugido3, 1, 1, 0, 0, 1);
					break;
				case 3:
					soundPool.play(idRugido4, 1, 1, 0, 0, 1);
					break;
				case 4:
					soundPool.play(idRugido6, 1, 1, 0, 0, 1);
					break;

				}
			} catch (Exception e) {
				Log.i("GameView", "Excepcion de soundPool chof");
				Log.i("GameView", "Excepcion : " + e.toString());
			}
		}
	}

	private void createSprites() {
		// Bitmap bmp = BitmapFactory.decodeResource(getResources(),
		// R.drawable.coches);
		// car= new SpriteCar(this, bmp);
		Bitmap bmp = BitmapFactory.decodeResource(getResources(),
				R.drawable.chica);
		girl = new Sprite(this, bmp);
		for (int i = 0; i < 2; i++) {
			sprites.add(createSprite(R.drawable.zombie1));
			sprites.add(createSprite(R.drawable.zombie2));
			sprites.add(createSprite(R.drawable.zombie3));
			sprites.add(createSprite(R.drawable.zombie4));
			sprites.add(createSprite(R.drawable.zombie5));
			sprites.add(createSprite(R.drawable.zombie6));
			sprites.add(createSprite(R.drawable.zombie7));
			sprites.add(createSprite(R.drawable.zombie8));
			sprites.add(createSprite(R.drawable.zombie9));
		}
	}

	private SpriteZombies createSprite(int resouce) {
		Bitmap bmp = BitmapFactory.decodeResource(getResources(), resouce);
		return new SpriteZombies(this, bmp);
	}

	// cambio este m�todo sobreescrito de View
	/*
	 * @Override protected void onDraw(Canvas canvas) {
	 * canvas.drawColor(Color.BLACK); sprite.dibujaSprite(canvas); }
	 */
	protected void dibujaCanvas(Canvas canvas) {
		// canvas.drawColor(Color.BLACK);
		try {
			// Log.i("GameView", "Canvas = " + canvas);
			// Log.i("GameView", "Canvas = " + this);
			canvas.drawBitmap(fondo, 0, 0, null);

			for (SpriteZombies sprite : sprites) {
				if (girl.isCollition(sprite.x, sprite.width, sprite.y,
						sprite.height)) {
					Log.i("gameview", "muerde a la chica");
					salir();
					break;
				}
			}

			// car.dibujaSprite(canvas);
			for (int i = temps.size() - 1; i >= 0; i--) {
				temps.get(i).dibujaSprite(canvas);
			}
			girl.dibujaSprite(canvas);
			for (SpriteZombies sprite : sprites) {
				sprite.persigue(girl.x, girl.y);
				sprite.dibujaSprite(canvas);
				/*
				 * if (sprite.isCollition(girl.x, girl.y)) { Log.i("gameview",
				 * "muerde a la chica"); break; }
				 */
			}

			/*
			 * for (SpriteZombies sprite : sprites) { if
			 * (sprite.isCollition(car.centX, car.centY)) {
			 * sprites.remove(sprite); temps.add(new TempSprite(temps, this,
			 * sprite.x +(sprite.width/2), sprite.y +(sprite.height/2),
			 * bmpBlood)); break; } }
			 */
			if (System.currentTimeMillis() - periodoNewZombies > frecuenciaZombies) {
				periodoNewZombies = System.currentTimeMillis();
				sprites.add(createSprite(R.drawable.zombie1));
				sprites.add(createSprite(R.drawable.zombie2));
				sprites.add(createSprite(R.drawable.zombie3));
				sprites.add(createSprite(R.drawable.zombie4));
				sprites.add(createSprite(R.drawable.zombie5));
				sprites.add(createSprite(R.drawable.zombie6));
				sprites.add(createSprite(R.drawable.zombie7));
				sprites.add(createSprite(R.drawable.zombie8));
				sprites.add(createSprite(R.drawable.zombie9));
			}
		} catch (Exception e) {
			Log.i("GameView", "Canvas = " + canvas);
			Log.i("GameView", "Canvas = " + this);
			Log.e("GameView", "Error en :" + e.toString());
		}

	}

	public void setPadre(Activity padre) {
		this.padre = padre;
	}

	private void salir() {
		Bundle bundle = new Bundle();
		bundle.putInt("puntuacion", puntuacion);
		bundle.putInt("eliminados", eliminados);
		Intent intent = new Intent();
		intent.putExtras(bundle);
		padre.setResult(Activity.RESULT_OK, intent);
		gameLoopThread.stopThread();
		padre.finish();

	}

	// posicion anterior del puntero
	//private float mX = 0, mY = 0;
	private int puntuacion;
	private int eliminados;

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		super.onTouchEvent(event);
		// Suponemos que vamos a procesar la pulsaci�n
		boolean procesada = true;

		if (System.currentTimeMillis() - lastClick > 150) {
			lastClick = System.currentTimeMillis();
			float x = event.getX();
			float y = event.getY();
			// sincronizado con el holder de gameLoopThread
			synchronized (holder) {
				for (int i = sprites.size() - 1; i >= 0; i--) {
					SpriteZombies sprite = sprites.get(i);
					if (sprite.isCollition(x, y)) {
						chof();
						sprites.remove(sprite);
						temps.add(new TempSprite(temps, this, sprite.x
								+ (sprite.width / 2), sprite.y
								+ (sprite.height / 2), bmpBlood));
						puntuacion += 25;
						eliminados += 1;
						break;
					}
				}
			}
		}
		/*
		 * synchronized (holder) {
		 * 
		 * 
		 * float x = event.getX(); float y = event.getY();
		 * 
		 * // puede acelerar y desacelerar float dx = x - mX; // float dy =
		 * Math.abs(y - mY);
		 * 
		 * // con valores negativos, puede acelerar pero no desacelerar // float
		 * dx = x - mX; float dy = mY - y; switch (event.getAction()) { case
		 * MotionEvent.ACTION_DOWN:
		 * 
		 * break;
		 * 
		 * case MotionEvent.ACTION_MOVE:
		 * 
		 * //car.giroCoche(dx); //car.aceleracion(dy);
		 * 
		 * Log.i("ACTION_MOVE", "dx = " + dx + ", " + "x = " + x +", " + "mX = "
		 * + mX);
		 * 
		 * 
		 * Log.i("ACTION_MOVE", "dy = " + dy + ", " + "y = " + y + ", " +
		 * "mY = " + mY);
		 * 
		 * 
		 * break; case MotionEvent.ACTION_UP: //car.aceleracion(0); break; } mX
		 * = x; mY = y; }
		 * 
		 * 
		 * /*if (System.currentTimeMillis() - lastClick > 500) { lastClick =
		 * System.currentTimeMillis(); float x = event.getX(); float y =
		 * event.getY(); // sincronizado con el holder de gameLoopThread
		 * synchronized (getHolder()) { for (int i = sprites.size() - 1; i >= 0;
		 * i--) { Sprite sprite = sprites.get(i); if (sprite.isCollition(x, y))
		 * { sprites.remove(sprite); temps.add(new TempSprite(temps, this,
		 * sprite.getX()+(sprite.getWidth()/2), sprite.getY()
		 * +(sprite.getHeight()/2), bmpBlood)); break; } } } }
		 */
		return procesada;
	}

	/* Callback invoked when the surface dimensions change. */
	public void setSurfaceSize(int width, int height) {
		// synchronized to make sure these all change atomically
		synchronized (holder) {
			// mCanvasWidth = width;
			// mCanvasHeight = height;

			// don't forget to resize the background image
			fondo = Bitmap.createScaledBitmap(fondo, width, height, true);
		}
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		setSurfaceSize(w, h);
	}

}