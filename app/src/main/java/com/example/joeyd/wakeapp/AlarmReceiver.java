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

        // accelerometerManager accelerometer = new accelerometerManager(context, MainActivity.instance);

        if (!MainActivity.instance.accelerometer.awake) {
            TextManager.Send("0478057618", "wake me up", context,1);
            MainActivity.instance.accelerometer.awake = false;
            Toast.makeText(context, "Rise and shine!", Toast.LENGTH_LONG).show();
        }
        else if (MainActivity.instance.accelerometer.awake) {
            TextManager.Send("0478057618"," I am awake",context,0);
            MainActivity.instance.accelerometer.awake = false;
            Toast.makeText(context, "You are awake, did you sleep well?", Toast.LENGTH_LONG).show();
        }
    }
}
