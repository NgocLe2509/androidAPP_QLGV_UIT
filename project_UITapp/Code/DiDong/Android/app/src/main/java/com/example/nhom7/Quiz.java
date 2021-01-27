package com.example.nhom7;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Quiz extends AppCompatActivity {

    private String UserID, IDGame, Username;
    private TextView tvSocau, tvCauHoi;
    private RadioButton radioA, radioB, radioC, radioD;
    private int index = 0;
    private JSONArray ja;
    private Button btnNext;
    private String[] result = new String[100];
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");
        Username = intent.getStringExtra("Username");
        IDGame = intent.getStringExtra("IDGame");

        ImageView imgThongbao = (ImageView) findViewById(R.id.imgThongBao);
        ImageView imgDiemDanh = (ImageView) findViewById(R.id.imgDiemDanh);
        ImageView imgMauDon = (ImageView) findViewById(R.id.imgMauDon);
        ImageView imgThongTinCaNhan = (ImageView) findViewById(R.id.imgThongTinCaNhan);
        ImageView imgHome = (ImageView) findViewById(R.id.imgHome);

        ImageView imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this, startQuiz.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        imgThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this, infoUser.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this, thongbao.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Quiz.this, maudon.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        tvSocau = (TextView) findViewById(R.id.tvSoCau);
        tvCauHoi = (TextView) findViewById(R.id.tvCauHoi);

        btnNext = (Button) findViewById(R.id.btnNext);

        radioA = (RadioButton) findViewById(R.id.radioA);
        radioB = (RadioButton) findViewById(R.id.radioB);
        radioC = (RadioButton) findViewById(R.id.radioC);
        radioD = (RadioButton) findViewById(R.id.radioD);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        CompoundButton.OnCheckedChangeListener listenerRadio = null;
        radioA.setOnCheckedChangeListener(listenerRadio);
        radioB.setOnCheckedChangeListener(listenerRadio);
        radioC.setOnCheckedChangeListener(listenerRadio);
        radioD.setOnCheckedChangeListener(listenerRadio);


        letQuiz();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!radioA.isChecked() && !radioB.isChecked() && !radioC.isChecked() && !radioD.isChecked()){
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Bạn chưa chọn đáp án!", Toast.LENGTH_SHORT).show();
                }
                else {

                    if (radioA.isChecked()) {
                        result[index] = "A";
                    }
                    else if (radioB.isChecked()){
                        result[index] = "B";
                    }
                    else if (radioC.isChecked()) {
                        result[index] = "C";
                    }
                    else {
                        result[index] = "D";
                    }

                    radioGroup.clearCheck();
                    index++;

                    if (index == ja.length()){
                        int SoCauDung = 0;
                        for(int i=0; i < index; i++){
                            try {
                                if (result[i].equals(ja.getJSONObject(i).getString("CauDung"))){
                                    SoCauDung++;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        call_acEndQuiz(String.valueOf(new Integer(ja.length())), String.valueOf(new Integer(SoCauDung)));
                    }
                    else {
                        if (index == ja.length() - 1) {
                            btnNext.setText("Kết thúc");
                        }
                        JSONObject jo = null;
                        try {
                            jo = ja.getJSONObject(index);
                            int value = index + 1;
                            tvSocau.setText("Câu hỏi số " + value);
                            tvCauHoi.setText(jo.getString("CauHoi"));
                            radioA.setText(jo.getString("CauA"));
                            radioB.setText(jo.getString("CauB"));
                            radioC.setText(jo.getString("CauC"));
                            radioD.setText(jo.getString("CauD"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });

    }

    private void letQuiz() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String code = IDGame;
                    ja = API.API(code, "", "", "", Constants.Quiz_URL);
                    JSONObject jo = ja.getJSONObject(0);
                    tvSocau.setText("Câu hỏi số 1");
                    tvCauHoi.setText(jo.getString("CauHoi"));
                    radioA.setText(jo.getString("CauA"));
                    radioB.setText(jo.getString("CauB"));
                    radioC.setText(jo.getString("CauC"));
                    radioD.setText(jo.getString("CauD"));

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


    //
    // call actvity endQuiz
    //
    void call_acEndQuiz(String SoCau, String SoCauDung) {
        Intent intent = new Intent(this,endQuiz.class);
        intent.putExtra("UserID", UserID);
        intent.putExtra("Username", Username);
        intent.putExtra("SoCau", SoCau);
        intent.putExtra("SoCauDung", SoCauDung);
        intent.putExtra("IDGame", IDGame);
        startActivity(intent);
    }
}
