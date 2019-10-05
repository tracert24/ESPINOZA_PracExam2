package com.espinoza.pracexam2_espinoza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    CheckBox sv_01, sv_02, sv_03, sv_04, sv_05, sv_06, sv_07, sv_08;
    EditText cm_01;
    Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv_01 = findViewById(R.id.sv1);
        sv_02 = findViewById(R.id.sv2);
        sv_03 = findViewById(R.id.sv3);
        sv_04 = findViewById(R.id.sv4);
        sv_05 = findViewById(R.id.sv5);
        sv_06 = findViewById(R.id.sv6);
        sv_07 = findViewById(R.id.sv7);
        sv_08 = findViewById(R.id.sv8);
        cm_01 = findViewById(R.id.cm1);
        button2 = findViewById(R.id.button2);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivitySecond.class));
            }
        });
    }

    public void writeData (View v){
        String data9 = cm_01.getText().toString()+"";

        FileOutputStream writer = null;
        try {
            writer = openFileOutput("data2.txt", MODE_PRIVATE);
            writer.write(data9.getBytes());
        } catch (FileNotFoundException e) {
            Log.d("error", "Subject not found.");
        } catch (IOException e) {
            Log.d("error", "IO Error.");
        } finally {
            try {
                writer.close();

            } catch (IOException e) {
                Log.d("error", "Subject not found");
            }
        }
        writer = null;

        try {
            writer = openFileOutput("data1.txt", MODE_PRIVATE);

            if (sv_01.isChecked()){
                writer.write((sv_01.getText().toString()+',').getBytes());
            }
            if (sv_02.isChecked()){
                writer.write((sv_02.getText().toString()+',').getBytes());
            }
            if (sv_03.isChecked()){
                writer.write((sv_03.getText().toString()+',').getBytes());
            }
            if (sv_04.isChecked()){
                writer.write((sv_04.getText().toString()+',').getBytes());
            }
            if (sv_05.isChecked()){
                writer.write((sv_05.getText().toString()+',').getBytes());
            }
            if (sv_06.isChecked()){
                writer.write((sv_06.getText().toString()+',').getBytes());
            }
            if (sv_07.isChecked()){
                writer.write((sv_07.getText().toString()+',').getBytes());
            }
            if (sv_08.isChecked()){
                writer.write((sv_08.getText().toString()+',').getBytes());
            }
        } catch (FileNotFoundException e) {
            Log.d("error", "Subject not found.");
        } catch (IOException e) {
            Log.d("error", "IO Error.");
        } finally {
            try {
                writer.close();

            } catch (IOException e) {
                Log.d("error", "Subject not found");
            }
        }
        Toast.makeText(this, "Data saved...", Toast.LENGTH_LONG).show();
    }
}
