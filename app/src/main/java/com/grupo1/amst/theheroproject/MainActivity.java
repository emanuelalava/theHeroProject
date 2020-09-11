package com.grupo1.amst.theheroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
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
    String token="4601905199827191";
    private RequestQueue ListaRequest = null;
    public ArrayList <Hero> Arrayheroes;
    EditText busqueda;
    String nombre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        busqueda = findViewById(R.id.txtBusqueda);
        nombre = busqueda.getText().toString();
        ListaRequest = Volley.newRequestQueue(this);
        Context contexto = this;
        this.buscarHeroe("batman");

    }


    public void buscarHeroe(String heroe){
        String url_superHero = "https://superheroapi.com/api.php/"+token+"/search/"+heroe;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url_superHero, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        System.out.println(response);
                        try {
                            JSONArray valores = response.getJSONArray("results");

                            for (int i = 0; i < response.length(); i++) {
                                JSONObject object = valores.getJSONObject(i);
                                String nombre = object.getString("name");
                                String id = object.getString("id");



                                JSONObject power = object.getJSONObject("powerstats");

                                String intelligence = power.getString("intelligence");
                                String strength = power.getString("strength");
                                String speed = power.getString("speed");
                                String durability = power.getString("durability");
                                String poder = power.getString("power");
                                String combat = power.getString("combat");
                                Hero h;
                                h = new Hero(id,nombre,intelligence,strength,speed,durability,poder,combat);
                                System.out.println(h);
                                Arrayheroes.add(h);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });
        ListaRequest.add(jsonObjectRequest);
    }

}