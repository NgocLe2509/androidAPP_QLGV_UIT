package com.example.nhom7;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.OpenableColumns;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class deadline extends AppCompatActivity implements item_deadline_adapter.customButtonListener {

    String UserID;
    JSONArray ja;
    ListView lvDeadline;

    ArrayList<item_deadline> item = new ArrayList<item_deadline>();
    item_deadline_adapter adapter =null;

    private static final int PICK_FILE_REQUEST = 6384;
    int serverResponseCode = 0;
    ProgressDialog dialog = null;

    private String sttBai;
    private int positionAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deadline);


        Intent intent = this.getIntent();
        UserID = intent.getStringExtra("UserID");

        ImageView imgBack = (ImageView) findViewById(R.id.imgBack);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(deadline.this, home.class);
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
                Intent intent = new Intent(deadline.this, infoUser.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgThongbao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(deadline.this, thongbao.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(deadline.this, home.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgDiemDanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(deadline.this, diemdanh.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });
        imgMauDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(deadline.this, maudon.class);
                intent.putExtra("UserID",UserID);
                startActivity(intent);
            }
        });

        lvDeadline = (ListView)findViewById(R.id.listitem);
        item = new ArrayList<item_deadline>();

        adapter = new item_deadline_adapter(this, R.layout.deadline_adapter, item, UserID);
        adapter.setCustomButtonListner(deadline.this);
        lvDeadline.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        deadline();
    }

    @Override
    public void onButtonClickListner(int position) {
        deleteBaiNop(item.get(position).getSttbainop(),position);
    }

    @Override
    public void onButtonADDClickListner(int position) {
        sttBai = item.get(position).getSttbai();
        positionAdd = position;
        dialog = ProgressDialog.show(this, "", "Uploading file...", true);
        onBrowse();
    }

    // get deadline
    private void deadline() {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    //Your code goes here
                    String userid = UserID;
                    String URL = Constants.deadline_URL;
                    ja = API.API(userid, "", "", "", URL);
                    int leng = ja.length();
                    for(int i = leng-1; i>=0; i--){
                        try {
                            JSONObject jo = ja.getJSONObject(i);

                            item_deadline item1 = new item_deadline();
                            item1.setMalop(jo.getString("malop"));
                            item1.setNoidung(jo.getString("noidung"));
                            item1.setDeadline(jo.getString("deadline"));
                            item1.setHanchot(jo.getString("hanchot"));
                            item1.setNopbai(jo.getString("tinhtrang"));
                            item1.setFilename(jo.getString("filename"));
                            item1.setSttbainop(jo.getString("STTBaiNop"));
                            item1.setSttbai(jo.getString("STTBai"));


                            item.add(item1);
                        } catch (Exception e) {
                            Log.e("name", e.getMessage());
                        }
                    }
                    adapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    // delete BaiNop
    private void deleteBaiNop(final String sttbainop, final int position) {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    JSONArray ja = API.API(UserID, sttbainop, "", "", Constants.deleteNopBai_URL);

                    try {
                        JSONObject jo = ja.getJSONObject(0);

                        if(jo.getString("code").equals("ok")){
                            item.get(position).setNopbai("Chưa nộp bài");
                            item.get(position).setFilename("null");
                            item.get(position).setSttbainop("null");
                            Toast.makeText(deadline.this, "Xóa bài nộp thành công!", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(deadline.this, "Xóa bài nộp không thành công!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    //
    // ---------------------------------------------------- upload Bai Nop --------------------------------------------------------------------
    //

    public void onBrowse() {
        Intent intent = new Intent();
        //sets the select file to all types of files
        intent.setType("*/*");
        //allows to select data and return it
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //starts new activity to select file and return data
        startActivityForResult(Intent.createChooser(intent, "Choose File to Upload.."), PICK_FILE_REQUEST);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == PICK_FILE_REQUEST) {
                if (data == null) {
                    //no data present
                    return;
                }
                Uri selectedFileUri = data.getData();
                String name = getFileName(selectedFileUri);
                upload_file(selectedFileUri, name);
            }
        }
    }

    private void upload_file(final Uri uri, final String name) {
        final Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    uploadFile(uri, name);
                    JSONArray jaNopBai = API.API(UserID, sttBai, name, "", Constants.addBaiNop_URL);
                    try {
                        JSONObject jo = jaNopBai.getJSONObject(0);

                        if(jo.getString("code").equals("ok")){
                            item.get(positionAdd).setNopbai("Đã Nộp Bài");
                            item.get(positionAdd).setFilename(name);
                            item.get(positionAdd).setSttbainop(jo.getString("SttBaiNop"));
                            Toast.makeText(deadline.this, "Nộp bài thành công!", Toast.LENGTH_SHORT).show();
                            adapter.notifyDataSetChanged();
                            lvDeadline.invalidateViews();
                            lvDeadline.refreshDrawableState();
                        }
                        else {
                            Toast.makeText(deadline.this, "Nộp bài không thành công!", Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }

    public String getFileName(Uri uri) {
        String result = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    result = cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                }
            } finally {
                cursor.close();
            }
        }
        if (result == null) {
            result = uri.getPath();
            int cut = result.lastIndexOf('/');
            if (cut != -1) {
                result = result.substring(cut + 1);
            }
        }
        return result;
    }

    public int uploadFile(Uri selectedFileUri, String name) throws IOException {
        HttpURLConnection connection;
        DataOutputStream dataOutputStream;
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1 * 1024 * 1024;

        InputStream inputStream = getContentResolver().openInputStream(selectedFileUri);

        try {
            URL url = new URL(Constants.uploadBaiNop_URL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);//Allow Inputs
            connection.setDoOutput(true);//Allow Outputs
            connection.setUseCaches(false);//Don't use a cached Copy
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("ENCTYPE", "multipart/form-data");
            connection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
            connection.setRequestProperty("uploaded_file", name);

            //creating new dataoutputstream
            dataOutputStream = new DataOutputStream(connection.getOutputStream());

            //writing bytes to data outputstream
            dataOutputStream.writeBytes(twoHyphens + boundary + lineEnd);
            dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\";filename=\""
                    + name + "\"" + lineEnd);

            dataOutputStream.writeBytes(lineEnd);

            //returns no. of bytes present in fileInputStream
            bytesAvailable = inputStream.available();
            //selecting the buffer size as minimum of available bytes or 1 MB
            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            //setting the buffer as byte array of size of bufferSize
            buffer = new byte[bufferSize];

            //reads bytes from FileInputStream(from 0th index of buffer to buffersize)
            bytesRead = inputStream.read(buffer, 0, bufferSize);

            //loop repeats till bytesRead = -1, i.e., no bytes are left to read
            while (bytesRead > 0) {
                //write the bytes read from inputstream
                dataOutputStream.write(buffer, 0, bufferSize);
                bytesAvailable = inputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = inputStream.read(buffer, 0, bufferSize);
            }

            dataOutputStream.writeBytes(lineEnd);
            dataOutputStream.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

            serverResponseCode = connection.getResponseCode();
            String serverResponseMessage = connection.getResponseMessage();

            Log.i("testLan1", "Server Response is: " + serverResponseMessage + ": " + serverResponseCode);

            //response code of 200 indicates the server status OK
            if (serverResponseCode == 200) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //tvFileName.setText("File Upload completed.\n\n You can see the uploaded file here: \n\n" + "http://coderefer.com/extras/uploads/" + name);
                    }
                });
            }
            //closing the input and output streams
            inputStream.close();
            dataOutputStream.flush();
            dataOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //Toast.makeText(NewClassPdf.this,"File Not Found",Toast.LENGTH_SHORT).show();
                }
            });
        } catch (MalformedURLException e) {
            e.printStackTrace();
            //Toast.makeText(NewClassPdf.this, "URL error!", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
            //Toast.makeText(NewClassPdf.this, "Cannot Read/Write File!", Toast.LENGTH_SHORT).show();
        }
        dialog.dismiss();
        return serverResponseCode;
    }
}