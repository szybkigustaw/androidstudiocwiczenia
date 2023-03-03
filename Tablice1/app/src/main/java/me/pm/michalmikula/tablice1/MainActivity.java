package me.pm.michalmikula.tablice1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll = findViewById(R.id.activity_main);


        Resources res = getResources();
        String[] voivodeships = res.getStringArray(R.array.voivodeships);
        int color = res.getColor(R.color.white);

        for (int i = 0; i < voivodeships.length; i++) {
            TextView tv = new TextView(this);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv.setTextColor(color);
            tv.setTextSize(16f);
            tv.setPadding(0, 25, 25, 0);
            tv.setGravity(Gravity.CENTER_VERTICAL);
            tv.setText(voivodeships[i]);

            ll.addView(tv);
        }
    }
}