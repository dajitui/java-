package com.example.demo.URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {
    public static void main(String[] args) {
        try {
            URL url=new URL("http://123.207.111.178:8081/login");
            URLConnection urlConnection=url.openConnection();
            String str=null;
            InputStream inputStream=urlConnection.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(inputStreamReader);
            while((str=br.readLine())!=null){
                System.out.println("服务端接收到信息:"+str);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
