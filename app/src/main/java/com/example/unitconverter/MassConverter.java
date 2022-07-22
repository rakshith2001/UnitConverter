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

public class MassConverter extends Activity  {
    Spinner sp1,sp2;
    Button btn1;
    EditText et;
    TextView tv1;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mass_converter);
        et = findViewById(R.id.et);
        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);
        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);
        sp1 = (Spinner)findViewById(R.id.sp1);
        sp2 = (Spinner)findViewById(R.id.sp2);


        ///spinner1
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.mass1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);

        /// spinner2
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.mass2, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter1);

        btn1.setOnClickListener(
                view -> {
                    String item = sp1.getSelectedItem().toString();
                    String ans = et.getText().toString();
                    String item2 = sp2.getSelectedItem().toString();
                    if(item.equals("Grams") && item2.equals("Milligram")){
                        float num = Float.parseFloat(ans);
                        double milligram= (num *1000);
                        tv1.setText(String.format("%.2f",milligram)+" "+"mg");
                    }
                    else if(item.equals("Grams") && item2.equals("Kilogram")){
                        float num1 = Float.parseFloat(ans);
                        double kilogram = (num1 /1000);
                        tv1.setText(String.format("%.3f",kilogram)+" "+"kg");


                    }
                    else if(item.equals("Milligram") && item2.equals("Grams")){
                        float num2 = Float.parseFloat(ans);
                        double gram = (num2 /1000);
                        tv1.setText(String.format("%.3f",gram)+" "+"g");


                    }
                    else if(item.equals("Milligram") && item2.equals("Kilogram")){
                        float num3 = Float.parseFloat(ans);
                        double kilogram = (num3 /1000000);
                        tv1.setText(String.format("%.6f",kilogram)+" "+"kg");


                    }
                    else if(item.equals("Kilogram") && item2.equals("Grams")){
                        float num4 = Float.parseFloat(ans);
                        double gram  = (num4 * 1000);
                        tv1.setText(String.format("%.2f",gram)+" "+"g");

                    }
                    else if(item.equals("Kilogram") && item2.equals("Milligram")){
                        float num4 = Float.parseFloat(ans);
                        double milligram = (num4 *1000000);
                        tv1.setText(String.format("%.2f",milligram)+" "+"mg");

                    }
                    else if(item.equals("Grams") && item2.equals("Grams")){
                        Toast.makeText(MassConverter.this,"Invalid Selection",Toast.LENGTH_SHORT).show();


                    }
                    else if(item.equals("Milligram") && item2.equals("Milligram")){
                        Toast.makeText(MassConverter.this,"Invalid Selection",Toast.LENGTH_SHORT).show();


                    }
                    else if(item.equals("Kilogram") && item2.equals("Kilogram")){
                        Toast.makeText(MassConverter.this,"Invalid Selection",Toast.LENGTH_SHORT).show();


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