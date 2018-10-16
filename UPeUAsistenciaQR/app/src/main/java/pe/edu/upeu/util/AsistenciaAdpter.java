package pe.edu.upeu.util;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import pe.edu.upeu.upeuasistenciaqr.R;

import pe.edu.upeu.modelo.AsistenciaTO;

public class AsistenciaAdpter extends RecyclerView.Adapter<AsistenciaAdpter.AsistenciaViewHolder>{

    private List<AsistenciaTO> asistencia;

    public AsistenciaAdpter(List<AsistenciaTO> asistencia){
        this.asistencia=asistencia;

        Log.e("DMP","Verrrrrrrrrrrrrrrrrrrrrr : "+this.asistencia.size());
    }

    @NonNull
    @Override
    public AsistenciaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.asistencia_lista,parent,false);
        AsistenciaViewHolder viewHolder=new AsistenciaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull AsistenciaViewHolder holder, int position) {
        AsistenciaTO asistenciaX=asistencia.get(position);
        /*if(position/2==1){
            holder.rowLayoutId2.setBackgroundColor(Color.parseColor("#bfbdbd"));
        }else {
            holder.rowLayoutId2.setBackgroundColor(Color.TRANSPARENT);
        }*/
        holder.setAsistencia(asistenciaX);
    }

   public List<AsistenciaTO> getAsistencia() {
        return asistencia;
    }

    @Override
    public int getItemCount() {
        return asistencia.size();
    }





    public class AsistenciaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNombre,txtCodigo,txtCompanhia;
        private AsistenciaTO asistencia;
        LinearLayout rowLayoutId2;


        public AsistenciaViewHolder(View itemView){
            super(itemView);
            this.txtNombre=(TextView)itemView.findViewById(R.id.txtNombre);
            this.txtCodigo=(TextView)itemView.findViewById(R.id.txtCodigo);
            this.txtCompanhia=(TextView)itemView.findViewById(R.id.txtCompanhia);
            this.rowLayoutId2=(LinearLayout)itemView.findViewById(R.id.rowLayoutId2);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context=v.getContext();
                    Toast.makeText(context,asistencia.getCodigo(),Toast.LENGTH_SHORT).show();
                }
            });
        }

        public void setAsistencia(AsistenciaTO asistencia){
            this.asistencia=asistencia;
            this.txtNombre.setText(asistencia.getNombres());
            this.txtCodigo.setText(asistencia.getCodigo());
            this.txtCompanhia.setText(asistencia.getCompanhia());
        }
    }

}
