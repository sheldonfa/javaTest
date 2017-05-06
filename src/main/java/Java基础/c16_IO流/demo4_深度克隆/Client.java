package Java基础.c16_IO流.demo4_深度克隆;


import java.io.*;

public class Client {

    /**
     * 序列化实现深度克隆
     */
    public static <T extends Serializable>T cloneObj(Person obj) throws IOException, ClassNotFoundException {
        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        // ObjectOutputStream是ByteOutputStream的包装模式，允许Object作为参数
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);
        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T)ois.readObject();
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person1 = new Person(1,"zhangsan",new Head(new Face()));
        Person person2 = cloneObj(person1);
        System.out.println("person1");
        System.out.println(person1);
        System.out.println(person1.getHead());
        System.out.println(person1.getHead().getFace());
        System.out.println("person2");
        System.out.println(person2);
        System.out.println(person2.getHead());
        System.out.println(person2.getHead().getFace());
        System.out.println("比较");
        System.out.println(person1==person2);
        System.out.println(person1.getHead()==person2.getHead());
        System.out.println(person1.getHead().getFace()==person2.getHead().getFace());
    }
}
