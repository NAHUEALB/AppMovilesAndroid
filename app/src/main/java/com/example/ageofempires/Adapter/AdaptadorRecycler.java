package com.example.ageofempires.Adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ageofempires.R;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.ViewHolderDatos> {
    public AdaptadorRecycler(ArrayList<String> listDatos) {
        this.listDatos = listDatos;
    }

    ArrayList<String> listDatos;



    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null,false);
        return new ViewHolderDatos(view);
    }

    //Establece la coneccion entre el ViewHolderDatos y el adaptador
    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {
        holder.asignarDatos(listDatos.get(position));
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView item;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.itemTxt);
        }

        public void asignarDatos(String datos) {
            item.setText(datos);

        }
    }
}
