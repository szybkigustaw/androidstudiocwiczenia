package me.pm.michalmikula.cwiczenie31;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.icu.text.PluralFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

import java.text.Format;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.layout);

        TextView tv = new TextView(this);
        tv.setGravity(Gravity.CENTER);
        tv.setPadding(450,800,0,0);
        tv.setTextSize(32.0f);

        Resources res = getResources();

        int[] nums = new int[7];

        Random rand = new Random();

        for(int i = 0; i < nums.length; i++){
            nums[i] = rand.nextInt(98) + 1;
        }


        String[] nums_texts = new String[]{
                res.getQuantityString(R.plurals.quantity_of_items, nums[0], nums[0]),
                res.getQuantityString(R.plurals.quantity_of_items, nums[1], nums[1]),
                res.getQuantityString(R.plurals.quantity_of_items, nums[2], nums[2]),
                res.getQuantityString(R.plurals.quantity_of_items, nums[3], nums[3]),
                res.getQuantityString(R.plurals.quantity_of_items, nums[4], nums[4]),
                res.getQuantityString(R.plurals.quantity_of_items, nums[5], nums[5]),
                res.getQuantityString(R.plurals.quantity_of_items, nums[6], nums[6]),
        };

        String concat_string = "";

        for(String nums_text : nums_texts){
            concat_string += nums_text + ", ";
        }

        tv.setText(concat_string);
        layout.addView(tv);
    }
}