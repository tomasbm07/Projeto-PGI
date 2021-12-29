package com.example.pgi_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class MainActivity : BasicActivity(), RecyclingViewAdapter.OnTouchListener{

    companion object {
        @JvmStatic lateinit var adapter: RecyclingViewAdapter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        createData()                        //creates planta objects
        loadData()                          //loads Hortas

        super.onCreate(savedInstanceState)
        setContentView(R.layout.agric)
        Toast.makeText(applicationContext, "Application started! Welcome!", Toast.LENGTH_SHORT).show()
        var intent : Intent

        val recyclerView = findViewById<RecyclerView>(R.id.rec);
        adapter = RecyclingViewAdapter(this,Horta.Hortas, 0, this)
        recyclerView.setAdapter(adapter)
        recyclerView.setLayoutManager(LinearLayoutManager(this))

       val button = findViewById<View>(R.id.button5) as Button
        button.setOnClickListener {
            intent = Intent(this, SearchPage::class.java)
            startActivity(intent)
            Toast.makeText(
                applicationContext,
                "Insira o nome da planta",
                Toast.LENGTH_SHORT
            ).show()
        }

        val button1 = findViewById<View>(R.id.button) as Button
        button1.setOnClickListener {
            intent = Intent(this, TiposdeAgricultura::class.java)
            //System.out.println(p.getCuidados());
            intent.putExtra("sample object", 1)
            startActivity(intent)
            Toast.makeText(
                applicationContext,
                "Agricultura regenerativa",
                Toast.LENGTH_SHORT
            ).show()
        }

        val button2 = findViewById<View>(R.id.button4) as Button
        button2.setOnClickListener {
            intent = Intent(this, TiposdeAgricultura::class.java)
            //System.out.println(p.getCuidados());
            intent.putExtra("sample object", 2)
            startActivity(intent)
            Toast.makeText(
                applicationContext,
                "Horta no apartamento",
                Toast.LENGTH_SHORT
            ).show()
        }

        val button3 = findViewById<View>(R.id.button6) as Button
        button3.setOnClickListener {
            intent = Intent(this, MinhasHortas::class.java)
            startActivity(intent)
        }
    }

    override fun onTouch(position: Int) {
        val intent = Intent(this, HortaActivity::class.java)
        intent.putExtra("sample object", Horta.Hortas[position])
        startActivity(intent)
    }

    override fun onStop() {
        saveData()
        super.onStop()
    }


    private fun saveData() {
        val sharedPreferences = getSharedPreferences(" pref", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        val gson = Gson()
        val jsonH: String = gson.toJson(Horta.Hortas)
        editor.putString("hortas", jsonH)
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences(" pref", MODE_PRIVATE)
        val gson = Gson()
        val jsonH: String? = sharedPreferences.getString("hortas", null)
        val typeH: Type = object : TypeToken<ArrayList<Horta>>() {}.getType()
        Horta.Hortas = gson.fromJson(jsonH, typeH)
        if(Horta.Hortas == null) {
            Horta.Hortas = arrayListOf<Horta>()
        }
    }

    private fun createData(){
        val f = floatArrayOf(20.1F,20.2F,20F,20F,20F,20F,20F,20F,20F,20F,20F);
        val p = Planta("Tomate","-Nome Científico: Solanum lycopersicum\n-Família: Solanaceae\n-Categoria: Frutas e Legumes, Plantas Hortícolas\n-Clima: Equatorial, Mediterrâneo, Oceânico, Subtropical, Tropical\n-Origem: América Central, América do Sul\n-Altura: 1.2 a 1.8 metros, 1.8 a 2.4 metros\n-Luminosidade: Sol Pleno\n-Ciclo de Vida: Anual","-Deve ser cultivado sob sol pleno, em solo fértil, profundo, destorroado, drenável, enriquecido com matéria orgânica e irrigado regularmente\\n-Aprecia o clima ameno e é bastante exigente em fertilidade\\n-Em condições de elevada umidade e calor se torna muito suscetível às pragas e doenças\\n-Necessita manejos específicos tais como transplante, amôntoa, desbrota, tutoramento com estacas e amarrios\\n-Multiplica-se facilmente por sementes postas a germinar em sementeiras ou diretamente no local definitivo\\n-Leva cerca de 110 dias do plantio à colheita no verão ",f,R.drawable.tomate);
        Planta.plantList.add(p);
        val q = Planta("Alface","Planta verde","Regar com frequencia",f,R.drawable.alface);
        Planta.plantList.add(q);
        val s = Planta("Batata","Planta castanha","Armazenar em local fresco",f,R.drawable.batata);
        Planta.plantList.add(s);
        val t = Planta("Cenoura","Planta laranja","Nao deixar morrer",f,R.drawable.cenoura);
        Planta.plantList.add(t);
        val u = Planta("Milho","Planta amarela","I dont know",f,R.drawable.milho);
        Planta.plantList.add(u);

    }

    // Toolbar toolbar = findViewById(R.layout.toolbar)
    }
