package com.example.demojobintent;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;
import android.widget.Toast;

public class IntentService extends JobIntentService implements SensorEventListener,StepListener {
    private static final String TAG = "ExampleJobIntentService";
    private StepDetector simpleStepDetector;
    private SensorManager sensorManager;
    private Sensor accel;
    private static final String TEXT_NUM_STEPS = "Number of Steps: ";
    SharedPreferences mSharedPreferences;
    boolean isWaitingForSensor=true;
    int numSteps;
    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        numSteps=0;
        simpleStepDetector = new StepDetector();
        simpleStepDetector.registerListener(this);
        sensorManager.registerListener(this, accel, SensorManager.SENSOR_DELAY_FASTEST);
        Log.d(TAG, "Handling work");

/*

        while (isWaitingForSensor)
        {
            try {
                Thread.sleep(100);


            }
            catch (Exception e)
            {

            }
        }
        for (int i=0;i<100;i++) {
            Log.d(TAG, "Printing");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
*/


    }
    static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, IntentService.class, 123, work);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate");
    }

    @Override
    public void onDestroy() {

        super.onDestroy();
        Log.d(TAG, "OnDestroy");
    }

    @Override
    public boolean onStopCurrentWork() {
        Log.d(TAG, "onStopCurrentWork");
        return super.onStopCurrentWork();
    }
    

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "Printing");
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            //Log.d(TAG, "Printing");
           // Toast.makeText(getApplicationContext(),"in sensor :"+numSteps,Toast.LENGTH_SHORT).show();

            simpleStepDetector.updateAccel(
                    event.timestamp, event.values[0], event.values[1], event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void step(long timeNs) {
        numSteps++;

/*
        numSteps++;
        SharedPreferences.Editor editor=mSharedPreferences.edit();
        editor.putString("Value", String.valueOf(numSteps));
        editor.commit();
        */
/*if(active==true)
        {
            tv_steps.setText(TEXT_NUM_STEPS +mSharedPreferences.getString("Value",""));
        }*//*

        Log.d(TAG, +numSteps);

        Toast.makeText(getApplicationContext(),"Steps :"+numSteps,Toast.LENGTH_SHORT).show();
*/

        Toast.makeText(getApplicationContext(),"Steps :"+numSteps,Toast.LENGTH_SHORT).show();
        Log.d(TAG,"" +numSteps);
    }
}
