package me.pm.michalmikula.napisy4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);

        TextView tv = new TextView(this);
        tv.setGravity(Gravity.CENTER);
        tv.setPadding(450,800,0,0);
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        Resources res = getResources();
        CharSequence label = res.getString(R.string.label);
        int color = res.getColor(R.color.red);
        int font_size = res.getInteger(R.integer.font_size);
        String form_label = String.format("<b>%s</b>",(String) res.getString(R.string.label));
        tv.setText(Html.fromHtml(form_label, Html.FROM_HTML_MODE_COMPACT));
        tv.setTextColor(color);
        tv.setTextSize((float) font_size);

        layout.addView(tv);
    }
}