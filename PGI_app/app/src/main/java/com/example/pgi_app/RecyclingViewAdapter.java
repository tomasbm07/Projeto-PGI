package com.example.pgi_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclingViewAdapter extends RecyclerView.Adapter<RecyclingViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Horta> horta;
    int type;

    public RecyclingViewAdapter(Context context, ArrayList<Horta> horta, int type){
        this.context = context;
        this.horta = horta;
        this.type = type;
    }
    @NonNull
    @Override
    public RecyclingViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //This is where you inflate the layout (Giving a look to your rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row,parent,false);

        return new RecyclingViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        //assigning values to the views created in the recycler_view_row layout file
        //based on the position of the recycler view
        holder.image.setImageResource(Horta.Hortas.get(position).getImage());
        holder.nomeHorta.setText(Horta.Hortas.get(position).getP().getNome());
        holder.dataCriacao.setText("Criado: " + Horta.Hortas.get(position).getData().toString().substring(0,16));

    }

    @Override
    public int getItemCount() {
        //how many items are going to be displayed
        if (type == 0){
            if(horta.size() < 4)
                return horta.size();
            else
                return 4;
        }
        else{
            return horta.size();

        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing the view from the recycler_view_row layout file
        ImageView image;
        TextView nomeHorta, dataCriacao;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            nomeHorta = itemView.findViewById(R.id.nome_horta);
            dataCriacao = itemView.findViewById(R.id.data_horta);

        }
    }
}
