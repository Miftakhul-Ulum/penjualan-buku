package com.project101.aplikasibuku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.project101.aplikasibuku.adapter.AdapterBukuPopuler;
import com.project101.aplikasibuku.adapter.AdapterListBuku;
import com.project101.aplikasibuku.model.ModelBukuPopuler;
import com.project101.aplikasibuku.model.ModelListBuku;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerListBuku, receyclerListPopuler;
    private RecyclerView.Adapter adapterListBuku, adapterBukuPopuler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerBuku();
        recyclerPopuler();
    }


    private void recyclerBuku() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerListBuku = findViewById(R.id.recyclerListBuku);
        recyclerListBuku.setLayoutManager(linearLayoutManager);

        ArrayList<ModelListBuku> listBuku = new ArrayList();
        listBuku.add(new ModelListBuku("Biologi", "book_1"));
        listBuku.add(new ModelListBuku("Bahasa", "book_2"));
        listBuku.add(new ModelListBuku("Geografi", "book_3"));
        listBuku.add(new ModelListBuku("Kimia", "book_4"));
        listBuku.add(new ModelListBuku("Akutansi", "book_5"));

        adapterListBuku = new AdapterListBuku(listBuku);
        recyclerListBuku.setAdapter(adapterListBuku);
    }
    private void recyclerPopuler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        receyclerListPopuler = findViewById(R.id.listBukuPopuler);
        receyclerListPopuler.setLayoutManager(layoutManager);

        ArrayList<ModelBukuPopuler> modelBukuPopulers = new ArrayList<>();
        modelBukuPopulers.add(new ModelBukuPopuler("Bahasa", "book_2","Materi Bahasa Kelas 7", 35.100));
        modelBukuPopulers.add(new ModelBukuPopuler("Geografi", "book_3","Manusia, Tempat, Dan Lingkungan", 30.500));
        modelBukuPopulers.add(new ModelBukuPopuler("Akutansi", "book_5","Pengenalan Akutansi Dasar", 45.000));

        adapterBukuPopuler = new AdapterBukuPopuler(modelBukuPopulers);
        receyclerListPopuler.setAdapter(adapterBukuPopuler);
    }

}