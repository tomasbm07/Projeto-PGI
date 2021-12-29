package com.example.pgi_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MinhasHortas extends AppCompatActivity implements RecyclingViewAdapter.OnTouchListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minhas_hortas);

        RecyclerView recyclerView = findViewById(R.id.rec);
        RecyclingViewAdapter adapter = new RecyclingViewAdapter(this,Horta.Hortas, 1, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onTouch(int position) {
        Intent intent = new Intent(this, HortaActivity.class);
        intent.putExtra("sample object", Horta.Hortas.get(position));
        startActivity(intent);
    }
}