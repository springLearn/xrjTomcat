package src.test;

import src.util.RequestWrapper;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.ProtectionDomain;

public class RefelectTest {
    public static void main(String[] args) {
        try {
             Class beanClass=ReflectBean.class;
             System.out.println(beanClass.getName());
             Field[] fields=beanClass.getDeclaredFields();
             System.out.println(fields.clone());
             Field field=beanClass.getField("sex");
             Method[]  methods=beanClass.getDeclaredMethods();
             Method[] methods1=beanClass.getMethods();
            ProtectionDomain domain=beanClass.getProtectionDomain();
             Method method=beanClass.getMethod("toString",(Class[]) null);
            System.out.println(method.invoke(new ReflectBean(),null).toString());
            System.out.println("--------------------------------------------------");
             Class beanClass1=Class.forName("src.test.ReflectBean");
             System.out.println(beanClass1.getName());
             System.out.println("--------------------------------------------------");
             ReflectBean bean=new ReflectBean("红红",12);
             System.out.println(bean.getClass().getName());
        } catch (Exception  e) {
            e.printStackTrace();
        }
    }
}
