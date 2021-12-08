package com.example.pgi_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toolbar
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "Application started! Welcome!", Toast.LENGTH_SHORT).show()
        val intent = Intent(this, SearchPage::class.java)


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


        // descomentar linha seguinte para testar pagina das plantas
        //startActivity(intent)


       // Toolbar toolbar = findViewById(R.layout.toolbar)
    }
}