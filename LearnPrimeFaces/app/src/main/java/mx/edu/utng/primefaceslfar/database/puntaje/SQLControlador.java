package mx.edu.utng.primefaceslfar.database.puntaje;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Luis Arevalo on 05/04/2016.
 */
public class SQLControlador {
    private DBHelperPuntuacion dbhelperPuntuacion;
    private Context ourcontext;
    private static SQLiteDatabase database;
    public static String resultado = "";
    public SQLControlador(Context c) {
        ourcontext = c;
    }

    public SQLControlador abrirBaseDeDatos() throws SQLException {
        dbhelperPuntuacion = new DBHelperPuntuacion(ourcontext);
        database = dbhelperPuntuacion.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelperPuntuacion.close();
    }

    public void insertarDatos(String calif, String intento) {
        ContentValues cv = new ContentValues();
        cv.put(DBHelperPuntuacion.CALIFICACION, calif);
        cv.put(DBHelperPuntuacion.INTENTO,intento);
        database.insert(DBHelperPuntuacion.TABLE_MEMBER, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBHelperPuntuacion.PUNTUACION_ID,
                DBHelperPuntuacion.CALIFICACION
        };
        Cursor c = database.query(DBHelperPuntuacion.TABLE_MEMBER, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public String id(String id){
        try{
            Cursor cursor = database.rawQuery("select _id from puntuacion where _id = ?",new String[]{id});
            cursor.moveToFirst();
            id = cursor.getString(0);
        }catch (Exception e){
            Log.i("El error ",e.toString());
        }
        return id;
    }

    public String resultado(String id){
        try{
            Cursor cursor = database.rawQuery("select calificacion from puntuacion where _id = ?",new String[]{id});
            cursor.moveToFirst();
            resultado = cursor.getString(0);
        }catch (Exception e){
            Log.i("El error ",e.toString());
        }
        return resultado;
    }

    public String intento(String id){
        try{
            Cursor cursor = database.rawQuery("select intento from puntuacion where _id = ?",new String[]{id});
            cursor.moveToFirst();
            resultado = cursor.getString(0);
        }catch (Exception e){
            Log.i("El error ",e.toString());
        }
        return resultado;
    }

    public int actualizarDatos(long califID, String calif, String inten) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBHelperPuntuacion.CALIFICACION, calif);
        cvActualizar.put(DBHelperPuntuacion.INTENTO,inten);
        int i = database.update(DBHelperPuntuacion.TABLE_MEMBER, cvActualizar,
                DBHelperPuntuacion.PUNTUACION_ID + " = " + califID, null);
        return i;
    }



    public void deleteData(long califID) {
        database.delete(DBHelperPuntuacion.TABLE_MEMBER, DBHelperPuntuacion.PUNTUACION_ID + "="
                + califID, null);
    }
}
