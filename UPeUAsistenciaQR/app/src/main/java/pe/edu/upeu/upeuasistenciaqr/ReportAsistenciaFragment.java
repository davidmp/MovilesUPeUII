package pe.edu.upeu.upeuasistenciaqr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import pe.edu.upeu.dao.AsistenciaDAO;
import pe.edu.upeu.dao.PersonaDAO;
import pe.edu.upeu.modelo.AsistenciaTO;
import pe.edu.upeu.util.PersonaAdapter;


public class ReportAsistenciaFragment extends Fragment {

    AsistenciaDAO dao;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;

    TextView txtReporte;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myFragmenView=inflater.inflate(R.layout.fragment_reportasistencia, container, false);
        txtReporte=myFragmenView.findViewById(R.id.textView4);
        dao=new AsistenciaDAO(container.getContext());
        List<AsistenciaTO> lista=dao.listarAsistencia();
        txtReporte.setText("Cantidad: "+lista.size());
        return myFragmenView;
    }
}
