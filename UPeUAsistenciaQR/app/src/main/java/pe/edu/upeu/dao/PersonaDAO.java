package pe.edu.upeu.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.dbcon.DBCon;
import pe.edu.upeu.modelo.PersonaTO;

public class PersonaDAO extends DBCon {

    DBCon con;
    Context context;
    SQLiteDatabase db;
    Cursor cur;
    String sql;

    public PersonaDAO(Context context) {
        super(context);
        this.context=context;
    }

    public List listarPersona(){
        con=new DBCon(context);
        db=con.getReadableDatabase();
        sql="select * from persona";
        cur=db.rawQuery(sql,null);
        ArrayList<PersonaTO> lista=new ArrayList<>();
        PersonaTO to;
        while (cur.moveToNext()){
            to=new PersonaTO();
            to.setNombres(cur.getString(1));
            to.setApellidos(cur.getString(2));
            to.setDnicodigo(cur.getString(3));
            to.setIdPersona(cur.getInt(0));
            to.setEmail(cur.getString(4));
            to.setNumerocelular(cur.getString(5));
            lista.add(to);
        }
        return lista;
    }
}
