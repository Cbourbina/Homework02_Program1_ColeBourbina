package com.example.homework02_program1_colebourbina;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class CustomColorAdapter extends BaseAdapter {
    Context context;
    ArrayList<CustomColor> listOfColors;

    public CustomColorAdapter(Context c, ArrayList<CustomColor> lc)
    {
        context = c;
        listOfColors = lc;
    }

    @Override
    public int getCount() {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int position) {
        return listOfColors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
        {
            LayoutInflater nInflater = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            convertView = nInflater.inflate(R.layout.custom_color_cell, null);
        }

        ConstraintLayout background = convertView.findViewById(R.id.cl_v_cell_background);
        TextView red = convertView.findViewById(R.id.tv_v_cell_red);
        TextView green = convertView.findViewById(R.id.tv_v_cell_green);
        TextView blue = convertView.findViewById(R.id.tv_v_cell_blue);
        TextView hex = convertView.findViewById(R.id.tv_v_cell_hex);

        CustomColor c = listOfColors.get(position);

        red.setText("Red: " + c.getRedValue());
        green.setText("Green: " + c.getGreenValue());
        blue.setText("Blue: " + c.getBlueValue());
        hex.setText("Hex: " + c.getHexValue());
        background.setBackgroundColor(c.getColor());

        if(c.isDark())
        {
            red.setTextColor(Color.rgb(255,255,255));
            green.setTextColor(Color.rgb(255,255,255));
            blue.setTextColor(Color.rgb(255,255,255));
            hex.setTextColor(Color.rgb(255,255,255));
        }
        else
        {
            red.setTextColor(Color.rgb(0,0,0));
            green.setTextColor(Color.rgb(0,0,0));
            blue.setTextColor(Color.rgb(0,0,0));
            hex.setTextColor(Color.rgb(0,0,0));
        }

        return convertView;
    }
}
