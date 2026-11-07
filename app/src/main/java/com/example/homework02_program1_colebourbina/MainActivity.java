package com.example.homework02_program1_colebourbina;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    TextView tv_j_hex;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    Button btn_j_save;
    int redValue;
    int greenValue;
    int blueValue;
    ConstraintLayout cl_j_main;

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
        cl_j_main = findViewById(R.id.main);

        saveButtonClickEvent();
        redChangeEvent();
        greenChangeEvent();
        blueChangeEvent();
        tv_j_hex.setText(convertToHex(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress()));
    }

    private void saveButtonClickEvent() {
        btn_j_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redValue = sb_j_red.getProgress();
                greenValue = sb_j_green.getProgress();
                blueValue = sb_j_blue.getProgress();
                Log.d("Color Values", "Red: " + redValue + ", Green: " + greenValue + ", Blue: " + blueValue);
                int savedColor = Color.rgb(redValue, greenValue, blueValue);
            }
        });
    }

    private void redChangeEvent()
    {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_j_red.setText("Red:  " + progress);
                int currentColor = Color.rgb(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress());
                cl_j_main.setBackgroundColor(currentColor);
                tv_j_hex.setText(convertToHex(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress()));
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
                int currentColor = Color.rgb(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress());
                cl_j_main.setBackgroundColor(currentColor);
                tv_j_hex.setText(convertToHex(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress()));
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
                int currentColor = Color.rgb(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress());
                cl_j_main.setBackgroundColor(currentColor);
                tv_j_hex.setText(convertToHex(sb_j_red.getProgress(), sb_j_green.getProgress(), sb_j_blue.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private String convertToHex(int red, int green, int blue)
    {
        String hexVal;
        int hexValOne = (red / 16);
        int hexValTwo = (red % 16);
        hexVal = hexValueString(hexValOne) + hexValueString(hexValTwo);
        hexValOne = (green / 16);
        hexValTwo = (green % 16);
        hexVal += hexValueString(hexValOne) + hexValueString(hexValTwo);
        hexValOne = (blue / 16);
        hexValTwo = (blue % 16);
        hexVal += hexValueString(hexValOne) + hexValueString(hexValTwo);
        return hexVal;
    }

    private String hexValueString(int value)
    {
        if (value == 10)
        {
            return "A";
        }
        else if (value == 11)
        {
            return "B";
        }
        else if (value == 12)
        {
            return "C";
        }
        else if (value == 13)
        {
            return "D";
        }
        else if (value == 14)
        {
            return "E";
        }
        else if (value == 15)
        {
            return "F";
        }
        else return Integer.toString(value);
    }
}