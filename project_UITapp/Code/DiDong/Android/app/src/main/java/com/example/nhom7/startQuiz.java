package com.example.nhom7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class startQuiz extends AppCompatActivity {

    private String UserID, Username;
    private TextView tvUsername, tvUserID, tvWarning;
    private Button btnStartQuiz;
    private EditText etCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_quiz);

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
                Intent intent = new Intent(startQuiz.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        imgThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startQuiz.this, infoUser.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startQuiz.this, thongbao.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startQuiz.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startQuiz.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(startQuiz.this, maudon.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvUserID = (TextView) findViewById(R.id.tvUID);
        btnStartQuiz = (Button) findViewById(R.id.startbutton);
        etCode = (EditText) findViewById(R.id.editcode);
        tvWarning = (TextView) findViewById(R.id.tvWarning);

        tvUsername.setText(Username);
        tvUserID.setText(UserID);

        btnStartQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (etCode.getText().toString().equals("")){

                    tvWarning.setText("Bạn chưa nhập Code");
                }
                else {
                    checkStartQuiz();
                }

            }
        });
    }


    //
    // thread get info user
    //
    private void checkStartQuiz() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    String code = etCode.getText().toString();
                    JSONArray ja = API.API(userid, code, "", "", Constants.startQuiz_URL);
                    Log.e("ja", ja.toString());
                    JSONObject jo = ja.getJSONObject(0);
                    if(jo.getString("result").equals("0")){
                        tvWarning.setText("Không tìm thấy Quiz có mã Code trên!");
                    }
                    else if (jo.getString("result").equals("1")){
                        tvWarning.setText("Quiz đã hết hạn!");
                    }
                    else if(jo.getString("result").equals("2")) {
                        tvWarning.setText("Mã Quiz này không nằm trong danh sách môn học của bạn!");
                    }
                    else {
                        call_acQuiz();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    //
    // call actvity quiz
    //
    void call_acQuiz() {
        Intent intent = new Intent(this,Quiz.class);
        intent.putExtra("UserID", UserID);
        intent.putExtra("Username", Username);
        intent.putExtra("IDGame", etCode.getText().toString());
        startActivity(intent);
    }


}