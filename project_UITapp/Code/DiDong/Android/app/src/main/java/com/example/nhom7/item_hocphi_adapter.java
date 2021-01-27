package com.example.nhom7;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class item_hocphi_adapter extends ArrayAdapter<item_hocphi> {
    private Activity context = null;
    private ArrayList<item_hocphi> objects=null;
    private int layoutId;

    public item_hocphi_adapter(Activity context, int layoutID, ArrayList<item_hocphi> objects) {
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
        item_hocphi item = getItem(position);

        // Get view
        TextView hocki = (TextView) convertView.findViewById(R.id.tvHocKi);
        TextView somon = (TextView) convertView.findViewById(R.id.tvSoMon);
        TextView dkhp = (TextView) convertView.findViewById(R.id.tvdkhp);
        TextView tong = (TextView) convertView.findViewById(R.id.tvTong);
        TextView dadong = (TextView) convertView.findViewById(R.id.tvDaDong);
        TextView conlai = (TextView) convertView.findViewById(R.id.tvConLai);
        TextView tai = (TextView) convertView.findViewById(R.id.tvTai);
        TextView thoigian = (TextView) convertView.findViewById(R.id.tvThoiGian);




        if (item.getHocky()!=null) {
            hocki.setText(item.getHocky());
        }
        else hocki.setText("");

        if (item.getSomon()!=null) {
            somon.setText(item.getSomon());
        }
        else somon.setText("");

        if (item.getDkhp()!=null) {
            dkhp.setText(item.getDkhp());
        }
        else dkhp.setText("");

        if (item.getTong()!=null) {
            tong.setText(item.getTong());
        }
        else tong.setText("");

        if (item.getDadong()!=null) {
            dadong.setText(item.getDadong());
        }
        else dadong.setText("");

        if (item.getConlai()!=null) {
            conlai.setText(item.getConlai());
        }
        else conlai.setText("");

        if (item.getTai()!=null) {
            tai.setText(item.getTai());
        }
        else tai.setText("");

        if (item.getThoigian()!=null) {
            thoigian.setText(item.getThoigian());
        }
        else thoigian.setText("");


        return convertView;
    }

}