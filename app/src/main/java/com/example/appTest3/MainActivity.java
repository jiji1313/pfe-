package com.example.appTest3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import android.util.Log;

import org.opencv.android.OpenCVLoader;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        OpenCVLoader.initLocal();


        //spinner item
        Spinner spinner=findViewById(R.id.menu);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = parent.getItemAtPosition(position).toString();
                Log.d("Selected Item", selectedItem);


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.d("Nothing Selected", "No item is selected");

            }
        });


        ArrayList<String>arrayList=new ArrayList<>();
        arrayList.add("cnn");
        arrayList.add("yolo");
        arrayList.add("SPP-net");
        arrayList.add("Blitznet");

        ArrayAdapter<String>adapter=
                new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        spinner.setAdapter(adapter);




        //button item
        Button button = findViewById(R.id.button1);

        // Set an OnClickListener for the button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start the second activity
                Intent intent = new Intent(getApplicationContext(), cameraActivity.class);


                // Start the second activity
                startActivity(intent);
                //close the first activity
                finish();

            }});








        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}