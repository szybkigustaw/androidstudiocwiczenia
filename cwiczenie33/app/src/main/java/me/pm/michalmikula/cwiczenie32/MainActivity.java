package me.pm.michalmikula.cwiczenie32;

import androidx.annotation.Px;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutCompat lt = findViewById(R.id.main);

        Resources res = getResources();
        TypedArray colors = res.obtainTypedArray(R.array.colors);

        Random rand = new Random();
        int nums_count = res.getInteger(R.integer.array_size);

        int[] nums_arr = new int[nums_count];

        for(int i = 0; i < nums_count; i++){
            nums_arr[i] = rand.nextInt(50) + 1;
        }

        ArrayList<TextView> tvs = new ArrayList<TextView>();

        for(int i = 0; i < nums_count; i++){

            TextView tv = new TextView(this);
            tv.setGravity(1);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_PT, 12f);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv.setId(i);

            String text_num = res.getQuantityString(R.plurals.quantity_of_items, nums_arr[i], nums_arr[i]);


            int rand_color = rand.nextInt(colors.length() - 1);

            tv.setTextColor(colors.getColor(rand_color, 0));
            tv.setText(text_num);

            tvs.add(tv);
        }
        colors.recycle();

        LinearLayoutCompat.LayoutParams ltp = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);

        for(int i = 0; i < tvs.size(); i++){
            lt.addView(tvs.get(i), i, ltp);
            System.out.println("Printed");
        }
    }
}