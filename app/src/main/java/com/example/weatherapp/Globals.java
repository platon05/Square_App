package com.example.weatherapp;

import android.app.Application;

public class Globals extends Application{
    public static  boolean ISREGISTERED = false;

    public void setISREGISTERED(boolean ISREGISTERED1) {
        ISREGISTERED = ISREGISTERED1;
    }

}
