package com.example.nhom7;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class KhaoSat extends AppCompatActivity {

    private ListView lvKhaoSat;
    private String UserID;

    ArrayList<item_khao_sat> item = new ArrayList<item_khao_sat>();
    item_khaosat_adapter adapter =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.khao_sat);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");

        ImageView imgThongbao = (ImageView) findViewById(R.id.imgThongBao);
        ImageView imgDiemDanh = (ImageView) findViewById(R.id.imgDiemDanh);
        ImageView imgMauDon = (ImageView) findViewById(R.id.ivMaudon);
        ImageView imgThongTinCaNhan = (ImageView) findViewById(R.id.imgThongTinCaNhan);
        ImageView imgHome = (ImageView) findViewById(R.id.imgHome);

        ImageView imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KhaoSat.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        imgThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KhaoSat.this, infoUser.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KhaoSat.this, thongbao.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KhaoSat.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KhaoSat.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KhaoSat.this, maudon.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        lvKhaoSat = (ListView)findViewById(R.id.listitem);
        item = new ArrayList<item_khao_sat>();

        adapter = new item_khaosat_adapter(this, R.layout.item_khao_sat, item);
        lvKhaoSat.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        getKhaoSat();


        lvKhaoSat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                call_webview(item.get(arg2).getLink());
            }
        });


    }


    //
    // call actvity webview
    //
    void call_webview(String link) {
        Intent intent = new Intent(this,web_view.class);
        intent.putExtra("link", link);
        intent.putExtra("UserID", UserID);
        startActivity(intent);
    }


    //
    // thread get info user
    //
    private void getKhaoSat() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    JSONArray ja = API.API(userid, "", "", "", Constants.KhaoSat_URL);

                    for (int i=0; i < ja.length(); i++) {
                        try {
                            JSONObject jo = ja.getJSONObject(i);
                            item_khao_sat item1 = new item_khao_sat();
                            item1.setMamon(jo.getString("MaLopHP"));
                            item1.setLink(jo.getString("KhaoSat"));
                            item.add(item1);
                        } catch (Exception e) {
                            Log.e("name", e.getMessage());
                        }

                    }
                    adapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
