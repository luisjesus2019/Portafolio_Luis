package com.example.portafolio_actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Repositorio extends AppCompatActivity {
    EditText txUsuario;
    Button btnBuscar;
    RequestQueue lapeticion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repositorio);

        txUsuario =findViewById(R.id.txtUsuario);
        btnBuscar= findViewById(R.id.btnBuscar);
        lapeticion = Volley.newRequestQueue(this);




        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerDatos(txUsuario.getText().toString());
            }
        });

    }

    private void obtenerDatos(String elUsuario){
        String laurl="https://api.github.com/users/"+elUsuario+"/repos";
        //metodo  GET, url , valor o referencia o tag,lo que me devolvera esta peticion, que pasa si hay un error
        JsonArrayRequest arregloJson = new JsonArrayRequest(
                Request.Method.GET, laurl, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response.length() > 0) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject repositorio = response.getJSONObject(i);
                            String nombreCarpeta = repositorio.get("name").toString();
                            Toast.makeText(getApplicationContext(),nombreCarpeta,Toast.LENGTH_LONG).show();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Tu eres el Error",Toast.LENGTH_LONG).show();
            }
        }
        );
        lapeticion.add(arregloJson);
    }
}
