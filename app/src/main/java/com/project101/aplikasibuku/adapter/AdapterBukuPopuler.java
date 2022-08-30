package com.project101.aplikasibuku.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project101.aplikasibuku.R;
import com.project101.aplikasibuku.activity.DetailBukuActivity;
import com.project101.aplikasibuku.model.ModelBukuPopuler;

import java.util.ArrayList;

public class AdapterBukuPopuler extends RecyclerView.Adapter<AdapterBukuPopuler.MyViewHolder> {
    ArrayList<ModelBukuPopuler> modelBukuPopulers;

    public AdapterBukuPopuler(ArrayList<ModelBukuPopuler> modelBukuPopulers) {
        this.modelBukuPopulers = modelBukuPopulers;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v =   LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_bukupopuler, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.judulBuku.setText(modelBukuPopulers.get(position).getBuku());
    holder.hargaBuku.setText(String.valueOf(modelBukuPopulers.get(position).getHarga()));
    int gambarId = holder.itemView.getContext().getResources().getIdentifier(modelBukuPopulers.get(position).getGambar(), "drawable",holder.itemView.getContext().getPackageName() );
        Glide.with(holder.itemView.getContext()).load(gambarId).into(holder.gambarBuku);

        holder.tambahBuku.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailBukuActivity.class);
                intent.putExtra("object",modelBukuPopulers.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return modelBukuPopulers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView judulBuku, hargaBuku;
        ImageView gambarBuku;
        TextView tambahBuku;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            judulBuku = itemView.findViewById(R.id.judul_buku);
            hargaBuku = itemView.findViewById(R.id.harga_buku);
            gambarBuku = itemView.findViewById(R.id.gambar_buku);
            tambahBuku = itemView.findViewById(R.id.tambahkan_buku);
        }
    }
}
