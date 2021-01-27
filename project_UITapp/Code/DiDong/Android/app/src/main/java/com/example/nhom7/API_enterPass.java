package com.example.nhom7;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class API_enterPass {
    public static String resetPass(String UserID, String pass){
        BufferedReader reader=null;
        String error = null;
        try
        {
            // Defined URL  where to send data
            URL url = new URL(Constants.resetPass_URL);
            String urlParameters = "UserID=" + UserID + "&newPassword=" + pass;
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
            JSONObject jo = new JSONObject(response);
            error = jo.getString("error");
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
        return error;
    }
}
