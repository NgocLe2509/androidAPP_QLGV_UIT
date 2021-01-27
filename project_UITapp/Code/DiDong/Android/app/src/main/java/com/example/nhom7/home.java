package com.example.nhom7;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class home extends AppCompatActivity {
    private String UserID;
    private String Username;
    private TextView tvUsername, tvLogout, tvResetPass, tvFeedback, tvTestSchedual, tvLichHoc, tvScore, tvKhaoSat, tvQuiz, tvDRL, tvHocPhi, tvDeadline;
    private ImageView imgLogout, imgResetPass, imgFeedback, imgThongTinCaNhan, imgMauDon, imgTestSchedual, imgLichHoc, imgScore, imgKhaoSat,
            imgQuiz, imgDRL, imgThongbao, imgHocPhi, imgDeadline, imgDiemDanh;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");

        tvUsername = (TextView) findViewById(R.id.tvUsername);
        tvLogout = (TextView) findViewById(R.id.tvLogout);
        tvResetPass = (TextView) findViewById(R.id.tvResetPass);
        tvFeedback = (TextView) findViewById(R.id.tvFeedback);
        tvTestSchedual = (TextView) findViewById(R.id.tvTestSchedual);
        tvLichHoc = (TextView) findViewById(R.id.tvLichHoc);
        tvScore = (TextView) findViewById(R.id.tvScore);
        tvKhaoSat= (TextView) findViewById(R.id.tvKhaoSat);
        tvQuiz = (TextView) findViewById(R.id.tvQuiz);
        tvDRL = (TextView) findViewById(R.id.tvDRL);
        tvHocPhi = (TextView) findViewById(R.id.tvHocPhi);
        tvDeadline = (TextView) findViewById(R.id.tvDeadline);

        imgLogout = (ImageView) findViewById(R.id.imgLogout);
        imgResetPass = (ImageView) findViewById(R.id.imgResetPass);
        imgFeedback = (ImageView) findViewById(R.id.imgFeedback);
        imgThongTinCaNhan = (ImageView) findViewById(R.id.imgThongTinCaNhan);
        imgMauDon = (ImageView) findViewById(R.id.ivMaudon);
        imgTestSchedual = (ImageView) findViewById(R.id.imgTestSchedual);
        imgLichHoc = (ImageView) findViewById(R.id.imgLichHoc);
        imgScore = (ImageView) findViewById(R.id.imgScore);
        imgKhaoSat = (ImageView) findViewById(R.id.imgKhaoSat);
        imgQuiz = (ImageView) findViewById(R.id.imgQuiz);
        imgDRL = (ImageView) findViewById(R.id.imgDRL);
        imgThongbao = (ImageView) findViewById(R.id.imgThongBao);
        imgHocPhi = (ImageView) findViewById(R.id.imgHocPhi);
        imgDeadline = (ImageView) findViewById(R.id.imgDeadline);
        imgDiemDanh = (ImageView) findViewById(R.id.imgDiemDanh);

        getInfoUser();

        //
        // event click logout
        //
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Login(v);
            }
        });
        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Login(v);
            }
        });

        //
        // event click reset password
        //
        tvResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_forgotPass(v);
            }
        });
        imgResetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_forgotPass(v);
            }
        });

        //
        // event click feedback
        //
        tvFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_feedback(v);
            }
        });
        imgFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_feedback(v);
            }
        });

        //
        // event click khaosat
        //
        tvKhaoSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_khaosat(v);
            }
        });
        imgKhaoSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_khaosat(v);
            }
        });

        //
        // event click feedback
        //
        tvTestSchedual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_testSchedual(v);
            }
        });
        imgTestSchedual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_testSchedual(v);
            }
        });

        //
        // event click schedual
        //
        tvLichHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Schedual(v);
            }
        });
        imgLichHoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Schedual(v);
            }
        });

        //
        // event click quiz
        //
        tvQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_quiz(v);
            }
        });
        imgQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_quiz(v);
            }
        });

        //
        // event click DLR
        //
        tvDRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_DRL(v);
            }
        });
        imgDRL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_DRL(v);
            }
        });

        //
        // event click score
        //
        tvScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_score(v);
            }
        });
        imgScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_score(v);
            }
        });

        //
        // event click hocphi
        //
        tvHocPhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_hocphi(v);
            }
        });
        imgHocPhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_hocphi(v);
            }
        });

        //
        // event click deadline
        //
        tvDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Deadline(v);
            }
        });
        imgDeadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_Deadline(v);
            }
        });

        //
        // event click info user
        //
        imgThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_infoUser(v);
            }
        });

        //
        // event click maudon
        //
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_maudon(v);
            }
        });

        //
        // event click thongbao
        //
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_ThongBao(v);
            }
        });

        //
        // event click diemdanh
        //
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_DiemDanh(v);
            }
        });


    }

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
                    tvUsername.setText("Xin chào ".concat(jo.getString("HoTen")));
                    Username =  jo.getString("HoTen");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    //
    // call actvity MainActivity
    //
    void call_Login(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //
    // call actvity forgot pass
    //
    void call_forgotPass(View v){
        Intent intent = new Intent(this, forgot_pass.class);
        startActivity(intent);
    }

    //
    // call actvity feedback
    //
    void call_feedback(View v){
        Intent intent = new Intent(this, feedback.class);
        intent.putExtra("UserID",UserID);
        startActivity(intent);
    }

    //
    // call actvity info user
    //
    void call_infoUser(View v){
        Intent intent = new Intent(this, infoUser.class);
        intent.putExtra("UserID",UserID);
        startActivity(intent);
    }

    //
    // call actvity Maudon
    //
    void call_maudon(View v){
        Intent intent = new Intent(this, maudon.class);
        intent.putExtra("UserID",UserID);
        startActivity(intent);
    }

    //
    // call actvity Test schedual
    //
    void call_testSchedual(View v){
        Intent intent = new Intent(this, testSchedual.class);
        intent.putExtra("UserID",UserID);
        startActivity(intent);
    }

    //
    // call actvity schedual
    //
    void call_Schedual(View v) {
        Intent intent = new Intent(this, Schedual.class);
        intent.putExtra("UserID", UserID);
        startActivity(intent);
    }

    //
    // call actvity score
    //
    void call_score(View v) {
        Intent intent = new Intent(this, Score.class);
        intent.putExtra("UserID", UserID);
        startActivity(intent);
    }

    //
    // call actvity khao sat
    //
    void call_khaosat(View v) {
        Intent intent = new Intent(this,KhaoSat.class);
        intent.putExtra("UserID", UserID);
        startActivity(intent);
    }

    //
    // call actvity quiz
    //
    void call_quiz(View v) {
        Intent intent = new Intent(this,startQuiz.class);
        intent.putExtra("UserID", UserID);
        intent.putExtra("Username", Username);
        startActivity(intent);
    }

    //
    // call actvity DLR
    //
    void call_DRL(View v) {
        Intent intent = new Intent(this,drl.class);
        intent.putExtra("UserID", UserID);
        intent.putExtra("Username", Username);
        startActivity(intent);
    }

    //
    // call actvity thong bao
    //
    void call_ThongBao(View v) {
        Intent intent = new Intent(this,thongbao.class);
        intent.putExtra("UserID", UserID);
        startActivity(intent);
    }

    //
    // call actvity hoc phi
    //
    void call_hocphi(View v) {
        Intent intent = new Intent(this,hocphi.class);
        intent.putExtra("UserID", UserID);
        startActivity(intent);
    }

    //
    // call actvity deadline
    //
    void call_Deadline(View v) {
        Intent intent = new Intent(this,deadline.class);
        intent.putExtra("UserID", UserID);
        startActivity(intent);
    }

    //
    // call actvity deadline
    //
    void call_DiemDanh(View v) {
        Intent intent = new Intent(this,diemdanh.class);
        intent.putExtra("UserID", UserID);
        Log.e("echo", UserID);
        startActivity(intent);
    }
}
