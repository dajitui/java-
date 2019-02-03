package com.example.demo.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class InSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8111);
            System.out.println("监听8111端口返回信息...");
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(inputStreamReader);
            String str=null;
            while((str=br.readLine())!=null){
                System.out.println("服务端接收到信息:"+str);
            }
            br.close();
            inputStream.close();
            socket.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
