package com.example.nhom7;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class feedback extends AppCompatActivity {
    private String UserID;
    private TextView tvUname, tvUID, tvEmail;
    private EditText etFeedback;
    private Button btnSend;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.feedback);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");

        tvUname = (TextView) findViewById(R.id.tvUname);
        tvUID = (TextView) findViewById(R.id.tvUID);
        tvEmail = (TextView) findViewById(R.id.tvEmail);

        btnSend = (Button) findViewById(R.id.btnSend);

        etFeedback = (EditText) findViewById(R.id.etFeedback);

        getInfoUser();

        ImageView imgBack = (ImageView) findViewById(R.id.imgBack);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFeedback();
                Context context = getApplicationContext();
                Toast.makeText(context, "Gửi Feedback Thành Công!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //
    // thread get info user
    //
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
                    tvUname.setText(jo.getString("HoTen"));
                    tvUID.setText(jo.getString("MaSV"));
                    tvEmail.setText(jo.getString("Email"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    //
    // thread send feedback
    //
    private void sendFeedback() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    String content = etFeedback.getText().toString();
                    etFeedback.setText("");
                    JSONArray ja = API.API(userid, content, "", "", Constants.sendFeedback_URL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}
