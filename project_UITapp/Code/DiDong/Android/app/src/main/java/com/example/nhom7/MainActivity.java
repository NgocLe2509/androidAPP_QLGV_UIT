package com.example.nhom7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    private EditText UserID, Password;
    private Button Login;
    private TextView forgotPass, clickForgotPass;
    int check = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        UserID = (EditText)findViewById(R.id.editUserID);
        Password = (EditText)findViewById(R.id.editPassword);
        Login = (Button)findViewById(R.id.btnLogin);
        forgotPass = (TextView) findViewById(R.id.forgotPass);
        clickForgotPass = (TextView) findViewById(R.id.clickForgotPass);

        // onClick btn Login
        Login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                loginUser(v);
                Log.e("ahihi", "aaaaaaaa");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (check == 1){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công.", Toast.LENGTH_SHORT).show();
                    call_home(v);
                }
                else{
                    Toast.makeText(MainActivity.this, "Sai Username hoặc Password.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        clickForgotPass.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                call_forgot_pass(v);
            }
        });
    }


    //
    // Thread follow click btn Login
    //
    private void loginUser(final View v) {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {

                    //Your code goes here
                    String userid = UserID.getText().toString();
                    String password = Password.getText().toString();

                    JSONArray ja = API.API(userid, password, "", "", Constants.login_URL);
                    JSONObject jo = ja.getJSONObject(0);
                    if(jo.getString("error").equals("false")){
                        check = 1;
                    }
                    else{
                        check = 0;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    //
    // call actvity forgot_pass
    //
    void call_forgot_pass(View v){
        Intent intent = new Intent(this, forgot_pass.class);
        startActivity(intent);
    }

    //
    // call actvity home
    //
    void call_home(View v){
        Intent intent = new Intent(this, home.class);
        intent.putExtra("UserID",UserID.getText().toString());
        startActivity(intent);
    }
}