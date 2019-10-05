package com.espinoza.pracexam2_espinoza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivitySecond extends AppCompatActivity {

    TextView reqsubj, comments;

    public void PrevPage(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void ViewData(View view){
        comments.getText().toString();
        Toast.makeText(this, "Request sent...", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_second);
        FileInputStream fin = null;
        reqsubj = findViewById(R.id.textView3);
        comments = findViewById(R.id.textView4);


        try {
            fin = openFileInput("data1.txt");
            int token;
            String temp = "";
            while ((token = fin.read()) != -1){
                temp = temp + ((char)token);
            }
            fin.close();
            try {
                String[] list = temp.split("_");
                String[] list2 = list[0].split(",");
                for(int i=0; i < list2.length; i++) {
                    reqsubj.append(list2[i] + "\n");
                }

            } catch (Exception e) {
                Log.d("error", "empty strings");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fin = openFileInput("data2.txt");
            int token;
            String temp = "";
            while ((token = fin.read()) != -1){
                temp = temp + ((char)token);
            }
            fin.close();
            try {
                String[] list = temp.split("_");
                comments.setText(list[0]);

            } catch (Exception e) {
                Log.d("error", "empty strings");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
