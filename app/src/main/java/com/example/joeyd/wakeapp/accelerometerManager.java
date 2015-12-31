package com.example.joeyd.wakeapp;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.widget.TextView;


/**
 * Created by mathias on 31/12/2015.
 */


public class accelerometerManager implements SensorEventListener {

    private Context context;
    private Activity activity;
    private SensorManager senSensorManager;
    private Sensor senAccelerometer;
    private long lastUpdate = 0;
    private float last_x, last_y, last_z;
    private static final int SHAKE_THRESHOLD = 100;
    private boolean smsSend = false;

    public accelerometerManager(Context context, Activity activity) {

        this.context = context;
        this.activity = activity;

        senSensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senSensorManager.registerListener(this, senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor mySensor = event.sensor;

        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            long curTime = System.currentTimeMillis();

            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;

                float speed = Math.abs(x + y + z - last_x - last_y - last_z)/ diffTime * 10000;

                if (speed > SHAKE_THRESHOLD) {
                    TextView xText = (TextView) activity.findViewById(R.id.x);
                    TextView yText = (TextView) activity.findViewById(R.id.y);
                    TextView zText = (TextView) activity.findViewById(R.id.z);
                    xText.setText("x: " + String.valueOf(x));
                    yText.setText("y: " + String.valueOf(y));
                    zText.setText("z: " + String.valueOf(z));
                    if (!smsSend){
                        TextManager.Send("0478057618", "Ik ben wakker", context);
                        smsSend = true;
                    }
                }

                last_x = x;
                last_y = y;
                last_z = z;
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
