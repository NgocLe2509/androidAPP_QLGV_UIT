package com.example.nhom7;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class item_maudon_adapter extends ArrayAdapter<item_maudon> {
    private Activity context = null;
    private ArrayList<item_maudon> objects=null;
    private int layoutId;

    public item_maudon_adapter(Activity context, int layoutID, ArrayList<item_maudon> objects) {
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
        item_maudon item = getItem(position);

        // Get view
        TextView name = (TextView) convertView.findViewById(R.id.tvID);
        LinearLayout llmaudon = (LinearLayout) convertView.findViewById(R.id.llmaudon);

        // Set fullname
        if (item.getName()!=null) {
            name.setText(item.getName());
        }
        else name.setText("");

        return convertView;
    }

}