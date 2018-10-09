package pe.edu.upeu.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.dbcon.DBCon;
import pe.edu.upeu.modelo.AsistenciaTO;


public class AsistenciaDAO extends DBCon {
    DBCon con;
    Context context;
    SQLiteDatabase db;
    Cursor cur;
    String sql;

    public AsistenciaDAO(Context context){
        super(context);
        this.context=context;
    }

    public List listarAsistencia(){
        con=new DBCon(context);
        db=con.getReadableDatabase();
        sql="select * from asistencia";
        cur=db.rawQuery(sql,null);
        ArrayList<AsistenciaTO> lista=new ArrayList<>();
        AsistenciaTO to;
        while (cur.moveToNext()){
            to=new AsistenciaTO();
            to.setNombres(cur.getString(5));
            lista.add(to);
        }
        return lista;
    }

    public void registrarAsistencia(AsistenciaTO to){
        con=new DBCon(context);
        db=con.getWritableDatabase();
        db.execSQL("insert into asistencia(idPersona, idUsuario, idEvento, codigo, nombres, companhia, fechahora, ofline) " +
                " values ("+to.getIdPersona()+","+to.getIdUsuario()+","+to.getIdEvento()+", '"+to.getCodigo()+"' " +
                " , '"+to.getNombres()+"', '"+to.getCompanhia()+"',datetime('now'),'0');");
    }

}
