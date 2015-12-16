package com.example.joeyd.wakeapp;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by joeyd on 15-12-2015.
 * constructor expects a phone number and a text message
 * after object is created you can use the method send to send the text message which is saved in the object through the constructor
 */
public class TextManager extends BroadcastReceiver{

    static final SmsManager sms = SmsManager.getDefault();

    private SmsMessage createFromPdu(byte[] pduobj,String format){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return SmsMessage.createFromPdu(pduobj,format);
        }else{
            return SmsMessage.createFromPdu(pduobj);
        }
    }


    static public  void Send(String number ,String text,Context context){
        //send SMS to the phone number with specified Text
        String secretAppCode = "#WakeApp";
        try{
            sms.sendTextMessage(number, null, text+secretAppCode, null, null);
            Toast toast = Toast.makeText(context,"SMS verstuurd",Toast.LENGTH_SHORT);
        }catch (Exception e){
            Toast toast = Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG);
        }

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //when sms is received
    }
}
