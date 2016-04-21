package mx.edu.utng.primefaceslfar.juego2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite implements ISprite{
	// direction = 0 up, 1 left, 2 down, 3 right,
	// animation = 3 back, 1 left, 0 front, 2 right
	int[] DIRECTION_TO_ANIMATION_MAP = { 3, 1, 0, 2 };
	private static final int BMP_ROWS = 4;
	private static final int BMP_COLUMNS = 3;
	private static final int MAX_SPEED = 5;
	public int x = 0;
	public int y = 0;
	// velocidad x
	private int xSpeed = 0;
	// velocidad y
	private int ySpeed = 0;
	private GameView gameView;
	private Bitmap bmp;
	private int currentFrame = 0;
	private int width;
	private int height;

	public Sprite(GameView gameView, Bitmap bmp) {
		this.gameView = gameView;
		this.bmp = bmp;
		// ancho del bmp/ cuantos sprites tiene
		this.width = bmp.getWidth() / BMP_COLUMNS;
		this.height = bmp.getHeight() / BMP_ROWS;
		// asigno velocidad aleatoria
		//Random rnd = new Random();
		xSpeed = MAX_SPEED;
		ySpeed = MAX_SPEED;

		x = (gameView.getWidth() / 2) - width / 2;
		y = (gameView.getHeight() / 2) - height / 2;
	}

	// actualizaF�sica
	private void update() {
		// restringimos su �rea de desplazamiento al centro de la pantalla
		if (x > gameView.getWidth() * 2 / 3 - width
				|| x < gameView.getWidth() * 1 / 3) {
			// invierto el valor de xSpeed
			xSpeed = -xSpeed;
		}
		x = x + xSpeed;
		if (y > gameView.getHeight() * 2 / 3 - height
				|| y < gameView.getHeight() * 1 / 3) {
			ySpeed = -ySpeed;
		}
		y = y + ySpeed;
		currentFrame = ++currentFrame % BMP_COLUMNS;
	}

	// dibujaGrafico(), equivalente a onDraw() en tutoriales
	public void dibujaSprite(Canvas canvas) {
		update();
		int srcX = currentFrame * width;
		int srcY = getCurrentFrame() * height;
		// rectangulo origen (bmp)
		Rect src = new Rect(srcX, srcY, srcX + width, srcY + height);
		// rectangulo destino en el canvas
		Rect dst = new Rect(x, y, x + width, y + height);
		// el bmp se empieza a dibujar left-top (x, y)
		canvas.drawBitmap(bmp, src, dst, null);

	}

	public void persigue(int posX, int posY) {
		int distanciaX = x - posX;
		int distanciaY = posY - y;
		if (distanciaX > 0) {
			xSpeed = -1;
		} else if (distanciaX < 0) {
			xSpeed = +1;
		} else {
			xSpeed = 0;
		}
		if (distanciaY > 0) {
			ySpeed = +1;
		} else if (distanciaY < 0) {
			ySpeed = -1;
		} else {
			ySpeed = 0;
		}
	}

	// direction = 0 up, 1 left, 2 down, 3 right,
	// animation = 3 back, 1 left, 0 front, 2 right
	private int getCurrentFrame() {
		double dirDouble = (Math.atan2(xSpeed, ySpeed) / (Math.PI / 2) + 2);
		int direction = (int) Math.round(dirDouble) % BMP_ROWS;
		return DIRECTION_TO_ANIMATION_MAP[direction];
	}
	
	@Override
	public boolean isCollition(float x2, float w, float y2, float h) {
		return x2 + w/3 > x && x2 + w*2/3 < x + width && y2 + h/2 > y 
				&&  y2 + h < y + height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public boolean isCollition(float x2, float y2) {
		//no hacer nada
		return false;
	}
}
