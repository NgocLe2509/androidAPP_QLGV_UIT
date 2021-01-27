package com.example.nhom7;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class item_score_adapter extends ArrayAdapter<item_score> {
    private Activity context = null;
    private ArrayList<item_score> objects=null;
    private int layoutId;

    public item_score_adapter(Activity context, int layoutID, ArrayList<item_score> objects) {
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
        item_score item = getItem(position);

        // Get view
        TextView tvMaMon = (TextView) convertView.findViewById(R.id.tvMaLop);
        TextView tvMaLop = (TextView) convertView.findViewById(R.id.tvMaLop);
        TextView tvTC = (TextView) convertView.findViewById(R.id.tvTC);
        TextView tvQT = (TextView) convertView.findViewById(R.id.tvQT);
        TextView tvTH = (TextView) convertView.findViewById(R.id.tvTH);
        TextView tvGK = (TextView) convertView.findViewById(R.id.tvGK);
        TextView tvCK = (TextView) convertView.findViewById(R.id.tvCK);
        TextView tvTB = (TextView) convertView.findViewById(R.id.tvTB);

        // Set fullname
        if (item.getCK()!=null) {
            tvCK.setText(item.getCK());
        }
        else tvCK.setText("");

        if (item.getMaLop()!=null) {
            tvMaLop.setText(item.getMaLop());
        }
        else tvMaLop.setText("");

        if (item.getMaMH()!=null) {
            tvMaMon.setText(item.getMaMH());
        }
        else tvMaMon.setText("");

        if (item.getTC()!=null) {
            tvTC.setText(item.getTC());
        }
        else tvTC.setText("");

        if (item.getQT()!=null) {
            tvQT.setText(item.getQT());
        }
        else tvQT.setText("");

        if (item.getTH()!=null) {
            tvTH.setText(item.getTH());
        }
        else tvTH.setText("");

        if (item.getGK()!=null) {
            tvGK.setText(item.getGK());
        }
        else tvGK.setText("");

        if (item.getTB()!=null) {
            tvTB.setText(item.getTB());
        }
        else tvTB.setText("");

        return convertView;
    }

}

