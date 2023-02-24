package me.pm.michalmikula.napisy5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);

        TextView tv = new TextView(this);
        tv.setGravity(Gravity.CENTER);
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv.setPadding(450,800,0,0);

        TextView tv2 = new TextView(this);
        tv2.setGravity(Gravity.CENTER);
        tv2.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv2.setPadding(450,1000,0, 0);

        Resources res = getResources();
        CharSequence label = res.getString(R.string.label);
        int color_red = res.getColor(R.color.red);
        int color_orange = res.getColor(R.color.orange);
        int font_size = res.getInteger(R.integer.font_size);
        String form_label = String.format("<b>%s</b>", label);
        String form_label2 = String.format("<i>%s</i>", label);

        tv.setTextSize((float) font_size);
        tv2.setTextSize((float) font_size);

        tv.setTextColor(color_red);
        tv2.setTextColor(color_orange);

        tv.setText(Html.fromHtml(form_label, Html.FROM_HTML_MODE_COMPACT));
        tv2.setText(Html.fromHtml(form_label2,Html.FROM_HTML_MODE_COMPACT));

        layout.addView(tv);
        layout.addView(tv2);
    }
}