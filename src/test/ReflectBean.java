package src.test;

public class ReflectBean {
    private String name;
    private int age;
    public boolean sex=false;
    public ReflectBean(){
    }
    public ReflectBean(String name,int age){
        this.name=name;
        this.age=age;
    }

    public String toString(){
        return this.name+":"+this.age;
    }
    private String say(){
        System.out.println("funck and funck");
        return "fuck";
    }
}
