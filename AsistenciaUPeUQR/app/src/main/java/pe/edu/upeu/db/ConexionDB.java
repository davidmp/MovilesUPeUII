package pe.edu.upeu.db;

import android.content.Context;

import pe.edu.upeu.dblibrary.ExternalSQLiteOpenHelper;

public class ConexionDB extends ExternalSQLiteOpenHelper {

    private static final String DATABASE_NAME="asistenciaupeu.db";
    private static final int DATABASE_VERSION=3;


    public ConexionDB(Context context){
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }
}
