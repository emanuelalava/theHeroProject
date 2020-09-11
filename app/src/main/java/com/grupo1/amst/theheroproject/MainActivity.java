package com.grupo1.amst.theheroproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListaRequest = Volley.newRequestQueue(this);
        Context contexto = this;
        this.buscarHeroe("bat");

    }


    public void buscarHeroe(String heroe){
        String url_superHero = "https://superheroapi.com/api.php/"+token+"/search/"+heroe;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url_superHero, null, new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray valores = response.getJSONArray("results");

                            for (int i = 0; i < response.length(); i++) {

                                JSONObject object = valores.getJSONObject(i);
                                String nombre = object.getString("name");
                                String id = object.getString("id");
                                Hero h = new Hero(id,nombre);
                                String intelligence,strength,speed,durability, poder, combat;

                                JSONObject power = object.getJSONObject("powerstats");
                                String it=power.getString("intelligence");
                                System.out.println(it);
                                String stre =power.getString("strength");
                                String spee =power.getString("speed");
                                String dura =power.getString("durability");
                                String poo=power.getString("power");
                                String comb =power.getString("combat");
                                if (it != null){
                                    intelligence = power.getString("intelligence");
                                    h.setIntelligence(it);

                                }else{
                                    h.setIntelligence("0");
                                }

                                if (stre!= null){
                                    strength = power.getString("strength");
                                    h.setStrength(stre);

                                }else{

                                    h.setStrength("0");
                                }

                                if (spee != null){
                                    speed = power.getString("speed");
                                    h.setSpeed(spee);

                                }else{

                                    speed = "0";
                                    h.setSpeed("0");
                                }


                                if (dura != null){

                                    durability = power.getString("durability");
                                    h.setDurability(dura);
                                }else{

                                    durability = "0";
                                    h.setDurability("0");
                                }

                                if ( poo != null){
                                    poder = power.getString("power");
                                    h.setPower(poo);
                                }else{

                                    poder = "0";
                                    h.setPower("0");
                                }

                                if (comb != null){
                                    combat = power.getString("combat");
                                    h.setCombat(comb);
                                }else{

                                    combat = "0";
                                    h.setCombat("0");
                                }


                                System.out.println(h);
                                try {
                                    Arrayheroes.add(h);
                                }catch (Exception e){
                                    System.out.println(e);
                                }


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