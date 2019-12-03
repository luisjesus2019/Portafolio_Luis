package com.example.portafolio_actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListaF extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView Listaf;
    List<String> tFlores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_f);
        Listaf = findViewById(R.id.Listaf);
        tFlores = new ArrayList<>();
        tFlores.add("Rosas");
        tFlores.add("Orquidias");
        tFlores.add("Girasoles");
        tFlores.add("Tulipanes");
        tFlores.add("Nopal");
        ArrayAdapter flor = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tFlores);
        Listaf.setAdapter(flor);

        Listaf.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case 0:
                Toast.makeText(this,"Arreglo no disponible", Toast.LENGTH_LONG).show();
                break;
            case 1:
                Toast.makeText(this,"Arreglo no disponible", Toast.LENGTH_LONG).show();
                break;
            case 2:
                Toast.makeText(this,"Arreglo no disponible", Toast.LENGTH_LONG).show();
                break;
            case 3:
                Toast.makeText(this,"Arreglo no disponible", Toast.LENGTH_LONG).show();
                break;
            case 4:
                Toast.makeText(this,"Arreglo no disponible", Toast.LENGTH_LONG).show();
                break;
        }






    }
}
