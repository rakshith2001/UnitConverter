package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TemperatureConverter extends Activity  {
    Spinner sp1,sp2;
    Button btn1;
    EditText et;
    TextView tv1;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature_converter);
        et = findViewById(R.id.et);
        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);
        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);
        sp1 = (Spinner)findViewById(R.id.sp1);
        sp2 = (Spinner)findViewById(R.id.sp2);
        ///spinner1
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temp1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);

        /// spinner2
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.temp2, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter1);

        btn1.setOnClickListener(
                view -> {
                    String item = sp1.getSelectedItem().toString();
                    String ans = et.getText().toString();
                    String item2 = sp2.getSelectedItem().toString();
                    if(item.equals("Celsius") && item2.equals("Fahrenheit")){
                        float num = Float.parseFloat(ans);
                        double fahren = (num *1.8)+ 32;
                        tv1.setText(String.format("%.2f",fahren)+" "+"°F");
                    }
                    else if(item.equals("Celsius") && item2.equals("Kelvin")){
                        float num1 = Float.parseFloat(ans);
                        double kel = num1 +273.15;
                        tv1.setText(String.format("%.2f",kel)+" "+"°K");


                    }
                    else if(item.equals("Fahrenheit") && item2.equals("Celsius")){
                        float num2 = Float.parseFloat(ans);
                        double cel = (num2-32)*5/9;
                        tv1.setText(String.format("%.2f",cel)+" "+"°C");


                    }
                    else if(item.equals("Fahrenheit") && item2.equals("Kelvin")){
                        float num3 = Float.parseFloat(ans);
                        double kel = (num3-32)*5/9+273.15;
                        tv1.setText(String.format("%.2f",kel)+" "+"°K");


                    }
                    else if(item.equals("Kelvin") && item2.equals("Celsius")){
                        float num4 = Float.parseFloat(ans);
                        double cel1 = num4-273.15;
                        tv1.setText(String.format("%.2f",cel1)+" "+"°C");

                    }
                    else if(item.equals("Kelvin") && item2.equals("Fahrenheit")){
                        float num4 = Float.parseFloat(ans);
                        double cel1 = (num4-273.15)*9/5 +32;
                        tv1.setText(String.format("%.2f",cel1)+" "+"°F");

                    }
                    else if(item.equals("Kelvin") && item2.equals("Kelvin")){
                        Toast.makeText(TemperatureConverter.this,"Invalid Selection",Toast.LENGTH_SHORT).show();


                    }
                    else if(item.equals("Fahrenheit") && item2.equals("Fahrenheit")){
                        Toast.makeText(TemperatureConverter.this,"Invalid Selection",Toast.LENGTH_SHORT).show();


                    }
                    else if(item.equals("Celsius") && item2.equals("Celsius")){
                        Toast.makeText(TemperatureConverter.this,"Invalid Selection",Toast.LENGTH_SHORT).show();


                    }
                    else if(ans.equals("")){
                        Toast.makeText(TemperatureConverter.this,"Enter the value",Toast.LENGTH_SHORT).show();


                    }

                }
        );

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                adapterView.getItemAtPosition(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}