package com.example.portafolio_actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Pokemon extends AppCompatActivity {
    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        lista = findViewById(R.id.listView);
        String laurl ="https://pokeapi.co/api/v2/pokemon/";
        obtieneJSON(laurl);

    }

    private void obtieneJSON(final String laweb) {
        class obtienepokemon extends AsyncTask<Void, Void, String> {

            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }
            @Override
            protected String doInBackground(Void... voids) {
                try {
                    //creamos la url
                    URL url = new URL(laweb);
                    //abrimos la url usandodo la clase http url conexion
                    HttpURLConnection conexion = (HttpURLConnection) url.openConnection();
                    StringBuilder StringBuilder = new StringBuilder();
                    // crear un bufer
                    BufferedReader elBuffersito = new BufferedReader(
                            new InputStreamReader(conexion.getInputStream())
                    );
                    //  crear una variable del json
                    String elJson;
                    // leer joson mientreas no sea luno
                    while ((elJson=elBuffersito.readLine()) !=null){
                        //agregar el string bufer
                        StringBuilder.append(elJson+"\n");

                    }
                    // creamos un objeto
                    return  StringBuilder.toString();
                } catch (Exception e) {
                    return null;
                }
                //return null;
            }
        }
        obtienepokemon pokemonsito=new obtienepokemon();
        pokemonsito.execute();
    }
    //metodo para cargar los datos en una list view


}
