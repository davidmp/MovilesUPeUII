package pe.edu.upeu.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import pe.edu.upeu.db.ConexionDB;
import pe.edu.upeu.db.DBcon;

public class PlantMesajeDAO extends ConexionDB {

    Context ctx;
    ConexionDB con;
    SQLiteDatabase db;
    Cursor cur;
    String sql;


    public PlantMesajeDAO(Context context){
        super(context);
        this.ctx=context;
    }

    public Cursor listarPlantMensaje(){
        con=new ConexionDB(ctx);
        db=con.getReadableDatabase();
        sql=" select * from plantmensaje ";
        cur=db.rawQuery(sql,null);
        return cur;
    }

}
