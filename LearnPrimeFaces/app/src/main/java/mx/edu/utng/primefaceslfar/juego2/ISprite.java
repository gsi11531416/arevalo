package mx.edu.utng.primefaceslfar.juego2;

import android.graphics.Canvas;

public interface ISprite {
	public void dibujaSprite(Canvas canvas);
	public void persigue(int posX, int posY);
	public boolean isCollition(float x2, float y2);
	public boolean isCollition(float x2, float w, float y2, float h);
	public int getX();
	public int getY();
	public int getWidth();
	public int getHeight();
}
