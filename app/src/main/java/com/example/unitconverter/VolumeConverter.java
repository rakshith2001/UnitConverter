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

public class VolumeConverter extends Activity  {
    Spinner sp1,sp2;
    Button btn1;
    EditText et;
    TextView tv1;
    ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume_converter);
        et = findViewById(R.id.et);
        sp1 = findViewById(R.id.sp1);
        sp2 = findViewById(R.id.sp2);
        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);
        sp1 = (Spinner)findViewById(R.id.sp1);
        sp2 = (Spinner)findViewById(R.id.sp2);
        ///spinner1
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.vol1, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);

        /// spinner2
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,
                R.array.vol2, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter1);

        btn1.setOnClickListener(
                view -> {
                    String item = sp1.getSelectedItem().toString();
                    String ans = et.getText().toString();
                    String item2 = sp2.getSelectedItem().toString();
                    if(item.equals("Liter") && item2.equals("Milliliter")){
                        float num = Float.parseFloat(ans);
                        double milliliter = (num *1000);
                        tv1.setText(String.format("%.2f",milliliter)+" "+"ml");
                    }
                    else if(item.equals("Liter") && item2.equals("Centiliter")){
                        float num1 = Float.parseFloat(ans);
                        double centiliter = (num1 *100) ;
                        tv1.setText(String.format("%.2f",centiliter)+" "+"cL");


                    }
                    else if(item.equals("Milliliter") && item2.equals("Liter")){
                        float num2 = Float.parseFloat(ans);
                        double liter = (num2 /1000);
                        tv1.setText(String.format("%.3f",liter)+" "+"L");


                    }
                    else if(item.equals("Milliliter") && item2.equals("Centiliter")){
                        float num3 = Float.parseFloat(ans);
                        double centiliter = (num3 /10);
                        tv1.setText(String.format("%.2f",centiliter)+" "+"cL");


                    }
                    else if(item.equals("Centiliter") && item2.equals("Liter")){
                        float num4 = Float.parseFloat(ans);
                        double liter = (num4 /100);
                        tv1.setText(String.format("%.2f",liter)+" "+"L");

                    }
                    else if(item.equals("Centiliter") && item2.equals("Milliliter")){
                        float num4 = Float.parseFloat(ans);
                        double milliliter = (num4 *10);
                        tv1.setText(String.format("%.2f",milliliter)+" "+"ml");

                    }
                    else if(item.equals("Liter") && item2.equals("Liter")){
                        Toast.makeText(VolumeConverter.this,"Invalid Selection",Toast.LENGTH_SHORT).show();


                    }
                    else if(item.equals("Milliliter") && item2.equals("Milliliter")){
                        Toast.makeText(VolumeConverter.this,"Invalid Selection",Toast.LENGTH_SHORT).show();


                    }
                    else if(item.equals("Centiliter") && item2.equals("Centiliter")){
                        Toast.makeText(VolumeConverter.this,"Invalid Selection",Toast.LENGTH_SHORT).show();


                    }
                    else if(ans.equals("")){
                        Toast.makeText(VolumeConverter.this,"Enter the value",Toast.LENGTH_SHORT).show();


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