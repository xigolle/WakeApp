package com.example.joeyd.wakeapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by mathias on 7/01/2016.
 */
public class checkTime extends IntentService {


    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public checkTime(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            Calendar cal = Calendar.getInstance();
            int hour = cal.get(Calendar.HOUR_OF_DAY);
            int minute = cal.get(Calendar.MINUTE);
            int second = cal.get(Calendar.SECOND);
            String time = hour + ":" + minute + ":" + second;
            Log.i("Debug", time);
        }
    }
}
