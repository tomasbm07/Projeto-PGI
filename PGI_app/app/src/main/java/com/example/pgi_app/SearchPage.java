package com.example.pgi_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.Serializable;

public class SearchPage extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<Planta> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);
        Intent i = new Intent(this, PlantPage.class);
        listView = findViewById(R.id.listview);

        arrayAdapter = new ArrayAdapter<Planta>(this, android.R.layout.simple_list_item_1, Planta.plantList);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                //TextView c = (TextView) v.findViewById(R.id.search_menu);
                String name = (String) ((TextView) v).getText();
                Toast.makeText(getApplicationContext(),name + " selected", Toast.LENGTH_SHORT).show();
                Planta p = Planta.getPlanta(name);
                //System.out.println(p.getCuidados());
                i.putExtra("sample object", p);
                startActivity(i);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.search_menu);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Type plant name...");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }





}