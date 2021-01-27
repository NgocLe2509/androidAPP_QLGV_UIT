package com.example.nhom7;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.view.View.OnClickListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class item_deadline_adapter extends ArrayAdapter<item_deadline> {
    private Activity context = null;
    private ArrayList<item_deadline> objects=null;
    private int layoutId;
    private String userid;
    private String sttbainop;
    customButtonListener customListner;

    private item_deadline item;

    public item_deadline_adapter(Activity context, int layoutID, ArrayList<item_deadline> objects, String userid) {
        super(context, layoutID, objects);
        this.context = context;
        this.layoutId = layoutID;
        this.objects = objects;
        this.userid = userid;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layoutId, null);
            viewHolder = new ViewHolder();
            viewHolder.btnXoa = (Button) convertView.findViewById(R.id.btnXoa);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Get item
        item = getItem(position);


        // Get view
        viewHolder.tvMaLop = (TextView) convertView.findViewById(R.id.tvMaLop);
        viewHolder.tvNoiDung = (TextView) convertView.findViewById(R.id.tvNoiDung);
        viewHolder.tvDeadline = (TextView) convertView.findViewById(R.id.tvDeadline);
        viewHolder.tvHanNop = (TextView) convertView.findViewById(R.id.tvHanNop);
        viewHolder.tvNopBai = (TextView) convertView.findViewById(R.id.tvNopBai);
        viewHolder.tvFilename = (TextView) convertView.findViewById(R.id.tvFilename);
        viewHolder.btnNop = (Button) convertView.findViewById(R.id.btnNop);
        viewHolder.btnXoa = (Button) convertView.findViewById(R.id.btnXoa);


        if (item.getMalop()!=null) {
            viewHolder.tvMaLop.setText(item.getMalop());
        }
        else viewHolder.tvMaLop.setText("");

        if (item.getNoidung()!=null) {
            viewHolder.tvNoiDung.setText(item.getNoidung());
        }
        else viewHolder.tvNoiDung.setText("");

        if (item.getDeadline()!=null) {
            viewHolder.tvDeadline.setText(item.getDeadline());
        }
        else viewHolder.tvDeadline.setText("");

        if (item.getHanchot()!=null) {
            viewHolder.tvHanNop.setText(item.getHanchot());
        }
        else viewHolder.tvHanNop.setText("");

        if (item.getNopbai()!=null) {
            viewHolder.tvNopBai.setText(item.getNopbai());
        }
        else viewHolder.tvNopBai.setText("");

        String filename = item.getFilename();
        if(filename.equals("null")){
            viewHolder.tvFilename.setVisibility(View.GONE);
            viewHolder.btnNop.setVisibility(View.VISIBLE);
            viewHolder.btnXoa.setVisibility(View.GONE);
        }
        else {
            viewHolder.tvFilename.setVisibility(View.VISIBLE);
            viewHolder.btnNop.setVisibility(View.GONE);
            viewHolder.btnXoa.setVisibility(View.VISIBLE);
            if (item.getFilename()!=null) {
                viewHolder.tvFilename.setText(item.getFilename());
            }
            else viewHolder.tvFilename.setText("");
        }

        if(item.getHanchot().equals("Hết hạn")){
            viewHolder.btnNop.setVisibility(View.GONE);
            viewHolder.btnXoa.setVisibility(View.GONE);
        }

        sttbainop = item.getSttbainop();

        viewHolder.btnXoa.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (customListner != null) {
                    customListner.onButtonClickListner(position);
                    viewHolder.tvFilename.setVisibility(View.GONE);
                    viewHolder.tvFilename.setText("");
                    viewHolder.btnXoa.setVisibility(View.GONE);
                    viewHolder.btnNop.setVisibility(View.VISIBLE);
                }

            }
        });
        viewHolder.btnNop.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (customListner != null) {
                    customListner.onButtonADDClickListner(position);
                    viewHolder.tvFilename.setText(item.getFilename());
                    viewHolder.tvFilename.setVisibility(View.VISIBLE);
                    viewHolder.btnXoa.setVisibility(View.VISIBLE);
                    viewHolder.btnNop.setVisibility(View.GONE);
                }

            }
        });




        return convertView;
    }



    public interface customButtonListener {
        public void onButtonClickListner(int position);
        public void onButtonADDClickListner(int position);
    }
    public void setCustomButtonListner(customButtonListener listener) {
        this.customListner = listener;
    }
    public class ViewHolder {
        public TextView tvMaLop;
        public TextView tvNoiDung;
        public TextView tvDeadline;
        public TextView tvHanNop;
        public TextView tvNopBai;
        public TextView tvFilename;
        public Button btnNop;
        Button btnXoa;
    }

}