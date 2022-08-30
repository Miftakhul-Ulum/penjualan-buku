package com.project101.aplikasibuku.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.project101.aplikasibuku.Interface.ChangeNumberItemListener;
import com.project101.aplikasibuku.R;
import com.project101.aplikasibuku.helper.ManagementCart;
import com.project101.aplikasibuku.model.ModelBukuPopuler;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {
    private ArrayList<ModelBukuPopuler> modelBukuPopulers;
    private ManagementCart managementCart;
    private ChangeNumberItemListener changeNumberItemListener;

    public CartAdapter(ArrayList<ModelBukuPopuler> modelBukuPopulers, ManagementCart managementCart, ChangeNumberItemListener changeNumberItemListener) {
        this.modelBukuPopulers = modelBukuPopulers;
        this.managementCart = managementCart;
        this.changeNumberItemListener = changeNumberItemListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.judulBukuCart.setText(modelBukuPopulers.get(position).getBuku());
        holder.eachItem.setText(String.valueOf(modelBukuPopulers.get(position).getHarga()));
        holder.totalEachItem.setText(String.valueOf(Math.round((modelBukuPopulers.get(position).getHarga()*modelBukuPopulers.get(position).getNumberInCart())*100)/100));
        holder.num.setText(String.valueOf(modelBukuPopulers.get(position).getNumberInCart()));

        int gambarId = holder.itemView.getContext().getResources().getIdentifier(modelBukuPopulers.get(position).getGambar(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(gambarId).into(holder.gambarBukuCart);

        holder.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.plusNumberBuku(modelBukuPopulers, position, new ChangeNumberItemListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemListener.changed();
                    }
                });
            }
        });
        holder.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.minusNumberBuku(modelBukuPopulers, position, new ChangeNumberItemListener() {
                    @Override
                    public void changed() {
                        notifyDataSetChanged();
                        changeNumberItemListener.changed();
                    }
                });
            }
        });




    }

    @Override
    public int getItemCount() {
        return modelBukuPopulers.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView judulBukuCart, eachItem;
        ImageView gambarBukuCart, btnPlus, btnMinus;
        TextView totalEachItem, num;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            judulBukuCart = itemView.findViewById(R.id.judulBukuCart);
            eachItem = itemView.findViewById(R.id.feeEachItem);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            num = itemView.findViewById(R.id.num);
            gambarBukuCart = itemView.findViewById(R.id.gambarBukuCart);
            btnMinus = itemView.findViewById(R.id.minusCart);
            btnPlus = itemView.findViewById(R.id.plusCart);
        }
    }
}
