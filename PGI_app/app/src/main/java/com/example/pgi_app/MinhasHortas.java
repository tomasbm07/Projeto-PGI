package com.example.pgi_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
