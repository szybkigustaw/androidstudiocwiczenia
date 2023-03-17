package me.pm.michalmikula.tablice3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TableLayout layout = findViewById(R.id.main);


        Resources res = getResources();
        String[] voivodeships = res.getStringArray(R.array.voivodeships);
        int[][] populations = {res.getIntArray(R.array.population_in_2018), res.getIntArray(R.array.population_in_2020)};

        for(int i = 0; i < voivodeships.length; i++){
          TableRow tr = new TableRow(this);
          tr.setBackgroundColor(res.getColor(R.color.black));

          TextView voivodeship = new TextView(this);
          voivodeship.setTextColor(res.getColor(R.color.white));
          voivodeship.setPadding(4,4,4,4);
          voivodeship.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
          voivodeship.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
          voivodeship.setText(voivodeships[i]);
          tr.addView(voivodeship);

          TextView population_2018 = new TextView(this);
          population_2018.setTextColor(res.getColor(R.color.white));
          population_2018.setPadding(4,4,4,4);
          population_2018.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
          population_2018.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
          population_2018.setText(Html.fromHtml(String.format(new Locale("pl"),"<b>%d</b>",populations[0][i])));
          tr.addView(population_2018);

          TextView population_2020 = new TextView(this);
          population_2020.setTextColor(res.getColor(R.color.white));
          population_2020.setPadding(4,4,4,4);
          population_2020.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
          population_2020.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
          population_2020.setText(Html.fromHtml(String.format(new Locale("pl"), "<b>%d</b>", populations[1][i])));
          tr.addView(population_2020);

          String population_diff = populations[0][i] > populations[1][i] ? String.format(new Locale("pl"),"<i>-%d</i>",populations[0][i] - populations[1][i]) : String.format(new Locale("pl"),"<i>+%d</i>",populations[1][i] - populations[0][i]);
          TextView diff = new TextView(this);
          diff.setTextColor(res.getColor(R.color.white));
          diff.setPadding(4,4,4,4);
          diff.setTextSize(TypedValue.COMPLEX_UNIT_SP, 11);
          diff.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
          diff.setText(Html.fromHtml(population_diff));
          tr.addView(diff);

          layout.addView(tr);
        }
    }
}