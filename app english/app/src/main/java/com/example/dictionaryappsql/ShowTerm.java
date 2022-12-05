package com.example.dictionaryappsql;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ShowTerm extends AppCompatActivity {
   //khai báo mảng databaseAdapter
    static DatabaseAdapter databaseAdapter;
   //
    static RecyclerView rvTerms;
    TermsAdapter termsAdapter;
    RecyclerView.LayoutManager layoutManager;
    //Khai báo cái arraylist
    static ArrayList<Term> termsList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_term);
     //xây dựng icon cho action bar
        setContentView(R.layout.show_term);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher_d);
        setContentView(R.layout.show_term);
        // đổ dữ liệu từ intent thông qua phương thức getintent().getStringExtra() dược đặt bởi sâu chuỗi"termStarWith"
        String termStarsWith = getIntent().getStringExtra("termStarsWith");
        //Khởi tạo đối tượng của databaseAdapter;
        databaseAdapter = new DatabaseAdapter(this);
        termsList = databaseAdapter.getSomeTerms(termStarsWith);
        rvTerms = findViewById(R.id.rvTerms);
        rvTerms.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvTerms.setLayoutManager(layoutManager);
        termsAdapter = new TermsAdapter(this, termsList, rvTerms);
        rvTerms.setAdapter(termsAdapter);
    }
}
