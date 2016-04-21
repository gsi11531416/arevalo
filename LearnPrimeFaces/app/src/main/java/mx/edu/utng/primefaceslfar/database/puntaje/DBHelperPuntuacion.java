package mx.edu.utng.primefaceslfar.database.puntaje;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Luis Arevalo on 05/04/2016.
 */
public class DBHelperPuntuacion extends SQLiteOpenHelper {
    // Información de la tabla
    public static final String TABLE_MEMBER = "puntuacion";//nombre de la tabla
    public static final String PUNTUACION_ID = "_id";//id puntuacion
    public static final String CALIFICACION = "calificacion";//atributo calificacion
    public static final String INTENTO = "intento";//atributo calificacion


    // información del a base de datos
    static final String DB_NAME = "DB_PUNTUACION";//nombre de base de dats
    static final int DB_VERSION = 1;//version base de datos

    // Información de la base de datos
    /**
     *
     */
    private static final String CREATE_TABLE = "create table "
            + TABLE_MEMBER + "(" + PUNTUACION_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CALIFICACION + " TEXT NOT NULL, " +INTENTO+ " TEXT NOT NULL);";//cadena para crear tabla
    private static final String INSERTAR1 =  "INSERT INTO " + TABLE_MEMBER+ " VALUES('1','0','0')";
    private static final String INSERTAR2 =  "INSERT INTO " + TABLE_MEMBER+ " VALUES('2','0','0')";
    private static final String INSERTAR3 =  "INSERT INTO " + TABLE_MEMBER+ " VALUES('3','0','0')";
    private static final String INSERTAR4 =  "INSERT INTO " + TABLE_MEMBER+ " VALUES('4','0','0')";
    private static final String INSERTAR5 =  "INSERT INTO " + TABLE_MEMBER+ " VALUES('5','0','0')";
    private static final String INSERTAR6 =  "INSERT INTO " + TABLE_MEMBER+ " VALUES('6','0','0')";
    private static final String INSERTAR7 =  "INSERT INTO " + TABLE_MEMBER+ " VALUES('7','0','0')";



    /**
     *
     * @param context
     *
     */
    public DBHelperPuntuacion(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    /**
     *
     * @param db
     * metodo lanzado al crear o iniciar el proceso relacionado con la base de datos para crear
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(INSERTAR1);
        db.execSQL(INSERTAR2);
        db.execSQL(INSERTAR3);
        db.execSQL(INSERTAR4);
        db.execSQL(INSERTAR5);
        db.execSQL(INSERTAR6);
        db.execSQL(INSERTAR7);
    }

    /**
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     * metodo lanzado al crear o iniciar el proceso relacionado con la base de datos para actualizar
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEMBER);
        onCreate(db);
    }
}
