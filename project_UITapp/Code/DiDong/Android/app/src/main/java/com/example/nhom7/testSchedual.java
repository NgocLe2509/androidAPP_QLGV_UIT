package com.example.nhom7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class testSchedual extends AppCompatActivity {

    private ListView lvTestSchedual;
    private String UserID;

    ArrayList<item_testSchedual> item = new ArrayList<item_testSchedual>();
    item_testSchedual_adapter adapter =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_schedual);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");

        ImageView imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(testSchedual.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        ImageView imgThongbao = (ImageView) findViewById(R.id.imgThongBao);
        ImageView imgDiemDanh = (ImageView) findViewById(R.id.imgDiemDanh);
        ImageView imgMauDon = (ImageView) findViewById(R.id.ivMaudon);
        ImageView imgThongTinCaNhan = (ImageView) findViewById(R.id.imgThongTinCaNhan);
        ImageView imgHome = (ImageView) findViewById(R.id.imgHome);

        imgThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(testSchedual.this, infoUser.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(testSchedual.this, thongbao.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(testSchedual.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(testSchedual.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(testSchedual.this, maudon.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        lvTestSchedual = (ListView)findViewById(R.id.lvTestSchedual);
        item = new ArrayList<item_testSchedual>();

        adapter = new item_testSchedual_adapter(this, R.layout.test_schedual_adapter, item);
        lvTestSchedual.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        getSchedual();
    }
    //
    // thread get info user
    //
    private void getSchedual() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    JSONArray ja = API.API(userid, "", "", "", Constants.testSchedual_URL);
                    Log.e("ngocle", ja.toString());

                    for (int i=0; i < ja.length(); i++) {
                        item_testSchedual item1 = new item_testSchedual();
                        JSONObject jo = ja.getJSONObject(i);
                        int Ca = Integer.parseInt(jo.getString("Ca"));

                        item1.setID(jo.getString("MaLH"));
                        item1.setName(jo.getString("TenLop"));
                        String time = jo.getString("Ngay")+"/"+jo.getString("Thang")+"/"+jo.getString("Nam");
                        item1.setDay(time);
                        String Phong = "P." + jo.getString("Phong");
                        item1.setRoom(Phong);
                        String Gio = null;
                        switch (Ca){
                            case 1: Gio = " 7h30";
                                break;
                            case 2: Gio = " 9h30";
                                break;
                            case 3: Gio = " 13h30";
                                break;
                            case 4: Gio = " 15h30";
                                break;
                        }
                        String ca = "Ca: " + jo.getString("Ca") + Gio;
                        item1.setTime(ca);
                        item.add(item1);

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