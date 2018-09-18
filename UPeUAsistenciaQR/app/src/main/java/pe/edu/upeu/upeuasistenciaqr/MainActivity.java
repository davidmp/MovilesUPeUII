package pe.edu.upeu.upeuasistenciaqr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import pe.edu.upeu.dao.PersonaDAO;

public class MainActivity extends AppCompatActivity {

    PersonaDAO dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dao=new PersonaDAO(this);
        List lista=dao.listarPersona();
        Log.i("RESULTADO:", " "+lista.size() );
    }
}
