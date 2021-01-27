package com.example.nhom7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class web_view extends AppCompatActivity {

    private WebView webView;
    private TextView tvLink;
    private String link, UserID;
    private ImageView imgBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        Intent intent = this.getIntent();
        link = intent.getStringExtra("link");
        UserID = intent.getStringExtra("UserID");

        webView = (WebView) findViewById(R.id.webview);
        imgBack = (ImageView) findViewById(R.id.imgBack);
        tvLink = (TextView) findViewById(R.id.tvLink);
        tvLink.setText("Khảo Sát");

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call_KhaoSat();
            }
        });

        goUrl(link);
    }

    //
    // call actvity KhaoSat
    //
    void call_KhaoSat() {
        Intent intent = new Intent(this,KhaoSat.class);
        intent.putExtra("UserID", UserID);
        startActivity(intent);
    }

    private void goUrl(String link)  {
        if(link.isEmpty())  {
            Toast.makeText(this,"Please enter url",Toast.LENGTH_SHORT).show();
            return;
        }
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(link);
    }
}
