package src.tomcat;

import src.util.XrjRequest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServeletTomcat {
    volatile boolean  acceptService =true;
    public void acceptClientRequest(){
        ServerSocket serverSocket=null;
        try{
             serverSocket=new ServerSocket(8081);
             while(acceptService){
                 Socket socket=serverSocket.accept();
                 InputStream inputStream=socket.getInputStream();
                 XrjRequest xrjRequest=new XrjRequest(inputStream);
                 OutputStream outputStream=socket.getOutputStream();
                 socket.close();
             }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(null!=serverSocket){
                try{
                    serverSocket.close();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }

    }
    public static void main(String[] args){
        ServeletTomcat serveletTomcat=new ServeletTomcat();
        serveletTomcat.acceptClientRequest();
    }

}
