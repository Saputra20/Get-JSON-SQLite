package com.example.root.contohdata;

import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.android.volley.Request.*;
import static com.android.volley.Request.Method.*;

public class MainActivity extends AppCompatActivity {

    Database db ;
    private RecyclerView recyclerView ;
    private AdapterData adapterData ;
    private ArrayList<ModelData> list ;
    private RequestQueue requestQueue ;
    public String urls = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new Database(this);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.receyl);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        list = new ArrayList<>();
        Database db = new Database(this);
        requestQueue = Volley.newRequestQueue(this);
        parseJson();
    }

    public void parseJson(){
        StringRequest request = new StringRequest(Request.Method.GET, urls , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.e("Log respon" ,response);
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONArray jsonArray = jsonObject.getJSONArray("teams");

                    for(int i = 0 ; i < jsonArray.length() ; i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    String id = jsonObject1.getString("idTeam");
                    String name = jsonObject1.getString("strTeam");
                    String alternate = jsonObject1.getString("strAlternate");
                    String manager = jsonObject1.getString("strManager");
                    String stadium = jsonObject1.getString("strStadium");
                    String words = jsonObject1.getString("strKeywords");

                    Log.e("Log String " , words);
                    ModelData modelData = new ModelData(id , name , alternate , manager , stadium , words);
                    list.add(modelData);
                    db.insertToDB(modelData);
                    }


                    adapterData = new AdapterData(MainActivity.this, list);
                    recyclerView.setAdapter(adapterData);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
        requestQueue.add(request);
    }
}
