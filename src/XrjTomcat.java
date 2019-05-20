import util.XrjRequest;
import util.XrjResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class XrjTomcat {
    private static int port=8080;
    private Map<String,String> urlServletMap=new HashMap<String,String>();
    public static void main(String[] args){
        //定义接受服务的socket
        ServerSocket serverSocket=null;
        try{
            serverSocket=new ServerSocket(port);
            System.out.println("MyTomcat is start ...");
            while(true){
                Socket scket=serverSocket.accept();
                InputStream inputStream=scket.getInputStream();
                OutputStream outputStream=scket.getOutputStream();
                //把请求的内容转成httpRequest对象
                XrjRequest xrjRequest=new XrjRequest(inputStream);
                XrjResponse xrjResponse=new XrjResponse(outputStream);
                StringBuffer writeContent=new StringBuffer();
                writeContent.append("好好学习，天天向上");
                xrjResponse.write(writeContent);
                scket.close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            if (null != serverSocket){
            try{
                serverSocket.close();
            }catch (IOException e){
                e.printStackTrace(); }}}
    }
}
