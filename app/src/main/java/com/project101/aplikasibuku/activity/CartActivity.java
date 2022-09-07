package com.project101.aplikasibuku.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.project101.aplikasibuku.Interface.ChangeNumberItemListener;
import com.project101.aplikasibuku.R;
import com.project101.aplikasibuku.adapter.CartAdapter;
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
        initList();
        calculator();
        botomNavigation();
    }
    private void botomNavigation(){
        FloatingActionButton floatingActionButton = findViewById(R.id.floatingBar);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CartActivity.this, CartActivity.class);
                startActivity(intent);
            }
        });
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
    private void initList(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CartAdapter(managementCart.getListCart(), this, new ChangeNumberItemListener() {
            @Override
            public void changed() {
                calculator();
            }
        });
        recyclerView.setAdapter(adapter);
        if(managementCart.getListCart().isEmpty()){
            emtyText.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }else {
            emtyText.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }
    }
    private void calculator(){
        double percentTax = 0.02;
        double delivery = 10;
        tax = Math.round((managementCart.getTotalHarga()*percentTax)*100)/100;
        double totalTagihan = Math.round((managementCart.getTotalHarga()*tax+delivery)*100)/100;
        double itemTotal =  Math.round(managementCart.getTotalHarga()*100)/100;

        jumlahBuku.setText("RP."+itemTotal);
        biayaPengiriman.setText("Rp."+delivery);
        pajak.setText("RP."+tax);
        total.setText("Rp."+totalTagihan);

    }
}