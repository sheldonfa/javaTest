package com.serialize;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * Created by Administrator on 2016/11/26.
 */
public class Client {

    /**
     * hessian实现序列化
     * @throws IOException
     */
    @Test
    public void testHessianSerialization() throws IOException {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(5);
        person.setBirthday(new Date());

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        // hessian的序列化输出
        HessianOutput ho = new HessianOutput(os);
        ho.writeObject(person);
        byte[] personByte = os.toByteArray();


        ByteArrayInputStream is = new ByteArrayInputStream(personByte);
        // hessian反序列化读取数据
        HessianInput hi = new HessianInput(is);
        Person newPerson = (Person) hi.readObject();
        System.out.println(newPerson);
    }

    /**
     * java自带对象序列化方式
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testJavaSerialization() throws IOException, ClassNotFoundException {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(5);
        person.setBirthday(new Date());

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        // 对象输出流
                ObjectOutputStream oos = new ObjectOutputStream(os);
        // 将对象写到字节数组输出流中
        oos.writeObject(person);
        byte[] personByte = os.toByteArray();


        ByteArrayInputStream is = new ByteArrayInputStream(personByte);
        // 反序列化
        ObjectInputStream in = new ObjectInputStream(is);
        Person newPerson = (Person)in.readObject();
        System.out.println(newPerson);
    }

    /**
     * json序列化，使用jackson方式一
     */
    @Test
    public void testJsonSerialzation() throws IOException {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(5);
        person.setBirthday(new Date());

        // json对象序列化
        String personJson = null;
        ObjectMapper mapper = new ObjectMapper();
        StringWriter sw = new StringWriter();
        JsonGenerator jg = new JsonFactory().createJsonGenerator(sw);
        mapper.writeValue(jg,person);
        jg.close();
        personJson = sw.toString();

        // json反序列化
        Person newPerson = mapper.readValue(personJson, Person.class);
        System.out.println(newPerson);
    }

    /**
     * json序列化，使用jackson方式一
     */
    @Test
    public void testJsonSerialzation2() throws IOException {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(5);
        person.setBirthday(new Date());

        // json对象序列化
        ObjectMapper mapper = new ObjectMapper();
        String personJson = mapper.writeValueAsString(person);

        // json反序列化
        Person newPerson = mapper.readValue(personJson, Person.class);
        System.out.println(newPerson);
    }

    /**
     * xml序列化
     */
    @Test
    public void testXmlSerialization() throws IOException {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(5);
        person.setBirthday(new Date());

        // 将person序列化为xml
        XStream xStream = new XStream(new DomDriver());
        // 设置Person类的别名
        xStream.alias("person",Person.class);
        String personXML = xStream.toXML(person);

        // 将xml反序列化为person对象
        Person newPerson = (Person) xStream.fromXML(personXML);
        System.out.println(newPerson);
    }
}
