package com.example.homework02_program1_colebourbina;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    TextView tv_j_hex;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    Button btn_j_save;
    ListView lv_j_listOfColors;
    int redValue;
    int greenValue;
    int blueValue;
    ConstraintLayout cl_j_main;
    CustomColor currentColor;
    CustomColorAdapter cAdapter;
    ArrayList<CustomColor> listOfColors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Set GUI elements
        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);
        tv_j_hex = findViewById(R.id.tv_v_hex);
        sb_j_red = findViewById(R.id.sb_v_red);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_blue = findViewById(R.id.sb_v_blue);
        btn_j_save = findViewById(R.id.btn_v_save);
        lv_j_listOfColors = findViewById(R.id.lv_v_listOfColors);
        cl_j_main = findViewById(R.id.main);

        listOfColors = new ArrayList<>();

        resetColor();

        saveButtonClickEvent();
        redChangeEvent();
        greenChangeEvent();
        blueChangeEvent();

        cAdapter = new CustomColorAdapter(this, listOfColors);
        lv_j_listOfColors.setAdapter(cAdapter);
        setOnClickListenerForListView();
    }

    private void saveButtonClickEvent() {
        btn_j_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listOfColors.add(currentColor);
                Log.d("Color Values", "Red: " + redValue + ", Green: " + greenValue + ", Blue: " + blueValue);
                cAdapter.notifyDataSetChanged();
                resetColor();
            }
        });
    }

    private void redChangeEvent()
    {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_j_red.setText("Red:  " + progress);
                currentColor = new CustomColor(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress());
                cl_j_main.setBackgroundColor(currentColor.getColor());
                tv_j_hex.setText("Hex Representation: " + currentColor.getHexValue());
                if (currentColor.isDark())
                {
                    tv_j_red.setTextColor(Color.rgb(255,255,255));
                    tv_j_green.setTextColor(Color.rgb(255,255,255));
                    tv_j_blue.setTextColor(Color.rgb(255,255,255));
                    tv_j_hex.setTextColor(Color.rgb(255,255,255));
                }
                else
                {
                    tv_j_red.setTextColor(Color.rgb(0,0,0));
                    tv_j_green.setTextColor(Color.rgb(0,0,0));
                    tv_j_blue.setTextColor(Color.rgb(0,0,0));
                    tv_j_hex.setTextColor(Color.rgb(0,0,0));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void greenChangeEvent()
    {
        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_j_green.setText("Green:  " + progress);
                currentColor = new CustomColor(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress());
                cl_j_main.setBackgroundColor(currentColor.getColor());
                tv_j_hex.setText("Hex Representation: " + currentColor.getHexValue());
                if (currentColor.isDark() == true)
                {
                    tv_j_red.setTextColor(Color.rgb(255,255,255));
                    tv_j_green.setTextColor(Color.rgb(255,255,255));
                    tv_j_blue.setTextColor(Color.rgb(255,255,255));
                    tv_j_hex.setTextColor(Color.rgb(255,255,255));
                }
                else
                {
                    tv_j_red.setTextColor(Color.rgb(0,0,0));
                    tv_j_green.setTextColor(Color.rgb(0,0,0));
                    tv_j_blue.setTextColor(Color.rgb(0,0,0));
                    tv_j_hex.setTextColor(Color.rgb(0,0,0));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void blueChangeEvent()
    {
        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_j_blue.setText("Blue:  " + progress);
                currentColor = new CustomColor(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress());
                cl_j_main.setBackgroundColor(currentColor.getColor());
                tv_j_hex.setText("Hex Representation: " + currentColor.getHexValue());
                if (currentColor.isDark() == true)
                {
                    tv_j_red.setTextColor(Color.rgb(255,255,255));
                    tv_j_green.setTextColor(Color.rgb(255,255,255));
                    tv_j_blue.setTextColor(Color.rgb(255,255,255));
                    tv_j_hex.setTextColor(Color.rgb(255,255,255));
                }
                else
                {
                    tv_j_red.setTextColor(Color.rgb(0,0,0));
                    tv_j_green.setTextColor(Color.rgb(0,0,0));
                    tv_j_blue.setTextColor(Color.rgb(0,0,0));
                    tv_j_hex.setTextColor(Color.rgb(0,0,0));
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void resetColor()
    {
        redValue = 255;
        greenValue = 255;
        blueValue = 255;

        sb_j_red.setProgress(redValue);
        sb_j_green.setProgress(greenValue);
        sb_j_blue.setProgress(blueValue);

        currentColor = new CustomColor(redValue, greenValue, blueValue);

        tv_j_red.setText("Red:  " + redValue);
        tv_j_green.setText("Green:  " + greenValue);
        tv_j_blue.setText("Blue:  " + blueValue);
        tv_j_hex.setText("Hex Representation: " + currentColor.getHexValue());
        cl_j_main.setBackgroundColor(currentColor.getColor());
    }

    private void setOnClickListenerForListView()
    {
        lv_j_listOfColors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                currentColor = listOfColors.get(position);
                setColor(currentColor);
            }
        });
    }

    private void setColor(CustomColor color)
    {
        sb_j_red.setProgress(color.getRedValue());
        sb_j_green.setProgress(color.getGreenValue());
        sb_j_blue.setProgress(color.getBlueValue());

        tv_j_red.setText("Red:  " + color.getRedValue());
        tv_j_green.setText("Green:  " + color.getGreenValue());
        tv_j_blue.setText("Blue:  " + color.getBlueValue());
        tv_j_hex.setText("Hex Representation: " + color.getHexValue());
        cl_j_main.setBackgroundColor(color.getColor());
    }
}