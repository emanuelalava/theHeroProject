package com.grupo1.amst.theheroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity {

    EditText busqueda;
    String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void buscar(View v){
        Intent i = new Intent(this,ResultActivity.class);
        busqueda = findViewById(R.id.txtBusqueda);
        nombre = busqueda.getText().toString();
        i.putExtra("nombre",nombre);
        startActivity(i);
    }




}