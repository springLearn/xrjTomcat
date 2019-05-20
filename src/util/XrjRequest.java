package util;

import java.io.IOException;
import java.io.InputStream;
/*
* @author xrj
* @version 1.0
* 封装请求对象
* */
public class XrjRequest {
    private String url;
    private String method;

    public XrjRequest(InputStream inputStream)throws IOException{

        String requestContent=null;
        byte[] readByte=new byte[1024];
        int length=0;
        while((length=inputStream.read(readByte))>0){
            requestContent=new String(readByte,0,length);
        }
        System.out.println(requestContent);
        if(null!=requestContent){
            String httpHead=requestContent.split("\n")[0];
            method=httpHead.split("\\s")[0];
            url=httpHead.split("\\s")[1];
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
