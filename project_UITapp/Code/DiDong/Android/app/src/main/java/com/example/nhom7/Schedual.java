package com.example.nhom7;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Schedual extends AppCompatActivity {

    private ListView lvSchedual;
    private String UserID;
    private  String position;
    private TextView Hai, Ba, Tu, Nam, Sau, Bay, CN, tvMonth, tvNonData;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd");

    ArrayList<item_schedual> item = new ArrayList<item_schedual>();
    item_schedual_adapter adapter =null;
    private JSONArray ja;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedual);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");

        ImageView imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Schedual.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        ImageView imgThongbao = (ImageView) findViewById(R.id.imgThongBao);
        ImageView imgDiemDanh = (ImageView) findViewById(R.id.imgDiemDanh);
        ImageView imgMauDon = (ImageView) findViewById(R.id.ivMaudon);
        ImageView imgThongTinCaNhan = (ImageView) findViewById(R.id.imgThongTinCaNhan);
        ImageView imgHome = (ImageView) findViewById(R.id.imgHome);

        imgThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Schedual.this, infoUser.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Schedual.this, thongbao.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Schedual.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Schedual.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Schedual.this, maudon.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        getSchedual();

        Hai = (TextView) findViewById(R.id.Hai);
        Ba = (TextView) findViewById(R.id.Ba);
        Tu = (TextView) findViewById(R.id.Tu);
        Nam = (TextView) findViewById(R.id.Nam);
        Sau = (TextView) findViewById(R.id.Sau);
        Bay = (TextView) findViewById(R.id.Bay);
        CN = (TextView) findViewById(R.id.CN);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvNonData = (TextView) findViewById(R.id.tvNonData);
        tvNonData.setVisibility(View.GONE);

        // listview
        lvSchedual = (ListView)findViewById(R.id.lvSchedual);
        item = new ArrayList<item_schedual>();

        adapter = new item_schedual_adapter(this, R.layout.schedual_adapter, item);
        lvSchedual.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        //
        // handling date
        //
        Date date = new Date();
        String strDate = date.toString();
        String[] ex = strDate.split(" ");

        Calendar date1 = Calendar.getInstance();

        // set tvMonth
        switch (ex[1]){
            case "Jan": tvMonth.setText("Tháng 1");
                break;
            case "Feb": tvMonth.setText("Tháng 2");
                break;
            case "Mar": tvMonth.setText("Tháng 3");
                break;
            case "Apr": tvMonth.setText("Tháng 4");
                break;
            case "May": tvMonth.setText("Tháng 5");
                break;
            case "Jun": tvMonth.setText("Tháng 6");
                break;
            case "Jul": tvMonth.setText("Tháng 7");
                break;
            case "Aug": tvMonth.setText("Tháng 8");
                break;
            case "Sep": tvMonth.setText("Tháng 9");
                break;
            case "Oct": tvMonth.setText("Tháng 10");
                break;
            case "Nov": tvMonth.setText("Tháng 11");
                break;
            case "Dec": tvMonth.setText("Tháng 12");
                break;
        }


        // set day
        switch (ex[0]){
            case "Mon": position = "2";
                Hai.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Ba.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Tu.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Nam.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Sau.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Bay.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                CN.setText(dateFormat.format(date1.getTime()));
                break;
            case "Tue": position = "3";
                date1.roll(Calendar.DATE, -1);
                Hai.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Ba.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Tu.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Nam.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Sau.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Bay.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                CN.setText(dateFormat.format(date1.getTime()));
                break;
            case "Wed": position = "4";
                date1.roll(Calendar.DATE, -2);
                Hai.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Ba.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Tu.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Nam.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Sau.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Bay.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                CN.setText(dateFormat.format(date1.getTime()));
                break;
            case "Thu": position = "5";
                date1.roll(Calendar.DATE, -3);
                Hai.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Ba.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Tu.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Nam.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Sau.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Bay.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                CN.setText(dateFormat.format(date1.getTime()));
                break;
            case "Fri": position = "6";
                date1.roll(Calendar.DATE, -4);
                Hai.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Ba.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Tu.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Nam.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Sau.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Bay.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                CN.setText(dateFormat.format(date1.getTime()));
                break;
            case "Sat": position = "7";
                date1.roll(Calendar.DATE, -5);
                Hai.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Ba.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Tu.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Nam.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Sau.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Bay.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                CN.setText(dateFormat.format(date1.getTime()));
                break;
            case "Sun": position = "8";
                date1.roll(Calendar.DATE, -6);
                Hai.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Ba.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Tu.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Nam.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Sau.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                Bay.setText(dateFormat.format(date1.getTime()));
                date1.roll(Calendar.DATE, 1);
                CN.setText(dateFormat.format(date1.getTime()));
                break;
        }



        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            setAdater(position);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // set day
        switch (ex[0]){
            case "Mon":
                Hai.setBackgroundResource(R.drawable.backgroup_tron);
                Hai.setTextColor(getColor(R.color.colorWhite));
                break;
            case "Tue":
                Ba.setBackgroundResource(R.drawable.backgroup_tron);
                Ba.setTextColor(getColor(R.color.colorWhite));
                break;
            case "Wed":
                Tu.setBackgroundResource(R.drawable.backgroup_tron);
                Tu.setTextColor(getColor(R.color.colorWhite));
                break;
            case "Thu":
                Nam.setBackgroundResource(R.drawable.backgroup_tron);
                Nam.setTextColor(getColor(R.color.colorWhite));
                break;
            case "Fri":
                Sau.setBackgroundResource(R.drawable.backgroup_tron);
                Sau.setTextColor(getColor(R.color.colorWhite));
                break;
            case "Sat":
                Bay.setBackgroundResource(R.drawable.backgroup_tron);
                Bay.setTextColor(getColor(R.color.colorWhite));
                break;
            case "Sun":
                CN.setBackgroundResource(R.drawable.backgroup_tron);
                CN.setTextColor(getColor(R.color.colorWhite));
                break;
        }

        Hai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setAdater("2");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Hai.setBackgroundResource(R.drawable.backgroup_tron);
                Hai.setTextColor(getColor(R.color.colorWhite));
            }
        });
        Ba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setAdater("3");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Ba.setBackgroundResource(R.drawable.backgroup_tron);
                Ba.setTextColor(getColor(R.color.colorWhite));
            }
        });
        Tu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setAdater("4");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Tu.setBackgroundResource(R.drawable.backgroup_tron);
                Tu.setTextColor(getColor(R.color.colorWhite));
            }
        });
        Nam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setAdater("5");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Nam.setBackgroundResource(R.drawable.backgroup_tron);
                Nam.setTextColor(getColor(R.color.colorWhite));
            }
        });
        Sau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setAdater("6");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Sau.setBackgroundResource(R.drawable.backgroup_tron);
                Sau.setTextColor(getColor(R.color.colorWhite));
            }
        });
        Bay.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                try {
                    setAdater("7");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Bay.setBackgroundResource(R.drawable.backgroup_tron);
                Bay.setTextColor(getColor(R.color.colorWhite));
            }
        });
        CN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    setAdater("8");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                CN.setBackgroundResource(R.drawable.backgroup_tron);
                CN.setTextColor(getColor(R.color.colorWhite));
            }
        });
    }
    //
    // thread get info user
    //
    private void getSchedual() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    ja = API.API(userid, "", "", "", Constants.Schedual_URL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    @SuppressLint("ResourceAsColor")
    private void setAdater(String Day) throws JSONException {
        Hai.setBackgroundResource(0);
        Ba.setBackgroundResource(0);
        Tu.setBackgroundResource(0);
        Nam.setBackgroundResource(0);
        Sau.setBackgroundResource(0);
        Bay.setBackgroundResource(0);
        CN.setBackgroundResource(0);

        Hai.setTextColor(getColor(R.color.colorBack));
        Ba.setTextColor(getColor(R.color.colorBack));
        Tu.setTextColor(getColor(R.color.colorBack));
        Nam.setTextColor(getColor(R.color.colorBack));
        Sau.setTextColor(getColor(R.color.colorBack));
        Bay.setTextColor(getColor(R.color.colorBack));
        CN.setTextColor(getColor(R.color.colorBack));

        item.clear();
        for (int i=0; i < ja.length(); i++) {
            Log.e("name","ahihi");
            JSONObject jo = ja.getJSONObject(i);

            String day = jo.getString("Day");

            if( day.equals(Day)){

                item_schedual item1 = new item_schedual();

                item1.setID(jo.getString("MaLopHP"));
                item1.setName(jo.getString("TenLop"));

                String ca = "Tiết: " + jo.getString("TietBD") + jo.getString("TietSau");
                item1.setTime(ca);

                item1.setRoom(jo.getString("Phong"));
                item1.setGV(jo.getString("TenGV"));
                String thu = "Thứ " + jo.getString("Day");
                item1.setDay(thu);
                item.add(item1);
            }
        }
        adapter.notifyDataSetChanged();
        if(item.size() == 0){
            lvSchedual.setVisibility(View.GONE);
            tvNonData.setVisibility(View.VISIBLE);
        }
        else {
            lvSchedual.setVisibility(View.VISIBLE);
            tvNonData.setVisibility(View.GONE);
        }

    }
}
