package com.example.nhom7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class thongbao extends AppCompatActivity {

    String UserID;
    JSONArray ja;
    ListView lvThongBao;

    ArrayList<item_thongbao> item = new ArrayList<item_thongbao>();
    item_thongbao_adapter adapter =null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thongbao);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");

        ImageView imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thongbao.this, home.class);
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
                Intent intent = new Intent(thongbao.this, infoUser.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thongbao.this, thongbao.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thongbao.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thongbao.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(thongbao.this, maudon.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        lvThongBao = (ListView)findViewById(R.id.listitem);
        item = new ArrayList<item_thongbao>();

        adapter = new item_thongbao_adapter(this, R.layout.thongbao_adapter, item);
        lvThongBao.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        thongbao();


    }

    private void thongbao() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    String URL = Constants.thongbao_URL;
                    ja = API.API(userid, "", "", "", URL);
                    int leng = ja.length();
                    for(int i = leng-1; i>=0; i--){
                        try {
                            JSONObject jo = ja.getJSONObject(i);

                            item_thongbao item1 = new item_thongbao();
                            item1.setLoaiTB(jo.getString("LoaiTB"));
                            item1.setMaLop(jo.getString("MaLop"));
                            item1.setTenLop(jo.getString("Mon"));
                            item1.setThu(jo.getString("Thu"));
                            item1.setNgay(jo.getString("Ngay"));
                            item1.setTiet(jo.getString("Tiet"));
                            item1.setPhong(jo.getString("Phong"));
                            item1.setNoiDung(jo.getString("NoiDung"));

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