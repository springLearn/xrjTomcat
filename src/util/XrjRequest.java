package src.util;


import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class XrjRequest {
    private InputStream inputStream;
    public XrjRequest(InputStream inputStream) {
        this.inputStream=inputStream;
    }
    public RequestWrapper parseInputStreamToWrapper(InputStream inputStream) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        StringBuffer requestContent=new StringBuffer();
        byte[] readContent=new byte[1024];
        int length=0;
        while((length=inputStream.read(readContent))!=-1){
            requestContent.append(new String(readContent,0,length));
        }
        Field[] fields=RequestWrapper.class.getDeclaredFields();
        RequestWrapper.class.getDeclaredConstructors();
        RequestWrapper requestWrapper=RequestWrapper.class.newInstance();
        String headContext=requestContent.toString().split("\n")[0];
        String method=headContext.split("\t")[0];
        String url=headContext.split("\t")[1];
        requestWrapper.setMethod(method);
        requestWrapper.setUrl(url);
        String[] contentArray=requestContent.toString().split("\n");
        for(String option:contentArray){
            String[] optionArra=option.split(":");
            String key=optionArra[0];
            String value=optionArra[1];
            for(Field field:fields){
                if(key.equals(field.getName())){
                    String setMethod="set"+field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
                    Method methods=RequestWrapper.class.getMethod(setMethod,field.getType());
                    methods.invoke(requestWrapper,value);
                }
            }
        }
        return requestWrapper;
    }
}
