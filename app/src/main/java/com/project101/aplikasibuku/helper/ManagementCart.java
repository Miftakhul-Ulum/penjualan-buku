package com.project101.aplikasibuku.helper;

import android.content.Context;
import android.widget.Toast;

import com.project101.aplikasibuku.Interface.ChangeNumberItemListener;
import com.project101.aplikasibuku.model.ModelBukuPopuler;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB = new TinyDB(context);
    }

    public void insertBuku(ModelBukuPopuler item){
        ArrayList<ModelBukuPopuler> listBuku = getListCart();
        Boolean existAlready = false;
        int n = 0;
        for(int i = 0; i<listBuku.size(); i++){
            if(listBuku.get(i).getBuku().equals(item.getBuku())){
                existAlready = true;
                n = i;
                break;
            }
        }
        if (existAlready){
            listBuku.get(n).setNumberInCart(item.getNumberInCart());
        } else {
            listBuku.add(item);
        }
        tinyDB.putListObject("CardList", listBuku);
        Toast.makeText(context,"Added To Your Card", Toast.LENGTH_SHORT).show();
    }


    public ArrayList<ModelBukuPopuler> getListCart(){
        return tinyDB.getListObject("CardList");
    }

    public void plusNumberBuku (ArrayList<ModelBukuPopuler> listBuku, int position, ChangeNumberItemListener changeNumberItemListener){
        listBuku.get(position).setNumberInCart(listBuku.get(position).getNumberInCart()+1);
        tinyDB.putListObject("CardList", listBuku);
        changeNumberItemListener.changed();
    }
    public void minusNumberBuku(ArrayList<ModelBukuPopuler> listBuku, int position, ChangeNumberItemListener changeNumberItemListener){
        if (listBuku.get(position).getNumberInCart()==1){
            listBuku.remove(position);
        }else {
            listBuku.get(position).setNumberInCart(listBuku.get(position).getNumberInCart()-1);
        }
        tinyDB.putListObject("CardList", listBuku);
        changeNumberItemListener.changed();
    }
    public Double getTotalHarga(){
        ArrayList<ModelBukuPopuler> listBuku = getListCart();
        double fee=0;
        for (int i = 0; i<listBuku.size();i++){
            fee = fee +(listBuku.get(i).getHarga()*listBuku.get(i).getNumberInCart());
        }
        return fee;
    }
}
