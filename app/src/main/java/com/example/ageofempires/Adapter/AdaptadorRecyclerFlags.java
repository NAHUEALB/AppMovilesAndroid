package com.example.ageofempires.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ageofempires.R;
import com.example.ageofempires.entitys.Civilization;

import java.util.ArrayList;

public class AdaptadorRecyclerFlags extends RecyclerView.Adapter<AdaptadorRecyclerFlags.ViewHolderDatos>  implements View.OnClickListener {
    ArrayList<Civilization> listCivilization;
    private View.OnClickListener listener;

    public AdaptadorRecyclerFlags(ArrayList<Civilization> listCivilization) {
        this.listCivilization = listCivilization;
    }

    @NonNull
    @Override
    //Es la clase que cree para manejar los datos e imprimirlos en la vista
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flags_list, null, false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    //Establece la coneccion entre el ViewHolderDatos y el adaptador
    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.name.setText(listCivilization.get(position).getName_Civi());
        holder.img.setImageResource(listCivilization.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return listCivilization.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        //Que el listener que generamos sea igual al listener que se genera al dar click
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener != null){
            listener.onClick(v);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView name;
        ImageView img;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            //Aca referencio a los items del item_list para luego cargarlos
            name = itemView.findViewById(R.id.nombreCivi);
            img = itemView.findViewById(R.id.imgg_Civi);


        }

    }
}
