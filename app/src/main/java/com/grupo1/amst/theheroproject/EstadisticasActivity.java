package com.grupo1.amst.theheroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;

public class EstadisticasActivity extends AppCompatActivity {
    BarChart grafica;
    TextView nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estadisticas);
        nombre = findViewById(R.id.nombre);
        Intent i = getIntent();

        HashMap<String,String> hash =(HashMap<String, String>) i.getSerializableExtra("info");


        nombre.setText(hash.get("name"));
        BarChart chart = findViewById(R.id.bar_chart);

        ArrayList NoOfEmp = new ArrayList();

        NoOfEmp.add(new BarEntry(Integer.parseInt(hash.get("inteligencia")), 0));
        NoOfEmp.add(new BarEntry(Integer.parseInt(hash.get("fuerza")), 1));
        NoOfEmp.add(new BarEntry(Integer.parseInt(hash.get("speed")), 2));
        NoOfEmp.add(new BarEntry(Integer.parseInt(hash.get("durabilidad")), 3));
        NoOfEmp.add(new BarEntry(Integer.parseInt(hash.get("poder")), 4));
        NoOfEmp.add(new BarEntry(Integer.parseInt(hash.get("combate")), 5));


        ArrayList year = new ArrayList();

        year.add("Inteligencia");
        year.add("Fuerza");
        year.add("Velocidad");
        year.add("Durabilidad");
        year.add("Poder");
        year.add("Combate");


        BarDataSet bardataset = new BarDataSet(NoOfEmp, "HABILIDADES");
        chart.animateY(2000);
        BarData data = new BarData(year, bardataset);
        bardataset.setColors(ColorTemplate.COLORFUL_COLORS);
        chart.setData(data);

    }

}