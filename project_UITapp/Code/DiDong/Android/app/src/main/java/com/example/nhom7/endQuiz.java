package com.example.nhom7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class endQuiz extends AppCompatActivity {

    private String UserID, Username, SoCau, SoCauDung, IDGame;
    private TextView tvUserID, tvUsername, tvKetQua;
    private Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.end_quiz);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");
        Username = intent.getStringExtra("Username");
        SoCau = intent.getStringExtra("SoCau");
        SoCauDung = intent.getStringExtra("SoCauDung");
        IDGame = intent.getStringExtra("IDGame");

        ImageView imgThongbao = (ImageView) findViewById(R.id.imgThongBao);
        ImageView imgDiemDanh = (ImageView) findViewById(R.id.imgDiemDanh);
        ImageView imgMauDon = (ImageView) findViewById(R.id.ivMaudon);
        ImageView imgThongTinCaNhan = (ImageView) findViewById(R.id.imgThongTinCaNhan);
        ImageView imgHome = (ImageView) findViewById(R.id.imgHome);

        imgThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(endQuiz.this, infoUser.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(endQuiz.this, thongbao.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(endQuiz.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(endQuiz.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(endQuiz.this, maudon.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });


        tvUserID = (TextView) findViewById(R.id.tvUserID);
        tvUsername = (TextView) findViewById(R.id.tvName);
        tvKetQua = (TextView) findViewById(R.id.tvKetQua);
        btnRestart = (Button) findViewById(R.id.btnRestart);

        tvUserID.setText(UserID);
        tvUsername.setText(Username);
        String ketqua = SoCauDung + "/" + SoCau;
        tvKetQua.setText(ketqua);
        updateScore();

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_quiz();
            }
        });
    }


    private void updateScore() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    String diem = SoCauDung;
                    String code = IDGame;

                    JSONArray ja = API.API(userid, diem, code, "", Constants.endQuiz_URL);

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
    void call_quiz() {
        Intent intent = new Intent(this,startQuiz.class);
        intent.putExtra("UserID", UserID);
        intent.putExtra("Username", Username);
        startActivity(intent);
    }
}