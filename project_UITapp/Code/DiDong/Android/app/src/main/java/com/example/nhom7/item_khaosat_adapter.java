package com.example.nhom7;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class item_khaosat_adapter extends ArrayAdapter<item_khao_sat> {

    private Activity context = null;
    private ArrayList<item_khao_sat> objects=null;
    private int layoutId;

    public item_khaosat_adapter(Activity context, int layoutID, ArrayList<item_khao_sat> objects) {
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
        item_khao_sat item = getItem(position);

        // Get view
        TextView mamon = (TextView) convertView.findViewById(R.id.ma_mon);
        TextView link = (TextView) convertView.findViewById(R.id.link);

        // Set fullname
        if (item.getMamon()!=null) {
            mamon.setText(item.getMamon());
        }
        else mamon.setText("");

        if (item.getLink()!=null) {
            link.setText(item.getLink());
        }
        else link.setText("");



        return convertView;
    }
}