package com.mongo.test;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MongoTest {
    private static Log log = LogFactory.getLog(MongoTest.class.getName());  
    private  AbstractRepository pr=null;  
    @SuppressWarnings("resource")
    public void init(){  
        System.out.println("开始启动");  
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");  
          pr= (PersonRepository)ctx.getBean("personRepository");  
    }  
    public void insert(){  
        Person p=new Person("cuiran",27);  
         pr.insert(p);  
         System.out.println("添加成功");
    }  
    public void findOne(){  
        String id="5338e1cdf6bfc8a01e233b4d";  
        Person p= pr.findOne(id);  
        System.out.println(p);
    }  
    public void listAll(){  
        List<Person> list=pr.findAll();  
        System.out.println("查询结果如下:");  
        for (Person p:list){  
            System.out.println(p.toString());  
        }  
    }  
      
    public void start(){  
        init();  
        //insert();  
        //listAll();  
        findOne();  
    }  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        MongoTest t=new MongoTest();  
        t.start();  
    }  
}
