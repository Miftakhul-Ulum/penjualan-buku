package com.project101.aplikasibuku.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.project101.aplikasibuku.R;
import com.project101.aplikasibuku.helper.ManagementCart;
import com.project101.aplikasibuku.model.ModelBukuPopuler;

public class DetailBukuActivity extends AppCompatActivity {
    private TextView tambahkan;
    private TextView judulBuku, harga, addBarang, deskripsi;
    private ImageView gambar, plusBtn, minusBtn;
    private ModelBukuPopuler object;
    int jumlahOrder = 10;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);

        managementCart = new ManagementCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object = (ModelBukuPopuler) getIntent().getSerializableExtra("object");
        int gambarResourceId = this.getResources().getIdentifier(object.getGambar(), "drawable", this.getPackageName());

        Glide.with(this).load(gambarResourceId).into(gambar);

        judulBuku.setText(object.getBuku());
        harga.setText("RP."+ object.getHarga());
        deskripsi.setText(object.getDeskripsi());
        addBarang.setText(String.valueOf(jumlahOrder));

        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jumlahOrder=jumlahOrder++;
                addBarang.setText(String.valueOf(jumlahOrder));

            }
        });
        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (jumlahOrder>1){
                    jumlahOrder = jumlahOrder--;
                }
                addBarang.setText(String.valueOf(jumlahOrder));
            }
        });

        tambahkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCart(jumlahOrder);
                managementCart.insertBuku(object);
            }
        });

    }

    private void initView(){
        tambahkan = findViewById(R.id.textTambahkan);
        judulBuku = findViewById(R.id.judul);
        harga = findViewById(R.id.harga);
        addBarang = findViewById(R.id.addBarang);
        deskripsi = findViewById(R.id.deskripsi);
        plusBtn = findViewById(R.id.plusBtn);
        minusBtn = findViewById(R.id.plusBtn);
        gambar = findViewById(R.id.gambar);
    }
}