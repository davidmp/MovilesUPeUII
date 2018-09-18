package pe.edu.upeu.dbcon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import pe.edu.upeu.dblibrary.ExternalSQLiteOpenHelper;

public class DBCon extends ExternalSQLiteOpenHelper{
    private static final String DATABASE_NAME="asistenciaupeu.db";
    private static final int DATABASE_VERSION=3;

    public DBCon(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
