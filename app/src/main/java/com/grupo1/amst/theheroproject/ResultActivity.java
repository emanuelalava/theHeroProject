package com.grupo1.amst.theheroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class ResultActivity extends AppCompatActivity {
    LinearLayout linearHeroes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        linearHeroes = findViewById(R.id.linearHeroes);
    }

//    public void mostarHeroes(ArrayList<Heroe> heroes){
//        for (Heroe heroe:heroes){
//            String nombre = heroe.get
//        }
//    }
}