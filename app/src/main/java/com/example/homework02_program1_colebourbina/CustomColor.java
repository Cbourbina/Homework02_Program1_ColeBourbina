package com.example.homework02_program1_colebourbina;

import android.graphics.Color;

public class CustomColor {
    private int redValue;
    private int greenValue;
    private int blueValue;
    private String hexValue;
    private int color;

    public CustomColor() {
    }

    public CustomColor(int red, int green, int blue) {
        redValue = red;
        greenValue = green;
        blueValue = blue;
        hexValue = convertToHex(red, green, blue);
        color = Color.rgb(redValue, greenValue, blueValue);
    }

    public int getRedValue() {
        return redValue;
    }

    public void setRedValue(int redValue) {
        this.redValue = redValue;
    }

    public int getGreenValue() {
        return greenValue;
    }

    public void setGreenValue(int greenValue) {
        this.greenValue = greenValue;
    }

    public int getBlueValue() {
        return blueValue;
    }

    public void setBlueValue(int blueValue) {
        this.blueValue = blueValue;
    }

    public String getHexValue() {
        return hexValue;
    }

    public int getColor() {
        return color;
    }

    public boolean isDark() {
        float[] hsb = new float[3];
        Color.colorToHSV(color, hsb);
        float brightness = hsb[2];
        if (brightness >= 0.5f)
        {
            return false;
        }
        else
        {
            return true;
        }
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