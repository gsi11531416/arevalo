package mx.edu.utng.primefaceslfar.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luis Arevalo on 29/03/2016.
 */
public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "db_quiz";
    // tasks table name
    private static final String TABLE_QUEST = "quiz";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTA= "opta"; //option a
    private static final String KEY_OPTB= "optb"; //option b
    private static final String KEY_OPTC= "optc"; //option c

    public static SQLiteDatabase hola = null;
    public static int holaadios = 0;

    private SQLiteDatabase dbase;
    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTA +" TEXT, "
                +KEY_OPTB +" TEXT, "+KEY_OPTC+" TEXT)";
        db.execSQL(sql);



        addQuestions();

        //db.close();
    }

    private void addQuestions() {
        //Quiz 1: Web Components
        Question q1 = new Question("Es una librería de componentes para JavaServer Faces (JSF) de código abierto que cuenta con un conjunto de componentes enriquecidos que facilitan la creación de las aplicaciones web.",
                "PrimeUI",
                "FacesPrime",
                "PrimeFaces",
                "PrimeFaces");
        this.addQuestion(q1);

        Question q2 = new Question("Es un conjunto de cuatro especificaciones para crear componentes de interfaz de usuario reutilizables. Estas diferentes tecnologías son elementos personalizados, Sombra DOM, HTML Las importaciones y plantillas .",
                "Web Components",
                "Auxiliar Web",
                "Prime Faces",
                "Web Components");
        this.addQuestion(q2);

        Question q3 = new Question("Como PrimeElements son también elementos regulares DOM, que se pueden inicializar con document.____________ donde se puede después adjuntarlo a otro elemento.",
                "insertItem()",
                "createElement()",
                "create()",
                "createElement()");
        this.addQuestion(q3);

        Question q4 = new Question("PrimeElements es __________________________, características tales como el enlace de datos, validación, enrutamiento están fuera del ámbito de aplicación ya que pueden ser proporcionados por el marco de la elección.",
                "una biblioteca no es un marco",
                "un marco no es una biblioteca",
                "un editor HTML",
                "una biblioteca no es un marco");
        this.addQuestion(q4);

        Question q5 = new Question("Reduce drásticamente la cantidad de trabajo necesario para crear una apariencia agradable y funcionales de interfaces de usuario proporcionando un kit de desarrollo rápido de aplicaciones basadas en tecnologías de componentes web estándar. esfuerzo de mantenimiento también se beneficia de esto ya que hay menos cantidad de la escritura en cuestión.",
                "PrimeFaces",
                "PrimeUI",
                "PrimeElements",
                "PrimeElements");
        this.addQuestion(q5);

        //Quiz 2: Input

    Question q6 = new Question("Es un componente de entrada para proporcionar una entrada numérica por medio de botones de incremento y decremento.",
            "Spinner",
            "InputText",
            "RadioButton",
            "Spinner");
        this.addQuestion(q6);

        Question q7 = new Question("Es un widget de entrada de proporcionar sugerencias en tiempo real cuando está tecleando .",
                "Complete",
                "AutoComplete",
                "AutoSave",
                "AutoComplete");
        this.addQuestion(q7);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Question> getAllQuestions() {
        SQLiteDatabase sql = null;
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));

                quesList.add(quest);
                holaadios = quesList.size();
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }
    public int rowcount()
    {
        int row=0;

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row=cursor.getCount();
        return row;
    }
}
