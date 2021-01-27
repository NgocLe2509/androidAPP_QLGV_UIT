package com.example.nhom7;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class enterOTP extends AppCompatActivity {

    private EditText etEnterOTP;
    private Button btnVerify;
    private String UserID;
    private int re = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_otp);

        etEnterOTP = (EditText) findViewById(R.id.etOTP);
        btnVerify = (Button) findViewById(R.id.btnVerify);
        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");

       btnVerify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                checkOTP(v);
                Context context = getApplicationContext();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (re == 1){
                    Toast.makeText(context, "Nhập OTP Thành Công.", Toast.LENGTH_SHORT).show();
                    call_enterNewPass(v);
                }
                else{
                    Toast.makeText(context, "Nhập OTP Thất Bại.", Toast.LENGTH_SHORT).show();
                    etEnterOTP.setText("");
                }

            }
        });
    }

    //
    // Thread follow click btn GetOTP
    //
    private void checkOTP(final View v) {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    String OTP = etEnterOTP.getText().toString();
                    String text = API_enterOTP.enterOTP(userid, OTP);
                    if(text.equals("true")){
                        re = 1;
                    }
                    else{
                        re = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    //
    // call actvity enter new password
    //
    void call_enterNewPass(View v){
        Intent intent = new Intent(this, enterPass.class);
        intent.putExtra("UserID",UserID);
        startActivity(intent);
    }
}
