package pe.edu.upeu.upeuasistenciaqr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import pe.edu.upeu.dao.PersonaDAO;
import pe.edu.upeu.modelo.PersonaTO;
import pe.edu.upeu.util.PersonaAdapter;


public class RegAsistenciaFragment extends Fragment {

    PersonaDAO dao;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;

    Button btnRegAsistencia;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myFragmenView=inflater.inflate(R.layout.fragment_regasistencia, container, false);
        btnRegAsistencia=myFragmenView.findViewById(R.id.button2);

        btnRegAsistencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context=v.getContext();
                Intent intent=new Intent();
                intent.putExtra("idUsuario", 1);
                intent.setClass(v.getContext(),SimpleScannerActivity.class);
                startActivity(intent);
            }
        });

        return myFragmenView;
    }
}
