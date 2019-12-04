package com.example.portafolio_actividades;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Binario extends AppCompatActivity {

    Button convert;
    EditText iproute;
    TextView binary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binario);

        convert = findViewById(R.id.btnConvert);
        iproute = findViewById(R.id.txtIp);
        binary = findViewById(R.id.txtBinary);

        convert.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {
                try {
                    System.out.println("Hola Luis");
                    String txt = iproute.getText().toString();
                    String[] direcciones = txt.split(Pattern.quote("."));
                    String binario = "";
                    for(int i=0; i < direcciones.length; i++)
                    {

                        binario += Integer.toString(Integer.parseInt(direcciones[i]), 2)+".";

                        System.out.println("VALUE: " + direcciones[i] + " BINARY: " + Integer.toString(Integer.parseInt(direcciones[i]), 2));
                    }
                    binary.setText("Binario: " + binario);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "El numero esta mal escrito", Toast.LENGTH_SHORT);
                }

            }
        });
    }

    private class Subclase{

    }
}