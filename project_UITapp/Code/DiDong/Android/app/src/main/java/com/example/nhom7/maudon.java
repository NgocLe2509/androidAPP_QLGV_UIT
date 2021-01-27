package com.example.nhom7;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class maudon extends AppCompatActivity {
    private static final int PERMISSION_STORAGE_CODE = 1000;

    private ListView lvMaudon;
    private static int save = 0;

    ArrayList<item_maudon> item = new ArrayList<item_maudon>();
    item_maudon_adapter adapter =null;

    String url = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maudon);

        Intent intent = this.getIntent();
        final String UserID = intent.getStringExtra("UserID");

        ImageView imgThongbao = (ImageView) findViewById(R.id.imgThongBao);
        ImageView imgDiemDanh = (ImageView) findViewById(R.id.imgDiemDanh);
        ImageView imgMauDon = (ImageView) findViewById(R.id.ivMaudon);
        ImageView imgThongTinCaNhan = (ImageView) findViewById(R.id.imgThongTinCaNhan);
        ImageView imgHome = (ImageView) findViewById(R.id.imgHome);

        ImageView imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(maudon.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        imgThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(maudon.this, infoUser.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(maudon.this, thongbao.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(maudon.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(maudon.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(maudon.this, maudon.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });


        lvMaudon = (ListView)findViewById(R.id.lvMaudon);
        item = new ArrayList<item_maudon>();

        adapter = new item_maudon_adapter(this, R.layout.maudon_adapter, item);
        lvMaudon.setAdapter(adapter);

        item_maudon item1 = new item_maudon();
        item1.setName("Đơn điều chỉnh ĐKHP");
        item1.setLink(Constants.API_URL + "MauDon/mau_11_don_dieu_chinh_dkhp.doc");
        item.add(item1);

        item_maudon item2 = new item_maudon();
        item2.setName("Đơn chuyển ngành");
        item2.setLink(Constants.API_URL + "MauDon/mau_01_don_xin_chuyen_nganh.doc");
        item.add(item2);

        item_maudon item3 = new item_maudon();
        item3.setName("Đơn chuyển trường");
        item3.setLink(Constants.API_URL + "MauDon/mau_02_don_xin_chuyen_truong.doc");
        item.add(item3);

        item_maudon item4 = new item_maudon();
        item4.setName("Tạm dừng & bảo lưu kết quả");
        item4.setLink(Constants.API_URL + "MauDon/mau_03_don_xin_tam_ngung_va_bao_luu_ket_qua_hoc_tap.doc");
        item.add(item4);

        item_maudon item5 = new item_maudon();
        item5.setName("Bảo lưu kết quả tuyển sinh");
        item5.setLink(Constants.API_URL + "MauDon/mau_08_don_xin_bao_luu_ket_qua_tuyen_sinh.doc");
        item.add(item5);

        item_maudon item6 = new item_maudon();
        item6.setName("Đơn học lại");
        item6.setLink(Constants.API_URL + "MauDon/mau_07_don_xin_hoc_lai.doc");
        item.add(item6);

        item_maudon item7 = new item_maudon();
        item7.setName("Đơn nhập học");
        item7.setLink(Constants.API_URL + "MauDon/mau_09_don_xin_nhap_hoc_lai.doc");
        item.add(item7);

        item_maudon item8 = new item_maudon();
        item8.setName("Đơn hoãn thi");
        item8.setLink(Constants.API_URL + "MauDon/mau_04_don_xin_hoan_thi.doc");
        item.add(item8);

        item_maudon item9 = new item_maudon();
        item9.setName("Đơn thôi học");
        item9.setLink(Constants.API_URL + "MauDon/mau_05_don_xin_thoi_hoc.doc");
        item.add(item9);

        item_maudon item10 = new item_maudon();
        item10.setName("Phúc khảo điểm");
        item10.setLink(Constants.API_URL + "MauDon/mau_10_don_phuc_khao.doc");
        item.add(item10);

        item_maudon item11 = new item_maudon();
        item11.setName("Cấp giấy giới thiệu");
        item11.setLink(Constants.API_URL + "MauDon/mau_12-giay_gioi_thieu_dieu_chinh.doc");
        item.add(item11);

        item_maudon item12 = new item_maudon();
        item12.setName("Miễn học phần anh văn");
        item12.setLink(Constants.API_URL + "MauDon/mau_13_don_xin_mien_hoc_anh_van.doc");
        item.add(item12);

        item_maudon item13 = new item_maudon();
        item13.setName("Xét tốt nghiệp cho SV chính quy");
        item13.setLink(Constants.API_URL + "MauDon/mau_14_don_de_nghi_xet_tot_nghiep_.doc");
        item.add(item13);

        item_maudon item14 = new item_maudon();
        item14.setName("Khiếu nại khác");
        item14.setLink(Constants.API_URL + "MauDon/mau_06_giay_de_nghi.doc");
        item.add(item14);

        item_maudon item15 = new item_maudon();
        item15.setName("Biểu mẫu KLTN");
        item15.setLink(Constants.API_URL + "MauDon/BieuMauKLTN.zip");
        item.add(item15);
        adapter.notifyDataSetChanged();

        lvMaudon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                arg0.getChildAt(arg2).setBackgroundColor(Color.GRAY);
                if (save != -1 && save != arg2){
                    arg0.getChildAt(save).setBackgroundColor(Color.WHITE);
                }
                save = arg2;
                url = item.get(arg2).getLink();
                if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.M ){
                    if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED){
                        // permission denied, request it
                        String[] permission = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
                        requestPermissions(permission, PERMISSION_STORAGE_CODE);
                    }
                    else{
                        // permission already granted, perform download
                        startDownloading();
                    }
                }
                else {
                    // system os is less than marshmallow, perform download
                    startDownloading();
                }
            }
        });

    }
    private void startDownloading(){
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE);
        request.setTitle("Download");
        request.setDescription("Downloading file...");
        request.allowScanningByMediaScanner();
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, ""+System.currentTimeMillis());

        DownloadManager manager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        manager.enqueue(request);

    }

    // handle permission result


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_STORAGE_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    startDownloading();
                }
                else {
                    Toast.makeText(this, "Permisson deny...!", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
