package com.example.joeyd.wakeapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by joeyd on 8-1-2016.
 */
public class BuddyListAdapter extends ArrayAdapter<ContactUser> {
    private final Activity context;
    private final List<ContactUser> ContactUsers;


    public BuddyListAdapter(Activity context,List<ContactUser> ContactUsers){

        super(context,R.layout.buddy_list_layout,ContactUsers);


        this.ContactUsers = ContactUsers;
        this.context= context;


    }
    public View getView(int position,View view,ViewGroup parent){



        LayoutInflater inflater = context.getLayoutInflater();
        View rowView =inflater.inflate(R.layout.buddy_list_layout, null, true);
        TextView buddyName = (TextView) rowView.findViewById(R.id.name);
        ImageView buddyIcon = (ImageView) rowView.findViewById(R.id.image);
        TextView buddyNumber = (TextView) rowView.findViewById(R.id.no);


        buddyName.setText(ContactUsers.get(position).getName());
        buddyNumber.setText(ContactUsers.get(position).getPhone());
//        if(ContactUsers.get(position).getThumb() != null){
//            buddyIcon.setImageBitmap(ContactUsers.get(position).getThumb());
//
//        }
//        else{
//            buddyIcon.setImageResource(R.drawable.image);
//        }
//        buddyIcon.setImageResource(R.drawable.image);


        return rowView;
    }

}
