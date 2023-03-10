package me.pm.michalmikula.cwiczenie32;

import androidx.annotation.Px;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
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

    int prev_color = 0;

    private void changeColor(int new_color){
        this.prev_color = new_color;
    }

    private int calculateColorDiff(int current_tint, int tint_diff){
        if(current_tint + tint_diff <= 255) {
            if(current_tint + tint_diff >= 0){
                return current_tint + tint_diff;
            } else {
                return current_tint;
            }
        } else if (current_tint - tint_diff <= 255) {
            if(current_tint - tint_diff >= 0){
                return current_tint - tint_diff;
            } else {
                return current_tint;
            }
        } else {
            return current_tint;
        }
    }

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
            nums_arr[i] = rand.nextInt(199) + 1;
        }

        int diff = nums_arr[0] - nums_arr[1];

        ArrayList<TextView> tvs = new ArrayList<TextView>();

        TextView tv = new TextView(this);
        tv.setGravity(1);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_PT, 12f);
        tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        tv.setId(0);

        String text_num = res.getQuantityString(R.plurals.quantity_of_items, nums_arr[0], nums_arr[0]);

        int rand_color = colors.getColor(rand.nextInt(colors.length() - 1), 0);

        tv.setTextColor(rand_color);
        tv.setText(text_num);

        tvs.add(tv);

        this.changeColor(rand_color);

        System.out.println(rand_color);

        for(int i = 1; i < nums_count; i++){

            System.out.printf("Prev color: \n green: %d \t green: %d \t blue: %d \n\n",
                              Color.red(this.prev_color), Color.green(this.prev_color), Color.blue(this.prev_color));

            tv = new TextView(this);
            tv.setGravity(1);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_PT, 12f);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv.setId(i);

            text_num = res.getQuantityString(R.plurals.quantity_of_items, nums_arr[i], nums_arr[i]);

            int color_diff = nums_arr[i] > nums_arr[i-1] ? diff : (nums_arr[i] < nums_arr[i-1] ? -diff : 0);

            System.out.printf("Color value diff: %d\n\n", color_diff);

            int[] color_diffs = {color_diff / 3, color_diff / 3, color_diff / 3};

            System.out.printf("Color value diff (red): %d\n Color value diff (green): %d\n" +
                              "Color value diff (blue): %d\n\n", color_diffs[0], color_diffs[1],
                              color_diffs[2]);

            /*
            int color_red = (Color.red(this.prev_color) + color_diffs[0] >= 255 ? (Color.red(this.prev_color) - color_diffs[0] <= 0 ? (Color.red(this.prev_color)) : Color.red(this.prev_color) - color_diffs[0]) : Color.red(this.prev_color) + color_diffs[0]);
            int color_green = (Color.green(this.prev_color) + color_diffs[1] >= 255 ? (Color.green(this.prev_color) - color_diffs[1] <= 0 ? (Color.green(this.prev_color)) : Color.green(this.prev_color) - color_diffs[1]) : Color.green(this.prev_color) + color_diffs[1]);
            int color_blue = (Color.blue(this.prev_color) + color_diffs[2] >= 255 ? (Color.blue(this.prev_color) - color_diffs[2] <= 0 ? (Color.blue(this.prev_color)) : Color.blue(this.prev_color) - color_diffs[2]) : Color.blue(this.prev_color) + color_diffs[2]);
            */

            /*
            int color_red = Color.red(this.prev_color) + color_diffs[0];
            int color_green = Color.green(this.prev_color) + color_diffs[1];
            int color_blue = Color.blue(this.prev_color) + color_diffs[2];
             */

            int color_red = this.calculateColorDiff(Color.red(this.prev_color), color_diffs[0]);
            int color_green = this.calculateColorDiff(Color.green(this.prev_color), color_diffs[1]);
            int color_blue = this.calculateColorDiff(Color.blue(this.prev_color), color_diffs[2]);

            int new_color = Color.rgb(color_red, color_green, color_blue);

            System.out.printf("New color: \n red: %d \t green: %d \t blue: %d \n\n",
                    Color.red(new_color), Color.green(new_color), Color.blue(new_color));

            tv.setTextColor(new_color);
            tv.setText(text_num);

            tvs.add(tv);

            this.changeColor(new_color);
        }
        colors.recycle();

        LinearLayoutCompat.LayoutParams ltp = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);

        for(int i = 0; i < tvs.size(); i++){
            lt.addView(tvs.get(i), i, ltp);
            System.out.println("Printed");
        }
    }
}