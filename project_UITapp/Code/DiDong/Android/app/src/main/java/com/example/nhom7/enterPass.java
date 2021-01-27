package com.example.nhom7;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONObject;

public class enterPass extends AppCompatActivity {

    private String UserID;
    private EditText enterPass, enterRePass;
    private Button btnVerify;
    private int re = 0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enterpassword);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");
        enterPass = (EditText) findViewById(R.id.etNewPass);
        enterRePass = (EditText) findViewById(R.id.etReNewPass);
        btnVerify = (Button) findViewById(R.id.btnVerify);

        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass = enterPass.getText().toString();
                String rePass = enterRePass.getText().toString();
                Context context = getApplicationContext();
                if(pass.equals("") || pass.equals(null)){
                    Toast.makeText(context, "Chưa nhập mật khẩu!.", Toast.LENGTH_SHORT).show();
                }
                else if(pass.equals(rePass) == false){
                    Toast.makeText(context, "Nhập lại mật khẩu chưa chính xác!", Toast.LENGTH_SHORT).show();
                }
                else{
                    resetPass(v);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(re==1){
                        Toast.makeText(context, "Thay đổi mật khẩu thành công!", Toast.LENGTH_SHORT).show();
                        call_login(v);
                    }
                    else{
                        Toast.makeText(context, "Thay đổi mật khẩu thất bại!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //
    // Thread follow click btn GetOTP
    //
    private void resetPass(final View v) {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    String pass = enterPass.getText().toString();
                    JSONArray ja = API.API(userid,pass, "", "", Constants.resetPass_URL);
                    JSONObject jo = ja.getJSONObject(0);
                    if(jo.getString("error").equals("false")){
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
    // call actvity login
    //
    void call_login(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
