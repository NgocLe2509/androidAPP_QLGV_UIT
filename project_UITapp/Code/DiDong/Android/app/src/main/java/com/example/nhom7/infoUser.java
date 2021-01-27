package com.example.nhom7;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class infoUser extends AppCompatActivity {
    private String UserID;
    private TextView tvUname, tvUID, tvEmail, tvGioiTinh, tvNgaySinh, tvSDT, tvDiaChi, tvMaLop;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_user);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");

        ImageView imgThongbao = (ImageView) findViewById(R.id.imgThongBao);
        ImageView imgDiemDanh = (ImageView) findViewById(R.id.imgDiemDanh);
        ImageView imgMauDon = (ImageView) findViewById(R.id.ivMaudon);
        ImageView imgThongTinCaNhan = (ImageView) findViewById(R.id.imgThongTinCaNhan);
        ImageView imgHome = (ImageView) findViewById(R.id.imgHome);

        imgThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(infoUser.this, infoUser.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(infoUser.this, thongbao.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(infoUser.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(infoUser.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(infoUser.this, maudon.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        tvUname = (TextView) findViewById(R.id.tvUname);
        tvUID = (TextView) findViewById(R.id.tvUID);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvGioiTinh = (TextView) findViewById(R.id.tvGioiTinh);
        tvNgaySinh = (TextView) findViewById(R.id.tvNgaySinh);
        tvSDT = (TextView) findViewById(R.id.tvSDT);
        tvDiaChi = (TextView) findViewById(R.id.tvDiaChi);
        tvMaLop = (TextView) findViewById(R.id.tvMaLop);

        getInfoUser();
    }

    //
    // thread get info user
    //
    private void getInfoUser() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    JSONArray ja = API.API(userid, "", "", "", Constants.getInfoUser_URL);
                    JSONObject jo = ja.getJSONObject(0);
                    // convert String to json arr
                    tvUname.setText(jo.getString("HoTen"));
                    tvUID.setText(jo.getString("MaSV"));
                    tvEmail.setText(jo.getString("Email"));
                    tvDiaChi.setText(jo.getString("DiaChi"));
                    tvGioiTinh.setText(jo.getString("GioiTinh"));
                    tvNgaySinh.setText(jo.getString("NgaySinh"));
                    tvSDT.setText(jo.getString("SDT"));
                    tvMaLop.setText(jo.getString("MaLopSH"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
