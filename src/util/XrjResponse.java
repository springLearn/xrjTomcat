package util;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/*
 * @author xrj
 * @version 1.0
 * 封装响应对象
 * */
public class XrjResponse {
    private OutputStream outputStream;

    public XrjResponse(OutputStream outputStream){
        this.outputStream=outputStream;
    }

    public void write(StringBuffer content)throws IOException{
       StringBuffer patternContent=new StringBuffer();
       patternContent.append("HTTP/1.1 200 OK\\n")
               .append("Content-Type: text/html\n")
               .append("\r\n")
               .append("<html><body>")
               .append(content.toString())
               .append("</body></html>");
        outputStream.write(patternContent.toString().getBytes());
        outputStream.flush();
        outputStream.close();

    }

}
