package com.example.joeyd.wakeapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Mathias on 7/01/2016.
 */
public class AlarmReceiver extends BroadcastReceiver {
    Context context;

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Checking if awake.", Toast.LENGTH_LONG).show();
        this.context = context;
        wakeMethod();
    }

    protected void wakeMethod() {
        accelerometerManager accelerometer = new accelerometerManager(context, (Activity)context);
        if (!accelerometer.awake) {
            TextManager.Send("0478057618", "wake me up", context);
        }
    }
}
