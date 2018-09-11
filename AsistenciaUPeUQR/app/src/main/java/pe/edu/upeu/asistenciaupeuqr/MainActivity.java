package pe.edu.upeu.asistenciaupeuqr;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import pe.edu.upeu.dao.PlantMesajeDAO;

public class MainActivity extends AppCompatActivity {
    PlantMesajeDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao=new PlantMesajeDAO(this);
        Cursor curx=null;
        curx=dao.listarPlantMensaje();
        if(curx!=null){
            Log.i("Resultado","Si creo la base de datos ...lista resgistro: "+curx.getCount());
        }else{
            Log.e("Error", "Error al crear la base de datos");
        }

    }
}
