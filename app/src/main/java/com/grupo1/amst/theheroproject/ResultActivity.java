package com.grupo1.amst.theheroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class ResultActivity extends AppCompatActivity {
    LinearLayout linearHeroes;
    String token="4601905199827191";
    private RequestQueue ListaRequest = null;
    public ArrayList <Hero> Arrayheroes = new ArrayList<Hero>();
    public Hero actualHero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        linearHeroes = findViewById(R.id.linearHeroes);
        ListaRequest = Volley.newRequestQueue(this);
        Intent i = getIntent();
        String nombre = i.getStringExtra("nombre");
        System.out.println(nombre);
        this.buscarHeroe(nombre);
    }

    public void buscarHeroe(String heroe){
        String url_superHero = "https://superheroapi.com/api/"+token+"/search/"+heroe;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url_superHero, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            System.out.println(response);
                            JSONArray valores = response.getJSONArray("results");

                            for (int i = 0; i < response.length(); i++) {

                                JSONObject object = valores.getJSONObject(i);
                                String nombre = object.getString("name");
                                String id = object.getString("id");
                                String it,stre,spee,dura,poo,comb;
                                JSONObject power = object.getJSONObject("powerstats");
                                if (!power.isNull("intelligence")){
                                    it=power.getString("intelligence");
                                }else{
                                    it = "0";
                                }
                                if (!power.isNull("strength")){
                                    stre=power.getString("strength");
                                }else{
                                    stre = "0";
                                }
                                if (!power.isNull("speed")){
                                    spee=power.getString("speed");
                                }else{
                                    spee = "0";
                                }
                                if (!power.isNull("durability")){
                                    dura=power.getString("durability");
                                }else{
                                    dura = "0";
                                }
                                if (!power.isNull("power")){
                                    poo=power.getString("power");
                                }else{
                                    poo = "0";
                                }
                                if (!power.isNull("combat")){
                                    comb=power.getString("combat");
                                }else{
                                    comb = "0";
                                }
                                Hero heroe = new Hero(getApplicationContext(),id,nombre,it,stre,spee,dura,poo,comb);
                                Arrayheroes.add(heroe);
                            }
                            mostarHeroes(Arrayheroes);
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

    public void mostarHeroes(ArrayList<Hero> heroes){
        for (Hero heroe:heroes){
            linearHeroes.addView(heroe);
            actualHero = heroe;
            heroe.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent(getApplicationContext(),EstadisticasActivity.class);
                    HashMap<String,String> hash = new HashMap<>();
                    hash.put("id", actualHero.getIdd());
                    hash.put("name", actualHero.getName());
                    hash.put("inteligencia", actualHero.getIntelligence());
                    hash.put("speed",actualHero.getSpeed());
                    hash.put("durabilidad",actualHero.getDurability());
                    hash.put("poder",actualHero.getPower());
                    hash.put("fuerza",actualHero.getStrength());
                    hash.put("combate",actualHero.getCombat());
                    i.putExtra("info",hash);
                    startActivity(i);

                }
            });


        }
    }
}