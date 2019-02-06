package com.example.demojobintent;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static int numSteps;
    SharedPreferences mSharedPreferences;
    public static final String mypreference = "mypref";
    private static final String TEXT_NUM_STEPS = "Number of Steps: ";

    public static TextView tv_steps;
    Button bt_clear;
    public static boolean active = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent serviceIntent = new Intent(this, IntentService.class);
        IntentService.enqueueWork(this,serviceIntent);
    }
}
