package com.example.films;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Movies[] m;
    Random random = new Random();
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputStream stream = null;
        try {
            stream = getAssets().open("movies.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputStreamReader reader = new InputStreamReader(stream);
        Gson gson = new Gson();
        m = gson.fromJson(reader, Movies[].class);
        tv = findViewById(R.id.textView);
        Log.d("message", m[1].toString());

    }


    public void sendMessage(View view) {
        boolean check = true;

        for (Movies movie: m){
            if (!movie.getView()){
                check = false;
                break;
            }
        }
        if (check){
            Toast toast = Toast.makeText(getApplicationContext(),"Фильмы закончились!",Toast.LENGTH_LONG);
            toast.show();
            tv.setText("");
        }
        else {
            do{
                int n = random.nextInt(10);
                if (m[n].getView() == false){
                    tv.setText(m[n].toString());
                    m[n].setView(true);
                    check = true;
                }
            }
            while(!check);
        }


    }
}