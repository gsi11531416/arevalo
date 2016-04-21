package mx.edu.utng.primefaceslfar.juego2;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import java.util.Random;

public class SpriteZombies implements ISprite{
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
	public int width;
	public int height;

	public SpriteZombies(GameView gameView, Bitmap bmp) {
		this.gameView = gameView;
		this.bmp = bmp;
		// ancho del bmp/ cuantos sprites tiene
		this.width = bmp.getWidth() / BMP_COLUMNS;
		this.height = bmp.getHeight() / BMP_ROWS;

		Random rnd = new Random();
		
		//izq-pantalla = 0, derecha-pantalla=2 , arriba=1, abajo=3
		int donde= rnd.nextInt(4);
		//Log.i("SpriteZombies", ""+donde);
		switch(donde){
		case 0:
			x = 0 - width - rnd.nextInt(width*1); 
			y = rnd.nextInt(gameView.getHeight());
			break;
		case 1:
			x = rnd.nextInt(gameView.getWidth());
			y = 0-height - rnd.nextInt(height*1);
			break;
		case 2:
			x = gameView.getWidth()+width +rnd.nextInt(width*1);
			y = rnd.nextInt(gameView.getHeight());
			break;
		case 3:
			x = rnd.nextInt(gameView.getWidth());
			y = gameView.getHeight()+ height + rnd.nextInt(height*1);
			break;
		}
		
	}

	// actualizaF�sica
	private void update() {
		x = x + xSpeed;
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
	public boolean isCollition(float x2, float y2) {
		return x2 > x && x2 < x + width && y2 > y && y2 < y + height;
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
	public boolean isCollition(float x2, float w, float y2, float h) {
		//no hacer nada
		return false;
	}
}
