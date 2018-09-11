package pe.edu.upeu.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBcon extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="asistencia.db";

    public DBcon(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE plantmensaje (idPlantmensaje INTEGER PRIMARY KEY  AUTOINCREMENT NOT NULL, tipomensaje TEXT NOT NULL, mensajeprevio TEXT NOT NULL );");
        db.execSQL("insert into plantmensaje values(1,'Anuncio','Debes Justificar tu inasistencia al evento deportivo');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists plantmensaje; ");
        onCreate(db);
        Log.v("Acion","Cambiar version de Base de datos !!");
    }
}
