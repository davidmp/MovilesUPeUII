package pe.edu.upeu.upeuasistenciaqr;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import pe.edu.upeu.dao.PersonaDAO;
import pe.edu.upeu.modelo.PersonaTO;
import pe.edu.upeu.util.PersonaAdapter;


public class ReporteFragment extends Fragment {

    PersonaDAO dao;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myFragmenView=inflater.inflate(R.layout.fragment_reporte, container, false);
        this.recyclerView=(RecyclerView)myFragmenView.findViewById(R.id.recyclerView);
        this.layoutManager=new LinearLayoutManager(this.getContext());
        dao=new PersonaDAO(this.getContext());
        List<PersonaTO> persona=dao.listarPersona();
        this.adapter=new PersonaAdapter(persona);
        this.recyclerView.setLayoutManager(layoutManager);

        this.recyclerView.setAdapter(adapter);
        return myFragmenView;
    }
}
