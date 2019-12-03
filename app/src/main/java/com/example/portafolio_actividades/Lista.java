package com.example.portafolio_actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity implements AdapterView.OnItemClickListener{
    ListView ListaFl;
    List<String> tFlores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        ListaFl = findViewById(R.id.Lista);
        tFlores = new ArrayList<>();
        tFlores.add("Login");
        tFlores.add("Lista de flores");
        tFlores.add("TOAST y SNACKBAR");
        tFlores.add("Mapa");
        tFlores.add("Fragmento");
        tFlores.add("Pokemon");
        tFlores.add("Repositorio");


        ArrayAdapter aTiposFlores = new ArrayAdapter(this, android.R.layout.simple_list_item_1,tFlores);
        ListaFl.setAdapter(aTiposFlores);

        ListaFl.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        switch (position)
        {
            case 0:
                intent = new Intent(this, MainActivity.class);

                break;
            case 1:
                 intent = new Intent(this, ListaF.class);
                break;
            case 2:
                intent = new Intent(this, Mensaje.class);

                break;
            case 3:
                intent = new Intent(this, mapita.class);

                break;

            case 4:
                intent = new Intent(this, Main2Activity.class);
                break;
            case 5:
            intent = new Intent(this, Pokemon.class);

            break;
            case 6:
                intent = new Intent(this, Repositorio.class);

                break;



        }
        startActivity(intent);

    }
}
