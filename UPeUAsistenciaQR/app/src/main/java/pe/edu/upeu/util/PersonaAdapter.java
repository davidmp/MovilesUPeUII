package pe.edu.upeu.util;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import pe.edu.upeu.modelo.PersonaTO;
import pe.edu.upeu.upeuasistenciaqr.R;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder>{
    private List<PersonaTO> persona;

    public PersonaAdapter(List<PersonaTO> persona){
        this.persona=persona;
    }

    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        View view= LayoutInflater.from(context).inflate(R.layout.persona_lista,parent,false);
        PersonaViewHolder viewHolder=new PersonaViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        PersonaTO personaX=persona.get(position);
        if(position/2==1){
            holder.rowLayoutId.setBackgroundColor(Color.parseColor("#bfbdbd"));
        }else {
            holder.rowLayoutId.setBackgroundColor(Color.TRANSPARENT);
        }
        holder.setPersona(personaX);
    }

    public List<PersonaTO> getPersona() {
        return persona;
    }

    @Override
    public int getItemCount() {
        return persona.size();
    }





    public class PersonaViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNombres,txtCorreo,txtCelular;
        private PersonaTO persona;
        LinearLayout rowLayoutId;


       public PersonaViewHolder(View itemView){
           super(itemView);
           this.txtNombres=(TextView)itemView.findViewById(R.id.txtNombres);
           this.txtCorreo=(TextView)itemView.findViewById(R.id.txtCorreo);
           this.txtCelular=(TextView)itemView.findViewById(R.id.txtCelular);
           this.rowLayoutId=(LinearLayout)itemView.findViewById(R.id.rowLayoutId);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Context context=v.getContext();
                   Toast.makeText(context,persona.getDnicodigo(),Toast.LENGTH_SHORT).show();
               }
           });
       }

       public void setPersona(PersonaTO persona){
           this.persona=persona;
           this.txtNombres.setText(persona.getNombres()+" "+persona.getApellidos());
           this.txtCorreo.setText(persona.getEmail());
           this.txtCelular.setText(persona.getNumerocelular());
       }
   }

}
