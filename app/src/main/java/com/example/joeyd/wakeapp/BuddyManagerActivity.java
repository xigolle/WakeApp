package com.example.joeyd.wakeapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class BuddyManagerActivity extends AppCompatActivity {

    public static List<ContactUser> buddyList = new ArrayList<ContactUser>();
    private ListView listView;

    public void goToContacts(View view){
        Intent intent = new Intent(this,ContactManagerActivity.class);
        startActivity(intent);
    }
    public void goToMain(View view){
        Intent intent = new Intent (this,MainActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buddy_manager);
        listView = (ListView) findViewById(R.id.buddyList);


        BuddyListAdapter adapter = new BuddyListAdapter(this,buddyList);

        listView.setAdapter(adapter);
        listView.setEmptyView(findViewById(R.id.emptylist));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                wakeBuddieApp(view,buddyList.get(position).getPhone());
                Log.e("Clicked", "Clicked on" + buddyList.get(position).getPhone());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_buddy_manager, menu);
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

    public void wakeBuddieApp(View view, String number) {
        Context context = getApplicationContext();
        TextManager.Send(number, "I am WAking you up", context,2);
    }
}
