package com.example.joeyd.wakeapp;

import android.app.AlertDialog;
import android.content.Context;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by joeyd on 15-12-2015.
 * constructor expects a phone number and a text message
 * after object is created you can use the method send to send the text message which is saved in the object through the constructor
 */
public class sendText {
    private String smsText;
    private String phoneNumber;
    public sendText(String number ,String text){
        smsText = text;
        phoneNumber = number;
    }
    public  void Send(){
        try{
            SmsManager.getDefault().sendTextMessage(phoneNumber,null,smsText,null,null);
            Log.d("werkt dit ?", "het werkt ");
        }catch (Exception e){
            Log.d("werkt dit ?","het werkt niet ");
        }

    }
}
