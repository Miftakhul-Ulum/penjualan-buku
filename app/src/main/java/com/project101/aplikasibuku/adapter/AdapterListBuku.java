package com.project101.aplikasibuku.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project101.aplikasibuku.R;
import com.project101.aplikasibuku.model.ModelListBuku;

import java.util.ArrayList;

public class AdapterListBuku extends RecyclerView.Adapter<AdapterListBuku.ViewHolder>{
   ArrayList<ModelListBuku> bukuArrayList;

    public AdapterListBuku(ArrayList<ModelListBuku> bukuArrayList) {
        this.bukuArrayList = bukuArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_listbuku, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.judulBuku.setText(bukuArrayList.get(position).getJudulBuku());
        String gambarBuku = "";
        switch (position){
            case 0:{
                gambarBuku = "book_1";
                holder.layoutListBuku.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.bg_blue1));
                break;
            }
            case 1:{
                gambarBuku = "book_2";
                holder.layoutListBuku.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.bg_blue2));
                break;
            }
            case 2:{
                gambarBuku = "book_3";
                holder.layoutListBuku.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.bg_blue3));
                break;
            }
            case 3:{
                gambarBuku = "book_4";
                holder.layoutListBuku.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.bg_blue4));
                break;
            }
            case 4:{
                gambarBuku = "book_5";
                holder.layoutListBuku.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(),R.drawable.bg_blue5));
                break;
            }
        }
        int gambarBukuId = holder.itemView.getContext().getResources().getIdentifier(gambarBuku, "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(gambarBukuId).into(holder.gambarBuku);
    }

    @Override
    public int getItemCount() {
        return bukuArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gambarBuku;
        TextView judulBuku;
        ConstraintLayout layoutListBuku;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gambarBuku = itemView.findViewById(R.id.imageListBuku);
            judulBuku = itemView.findViewById(R.id.textViewListBuku);
            layoutListBuku = itemView.findViewById(R.id.layoutListBuku);
        }
    }
}
