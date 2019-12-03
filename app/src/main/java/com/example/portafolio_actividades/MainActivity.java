package com.example.portafolio_actividades;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText textLoginn;
    EditText textPasss;
    Button btnLogin;
    Button btnInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textLoginn = findViewById(R.id.textLogin);
        textPasss = findViewById(R.id.textPass);
        btnLogin = findViewById(R.id.btnLogin);
        btnInfo = findViewById(R.id.btnInfo);

        btnLogin.setOnClickListener(this);
        btnInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.btnLogin) {
            if (textLoginn.getText().toString().equals("Luis")) {
                if (textPasss.getText().toString().equals("12345")) {
                    Intent enviar = new Intent(MainActivity.this, Lista.class);
                    startActivity(enviar);

                } else {
                    Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(this, "Nombre de usuario incorrecto", Toast.LENGTH_LONG).show();
            }
        }else if(view.getId()==R.id.btnInfo){
            Intent enviar = new Intent(MainActivity.this,InfoActivity.class);
            startActivity(enviar);
        }

    }

    /*
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Errorcito","Ingresa al onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Errorcito", "Ingresa al onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Errorcito", "Ingresa al onDestroy");
    }

    @Override
    public void onClick(View view) {
        Log.i( "ETIQUETA", "Diste clic en Login");
    }


    edi=(EditText)findViewById(R.id.edi1);
    bot=(Button)findViewById(R.id.bot1);
    mos=(TextView)findViewById(R.id.mos1);

        bot.setOnClickListener(this);
}
*/
}