package com.example.nhom7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class drl extends AppCompatActivity {

    private String UserID, Username;
    private TextView tv1, tv2, tv3, tv4, tv5, tvUserID, tvUsername;
    private JSONArray ja;
    private TableRow row;
    private TableLayout tl;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drl);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");
        Username = intent.getStringExtra("Username");

        ImageView imgThongbao = (ImageView) findViewById(R.id.imgThongBao);
        ImageView imgDiemDanh = (ImageView) findViewById(R.id.imgDiemDanh);
        ImageView imgMauDon = (ImageView) findViewById(R.id.ivMaudon);
        ImageView imgThongTinCaNhan = (ImageView) findViewById(R.id.imgThongTinCaNhan);
        ImageView imgHome = (ImageView) findViewById(R.id.imgHome);

        ImageView imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(drl.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        imgThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(drl.this, infoUser.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(drl.this, thongbao.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(drl.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(drl.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(drl.this, maudon.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        tl = (TableLayout) findViewById(R.id.tableLayout);
        tl.setStretchAllColumns(true);
        tvUserID = (TextView) findViewById(R.id.tvUserID);
        tvUsername = (TextView) findViewById(R.id.tvUsername);

        tvUsername.setText(Username);
        tvUserID.setText(UserID);


        getDRL();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i=0; i < ja.length(); i++) {
            try {

                JSONObject jo = ja.getJSONObject(i);
                row = new TableRow(this);
                row.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.WRAP_CONTENT));


                tv1 = new TextView(this);
                tv1.setBackground(this.getResources().getDrawable(R.drawable.cell_shape));
                tv1.setGravity(Gravity.CENTER);
                tv1.setPadding(5, 5, 5, 5);
                tv1.setTextColor(Color.BLACK);

                tv2 = new TextView(this);
                tv2.setBackground(this.getResources().getDrawable(R.drawable.cell_shape));
                tv2.setGravity(Gravity.CENTER);
                tv2.setPadding(5, 5, 5, 5);
                tv2.setTextColor(Color.BLACK);

                tv3 = new TextView(this);
                tv3.setBackground(this.getResources().getDrawable(R.drawable.cell_shape));
                tv3.setGravity(Gravity.CENTER);
                tv3.setPadding(5, 5, 5, 5);
                tv3.setTextColor(Color.BLACK);

                tv4 = new TextView(this);
                tv4.setBackground(this.getResources().getDrawable(R.drawable.cell_shape));
                tv4.setGravity(Gravity.CENTER);
                tv4.setPadding(5, 5, 5, 5);
                tv4.setTextColor(Color.BLACK);

                tv5 = new TextView(this);
                tv5.setBackground(this.getResources().getDrawable(R.drawable.cell_shape));
                tv5.setGravity(Gravity.CENTER);
                tv5.setPadding(5, 5, 5, 5);
                tv5.setTextColor(Color.BLACK);

                int stt = i+1;
                tv1.setText(String.valueOf(stt));
                Log.e("test", "aaaaaaaa");
                row.addView(tv1);

                String hocki;
                if(jo.getInt("HocKi") % 2 == 0){
                    hocki = "HK2";
                }
                else {
                    hocki = "HK1";
                }
                tv2.setText(hocki);
                row.addView(tv2);
                tv3.setText(jo.getString("Nam"));
                row.addView(tv3);
                tv4.setText(jo.getString("TongDiem"));
                row.addView(tv4);
                tv5.setText(jo.getString("XepLoai"));
                row.addView(tv5);
                tl.addView(row, new TableLayout.LayoutParams(
                        TableLayout.LayoutParams.FILL_PARENT,                    //part4
                        TableLayout.LayoutParams.WRAP_CONTENT));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

    }


    //
    // thread get info user
    //
    private void getDRL() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    String URL = Constants.drl_URL;
                    ja = API.API(userid, "", "", "", URL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


}