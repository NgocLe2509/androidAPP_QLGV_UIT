package com.example.nhom7;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class item_schedual_adapter  extends ArrayAdapter<item_schedual> {
    private Activity context = null;
    private ArrayList<item_schedual> objects=null;
    private int layoutId;

    public item_schedual_adapter(Activity context, int layoutID, ArrayList<item_schedual> objects) {
        super(context, layoutID, objects);
        this.context = context;
        this.layoutId = layoutID;
        this.objects = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutId, null);
        }

        // Get item
        item_schedual item = getItem(position);

        // Get view
        TextView name = (TextView) convertView.findViewById(R.id.tvName);
        TextView id = (TextView) convertView.findViewById(R.id.tvID);
        TextView day = (TextView) convertView.findViewById(R.id.tvDay);
        TextView time = (TextView) convertView.findViewById(R.id.tvTime);
        TextView room = (TextView) convertView.findViewById(R.id.tvRoom);
        TextView GV = (TextView) convertView.findViewById(R.id.tvGV);

        // Set fullname
        if (item.getName()!=null) {
            name.setText(item.getName());
        }
        else name.setText("");

        if (item.getID()!=null) {
            id.setText(item.getID());
        }
        else id.setText("");

        if (item.getDay()!=null) {
            day.setText(item.getDay());
        }
        else day.setText("");

        if (item.getTime()!=null) {
            time.setText(item.getTime());
        }
        else time.setText("");

        if (item.getRoom()!=null) {
            room.setText(item.getRoom());
        }
        else room.setText("");

        if (item.getGV()!=null) {
            GV.setText(item.getGV());
        }
        else GV.setText("");

        return convertView;
    }
}
