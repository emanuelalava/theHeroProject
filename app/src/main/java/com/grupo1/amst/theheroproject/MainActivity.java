package com.grupo1.amst.theheroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {
    EditText busqueda;
    String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        busqueda = findViewById(R.id.txtBusqueda);
        nombre = busqueda.getText().toString();
    }
}