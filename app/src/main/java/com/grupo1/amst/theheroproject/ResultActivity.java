package com.grupo1.amst.theheroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;

public class ResultActivity extends AppCompatActivity {
    LinearLayout linearHeroes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        linearHeroes = findViewById(R.id.linearHeroes);
        mostarHeroes(null);
    }

    public void mostarHeroes(ArrayList<Hero> heroes){
        ArrayList<Hero> heroes1 = new ArrayList<Hero>();
        heroes1.add(new Hero(this,"1","Wonder Woman","1","1","1","1","1","1"));
        heroes1.add(new Hero(this,"2","Superman","1","1","1","1","1","1"));
        heroes1.add(new Hero(this,"3","Batman","1","1","1","1","1","1"));

        for (final Hero heroe:heroes1){
            String nombre = heroe.getName();
//            String inteligencia = heroe.getIntelligence();
//            String speed = heroe.getSpeed();
//            String durabilidad = heroe.getDurability();
//            String poder = heroe.getPower();
//            String combate = heroe.getCombat();
            heroe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(),EstadisticasActivity.class);
                    HashMap<String,String> hash = new HashMap<>();
                    hash.put("id", heroe.getIdd());
                    hash.put("name", heroe.getName());
                    hash.put("inteligencia", heroe.getIntelligence());
                    hash.put("speed",heroe.getSpeed());
                    hash.put("durabilidad",heroe.getDurability());
                    hash.put("poder",heroe.getPower());
                    hash.put("fuerza",heroe.getStrength());
                    hash.put("combate",heroe.getCombat());
                    i.putExtra("info",hash);
                    startActivity(i);

                }
            });
            linearHeroes.addView(heroe);


        }
    }
}