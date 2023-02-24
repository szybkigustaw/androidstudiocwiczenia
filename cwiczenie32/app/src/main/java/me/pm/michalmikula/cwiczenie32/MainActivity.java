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

        for(int i = 0; i < nums_arr.length - 1; i++){
            for(int j = i+1; j < nums_arr.length; j++){
                if(nums_arr[j] > nums_arr[i]){
                    int mem = nums_arr[i];
                    nums_arr[i] = nums_arr[j];
                    nums_arr[j] = mem;
                }
            }
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

        int highest_value = nums_arr[0];
        int lowest_value = nums_arr[0];
        int highest_color = rand_color;
        int lowest_color = rand_color;

        System.out.println(rand_color);

        for(int i = 1; i < nums_count; i++){

            System.out.printf("\nHV: %d \n LV: %d \n HC: %d \n LC: %d \n", highest_value, lowest_value, highest_color, lowest_color);

            tv = new TextView(this);
            tv.setGravity(1);
            tv.setTextSize(TypedValue.COMPLEX_UNIT_PT, 12f);
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            tv.setId(i);

            text_num = res.getQuantityString(R.plurals.quantity_of_items, nums_arr[i], nums_arr[i]);

            int color_diff = nums_arr[i] > highest_value ? diff : (nums_arr[i] < lowest_value ? -diff : 0) * 3; //Amplituda 3 - dla wyraźniejszej różnicy w odcieniach barw
            int last_color = nums_arr[i] > highest_value ? highest_color : lowest_color;

            int color_red = Color.red(last_color) + color_diff;
            int color_green = Color.green(last_color) + color_diff;
            int color_blue = Color.blue(last_color) + color_diff;

            int new_color = Color.rgb(color_red, color_green, color_blue);

            tv.setTextColor(new_color);
            tv.setText(text_num);

            tvs.add(tv);

            highest_color = nums_arr[i] > highest_value ? new_color : highest_color;
            lowest_color = nums_arr[i] < lowest_value ? new_color : lowest_color;
            highest_value = nums_arr[i] > highest_value ? nums_arr[i] : highest_value;
            lowest_value = nums_arr[i] < lowest_value ? nums_arr[i] : lowest_value;

        }
        colors.recycle();

        LinearLayoutCompat.LayoutParams ltp = new LinearLayoutCompat.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f);

        for(int i = 0; i < tvs.size(); i++){
            lt.addView(tvs.get(i), i, ltp);
            System.out.println("Printed");
        }
    }
}