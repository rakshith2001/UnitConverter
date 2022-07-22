package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button lbtn,vbtn,mbtn,tbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lbtn = findViewById(R.id.Length);
        vbtn = findViewById(R.id.Volume);
        mbtn = findViewById(R.id.Mass);
        tbtn = findViewById(R.id.Temperature);
        lbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLength();

            }
        });

        vbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVolume();

            }
        });
        mbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMass();

            }
        });

        tbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTemp();

            }
        });

    }

    public void openLength(){
        Intent intent = new Intent(this,LengthConvertor.class);
        startActivity(intent);
    }
    public void openVolume(){
        Intent intent = new Intent(this,VolumeConverter.class);
        startActivity(intent);
    }
    public void openMass(){
        Intent intent = new Intent(this,MassConverter.class);
        startActivity(intent);
    }
    public void openTemp(){
        Intent intent = new Intent(this,TemperatureConverter.class);
        startActivity(intent);
    }

}