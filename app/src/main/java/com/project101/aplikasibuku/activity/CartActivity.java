package com.project101.aplikasibuku.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ScrollView;
import android.widget.TextView;

import com.project101.aplikasibuku.R;
import com.project101.aplikasibuku.helper.ManagementCart;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private ManagementCart managementCart;
    TextView jumlahBuku, biayaPengiriman, pajak, total, emtyText;
    private double tax;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        managementCart = new ManagementCart(this);
        initView();
    }

    private void initView() {
        jumlahBuku = findViewById(R.id.jumlahBuku);
        biayaPengiriman = findViewById(R.id.biayaPengiriman);
        pajak = findViewById(R.id.pajak);
        total = findViewById(R.id.total);
        emtyText = findViewById(R.id.emtyText);
        recyclerView= findViewById(R.id.recyclerCart);
        scrollView = findViewById(R.id.scrollView3);
    }
}