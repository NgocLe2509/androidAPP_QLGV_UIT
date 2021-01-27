package com.example.nhom7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class hocphi extends AppCompatActivity {

    private String UserID;
    ListView lvhocphi;

    ArrayList<item_hocphi> item = new ArrayList<item_hocphi>();
    item_hocphi_adapter adapter =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hocphi);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");

        ImageView imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hocphi.this, home.class);
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
                Intent intent = new Intent(hocphi.this, infoUser.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hocphi.this, thongbao.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hocphi.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hocphi.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(hocphi.this, maudon.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        lvhocphi = (ListView)findViewById(R.id.listitem);
        item = new ArrayList<item_hocphi>();

        adapter = new item_hocphi_adapter(this, R.layout.hocphi_adapter, item);
        lvhocphi.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        hocphi();
    }

    private void hocphi() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    String URL = Constants.hocphi_URL;
                    JSONArray ja = API.API(userid, "", "", "", URL);
                    int leng = ja.length();

                    for(int i = leng-1; i>=0; i--){
                        try {
                            JSONObject jo = ja.getJSONObject(i);

                            item_hocphi item1 = new item_hocphi();
                            item1.setHocky(jo.getString("hocky"));
                            item1.setSomon(jo.getString("somon"));
                            item1.setTong(jo.getString("tong"));
                            item1.setDadong(jo.getString("dadong"));
                            item1.setConlai(jo.getString("conlai"));
                            item1.setDkhp(jo.getString("dkhp"));
                            item1.setTai(jo.getString("tai"));
                            item1.setThoigian(jo.getString("thoigian"));

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