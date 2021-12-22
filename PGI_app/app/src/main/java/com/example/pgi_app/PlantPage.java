package com.example.pgi_app;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class PlantPage extends AppCompatActivity  {

    private AppBarConfiguration appBarConfiguration;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_page);
        Intent i = getIntent();


        Planta p = (Planta) getIntent().getSerializableExtra("sample object");

        TextView description = (TextView) findViewById(R.id.textView2);
        description.setText(p.getDescription());
        TextView cuidados = (TextView) findViewById(R.id.textView4);
        cuidados.setText(p.getCuidados());
        TextView nutricional = (TextView) findViewById(R.id.textView6);
        float nutriValues[] = p.getNutriValues();
        String buf = "Energia (kcal)                          " + nutriValues[0] + "\n Água (g)	                               " + nutriValues[1] + "\n Proteínas (g)	                         " + nutriValues[2] + "\n Lípidos (g)	                             " + nutriValues[3] + "\n Hidratos de Carbono (g)	           " + nutriValues[4] + "\n Fibra (g)                                 " + nutriValues[5] + "\n Vitamina C (mg)                      " + nutriValues[6] + "\n Carotenos (µg)	                        " + nutriValues[7] + "\n Vitamina A (µg)	                      " + nutriValues[8] + "\n Potássio (mg)	                         " + nutriValues[9] + "\n Magnésio (mg)	                        " + nutriValues[10];
        nutricional.setText(buf);
        ImageView img = (ImageView) findViewById(R.id.image1);
        img.setImageResource(p.getImage());
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TextView toolbar_text = (TextView) findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        toolbar_text.setText(p.getNome());
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final FloatingActionButton button =  findViewById(R.id.fab_list);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Horta.Hortas.add(new Horta(p,p.getImage()));
                    Toast.makeText(getApplicationContext(),p.getNome() + " added to Minhas Hortas", Toast.LENGTH_SHORT).show();
            }



            });
        }

}