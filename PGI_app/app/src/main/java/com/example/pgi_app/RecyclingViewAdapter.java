package com.example.pgi_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclingViewAdapter extends RecyclerView.Adapter<RecyclingViewAdapter.MyViewHolder> {
    Context context;
    ArrayList<Horta> horta;
    int type, toast;
    private OnTouchListener mOnTouchListener;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Horta> getHorta() {
        return horta;
    }

    public void setHorta(ArrayList<Horta> horta) {
        this.horta = horta;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public OnTouchListener getmOnTouchListener() {
        return mOnTouchListener;
    }

    public void setmOnTouchListener(OnTouchListener mOnTouchListener) {
        this.mOnTouchListener = mOnTouchListener;
    }

    public RecyclingViewAdapter(Context context, ArrayList<Horta> horta, int type, OnTouchListener onTouchListener){
        this.context = context;
        this.horta = horta;
        this.type = type;
        this.mOnTouchListener = onTouchListener;
    }
    @NonNull
    @Override
    public RecyclingViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //This is where you inflate the layout (Giving a look to your rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row,parent,false);

        return new RecyclingViewAdapter.MyViewHolder(view, mOnTouchListener);
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
        if (type == 0){             //recycling view in MainActivity
            if(horta.size() == 0){
                if(toast != 1){
                    Toast.makeText(context, "Sem hortas cridas", Toast.LENGTH_SHORT).show();
                    toast = 1;
                }
                return 0;
            }
            if(horta.size() < 5)
                return horta.size();
            else
                return 5;
        }
        else{
            return horta.size();

        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //grabbing the view from the recycler_view_row layout file
        ImageView image;
        TextView nomeHorta, dataCriacao;
        OnTouchListener onTouchListener;

        public MyViewHolder(@NonNull View itemView, OnTouchListener onTouchListener) {
            super(itemView);
            image = itemView.findViewById(R.id.imageView);
            nomeHorta = itemView.findViewById(R.id.nome_horta);
            dataCriacao = itemView.findViewById(R.id.data_horta);
            this.onTouchListener = onTouchListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onTouchListener.onTouch(getAdapterPosition());
        }
    }
    public interface OnTouchListener{
        void onTouch(int position);
    }
}
