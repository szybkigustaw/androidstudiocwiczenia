package me.pm.michalmikula.tablice4;

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
          voivodeship.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
          voivodeship.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
          voivodeship.setText(voivodeships[i]);
          tr.addView(voivodeship);

          TextView population_2018 = new TextView(this);
          population_2018.setTextColor(res.getColor(R.color.white));
          population_2018.setPadding(4,4,4,4);
          population_2018.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
          population_2018.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

          String population_2018_format = String.format(new Locale("pl"),"<b>%s</b>", res.getQuantityString(R.plurals.quantity_of_people, populations[0][i], populations[0][i]));

          population_2018.setText(Html.fromHtml(population_2018_format));
          tr.addView(population_2018);

          TextView population_2020 = new TextView(this);
          population_2020.setTextColor(res.getColor(R.color.white));
          population_2020.setPadding(4,4,4,4);
          population_2020.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
          population_2020.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

          String population_2020_format = String.format(new Locale("pl"),"<b>%s</b>", res.getQuantityString(R.plurals.quantity_of_people, populations[1][i], populations[1][i]));

          population_2020.setText(Html.fromHtml(population_2020_format));
          tr.addView(population_2020);

          int population_diff = populations[0][i] > populations[1][i] ? populations[0][i] - populations[1][i] : populations[1][i] - populations[0][i];
          char diff_sign = populations[0][i] > populations[1][i] ? '-' : '+';
          TextView diff = new TextView(this);
          diff.setTextColor(diff_sign == '-' ? res.getColor(R.color.red) : res.getColor(R.color.green));
          diff.setPadding(4,4,4,4);
          diff.setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
          diff.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

          String population_diff_format = String.format(new Locale("pl"), "<i>%c%s</i>", diff_sign, res.getQuantityString(R.plurals.quantity_of_people, population_diff, population_diff));

          diff.setText(Html.fromHtml(population_diff_format));
          tr.addView(diff);

          layout.addView(tr);
        }
    }
}