package com.example.portafolio_actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Mensaje extends AppCompatActivity implements View.OnClickListener {
    Button btnToast, btnSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);
        //enlazamos var-layout
        btnToast=findViewById(R.id.btnToast);
        btnSnackbar=findViewById(R.id.btnSnackbar);
        //evento onclic
        btnToast.setOnClickListener(this);
        btnSnackbar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnToast){
            Toast.makeText(this,"Soy un TOAST", Toast.LENGTH_LONG).show();
        }else if(view.getId()==R.id.btnSnackbar){
            Snackbar.make(view,"Soy un SNACKBAR", Snackbar.LENGTH_INDEFINITE).setAction("Dame click",
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(Mensaje.this,"Le diste click al SNACKBAR",Toast
                                    .LENGTH_SHORT).show();
                        }
                    }
            ).show();
        }
    }
}
