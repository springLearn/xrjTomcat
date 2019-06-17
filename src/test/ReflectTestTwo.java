package src.test;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectTestTwo {
    private String name;
    private int age;
    private double score;

    public static void main(String[] args) {
        File file=new File("F:\\aa.txt");
        try{
            FileOutputStream fileOutputStream=new FileOutputStream(file);
            Scanner scanner=new Scanner(System.in);
            int time=0;
            String str="";
            while(time<=2) {
                str+= scanner.next() + ":";
                time++;
            }
            String content="";
            int length=0;
            byte[] contentArr=new byte[1024];
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
            FileInputStream fileInputStream=new FileInputStream(file);
            while((length=fileInputStream.read(contentArr))!=-1){
                content=content+new String(contentArr,0,length);
            }
            String[] strings=content.split(":");
            Class class1=ReflectTestTwo.class;
            ReflectTestTwo two=new ReflectTestTwo();
            Method[] fields=class1.getDeclaredMethods();
            for(int i=0;i<fields.length;i++){
                if(fields[i].getName().contains("set")){
                    fields[i].invoke(two,strings[i/3]);
                }
                if(fields[i].getName().contains("toStrings")){
                    fields[i].invoke(two,null);
                }
            }

        }catch(InvocationTargetException|IllegalAccessException|IOException e){
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
    public void toStrings(){
        System.out.println(this.name+":"+this.age+":"+this.score);
    }
}
