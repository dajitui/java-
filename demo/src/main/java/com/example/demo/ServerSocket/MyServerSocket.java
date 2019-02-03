package com.example.demo.ServerSocket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServerSocket {
    public static void main(String[] args) {
        InputStream inputStream = null;

        String str=null;
        try {
            ServerSocket serverSocket=new ServerSocket(8111);
            System.out.println("服务器已开启8111端口监听...");
            Socket socket=serverSocket.accept();
            inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader=new InputStreamReader(inputStream);
            BufferedReader br=new BufferedReader(inputStreamReader);
            while((str=br.readLine())!=null){
                System.out.println("服务端接收到信息:"+str);
            }
            OutputStream outputStream=socket.getOutputStream();
            outputStream.write("收到信息".getBytes());
            outputStream.flush();
            outputStream.close();
            br.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
