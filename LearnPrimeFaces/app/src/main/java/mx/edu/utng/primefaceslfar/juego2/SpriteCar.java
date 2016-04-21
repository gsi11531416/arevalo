package mx.edu.utng.primefaceslfar.juego2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class SpriteCar {
	// array direccion = 18 left,12 up, 6 right , 0 down
	// resultado getCurrentFrame = 0 left,12 right, 6 up , 18 down
	// los int del array corresponden al frame del bmp
	int[] DIRECTION_TO_ANIMATION_MAP = { 18, 19, 20, 21, 22, 23, 12, 11, 10, 9,
			8, 7, 6, 5, 4, 3, 2, 1, 0, 13, 14, 15, 26, 17 };
	private static final int BMP_ROWS = 24;
	private static final int BMP_COLUMNS = 1;

	// posicion del sprite 
	public int centX;
	public int centY;
	// angulo de giro en grados y modulo de desplazamineto en radianes
	private final static int GIRO = 5;
	private int angulo;
	// aceleracion que modifica xSpeed y ySpeed
	private int VELOCIDAD = 10;
	private final static int MARCHA_ATRAS = -15;
	private static final int MAX_SPEED = 50;
	private static final int MAX_SPEED_ATRAS = -25;
	// modulo de direcci�n descompuesta en X y Y
	private int xSpeed = 0;
	private int ySpeed = 0;
	private GameView gameView;
	private Bitmap bmp;
	private int currentFrame = 0;
	private int width;
	private int height;
	private static int ACELERACION;

	public SpriteCar(GameView gameView, Bitmap bmp) {
		this.gameView = gameView;
		this.bmp = bmp;
		// ancho del bmp/ cuantos sprites tiene
		this.width = bmp.getWidth() / BMP_ROWS;
		this.height = bmp.getHeight() / BMP_COLUMNS;

		// posicion centro del canvas donde se dibuja por primera vez
		centX = gameView.getWidth() / 2 - width / 2;
		centY = gameView.getHeight() / 2 - height / 2;
	}

	// determina angulo de desplazamiento
	public void giroCoche(float x) {
		if (direccionX * direccionY > 0) {
			this.angulo += (int) x / 2;
		} else {
			this.angulo -= (int) x / 2;
		}
	}

	// se modifica modVelocidad
	public void aceleracion(float y) {
		// si la velocidad no supera o es igual a MaxSpeed
		/*
		 * if( y > 0 ) ACELERACION = 1; if( y < 0) ACELERACION = -1; if( y == 0)
		 * ACELERACION = 0;
		 */

		VELOCIDAD += (y > 0) ? VELOCIDAD : MARCHA_ATRAS;

		if (VELOCIDAD > MAX_SPEED)
			VELOCIDAD = MAX_SPEED;
		if (VELOCIDAD < MAX_SPEED_ATRAS)
			VELOCIDAD = MAX_SPEED_ATRAS;
	}

	private int direccionX = 1;
	private int direccionY = 1;

	private int despX;
	private int despY;

	private void evaluaMargenes(int velX, int velY) {
		if (centX > gameView.getWidth() - width - velX || centX + velX < 0) {
			direccionX = -direccionX;
		}
		centX += velX;
		if (centY > gameView.getHeight() - height - velY || centY + velY < 0) {
			direccionY = -direccionY;
		}
		centY += velY;
		despX = velX;
		despY = velY;
	}

	// actualizaF�sica, modVelocidad modifica cantidad de x y de y
	private void update() {
		int velX = (int) (direccionX * VELOCIDAD * Math.cos(Math
				.toRadians(angulo)));

		int velY = (int) (direccionY * VELOCIDAD * Math.sin(Math
				.toRadians(angulo)));

		evaluaMargenes(velX, velY);
	}

	// dibujaGrafico(), equivalente a onDraw() en tutoriales
	public void dibujaSprite(Canvas canvas) {
		update();
		int srcX = getCurrentFrame() * width;
		// int srcY = getAnimationRow() * height;
		int srcY = 0;
		// rectangulo origen (bmp)
		Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
		// rectangulo destino en el canvas
		// Rect dst = new Rect(x, y, x + width, y + height);
		Rect dst = new Rect(centX, centY, centX + width, centY + height);
		// el bmp se empieza a dibujar left-top (x, y)
		canvas.drawBitmap(bmp, src, dst, null);

	}

	// array direccion = 18 left,12 up, 6 right , 0 down
	// animacion = 0 left,12 up, 6 right , 0 down
	private int getCurrentFrame() {
		// determino direccion a trav�s de las velocidades de xSpeed y de ySpeed
		double dirDouble = (Math.atan2(despX, despY) / (Math.PI / 12) + 24);

		int direction = (int) Math.round(dirDouble) % BMP_ROWS;
		return DIRECTION_TO_ANIMATION_MAP[direction];
	}

	public boolean isCollition(float x2, float y2) {
		return x2 > centX && x2 < centX + width && y2 > centY && y2 < centY + height;
	}

	public int getX() {
		return centX;
	}

	public int getY() {
		return centY;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}