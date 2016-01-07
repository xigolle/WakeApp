package com.example.joeyd.wakeapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


public class MainActivity extends AppCompatActivity /* implements SensorEventListener*/ {

    accelerometerManager accelerometer;

    //TextView timeTxtView;
    checkTime timeCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //how to call the send function
        //TextManager.Send("0487174475","testing",this);

        accelerometer = new accelerometerManager(this.getApplicationContext(), this);

        //getTime.execute();
        timeCheck = new checkTime("name");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /*AsyncTask getTime = new AsyncTask<Object, String, String>() {
        @Override
        protected String doInBackground(Object... params) {

            for (int i = 0; i < 0; i++) {
                Calendar cal = Calendar.getInstance();
                int hour = cal.get(Calendar.HOUR_OF_DAY);
                int minute = cal.get(Calendar.MINUTE);
                int second = cal.get(Calendar.SECOND);
                String time = hour + ":" + minute + ":" + second;
                Log.i("Debug", time);
                publishProgress(time);
            }
            return "5";
        }

        protected void onProgressUpdate(String... time) {
            timeTxtView = (TextView)findViewById(R.id.time);
            timeTxtView.setText(time.toString());
        }

        protected void onPostExecute(String time) {
            timeTxtView = (TextView)findViewById(R.id.time);
            timeTxtView.setText(time);
        }
    };

    public void setTime(View v) {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);
        String time = hour + ":" + minute + ":" + second;
        TextView timeTxt = (TextView)findViewById(R.id.time);
        timeTxt.setText(time);


    }*/
}
