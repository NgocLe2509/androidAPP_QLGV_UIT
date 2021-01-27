package com.example.nhom7;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;

public class forgot_pass extends AppCompatActivity {
    private EditText UserID;
    private Button GetOTP;
    private int re = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_pass);

        UserID = (EditText) findViewById(R.id.etUserID);
        GetOTP = (Button) findViewById(R.id.btnGetOTP);

        GetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getOTP(v);
                call_enterOTP(v);

            }
        });
    }

    //
    // Thread follow click btn GetOTP
    //
    private void getOTP(final View v) {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID.getText().toString();
                    JSONArray ja = API.API(userid, "", "", "", Constants.sendOTP_URL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    //
    // call actvity enter OTP
    //
    void call_enterOTP(View v){
        Intent intent = new Intent(this, enterOTP.class);
        intent.putExtra("UserID",UserID.getText().toString());
        startActivity(intent);
    }
}
