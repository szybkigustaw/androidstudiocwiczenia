package me.pm.michalmikula.napisy3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = (ConstraintLayout)findViewById(R.id.layout);

        TextView textView = new TextView(this);


        Resources res = getResources();
        CharSequence label = res.getText(R.string.label);
        int color = res.getColor(R.color.red);
        int font_size = res.getInteger(R.integer.font_size);

        textView.setText(label);
        textView.setTextColor(color);
        textView.setGravity(Gravity.CENTER);
        textView.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        textView.setTextSize((float)font_size);

        layout.addView(textView);
    }
}