package com.example.nhom7;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Score  extends AppCompatActivity {

    private JSONArray ja;
    private String UserID;

    private ArrayList<item_score> item_adapter1;
    private ArrayList<item_score> item_adapter2;
    private ArrayList<item_score> item_adapter3;
    private ArrayList<item_score> item_adapter4;
    private ArrayList<item_score> item_adapter5;
    private ArrayList<item_score> item_adapter6;
    private ArrayList<item_score> item_adapter7;
    private ArrayList<item_score> item_adapter8;
    private ArrayList<item_score> item_adapter9;

    private item_score_adapter is_adapter1 = null;
    private item_score_adapter is_adapter2 = null;
    private item_score_adapter is_adapter3 = null;
    private item_score_adapter is_adapter4 = null;
    private item_score_adapter is_adapter5 = null;
    private item_score_adapter is_adapter6 = null;
    private item_score_adapter is_adapter7 = null;
    private item_score_adapter is_adapter8 = null;
    private item_score_adapter is_adapter9 = null;

    private TextView sp1, sp2, sp3, sp4, sp5, sp6, sp7, sp8, sp9;
    private ListView lv1, lv2, lv3, lv4, lv5, lv6, lv7, lv8, lv9;
    private LinearLayout ll1, ll2, ll3, ll4, ll5, ll6, ll7, ll8, ll9;
    private LinearLayout v1, v2, v3, v4, v5, v6, v7, v8, v9;
    private ImageView img11, img12, img21, img22, img31, img32, img41, img42, img51, img52, img61, img62, img71, img72, img81, img82, img91, img92;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score);

        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");

        ImageView imgBack = (ImageView) findViewById(R.id.imgBack);

        ImageView imgThongbao = (ImageView) findViewById(R.id.imgThongBao);
        ImageView imgDiemDanh = (ImageView) findViewById(R.id.imgDiemDanh);
        ImageView imgMauDon = (ImageView) findViewById(R.id.ivMaudon);
        ImageView imgThongTinCaNhan = (ImageView) findViewById(R.id.imgThongTinCaNhan);
        ImageView imgHome = (ImageView) findViewById(R.id.imgHome);

        imgThongTinCaNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Score.this, infoUser.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Score.this, thongbao.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Score.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Score.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Score.this, maudon.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        sp1 = (TextView) findViewById(R.id.sp1);
        sp2 = (TextView) findViewById(R.id.sp2);
        sp3 = (TextView) findViewById(R.id.sp3);
        sp4 = (TextView) findViewById(R.id.sp4);
        sp5 = (TextView) findViewById(R.id.sp5);
        sp6 = (TextView) findViewById(R.id.sp6);
        sp7 = (TextView) findViewById(R.id.sp7);
        sp8 = (TextView) findViewById(R.id.sp8);
        sp9 = (TextView) findViewById(R.id.sp9);

        lv1 = (ListView) findViewById(R.id.lv1);
        lv2 = (ListView) findViewById(R.id.lv2);
        lv3 = (ListView) findViewById(R.id.lv3);
        lv4 = (ListView) findViewById(R.id.lv4);
        lv5 = (ListView) findViewById(R.id.lv5);
        lv6 = (ListView) findViewById(R.id.lv6);
        lv7 = (ListView) findViewById(R.id.lv7);
        lv8 = (ListView) findViewById(R.id.lv8);
        lv9 = (ListView) findViewById(R.id.lv9);

        ll1 = (LinearLayout) findViewById(R.id.ll1);
        ll2 = (LinearLayout) findViewById(R.id.ll2);
        ll3 = (LinearLayout) findViewById(R.id.ll3);
        ll4 = (LinearLayout) findViewById(R.id.ll4);
        ll5 = (LinearLayout) findViewById(R.id.ll5);
        ll6 = (LinearLayout) findViewById(R.id.ll6);
        ll7 = (LinearLayout) findViewById(R.id.ll7);
        ll8 = (LinearLayout) findViewById(R.id.ll8);
        ll9 = (LinearLayout) findViewById(R.id.ll9);

        img11 = (ImageView) findViewById(R.id.img11);
        img12 = (ImageView) findViewById(R.id.img12);
        img21 = (ImageView) findViewById(R.id.img21);
        img22 = (ImageView) findViewById(R.id.img22);
        img31 = (ImageView) findViewById(R.id.img31);
        img32 = (ImageView) findViewById(R.id.img32);
        img41 = (ImageView) findViewById(R.id.img41);
        img42 = (ImageView) findViewById(R.id.img42);
        img51 = (ImageView) findViewById(R.id.img51);
        img52 = (ImageView) findViewById(R.id.img52);
        img61 = (ImageView) findViewById(R.id.img61);
        img62 = (ImageView) findViewById(R.id.img62);
        img71 = (ImageView) findViewById(R.id.img71);
        img72 = (ImageView) findViewById(R.id.img72);
        img81 = (ImageView) findViewById(R.id.img81);
        img82 = (ImageView) findViewById(R.id.img82);
        img91 = (ImageView) findViewById(R.id.img91);
        img92 = (ImageView) findViewById(R.id.img92);

        v1 = (LinearLayout) findViewById(R.id.v1);
        v2 = (LinearLayout) findViewById(R.id.v2);
        v3 = (LinearLayout) findViewById(R.id.v3);
        v4 = (LinearLayout) findViewById(R.id.v4);
        v5 = (LinearLayout) findViewById(R.id.v5);
        v6 = (LinearLayout) findViewById(R.id.v6);
        v7 = (LinearLayout) findViewById(R.id.v7);
        v8 = (LinearLayout) findViewById(R.id.v8);
        v9 = (LinearLayout) findViewById(R.id.v9);

        v1.setVisibility(View.GONE);
        v2.setVisibility(View.GONE);
        v3.setVisibility(View.GONE);
        v4.setVisibility(View.GONE);
        v5.setVisibility(View.GONE);
        v6.setVisibility(View.GONE);
        v7.setVisibility(View.GONE);
        v8.setVisibility(View.GONE);
        v9.setVisibility(View.GONE);

        sp1.setVisibility(View.GONE);
        sp2.setVisibility(View.GONE);
        sp3.setVisibility(View.GONE);
        sp4.setVisibility(View.GONE);
        sp5.setVisibility(View.GONE);
        sp6.setVisibility(View.GONE);
        sp7.setVisibility(View.GONE);
        sp8.setVisibility(View.GONE);
        sp9.setVisibility(View.GONE);

        lv1.setVisibility(View.GONE);
        lv2.setVisibility(View.GONE);
        lv3.setVisibility(View.GONE);
        lv4.setVisibility(View.GONE);
        lv5.setVisibility(View.GONE);
        lv6.setVisibility(View.GONE);
        lv7.setVisibility(View.GONE);
        lv8.setVisibility(View.GONE);
        lv9.setVisibility(View.GONE);

        ll1.setVisibility(View.GONE);
        ll2.setVisibility(View.GONE);
        ll3.setVisibility(View.GONE);
        ll4.setVisibility(View.GONE);
        ll5.setVisibility(View.GONE);
        ll6.setVisibility(View.GONE);
        ll7.setVisibility(View.GONE);
        ll8.setVisibility(View.GONE);
        ll9.setVisibility(View.GONE);

        img11.setVisibility(View.VISIBLE);
        img21.setVisibility(View.VISIBLE);
        img31.setVisibility(View.VISIBLE);
        img41.setVisibility(View.VISIBLE);
        img51.setVisibility(View.VISIBLE);
        img61.setVisibility(View.VISIBLE);
        img71.setVisibility(View.VISIBLE);
        img81.setVisibility(View.VISIBLE);
        img91.setVisibility(View.VISIBLE);

        img12.setVisibility(View.GONE);
        img22.setVisibility(View.GONE);
        img32.setVisibility(View.GONE);
        img42.setVisibility(View.GONE);
        img52.setVisibility(View.GONE);
        img62.setVisibility(View.GONE);
        img72.setVisibility(View.GONE);
        img82.setVisibility(View.GONE);
        img92.setVisibility(View.GONE);

        item_adapter1 = new ArrayList<item_score>();
        item_adapter2 = new ArrayList<item_score>();
        item_adapter3 = new ArrayList<item_score>();
        item_adapter4 = new ArrayList<item_score>();
        item_adapter5 = new ArrayList<item_score>();
        item_adapter6 = new ArrayList<item_score>();
        item_adapter7 = new ArrayList<item_score>();
        item_adapter8 = new ArrayList<item_score>();
        item_adapter9 = new ArrayList<item_score>();


        is_adapter1 = new item_score_adapter(this, R.layout.score_adapter, item_adapter1);
        is_adapter2 = new item_score_adapter(this, R.layout.score_adapter, item_adapter2);
        is_adapter3 = new item_score_adapter(this, R.layout.score_adapter, item_adapter3);
        is_adapter4 = new item_score_adapter(this, R.layout.score_adapter, item_adapter4);
        is_adapter5 = new item_score_adapter(this, R.layout.score_adapter, item_adapter5);
        is_adapter6 = new item_score_adapter(this, R.layout.score_adapter, item_adapter6);
        is_adapter7 = new item_score_adapter(this, R.layout.score_adapter, item_adapter7);
        is_adapter8 = new item_score_adapter(this, R.layout.score_adapter, item_adapter8);
        is_adapter9 = new item_score_adapter(this, R.layout.score_adapter, item_adapter9);


        lv1.setAdapter(is_adapter1);
        lv2.setAdapter(is_adapter2);
        lv3.setAdapter(is_adapter3);
        lv4.setAdapter(is_adapter4);
        lv5.setAdapter(is_adapter5);
        lv6.setAdapter(is_adapter6);
        lv7.setAdapter(is_adapter7);
        lv8.setAdapter(is_adapter8);
        lv9.setAdapter(is_adapter9);

        getScore();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            initList();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lv1.getVisibility() == View.VISIBLE) {
                    img11.setVisibility(View.VISIBLE);
                    img12.setVisibility(View.GONE);
                    lv1.setVisibility(View.GONE);
                    v1.setVisibility(View.GONE);
                } else {
                    lv1.setVisibility(View.VISIBLE);
                    img12.setVisibility(View.VISIBLE);
                    img11.setVisibility(View.GONE);
                    v1.setVisibility(View.VISIBLE);
                    v1.setVisibility(View.VISIBLE);
                }
            }
        });

        ll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lv2.getVisibility() == View.VISIBLE) {
                    lv2.setVisibility(View.GONE);
                    img21.setVisibility(View.VISIBLE);
                    img22.setVisibility(View.GONE);
                    v2.setVisibility(View.GONE);
                } else {
                    lv2.setVisibility(View.VISIBLE);
                    img22.setVisibility(View.VISIBLE);
                    img21.setVisibility(View.GONE);
                    v2.setVisibility(View.VISIBLE);
                }
            }
        });

        ll3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lv3.getVisibility() == View.VISIBLE) {
                    lv3.setVisibility(View.GONE);
                    img31.setVisibility(View.VISIBLE);
                    img32.setVisibility(View.GONE);
                    v3.setVisibility(View.GONE);
                } else {
                    lv3.setVisibility(View.VISIBLE);
                    img32.setVisibility(View.VISIBLE);
                    img31.setVisibility(View.GONE);
                    v3.setVisibility(View.VISIBLE);
                }
            }
        });

        ll4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lv4.getVisibility() == View.VISIBLE) {
                    lv4.setVisibility(View.GONE);
                    img41.setVisibility(View.VISIBLE);
                    img42.setVisibility(View.GONE);
                    v4.setVisibility(View.GONE);
                } else {
                    lv4.setVisibility(View.VISIBLE);
                    img42.setVisibility(View.VISIBLE);
                    img41.setVisibility(View.GONE);
                    v4.setVisibility(View.VISIBLE);
                }
            }
        });

        ll5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lv5.getVisibility() == View.VISIBLE) {
                    lv5.setVisibility(View.GONE);
                    img51.setVisibility(View.VISIBLE);
                    img52.setVisibility(View.GONE);
                    v5.setVisibility(View.GONE);
                } else {
                    lv5.setVisibility(View.VISIBLE);
                    img52.setVisibility(View.VISIBLE);
                    img51.setVisibility(View.GONE);
                    v5.setVisibility(View.VISIBLE);
                }
            }
        });

        ll6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lv6.getVisibility() == View.VISIBLE) {
                    lv6.setVisibility(View.GONE);
                    img61.setVisibility(View.VISIBLE);
                    img62.setVisibility(View.GONE);
                    v6.setVisibility(View.GONE);
                } else {
                    lv6.setVisibility(View.VISIBLE);
                    img62.setVisibility(View.VISIBLE);
                    img61.setVisibility(View.GONE);
                    v6.setVisibility(View.VISIBLE);
                }
            }
        });

        ll7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lv7.getVisibility() == View.VISIBLE) {
                    lv7.setVisibility(View.GONE);
                    img71.setVisibility(View.VISIBLE);
                    img72.setVisibility(View.GONE);
                    v7.setVisibility(View.GONE);
                } else {
                    lv7.setVisibility(View.VISIBLE);
                    img72.setVisibility(View.VISIBLE);
                    img71.setVisibility(View.GONE);
                    v7.setVisibility(View.VISIBLE);
                }
            }
        });

        ll8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lv8.getVisibility() == View.VISIBLE) {
                    lv8.setVisibility(View.GONE);
                    img81.setVisibility(View.VISIBLE);
                    img82.setVisibility(View.GONE);
                    v8.setVisibility(View.GONE);
                } else {
                    lv8.setVisibility(View.VISIBLE);
                    img82.setVisibility(View.VISIBLE);
                    img81.setVisibility(View.GONE);
                    v8.setVisibility(View.VISIBLE);
                }
            }
        });

        ll9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lv9.getVisibility() == View.VISIBLE) {
                    lv9.setVisibility(View.GONE);
                    img91.setVisibility(View.VISIBLE);
                    img92.setVisibility(View.GONE);
                    v9.setVisibility(View.GONE);
                } else {
                    lv9.setVisibility(View.VISIBLE);
                    img92.setVisibility(View.VISIBLE);
                    img91.setVisibility(View.GONE);
                    v9.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void getScore() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    ja = API.API(userid, "", "", "", Constants.score_URL);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

    }

    private void initList() throws JSONException {

        for (int i=0; i < ja.length(); i++) {

            JSONObject jo = ja.getJSONObject(i);

            item_score item = new item_score();

            String ki = jo.getString("Ki");
            String nam = jo.getString("NamHoc");
            String mamh = jo.getString("MaMH");
            String malop = jo.getString("MaLop");
            String tc = jo.getString("TinChi");
            String qt = jo.getString("QuaTrinh");
            String gk = jo.getString("GiuaKi");
            String th = jo.getString("ThucHanh");
            String ck = jo.getString("CuoiKi");
            String tb = jo.getString("DTB");


            // add item
            item.setCK(ck);
            item.setGK(gk);
            item.setKi(ki);
            item.setMaLop(malop);
            item.setMaMH(mamh);
            item.setNamHoc(nam);
            item.setQT(qt);
            item.setTB(tb);
            item.setTC(tc);
            item.setTH(th);

            switch (ki){
                case "1": item_adapter1.add(item);
                    Log.e("khoa", ki+" ki");
                    Log.e("khoa", tb+" tb");
                    sp1.setVisibility(View.VISIBLE);
                    ll1.setVisibility(View.VISIBLE);
                    sp1.setText("HKI (" + nam + ")");
                    break;
                case "2": item_adapter2.add(item);
                    sp2.setVisibility(View.VISIBLE);
                    ll2.setVisibility(View.VISIBLE);
                    sp2.setText("HKII (" + nam + ")");
                    break;
                case "3": item_adapter3.add(item);
                    sp3.setVisibility(View.VISIBLE);
                    ll3.setVisibility(View.VISIBLE);
                    sp3.setText("HKI (" + nam + ")");
                    break;
                case "4": item_adapter4.add(item);
                    sp4.setVisibility(View.VISIBLE);
                    ll4.setVisibility(View.VISIBLE);
                    sp4.setText("HKII (" + nam + ")");
                    break;
                case "5": item_adapter5.add(item);
                    sp5.setVisibility(View.VISIBLE);
                    ll5.setVisibility(View.VISIBLE);
                    sp5.setText("HKI (" + nam + ")");
                    break;
                case "6": item_adapter6.add(item);
                    sp6.setVisibility(View.VISIBLE);
                    ll6.setVisibility(View.VISIBLE);
                    sp6.setText("HKII (" + nam + ")");
                    break;
                case "7": item_adapter7.add(item);
                    sp7.setVisibility(View.VISIBLE);
                    ll7.setVisibility(View.VISIBLE);
                    sp7.setText("HKI (" + nam + ")");
                    break;
                case "8": item_adapter8.add(item);
                    sp8.setVisibility(View.VISIBLE);
                    ll8.setVisibility(View.VISIBLE);
                    sp8.setText("HKII (" + nam + ")");
                    break;
                case "9": item_adapter9.add(item);
                    sp9.setVisibility(View.VISIBLE);
                    ll9.setVisibility(View.VISIBLE);
                    sp9.setText("HKI (" + nam + ")");
                    break;
            }
        }
        is_adapter1.notifyDataSetChanged();
        is_adapter2.notifyDataSetChanged();
        is_adapter3.notifyDataSetChanged();
        is_adapter4.notifyDataSetChanged();
        is_adapter5.notifyDataSetChanged();
        is_adapter6.notifyDataSetChanged();
        is_adapter7.notifyDataSetChanged();
        is_adapter8.notifyDataSetChanged();
        is_adapter8.notifyDataSetChanged();
    }
}
