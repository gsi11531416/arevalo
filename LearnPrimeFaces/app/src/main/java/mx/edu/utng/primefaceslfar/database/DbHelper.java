package mx.edu.utng.primefaceslfar.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import mx.edu.utng.primefaceslfar.database.puntaje.SQLControlador;

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
    private static final String KEY_OPTA = "opta"; //option a
    private static final String KEY_OPTB = "optb"; //option b
    private static final String KEY_OPTC = "optc"; //option c

    public static SQLiteDatabase hola = null;
    public static int holaadios = 0;

    private SQLiteDatabase dbase;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sql);


        addQuestions();

        //db.close();
    }

    SQLControlador dbconection;

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

        Question q8 = new Question("Es una extensión de inputText estándar con capacidades de desoliar.",
                "InputText",
                "TextInput",
                "TextView",
                "InputText");
        this.addQuestion(q8);

        Question q9 = new Question("Es un widget de avanzada para seleccionar un elemento de una colección",
                "WidgetDrown",
                "InputDown",
                "Dropdown",
                "Dropdown");
        this.addQuestion(q9);

        Question q10 = new Question("¿Cuáles son los métodos que se utilizan en inputText de Primefaces?",
                "Habitar, Deshabitar",
                "Habilitar, Deshabitar y Opciones",
                "Ninguna de las Anteriores",
                "Habilitar, Deshabitar y Opciones");
        this.addQuestion(q10);

        //Quiz 3 Button
        Question q11 = new Question("¿Cúal es el atributo para ejecutar o crear un boton en primefaces?",
                "button",
                "f-button",
                "p-button",
                "p-button");
        this.addQuestion(q11);

        Question q12 = new Question("Ofrece un estilo mas en elementos de boton nativos...",
                "View",
                "Button",
                "ButtonPrime",
                "Button");
        this.addQuestion(q12);

        Question q13 = new Question("Es un conjunto de comandos en una superposición con un comando predeterminado.",
                "SplitButton",
                "Button",
                "SpliBoton",
                "SplitButton");
        this.addQuestion(q13);

        Question q14 = new Question("Atributos que se utilizan en los botones de primeFaces (VIdeo)",
                "on, off, default",
                "outcome, value y title",
                "title, background y disable-enable",
                "outcome, value y title");
        this.addQuestion(q14);

        Question q15 = new Question("Atributo que tiene primefaces en botones para dar una descripcion preliminar al poner el cursor sobre el boton.",
                "ACCESSKEY",
                "ALT",
                "INFO",
                "ALT");
        this.addQuestion(q15);

        //Quiz 4: Data
        Question q16 = new Question("Muestra el contenido con un efecto deslizante feauturing modo de respuesta, el apoyo golpe para los dispositivos habilitados para tocar y diversas opciones de personalización.",
                "Carousel",
                "Swipe",
                "Mode",
                "Carousel");
        this.addQuestion(q16);

        Question q17 = new Question("El contenido del carrusel se puede definir mediante programación o de forma declarativa. Por forma __________________, definen los datos siguiendo la opción de fuente de datos, donde el valor puede ser una matriz de Javascript o una función que devuelve datos por lo general mediante la conexión a una fuente remota.",
                "Declarativa",
                "Programática",
                "Ambas",
                "Programática");
        this.addQuestion(q17);

        Question q18 = new Question("DataTable tiene ___ modos de inicialización; local, remoto con ganas y perezoso remoto. Tipo de datos debe ser un conjunto de objetos JSON para todos los casos.",
                "1",
                "2",
                "3",
                "3");
        this.addQuestion(q18);

        Question q19 = new Question("Los datos se representa como una variable local",
                "modo local",
                "modo ansiosos remoto",
                "modo de fuente de datos perezoso",
                "modo local");
        this.addQuestion(q19);

        Question q20 = new Question("Fuente de datos es una función para recuperar los datos una sola vez desde el servidor",
                "modo local",
                "modo ansiosos remoto",
                "modo de fuente de datos perezoso",
                "modo ansiosos remoto");
        this.addQuestion(q20);

        //Quiz 5: Panel
        Question q21 = new Question("Es una colección de contenidos en las fichas. De marcado requiere es un conjunto de cabeceras y contenidos correspondientes",
                "Panel",
                "Accordion groups",
                "TabView",
                "Accordion groups");
        this.addQuestion(q21);

        Question q22 = new Question("Es una (1,4 kb) utilidad de diseño de peso ligero de respuesta optimizada para dispositivos móviles, tablets y ordenadores de sobremesa.",
                "FieldSet",
                "Grid CSS ",
                "Notify",
                "Grid CSS");
        this.addQuestion(q22);

        Question q23 = new Question("Es una barra de notificación que se puede colocar en la parte superior o inferior de la pantalla.",
                "FieldSet",
                "Grid CSS ",
                "Notify",
                "Notufy");
        this.addQuestion(q23);

        Question q24 = new Question("Es un componente del panel con pestañas con las pestañas del lado del cliente, carga de contenidos dinámicos con Ajax y efectos de transición de contenido.",
                "Panel",
                "Accordion groups",
                "TabView",
                "TabView");
        this.addQuestion(q24);

        Question q25 = new Question("Es un componente de la agrupación de palanca proporciona contenido y características cercanas.",
                "Panel",
                "Grid CSS",
                "Accordion groups",
                "Panel");
        this.addQuestion(q25);

        //Quiz 6: OverLay

        Question q26 = new Question("Es un componente situado con relación a su objetivo de contenedores.",
                "OverlayPanel",
                "PanelOverlay",
                "Overlay",
                "OverlayPanel");
        this.addQuestion(q26);

        Question q27 = new Question("Es un widget de panel recubierto con la modalidad, minimizar, maximizar y animaciones.",
                "LighBox",
                "OverLay",
                "Dialog",
                "Dialog");
        this.addQuestion(q27);

        Question q28 = new Question("Es una herramienta que va más allá de la información de herramientas del navegador proporcionado por feauturing básicos tematización diferentes, efectos, eventos y soporte de contenido personalizado.",
                "Boton",
                "Tooltip",
                "Widget",
                "Tooltip");
        this.addQuestion(q28);

        Question q29 = new Question("Es un componente de superposición modal para mostrar imágenes, vídeos, contenido en línea html y iframes.",
                "LightBox",
                "iframe",
                "Box",
                "LightBox");
        this.addQuestion(q29);

        Question q30 = new Question("Selecciona las tres opciones que tiene el componente LoghtBox",
                "frame, frameWidht y frameHeight",
                "iframe, iframeWidht y iframeHeight",
                "eframe, eframeWidht y eframeHeight",
                "iframe, iframeWidht y iframeHeight");
        this.addQuestion(q30);

        //Quiz 7: Menu
        Question q31 = new Question("Es un componente de navegación / comando altamente personalizable que soporta posicionamiento dinámico y estático.",
                "Multi-menu",
                "Menu",
                "ItemMenu",
                "Menu");
        this.addQuestion(q31);

        Question q32 = new Question("Selecciono los metodos que incorpora el MENU",
                "show, hide,align",
                "show, hide",
                "ver, ocultar",
                "show, hide,align");
        this.addQuestion(q32);

        Question q33 = new Question("Es un menu de componentes horizontales con sopoete para los submenús anidados",
                "Bar",
                "MenuHorizontal",
                "MenuBar",
                "MenuBar");
        this.addQuestion(q33);

        Question q34 = new Question("Es un híbrido de componentes de acordeón de árboles.",
                "PanelMenu",
                "MenuPanel",
                "Panel",
                "PanelMenu");
        this.addQuestion(q34);

        Question q35 = new Question("Muestra submenús de elementos raiz juntos",
                "BarMenu",
                "MegaMenu",
                "MenuBasic",
                "MegaMenu");
        this.addQuestion(q35);


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
        dbase = this.getReadableDatabase();
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

    public int rowcount() {
        int row = 0;

        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();
        return row;
    }


}
