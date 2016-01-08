package com.example.joeyd.wakeapp;

import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
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
    static String secretAppCode = "#WakeApp";
    static String IamAwake = "#Awake";
    static String WakeUp = "#WakeApp";
    private SmsMessage createFromPdu(byte[] pduobj,String format){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return SmsMessage.createFromPdu(pduobj,format);
        }else{
            return SmsMessage.createFromPdu(pduobj);
        }
    }


    static public  void Send(String number ,String text,Context context,Boolean Awake){
        //send SMS to the phone number with specified Text
        if(Awake){
            secretAppCode = IamAwake;
        }else{
            secretAppCode = WakeUp;
        }
        try{
            sms.sendTextMessage(number, null, text + " " + secretAppCode, null, null);
            Toast toast = Toast.makeText(context,"SMS verstuurd",Toast.LENGTH_SHORT);
            toast.show();

        }catch (Exception e){
            Toast toast = Toast.makeText(context,e.getMessage(),Toast.LENGTH_LONG);
            toast.show();
        }

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //when sms is received
        final Bundle bundle = intent.getExtras();
        if(bundle !=null){
            final Object[] pduObj = (Object[]) bundle.get("pdus");
            for ( int i =0; i<pduObj.length; i++){
                SmsMessage currentMessage = createFromPdu((byte[]) pduObj[i], bundle.getString("format"));
                String textMessage = currentMessage.getDisplayMessageBody();
                AudioManager am = (AudioManager) context.getSystemService(context.AUDIO_SERVICE);

                Uri defaultAlarmRingtone = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                final MediaPlayer mp = MediaPlayer.create(context,defaultAlarmRingtone);

                //check of de tijd verstreken is nadat de persoon wakker mag worden
                //check of de persoon al wakker is geworden zo niet Wekken.
                if(textMessage.toLowerCase().indexOf(WakeUp.toLowerCase()) != -1){
                    //persoon moet gewekt worden
                    am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC),0);
                    Toast toast = Toast.makeText(context,"Going to wake you up!",Toast.LENGTH_SHORT);
                    mp.start();
                }else if(textMessage.toLowerCase().indexOf(IamAwake.toLowerCase()) != -1){
                    //persoon is wakker en moet lijst geupdate worden
                    //TODO Check of het nummer in de buddy lijst zit zo ja update dat de persoon wakker is
                }
            }
        }
        Toast.makeText(context,"Intent Detected",Toast.LENGTH_LONG).show();
    }
}
