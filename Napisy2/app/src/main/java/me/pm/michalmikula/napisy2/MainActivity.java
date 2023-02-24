package me.pm.michalmikula.napisy2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.napis);

        Random rand = new Random();
        int red = rand.nextInt(255);
        int green = rand.nextInt(255);
        int blue = rand.nextInt(255);

        textView.setTextColor(Color.rgb(red, green, blue));
    }
}