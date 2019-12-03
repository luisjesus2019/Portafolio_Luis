package com.example.portafolio_actividades;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class Main2Activity extends AppCompatActivity {
    boolean modoDia=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedor,new ModoDiaFragment())
                .commit();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment f  = null;

                if (modoDia){
                    f=new ModoNocheFragment();
                }else {
                    f = new ModoDiaFragment();
                }

                modoDia = !modoDia;
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contenedor,f)
                        .commit();

            }
        });
    }

}

