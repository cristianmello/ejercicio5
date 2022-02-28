package com.example.newaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class imc extends AppCompatActivity {

    EditText tx1;
    EditText tx2;
    double imc = 0;
    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        tx1 = (EditText) findViewById(R.id.editText);
        tx2 = (EditText) findViewById(R.id.editText2);
        btCalcular = (Button) findViewById(R.id.button);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pesoString = tx1.getText().toString();
                double pesoKg = Double.parseDouble(pesoString);
                String alturaString = tx2.getText().toString();
                double alturaM = Double.parseDouble(alturaString);

                if (pesoKg > 0 && alturaM >0 ) {
                    imc = pesoKg / (alturaM * alturaM);
                    String pesokgString = String.format("%.2f", imc);
                    String mensaje = "Su indice de masa corporal es:" +  pesokgString;
                    Toast.makeText(getApplicationContext(), mensaje , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}