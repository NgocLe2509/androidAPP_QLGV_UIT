package com.example.nhom7;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class item_thongbao_adapter extends ArrayAdapter<item_thongbao> {
    private Activity context = null;
    private ArrayList<item_thongbao> objects=null;
    private int layoutId;

    public item_thongbao_adapter(Activity context, int layoutID, ArrayList<item_thongbao> objects) {
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
        item_thongbao item = getItem(position);

        // Get view
        TextView LoaiTB = (TextView) convertView.findViewById(R.id.tvLoaiTB);
        TextView MaLop = (TextView) convertView.findViewById(R.id.tvMaLop);
        TextView TenLop = (TextView) convertView.findViewById(R.id.tvTenLop);
        TextView Time = (TextView) convertView.findViewById(R.id.tvTime);
        TextView Tiet = (TextView) convertView.findViewById(R.id.tvDay);
        TextView Room = (TextView) convertView.findViewById(R.id.tvRoom);
        TextView content = (TextView) convertView.findViewById(R.id.tvContent);

        ImageView imgMaLop = (ImageView) convertView.findViewById(R.id.imgMaLop);
        ImageView imgTenLop = (ImageView) convertView.findViewById(R.id.imgTenLop);
        ImageView imgTime = (ImageView) convertView.findViewById(R.id.imgNgay);
        ImageView imgTiet = (ImageView) convertView.findViewById(R.id.imgTiet);
        ImageView imgRoom = (ImageView) convertView.findViewById(R.id.imgPhong);
        ImageView imgcontent = (ImageView) convertView.findViewById(R.id.imgNoiDung);


        String loaitb = item.getLoaiTB();

        if (item.getMaLop()!=null) {
            MaLop.setText(item.getMaLop());
        }
        else MaLop.setText("");

        if (item.getTenLop()!=null) {
            TenLop.setText(item.getTenLop());
        }
        else TenLop.setText("");

        if (item.getNgay()!=null) {
            String ngay = "Thứ " + item.getThu() + " ngày " + item.getNgay();
            Time.setText(ngay);
        }
        else Time.setText("");

        if (item.getTiet()!=null) {
            String tiet = "Tiết " + item.getTiet();
            Tiet.setText(tiet);
        }
        else Tiet.setText("");

        if (item.getPhong()!=null) {
            Room.setText(item.getPhong());
        }
        else Room.setText("");

        if (item.getNoiDung()!=null) {
            content.setText(item.getNoiDung());
        }
        else content.setText("");

        //
        // check loaitb
        //
        if(loaitb.equals("0")){
            LoaiTB.setText("[TB] Thông Báo Nghỉ Lớp");
            LoaiTB.setVisibility(View.VISIBLE);
            MaLop.setVisibility(View.VISIBLE);
            TenLop.setVisibility(View.VISIBLE);
            Time.setVisibility(View.VISIBLE);
            Tiet.setVisibility(View.GONE);
            Room.setVisibility(View.GONE);
            content.setVisibility(View.GONE);

            imgMaLop.setVisibility(View.VISIBLE);
            imgTenLop.setVisibility(View.VISIBLE);
            imgTime.setVisibility(View.VISIBLE);
            imgTiet.setVisibility(View.GONE);
            imgRoom.setVisibility(View.GONE);
            imgcontent.setVisibility(View.GONE);
        }
        else if (loaitb.equals("1")){
            LoaiTB.setText("[TB] Thông Báo Học Bù");
            LoaiTB.setVisibility(View.VISIBLE);
            MaLop.setVisibility(View.VISIBLE);
            TenLop.setVisibility(View.VISIBLE);
            Time.setVisibility(View.VISIBLE);
            Tiet.setVisibility(View.VISIBLE);
            Room.setVisibility(View.VISIBLE);
            content.setVisibility(View.GONE);

            imgMaLop.setVisibility(View.VISIBLE);
            imgTenLop.setVisibility(View.VISIBLE);
            imgTime.setVisibility(View.VISIBLE);
            imgTiet.setVisibility(View.VISIBLE);
            imgRoom.setVisibility(View.VISIBLE);
            imgcontent.setVisibility(View.GONE);
        }
        else if(loaitb.equals("2")){
            LoaiTB.setText("[TB] Thông Báo Lịch Học");
            LoaiTB.setVisibility(View.VISIBLE);
            MaLop.setVisibility(View.VISIBLE);
            TenLop.setVisibility(View.VISIBLE);
            Time.setVisibility(View.VISIBLE);
            Tiet.setVisibility(View.VISIBLE);
            Room.setVisibility(View.VISIBLE);
            content.setVisibility(View.GONE);

            imgMaLop.setVisibility(View.VISIBLE);
            imgTenLop.setVisibility(View.VISIBLE);
            imgTime.setVisibility(View.VISIBLE);
            imgTiet.setVisibility(View.VISIBLE);
            imgRoom.setVisibility(View.VISIBLE);
            imgcontent.setVisibility(View.GONE);
        }
        else{
            LoaiTB.setText("[TB] Thông Báo Chung");
            LoaiTB.setVisibility(View.VISIBLE);
            MaLop.setVisibility(View.GONE);
            TenLop.setVisibility(View.GONE);
            Time.setVisibility(View.GONE);
            Tiet.setVisibility(View.GONE);
            Room.setVisibility(View.GONE);
            content.setVisibility(View.VISIBLE);

            imgMaLop.setVisibility(View.GONE);
            imgTenLop.setVisibility(View.GONE);
            imgTime.setVisibility(View.GONE);
            imgTiet.setVisibility(View.GONE);
            imgRoom.setVisibility(View.GONE);
            imgcontent.setVisibility(View.VISIBLE);
        }


        return convertView;
    }

}