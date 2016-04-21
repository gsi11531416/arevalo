package mx.edu.utng.primefaceslfar.juego2;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class GameLoopThread extends Thread {
	private GameView view;
	private boolean running = false;
	private boolean mInBackground = false;
	private int mMode;
	private SurfaceHolder holder;
	static final long FPS = 10;
	public static final int STATE_LOSE = 1;
	public static final int STATE_PAUSE = 2;
	public static final int STATE_READY = 3;
	public static final int STATE_RUNNING = 4;
	public static final int STATE_WIN = 5;

	public GameLoopThread(GameView view) {
		this.view = view;
		holder = view.getHolder();
	}

	public void setRunning(boolean run) {
		synchronized (holder) {
			running = run;
		}

	}

	public void stopThread() {
		synchronized (holder) {
			running = false;

			if (mInBackground)
				setInBackground(false);
		}

	}

	// por convenci�n los m�todos llamados on_xxx son llamados desde el sistema,
	// desde versiones recientes se tiene que:
	// 1- se puede implementar un m�todo propio que dibuje la vista
	// 2- a�adir @SuppressLint("WrongCall")
	// @SuppressLint("WrongCall")
	@Override
	public void run() {
		long ticksPS = 1000 / FPS;
		long startTime;
		long sleepTime;
		setState(STATE_RUNNING);
		Log.i("GameLoopThread", "run()");
		while (running) {
			//Log.i("GameLoopThread", "running");
			if (mInBackground) {
				try {
					//Log.i("GameLoopThread", "sleep(600);");
					sleep(600);

				} catch (final InterruptedException e) {
				} finally {
					//Log.i("GameLoopThread", "finally despues de sleep(500);");
				}
			} else {
				Canvas c = null;
				startTime = System.currentTimeMillis();
				try {
					c = holder.lockCanvas();
					synchronized (holder) {
						// usa el m�todo de dibujar del GameView
						// cambio nombre m�todo onDraw(c)
						// view.onDraw(c);
						// por:
						view.dibujaCanvas(c);
					}
				} finally {
					if (c != null) {
						holder.unlockCanvasAndPost(c);
					}
				}
				// si sleepTime >0 ha ido m�s rapido que FPS, si es menor ha ido
				// m�s lento
				sleepTime = ticksPS - (System.currentTimeMillis() - startTime);
				try {
					if (sleepTime > 0)
						// ha ido m�s rapido y dormimos la diferencia
						sleep(sleepTime);
					else
						// si ha ido m�s lento dormimos 10mseg para que no
						// seamos �vidos con el procesador
						sleep(10);
				} catch (Exception e) {
					Log.e("GameLoopThread", e.toString());
				}
			}
		}
	}

	public boolean isInBackground() {
		//synchronized (view.getHolder()) {
			return mInBackground;
		//}
	}

	public void setInBackground(boolean b) {
		synchronized (view.getHolder()) {
			mInBackground = b;
		}

	}

	public void pause() {
		synchronized (holder) {
			if (mMode == STATE_RUNNING)
				setState(STATE_PAUSE);
		}
	}

	public void setState(final int mode) {
		synchronized (holder) {
			setState(mode, null);
		}
	}

	/**
	 * Sets the game mode. That is, whether we are running, paused, in the
	 * failure state, in the victory state, etc.
	 * 
	 * @param mode
	 *            one of the STATE_* constants
	 * @param message
	 *            string to add to screen or null
	 */
	public void setState(final int mode, final CharSequence message) {
		/*
		 * This method optionally can cause a text message to be displayed to
		 * the user when the mode changes. Since the View that actually renders
		 * that text is part of the main View hierarchy and not owned by this
		 * thread, we can't touch the state of that View. Instead we use a
		 * Message + Handler to relay commands to the main thread, which updates
		 * the user-text View.
		 */
		synchronized (holder) {
			mMode = mode;

			if (mMode == STATE_RUNNING) {

			} else {

				CharSequence str = "";
				if (mMode == STATE_READY)
					str = "";
				else if (mMode == STATE_PAUSE)
					str = "";
				else if (mMode == STATE_LOSE)
					str = "";
				else if (mMode == STATE_WIN)
					str = "";

				if (message != null) {
					str = message + "\n" + str;
				}

				if (mMode == STATE_LOSE)
					;

			}
		}
	}
}