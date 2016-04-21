package mx.edu.utng.primefaceslfar.juego2;

import java.util.Vector;

public interface IAlmacenPuntuaciones {
	public void guardarPuntuacion(int puntos, int eliminados, String nombre, long fecha);

	public Vector<String> listaPuntuaciones(int cantidad);
}