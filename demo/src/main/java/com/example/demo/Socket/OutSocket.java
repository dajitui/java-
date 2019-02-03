package com.example.demo.Socket;

import java.io.*;
import java.net.Socket;

public class OutSocket {
    public static void main(String[] args) {
        OutputStream outputStream = null;
        try {
            Socket socket = new Socket("127.0.0.1", 8111);
            outputStream = socket.getOutputStream();
            outputStream.write("大鸡腿".getBytes());
            outputStream.flush();
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(inputStreamReader);
            String str=null;
            while((str=br.readLine())!=null){
                System.out.println("服务端接收到信息:"+str);
            }
            br.close();
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
