package mx.edu.utng.primefaceslfar.juego2;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Vector;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AlmacenPuntuacionesSW_AsyncTask implements IAlmacenPuntuaciones {
	private final static String TAG = AlmacenPuntuacionesSW_AsyncTask.class.getSimpleName();
	 
	private Context contexto;

	public AlmacenPuntuacionesSW_AsyncTask(Context contexto) {
	       this.contexto = contexto;
	} 

	public Vector<String> listaPuntuaciones(int cantidad) {
	       try {
	             TareaLista tarea = new TareaLista();
	             tarea.execute(cantidad);
	             return tarea.get(4, TimeUnit.SECONDS);
	       } catch (TimeoutException e) {
	             Toast.makeText(contexto, "Tiempo excedido al conectar",
	                           Toast.LENGTH_LONG).show();
	       } catch (CancellationException e) {
	             Toast.makeText(contexto, "Error al conectar con servidor",
	                           Toast.LENGTH_LONG).show();
	       } catch (Exception e) {
	             Toast.makeText(contexto, "Error con tarea as�ncrona",
	                           Toast.LENGTH_LONG).show();
	       }
	       return new Vector<String>();
	}
	
	private class TareaLista extends AsyncTask<Integer, Void, Vector<String>>{

		  @Override
		  protected Vector<String> doInBackground(Integer... cantidad){
			  Vector<String> result = new Vector<String>();
	          try {
	                 URL url=new URL("http://epr.hostinazo.com/puntuaciones/lista.php" + "?max=" + cantidad[0]);

	                 HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

	                 if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
	                        BufferedReader reader = new BufferedReader(new
	                                InputStreamReader(conexion.getInputStream()));
	                        String linea = reader.readLine();
	                        while (!linea.equals("")) {
	                               result.add(linea);
	                               linea = reader.readLine();
	                        }
	                        reader.close();
	                        conexion.disconnect();
	                        return result;
	                 } else {
	                               Log.e(TAG, conexion.getResponseMessage());
	                               cancel(true);
	                               conexion.disconnect();
	                               return result;
	                        }
	          } catch (Exception e) {
	                 Log.e(TAG, e.getMessage(), e);
	                 cancel(true);
	                 return result;
	          }
		  }
		 }     
    
	public void guardarPuntuacion(int puntos, int eliminados, String nombre, long fecha){

	       try {
	             TareaGuardar tarea = new TareaGuardar();
	             tarea.execute(String.valueOf(puntos), nombre, String.valueOf(fecha), String.valueOf(eliminados));
	             tarea.get(4, TimeUnit.SECONDS);
	       } catch (TimeoutException e) {
	             Toast.makeText(contexto, "Tiempo excedido al conectar",
	                           Toast.LENGTH_LONG).show();
	       } catch (CancellationException e) {
	             Toast.makeText(contexto, "Error al conectar con servidor",
	                           Toast.LENGTH_LONG).show();
	       } catch (Exception e) {
	             Toast.makeText(contexto, "Error con tarea as�ncrona",
	                           Toast.LENGTH_LONG).show();
	       }
	}

	private class TareaGuardar extends AsyncTask<String, Void, Void> {

	       @Override

	       protected Void doInBackground(String... param) {

	             try {
	                    URL url = new URL("http://epr.hostinazo.com/puntuaciones/nueva.php"

	                                        + "?puntos=" + param[0] + "&nombre="
	                                        + URLEncoder.encode(param[1], "UTF-8")
	                                        + "&fecha=" + param[2]
	                                        		+"&eliminados=" + param[3]);
	                    HttpURLConnection conexion = (HttpURLConnection) url.openConnection();

	                    if (conexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
	                           BufferedReader reader = new BufferedReader(new
	                                         InputStreamReader(conexion.getInputStream()));
	                           String linea = reader.readLine();
	                           if (!linea.equals("OK")) {
	                                  Log.e("Asteroides","Error en servicio Web nueva");
	                                  cancel(true);
	                           }
	                    } else {
	                           Log.e("Asteroides", conexion.getResponseMessage());
	                           cancel(true);
	                    }
	                    conexion.disconnect();
	             } catch (Exception e) {
	                    Log.e(TAG, e.getMessage(), e);
	                    cancel(true);
	             }
	             Log.i(TAG, "antes de 'return null' en TareaGuardar");
	        return null;
	       }	

		@Override
		protected void onCancelled() {
			//super.onCancelled();
			Log.e(TAG, "onCanceled()");
		}
	}
    
}


