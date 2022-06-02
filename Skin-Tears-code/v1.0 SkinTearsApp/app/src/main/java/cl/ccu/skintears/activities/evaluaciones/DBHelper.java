package cl.ccu.skintears.activities.evaluaciones;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import cl.ccu.skintears.R;

import java.util.Scanner;


public class DBHelper extends SQLiteOpenHelper {
    public static final String NOM_DB = "Preguntas2019v1000"; // Si agrega preguntas en la BD cambie este nombre
    public static final int DB_VERSION = 1;

    protected SQLiteDatabase DBLite;
    protected Context contexto;

    public DBHelper(Context contexto) {
        super(contexto, NOM_DB, null, DB_VERSION);
        this.contexto = contexto;
        this.open();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("debug", "onCreate, creando base de datos...");

        StringBuilder strBuilder = new StringBuilder();
        Scanner scn = new Scanner(this.contexto.getResources().openRawResource(R.raw.database));

        while (scn.hasNextLine()) {
            strBuilder.append(scn.nextLine());
            strBuilder.append("\n");

            if (strBuilder.indexOf(";") != -1) {
                sqLiteDatabase.execSQL(strBuilder.toString());
                strBuilder.delete(0, strBuilder.capacity());
            }
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int version, int nueva) {
        Log.d("debug", "onUpgrade, método no implementado");
        //sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + NOM_DB);
        //onCreate(sqLiteDatabase);
    }

    public void open() {
        Log.d("debug", "OPEN, abriendo base de datos...");
        this.DBLite = this.getWritableDatabase();
    }

    public void close() {
        Log.d("debug", "CLOSE, cerrando base de datos...");
        this.DBLite.close();
    }
}