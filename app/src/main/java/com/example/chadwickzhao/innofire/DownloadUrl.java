package com.example.chadwickzhao.innofire;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chadwickzhao on 21/08/16.
 */
public class DownloadUrl {

 public String readUrl(String strUrl) throws IOException {
     String data = "";
     InputStream iSream = null;
     HttpURLConnection urlConnection = null;
     try{
         URL url = new URL(strUrl);

         urlConnection = (HttpURLConnection) url.openConnection();
         urlConnection.connect();
         iSream = urlConnection.getInputStream();
         BufferedReader br = new BufferedReader(new InputStreamReader(iSream));
         StringBuffer sb = new StringBuffer();

         String line = "";
         while ((line = br.readLine()) != null){
             sb.append(line);
         }


         data = sb.toString();
         Log.d("downloadUrl", data.toString());
         br.close();

     }catch(Exception e){

         Log.d("Exception", e.toString());
     }finally{

         iSream.close();
         urlConnection.disconnect();
     }

     return data;
 }

}
