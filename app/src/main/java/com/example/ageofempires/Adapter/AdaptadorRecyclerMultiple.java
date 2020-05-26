package com.example.ageofempires.Adapter;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ageofempires.R;
import com.example.ageofempires.entitys.Civilization;

import java.util.ArrayList;

public class AdaptadorRecyclerMultiple extends RecyclerView.Adapter<AdaptadorRecyclerMultiple.ViewHolderDatos> {
    ArrayList<Civilization> listCivilization;
    String rta;

    public AdaptadorRecyclerMultiple(ArrayList<Civilization> listCivilization, String rta) {
        this.listCivilization = listCivilization;
        this.rta = rta;
    }

    @NonNull
    @Override
    //Es la clase que cree para manejar los datos e imprimirlos en la vista
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null,false);
        return new ViewHolderDatos(view);
    }

    //Establece la coneccion entre el ViewHolderDatos y el adaptador
    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {


//        if (listCivilization.get(position).getEspecialidad() == "%Infanteria%")
        if (rta == null) {
            holder.name.setText(listCivilization.get(position).getName_Civi());
            holder.arqui.setText(listCivilization.get(position).getArquitectura());
            holder.espec.setText(listCivilization.get(position).getEspecialidad());
            holder.unidad.setText(listCivilization.get(position).getUnidad_Unica());
            holder.tec.setText(listCivilization.get(position).getTecnologias());
            holder.maravilla.setText(listCivilization.get(position).getMaravilla());
            holder.bonus.setText(listCivilization.get(position).getBonus());
            holder.bonusT.setText(listCivilization.get(position).getBonus_team());
            holder.img.setImageResource(listCivilization.get(position).getImg());
        }
    }

    @Override
    public int getItemCount() {
        return listCivilization.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView name,arqui,espec,unidad,tec,maravilla,bonus,bonusT;
        ImageView img;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            //Aca referencio a los items del item_list para luego cargarlos
            name = itemView.findViewById(R.id.nameCivilization);
            arqui = itemView.findViewById(R.id.arquiCivilization);
            espec = itemView.findViewById(R.id.especCivilization);
            unidad = itemView.findViewById(R.id.unidadCivilization);
            tec = itemView.findViewById(R.id.tecCivilization);
            maravilla = itemView.findViewById(R.id.maravillaCivilization);
            bonus = itemView.findViewById(R.id.bonusCivilization);
            bonusT = itemView.findViewById(R.id.bonusTCivilization);
            img = itemView.findViewById(R.id.img_Civi);


        }

    }
}
