package com.example.pgi_app;

import android.content.Intent;
import android.os.Bundle;

import com.example.pgi_app.databinding.ActivitySearchPageBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;

public class TiposdeAgricultura extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiposde_agricultura);

       final FloatingActionButton button = (FloatingActionButton) findViewById(R.id.fab_list);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SearchPage.class);
                startActivity(i);
            }



        });

        Intent i = getIntent();


        int p = (int) getIntent().getSerializableExtra("sample object");

        TextView name = (TextView) findViewById(R.id.textView1);
        TextView text = (TextView) findViewById(R.id.textView2);
        ImageView img = (ImageView) findViewById(R.id.image1);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView toolbar_text = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        switch(p){
            case 1:
                toolbar_text.setText("Agricultura regenerativa");
                name.setText("Informação geral");
                text.setText("Informção sobre agricultura regenrativa");
                img.setImageResource(R.drawable.crop);
                break;
            case 2:
                toolbar_text.setText("Horta no apartamento");
                name.setText("Informação geral");
                text.setText("Informção sobre horta no apartamento");
                img.setImageResource(R.drawable.balcon);
                break;
        }

    }
}