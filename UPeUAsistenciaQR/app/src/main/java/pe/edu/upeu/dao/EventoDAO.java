package pe.edu.upeu.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import pe.edu.upeu.dbcon.DBCon;

public class EventoDAO extends DBCon {
    DBCon con;
    Context context;
    SQLiteDatabase db;
    Cursor cur;
    String sql;

    public EventoDAO(Context context){
        super(context);
        this.context=context;
    }

    public int eventoActivo() {
        con = new DBCon(context);
        db = con.getReadableDatabase();
        sql = "select * from evento where estado='1'";
        cur = db.rawQuery(sql, null);
        if (cur.moveToNext()) {
            return cur.getInt(0);
        }else{
            return 0;
        }
    }

}
