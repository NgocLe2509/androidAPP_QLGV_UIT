package com.example.nhom7;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class API {
    public static JSONArray API(String item1, String item2, String item3, String item4, String URL){
        BufferedReader reader=null;
        JSONArray ja = null;
        try
        {
            // Defined URL  where to send data
            URL url = new URL(URL);
            String urlParameters = "item1=" + item1  + "&item2=" + item2 + "&item3=" + item3 + "&item4=" + item4;
            HttpURLConnection conn;
            byte[] postData = urlParameters.getBytes( StandardCharsets.UTF_8 );
            int postDataLength = postData.length;
            conn= (HttpURLConnection) url.openConnection();
            conn.setInstanceFollowRedirects( false );
            conn.setRequestMethod( "POST" );
            conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty( "charset", "utf-8");
            conn.setRequestProperty( "Content-Length", Integer.toString( postDataLength ));
            conn.setUseCaches( false );
            conn.setDoInput( true );
            conn.setDoOutput( true );

            // Send POST data request
            DataOutputStream wr = new DataOutputStream( conn.getOutputStream());
            wr.write( postData );
            wr.flush();
            wr.close();

            // Get the server response
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
            }
            String response = sb.toString();
            ja = new JSONArray(response);

        }
        catch(Exception ex)
        {

        }
        finally
        {
            try
            {
                reader.close();
            }

            catch(Exception ex) {}
        }
        return ja;
    }
}
