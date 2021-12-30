package com.example.pgi_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.content.SharedPreferences
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONException
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : BasicActivity(), RecyclingViewAdapter.OnTouchListener{

    companion object {
        @JvmStatic lateinit var adapter: RecyclingViewAdapter
    }

    private val mQueue: RequestQueue? = null
    private var initialize = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        if(initialize == 0){
            createData()                        //creates planta objects
            loadData()                          //loads Hortas
            initialize++
        }


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
        val mQueue = Volley.newRequestQueue(this)
        val url = "https://www.growstuff.org/crops.json"
        println("A entrar !!!!")

        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            { response ->
                try {
                    for (i in 0 until response.length()) {
                        val jsonobject = response.getJSONObject(i)
                        val description = jsonobject.getString("description")
                        val nome = jsonobject.getString("name")
                        val uppe = nome.substring(0,1).uppercase(Locale.getDefault()) + nome.substring(1)
                            .lowercase(Locale.getDefault());
                        val scientificN = jsonobject.getString("scientific_name")
                        val source = jsonobject.getString("thumbnail_url")
                        val f = floatArrayOf(20.1F,20.2F,20F,20F,20F,20F,20F,20F,20F,20F,20F);
                        val p = Planta(uppe,description,scientificN,f,source);
                        Planta.plantList.add(p);
                        println("Nome: $nome")
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            }) { error -> error.printStackTrace() }

        println("A sair !!!")
        mQueue.add(request)

        val f = floatArrayOf(20.1F,20.2F,20F,20F,20F,20F,20F,20F,20F,20F,20F);
        val p = Planta("Tomate","-Nome Científico: Solanum lycopersicum\n-Família: Solanaceae\n-Categoria: Frutas e Legumes, Plantas Hortícolas\n-Clima: Equatorial, Mediterrâneo, Oceânico, Subtropical, Tropical\n-Origem: América Central, América do Sul\n-Altura: 1.2 a 1.8 metros, 1.8 a 2.4 metros\n-Luminosidade: Sol Pleno\n-Ciclo de Vida: Anual","-Deve ser cultivado sob sol pleno, em solo fértil, profundo, destorroado, drenável, enriquecido com matéria orgânica e irrigado regularmente\\n-Aprecia o clima ameno e é bastante exigente em fertilidade\\n-Em condições de elevada umidade e calor se torna muito suscetível às pragas e doenças\\n-Necessita manejos específicos tais como transplante, amôntoa, desbrota, tutoramento com estacas e amarrios\\n-Multiplica-se facilmente por sementes postas a germinar em sementeiras ou diretamente no local definitivo\\n-Leva cerca de 110 dias do plantio à colheita no verão ",f,"https://upload.wikimedia.org/wikipedia/commons/8/89/Tomato_je.jpg" );
        Planta.plantList.add(p);
        val q = Planta("Alface","Planta verde","Regar com frequencia",f,"https://upload.wikimedia.org/wikipedia/commons/2/20/Kropsla_herfst.jpg");
        Planta.plantList.add(q);
        val s = Planta("Batata","Planta castanha","Armazenar em local fresco",f,"https://upload.wikimedia.org/wikipedia/commons/a/ab/Patates.jpg");
        Planta.plantList.add(s);
        val t = Planta("Cenoura","Planta laranja","Nao deixar morrer",f,"https://upload.wikimedia.org/wikipedia/commons/e/e6/Carrots.JPG");
        Planta.plantList.add(t);
        val u = Planta("Milho","Planta amarela","I dont know",f,"https://www.infoescola.com/wp-content/uploads/2010/12/milho_616104491.jpg");
        Planta.plantList.add(u);

    }

    // Toolbar toolbar = findViewById(R.layout.toolbar)
    }
/*
{"_index":"crops_production_20200824003628370",
	"_type":"_doc",
"_id":"113",
"_score":8.847935,
"name":"lettuce",
"description":"Lettuce is a cool weather crop and high temperatures will impede germination and/or cause the plant to bolt (go to seed quickly). Some hybrid cultivars have been bred to be more heat-resistant.",
"slug":"lettuce",
"alternate_names":[],
"scientific_names":["Lactuca sativa"],
"photos_count":59,"plantings_count":143,
"harvests_count":46,"
planters_ids":[15,864,1736,31,86,124,28,145,33,127,34,167,6,103,802,174,807,180,182,48,725,1153,227,34,28,13504,275,277,807,807,904,910,550,428,433,1999,50,134,1073,1044,309,1210,1,1,1,1,1044,1327,1390,1126,1221,1375,1044,1390,1,1571,1577,14051,304,1171,45,948,253,804,935,1661,1584,1325,1325,99,1400,1577,197,675,1577,58,234,1400,575,1168,962,1684,1684,804,1325,1690,1325,840,874,993,452,1321,202,313,95,95,1782,1285,782,782,99,1876,2046,1907,659,1212,15,2056,2056,2064,2134,15,15,15,2116,942,15,1639,1329,1,134,15,15,2159,2560,15,15,15,15,7366,15,6532,988,15,223,8337,201,1212,15,10396,12052],
"has_photos":true,
"thumbnail_url":"https://s3.amazonaws.com/openfarm-project/production/media/pictures/attachments/576b87bafe8d750003000424.jpg?1466664889",
"scientific_name":"Lactuca sativa",
"created_at":1363656627,
"id":"113"}


Exemplo de objeto JSON
Sourrce : "https://www.growstuff.org/crops.json"
 */