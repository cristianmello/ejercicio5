package com.example.newaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ListView listaItem;
    ProgressBar pgBar;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaItem = (ListView) findViewById(R.id.listViewId);
        pgBar = (ProgressBar) findViewById(R.id.progressBarId);

        Timer timer = new Timer();
        TimerTask Ttimer = new TimerTask() {
            @Override
            public void run() {
                counter ++;
                pgBar.setProgress(counter);

                if (counter == 100) {
                    timer.cancel();
                    pgBar.setVisibility(View.INVISIBLE);
                }
            }
        };
        timer.schedule(Ttimer, 0, 10);


        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this, R.array.arrayItems, android.R.layout.simple_list_item_1);

        listaItem.setAdapter(adaptador);

        listaItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String itemSelected = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), itemSelected, Toast.LENGTH_SHORT).show();

                counter = 0;
                pgBar.setVisibility(View.VISIBLE);
                pgBar.setProgress(0);

                Timer timer = new Timer();
                TimerTask Ttimer = new TimerTask() {
                    @Override
                    public void run() {
                        counter ++;
                        pgBar.setProgress(counter);

                        if (counter == 100) {
                            timer.cancel();
                            pgBar.setVisibility(View.INVISIBLE);
                            if (itemSelected.equalsIgnoreCase("LinearLayout")){
                                Intent intent = new Intent(getApplicationContext(), linealLayout.class);
                                startActivity(intent);
                            } else if(itemSelected.equalsIgnoreCase("RelativeLayout")) {
                                Intent intent = new Intent(getApplicationContext(), relativeLayout.class);
                                startActivity(intent);
                            } else if (itemSelected.equalsIgnoreCase("Calcular IMC")) {
                                Intent intent = new Intent(getApplicationContext(), imc.class);
                                startActivity(intent);
                            }
                        }
                    }
                };
                timer.schedule(Ttimer,0, 10);

            }
        });
    }
}