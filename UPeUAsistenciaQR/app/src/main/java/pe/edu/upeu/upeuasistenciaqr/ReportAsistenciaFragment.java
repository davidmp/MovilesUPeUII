package pe.edu.upeu.upeuasistenciaqr;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pe.edu.upeu.dao.AsistenciaDAO;
import pe.edu.upeu.dao.PersonaDAO;
import pe.edu.upeu.modelo.AsistenciaTO;
import pe.edu.upeu.servis.AsisteciaServices;
import pe.edu.upeu.util.AsistenciaAdpter;
import pe.edu.upeu.util.PersonaAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ReportAsistenciaFragment extends Fragment {

    //AsistenciaDAO dao;
    String urlBase="http://172.22.90.54:7171/";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter<AsistenciaAdpter.AsistenciaViewHolder> adapter;
    private RecyclerView.LayoutManager layoutManager;


    public final String TAG=this.getClass().getSimpleName();
    Retrofit retrofit;
    AsisteciaServices asisteciaServices;
    List<AsistenciaTO> asistencia;

    //TextView txtReporte;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myFragmenView=inflater.inflate(R.layout.fragment_reportasistencia, container, false);
        this.recyclerView=(RecyclerView) myFragmenView.findViewById(R.id.recyclerViewA);
        this.layoutManager=new LinearLayoutManager(this.getContext());

        //Rest Retrofit
        retrofit=new Retrofit.Builder().baseUrl(urlBase)
                .addConverterFactory(GsonConverterFactory.create()).build();
        asisteciaServices=retrofit.create(AsisteciaServices.class);
        Call<List<AsistenciaTO>> listarAsistencia=asisteciaServices.listarAsistencia();
        listarAsistencia.enqueue(new Callback<List<AsistenciaTO>>() {
            @Override
            public void onResponse(Call<List<AsistenciaTO>> call, Response<List<AsistenciaTO>> response) {
                asistencia=response.body();
                Log.i(TAG,"DMP reportado: "+response.body().size());
                Toast.makeText(getContext(),"Cantidad de Reg. Asistencia :"+response.body().get(0).getIdEvento().toString(),Toast.LENGTH_SHORT).show();

                adapter=new AsistenciaAdpter(asistencia);
                recyclerView.setLayoutManager(layoutManager);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<AsistenciaTO>> call, Throwable t) {
                Log.e(TAG,"Error al recuperar el servicio REST de Asistencia: "+t.getMessage());
            }
        });



        /*this.adapter=new AsistenciaAdpter(asistencia);
        this.recyclerView.setLayoutManager(layoutManager);
        this.recyclerView.setAdapter(adapter);*/

        return myFragmenView;
    }
}
