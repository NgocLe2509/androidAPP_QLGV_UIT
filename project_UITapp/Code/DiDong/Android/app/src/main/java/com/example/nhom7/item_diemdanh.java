package com.example.nhom7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class item_diemdanh extends AppCompatActivity {

    private String UserID, Code;
    private JSONArray ja;

    private TextView tvThongBao, tvMaLop1, tvMaLop2, tvBuoi1, tvBuoi2, tvCode1, tvCode2;
    private Button btnBack1, btnBack2, btnDiemDanh;

    private String check;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_diemdanh);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");
        Code = intent.getStringExtra("Code");

        Log.e("blabla", UserID + " " + Code);

        tvThongBao = (TextView) findViewById(R.id.tvThongBao);
        tvMaLop1 = (TextView) findViewById(R.id.tvMaLop1);
        tvMaLop2 = (TextView) findViewById(R.id.tvMaLop2);
        tvBuoi1 = (TextView) findViewById(R.id.tvBuoi1);
        tvBuoi2 = (TextView) findViewById(R.id.tvBuoi2);
        tvCode1 = (TextView) findViewById(R.id.tvCode1);
        tvCode2 = (TextView) findViewById(R.id.tvCode2);

        btnBack1 = (Button) findViewById(R.id.btnBack1);
        btnBack2 = (Button) findViewById(R.id.btnBack2);
        btnDiemDanh = (Button) findViewById(R.id.btnDiemDanh);

        tvThongBao.setVisibility(View.GONE);
        tvMaLop1.setVisibility(View.GONE);
        tvMaLop2.setVisibility(View.GONE);
        tvBuoi1.setVisibility(View.GONE);
        tvBuoi2.setVisibility(View.GONE);
        tvCode1.setVisibility(View.GONE);
        tvCode2.setVisibility(View.GONE);

        btnBack1.setVisibility(View.GONE);
        btnBack2.setVisibility(View.GONE);
        btnDiemDanh.setVisibility(View.GONE);

        getDiemDanh();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        btnBack1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(item_diemdanh.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(item_diemdanh.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        btnDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDiemDanh();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(check.equals("1")){
                    Toast.makeText(item_diemdanh.this, "Điểm danh thành công!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(item_diemdanh.this, diemdanh.class);
                    intent.putExtra("UserID",UserID);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(item_diemdanh.this, "Điểm danh không thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    //
    // thread get info user
    //
    private void getDiemDanh() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    ja = API.API(UserID, Code, "", "", Constants.checkDiemDanh_URL);
                    Log.e("aaabbb", ja.toString());
                    JSONObject jo = ja.getJSONObject(0);
                    if(jo.getString("code").equals("1")){
                        tvThongBao.setVisibility(View.VISIBLE);
                        btnBack1.setVisibility(View.VISIBLE);
                        tvThongBao.setText("Không tìm thấy lớp học phù hợp");
                    }
                    else if(jo.getString("code").equals("2")){
                        tvThongBao.setVisibility(View.VISIBLE);
                        btnBack1.setVisibility(View.VISIBLE);
                        tvThongBao.setText("Sinh viên không phải là thành viên lớp");
                    }
                    else if(jo.getString("code").equals("3")){
                        tvThongBao.setVisibility(View.VISIBLE);
                        btnBack1.setVisibility(View.VISIBLE);
                        tvThongBao.setText("Sinh viên đã điểm danh");
                    }
                    else {
                        tvMaLop1.setVisibility(View.VISIBLE);
                        tvMaLop2.setVisibility(View.VISIBLE);
                        tvBuoi1.setVisibility(View.VISIBLE);
                        tvBuoi2.setVisibility(View.VISIBLE);
                        tvCode1.setVisibility(View.VISIBLE);
                        tvCode2.setVisibility(View.VISIBLE);
                        btnBack2.setVisibility(View.VISIBLE);
                        btnDiemDanh.setVisibility(View.VISIBLE);

                        tvCode2.setText(Code);
                        tvMaLop2.setText(jo.getString("malop"));
                        tvBuoi2.setText(jo.getString("buoi"));

                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    private void addDiemDanh() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String MaLop = (String) tvMaLop2.getText();
                    String Buoi = (String) tvBuoi2.getText();
                    ja = API.API(UserID, Code, MaLop, Buoi, Constants.addDiemDanh_URL);
                    Log.e("testDD", ja.toString());
                    JSONObject jo = ja.getJSONObject(0);
                    check = jo.getString("code");



                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}